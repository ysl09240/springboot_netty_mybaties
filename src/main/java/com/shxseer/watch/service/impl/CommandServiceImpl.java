package com.shxseer.watch.service.impl;

import cn.edu.xidian.wave.ppgpreprocessor.InvalidWaveException;
import com.alibaba.fastjson.JSON;
import com.shxseer.watch.algorithm.diseasereport.*;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseScaleUtils;
import com.shxseer.watch.algorithm.eigenvalue.EigenvalueUtils;
import com.shxseer.watch.algorithm.wavetools.Test;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.DateUtils;
import com.shxseer.watch.common.DiseaseEnum;
import com.shxseer.watch.dao.BloodDatumValueMapper;
import com.shxseer.watch.dao.CommandMapper;
import com.shxseer.watch.dao.ReportDiseaseMapper;
import com.shxseer.watch.dao.UserMapper;
import com.shxseer.watch.model.*;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.service.IDiseaseScaleValueService;
import com.shxseer.watch.service.IDiseaseTipsService;
import com.shxseer.watch.service.IEigenValueService;
import com.shxseer.watch.utils.FileUtils;
import com.shxseer.watch.utils.HttpUtils;
import com.shxseer.watch.utils.IdUtils;
import com.shxseer.watch.vo.BloodPressValueVo;
import com.shxseer.watch.vo.DrugStoreVo;
import com.shxseer.watch.vo.NotificationToRelatedPersonnelVo;
import com.shxseer.watch.vo.UserWaveVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.util.*;


/**
 * @author yangsonglin
 * @create 2018-07-09 17:33
 **/
@Service("commandService")
public class CommandServiceImpl implements CommandService {

    private static Logger logger = LoggerFactory.getLogger(CommandServiceImpl.class);


    @Value("${ppg.preprocess}")
    private String preprocess;

    @Value("${notice.url.toRelatedPersonnel}")
    private String noticeUrltoRelatedPersonnel;

    @Value("${notice.url.toMine}")
    private String noticeUrltoMine;

    @Value("${file.url}")
    private String fileUrl;

    @Autowired
    CommandMapper commandMapper;

    @Autowired
    UserMapper userMapper;

    @Autowired
    ReportDiseaseMapper reportDiseaseMapper;

    @Autowired
    BloodDatumValueMapper bloodDatumValueMapper;

    @Autowired
    IEigenValueService eigenValueService;

    @Autowired
    IDiseaseScaleValueService diseaseScaleValueService;

    @Autowired
    IDiseaseTipsService diseaseTipsService;

    @Override
    public DrugStoreVo findDrugStore(String id) {
        return commandMapper.findDrugStore(id);
    }

    /**
     * 波形保存
     */
    @Override
    public WaveDataUpBean waveSave(WaveDataUpBean waveDataUpBean,User user) throws Exception {
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));
        String month = String.valueOf((now.get(Calendar.MONTH)+1));
        String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        StringBuilder path = new StringBuilder("");
        path.append(fileUrl)
            .append(year).append(File.separator)
            .append(month).append(File.separator)
            .append(day).append(File.separator)
            .append(user.getId()).append(File.separator);

        String filename = new StringBuilder("").append(user.getId()).append("_").append(now.getTimeInMillis()).append(".txt").toString();
        FileUtils.writeFile(path.toString(),filename,waveDataUpBean.getData());
        waveDataUpBean.setFileUrl(path.toString()+filename);
        commandMapper.waveSave(waveDataUpBean);
        return waveDataUpBean;
    }

    /**
     * 久坐提醒上传
     */
    @Override
    public boolean sedentarySave(SedentaryBean sedentaryBean) {
        sedentaryBean.setId(IdUtils.uuid());
        commandMapper.sedentarySave(sedentaryBean);
        return true;
    }



    /**
     * 计步上传
     */
    @Override
    public void stepCountSave(StepBean stepBean) {
        stepBean.setId(IdUtils.uuid());
        commandMapper.stepCountSave(stepBean);
    }



    /**
     * 查询公共参数
     * @param commonType
     * @return
     */
    @Override
    public CommonParamsBean findCommonParams(String commonType) {
        return commandMapper.findCommonParams(commonType);
    }

    /**
     * 心率保存
     * @param heartRateDataBean
     */
    @Override
    public void heartRateDataSave(HeartRateDataBean heartRateDataBean) {
        heartRateDataBean.setId(IdUtils.uuid());
        commandMapper.heartRateDataSave(heartRateDataBean);
    }

    /**
     * 根据设备号查询用户对应关系
     * @param heartBeatBean
     * @return
     */
    @Override
    public WatchUserRecordBean findWatchUserRecordByImei(HeartBeatBean heartBeatBean) {
        return commandMapper.findWatchUserRecordByImei(heartBeatBean);
    }

    /**
     * 处理波型数据
     * @param waveDataUpBean
     * @return
     */
    @Override
    public Object waveDealData(WaveDataUpBean waveDataUpBean,User user) throws Exception {
        //***********杨松林计算特征值条件开始*************
        boolean flag = false;
        UserWaveVo vo = new UserWaveVo();
        String imei = waveDataUpBean.getImei();
        vo.setAdornType(String.valueOf(waveDataUpBean.getLrhand()));
        vo.setUser(user);
        double[] d = Test.getArray(waveDataUpBean.getData());
        if(null == d || d.length<=0){
             NoticeBean noticeBean = new NoticeBean();
             noticeBean.setContent("波型数据有误");
             noticeBean.setTime(System.currentTimeMillis() / 1000);
             noticeBean.setDatatype(2);
             return noticeBean;
        }

        //*************杨松林计算特征值条件结束************

        //**************张亮负责特征值，尽度值，病症报告开始***************
        /**
         * 1、计算保存特征值
         */
        String eigenValueInfo = null;
        //这里因为下面尺度值计算需要当前波形的特征值所以变量定义在外面
        Map<String,Object> returnMap = null;
        try{
            String exePath = preprocess;
            vo.setExePath(exePath);
            vo.setWaveArray(d);
            vo.setStartTime(DateUtils.timeStamp2Date(waveDataUpBean.getStarttime()+"", null));
            //获取特征值
            returnMap = EigenvalueUtils.getNewEigenValue(vo);
            vo.setNowEigenValueMap(returnMap);
            EigenValueOne eigenValueOne = (EigenValueOne) returnMap.get("eigenValueOne");
            EigenValueTwo eigenValueTwo = (EigenValueTwo) returnMap.get("eigenValueTwo");
            EigenValueThree eigenValueThree = (EigenValueThree) returnMap.get("eigenValueThree");
            EigenValueFour eigenValueFour = (EigenValueFour) returnMap.get("eigenValueFour");
            EigenValueFive eigenValueFive = (EigenValueFive) returnMap.get("eigenValueFive");
            if(eigenValueOne != null){
                eigenValueOne.setWaveId(waveDataUpBean.getId());
            }
            //保存特征值
            eigenValueService.saveNewEigenRecord(eigenValueOne, eigenValueTwo, eigenValueThree, eigenValueFour, eigenValueFive);
            flag = true;
        } catch(InvalidWaveException iwe){
            flag = false;
            eigenValueInfo = "本次测量数据无效，请您重新测量。";
            logger.info(eigenValueInfo + iwe.getMessage());

            NotificationToRelatedPersonnelVo noticeVo = new NotificationToRelatedPersonnelVo();
            noticeVo.setUserId(user.getId());
            //有预警的病症推送给手机
            noticeVo.setCellphone(user.getCellphone());
            noticeVo.setDiseaseCode(0);
            noticeVo.setHeadPortrait("");
            noticeVo.setPushMessage(eigenValueInfo);
            noticeVo.setStartTime(DateUtils.timeStamp2Date(waveDataUpBean.getStarttime()+"", null));
            noticeVo.setUserHeadPortrait(user.getHeadPortrait());
            try {
                String msg = HttpUtils.doPost(noticeUrltoMine, JSON.toJSONString(noticeVo));
                logger.info("短信接口调用："+msg);
            } catch (Exception e) {
                logger.error(""+e.getStackTrace());
            }
            NoticeBean noticeBean = new NoticeBean();
            noticeBean.setContent(eigenValueInfo);
            noticeBean.setTime(System.currentTimeMillis() / 1000);
            noticeBean.setDatatype(2);
            return noticeBean;
        } catch (Exception e) {
            logger.error("生成新特征值 失败", e);
        }

        if(flag){
            //1.脉搏测量——上传
            waveDataUpBean = this.waveSave(waveDataUpBean,user);
            logger.info("波型保存成功...");
        }
        /**
         * 2、计算保存病症所需的尺度值
         * 注：这里因为业务原因，和TestController里的尺度值计算有些许不同，具体为：这里的原始数据数量为2时就进行尺度计算，
         * 然后将上面算好的特征值对象放到这里的eigenValueMapList中。
         */
        String userId = user.getId();
        Map<String, Object> diseaseScaleMap = diseaseScaleValueService.getDiseaseScaleValueByUserId(userId);
        if(diseaseScaleMap == null) {
            //计算病症所需的尺度值
            List<String> waveIdList = getWaveIdByimei(imei);
            if (waveIdList != null && waveIdList.size() > 0) {
                //如果计算尺度值的原始数据id集合不为空
                int size = waveIdList.size();
                if (size == 2) {
                    //如果计算尺度值的原始数据id集合的size符合计算尺度值的条件，这里数据库查出来的波形数量改为2，加上当前这组波形的特征值共三组
                    List<Map<String, Object>> eigenValueMapList = new ArrayList<>();
                    if(returnMap != null){
                        //将当前这组波形的特征值添加进计算尺度值的特征值集合中
                        eigenValueMapList.add(returnMap);
                        for (String waveId1 : waveIdList) {
                            Map<String, Object> eigenValueMap = eigenValueService.getNewEigenValuebyWaveId(waveId1);
                            eigenValueMapList.add(eigenValueMap);
                        }
                        diseaseScaleMap = DiseaseScaleUtils.getDiseaseScaleValue(eigenValueMapList, userId);
                        DiseaseScaleValueOne diseaseScaleValueOne = (DiseaseScaleValueOne) diseaseScaleMap.get("diseaseScaleValueOne");
                        DiseaseScaleValueTwo diseaseScaleValueTwo = (DiseaseScaleValueTwo) diseaseScaleMap.get("diseaseScaleValueTwo");
                        DiseaseScaleValueThree diseaseScaleValueThree = (DiseaseScaleValueThree) diseaseScaleMap.get("diseaseScaleValueThree");
                        DiseaseScaleValueFour diseaseScaleValueFour = (DiseaseScaleValueFour) diseaseScaleMap.get("diseaseScaleValueFour");
                        diseaseScaleValueService.addDiseaseScaleValue(diseaseScaleValueOne, diseaseScaleValueTwo, diseaseScaleValueThree, diseaseScaleValueFour);
                    }
                } else if (size < 2) {
                    logger.info("您测量的数据数为" + size + "，数据量较少，报告正在初始化");

                }else{
                    logger.info("您测量过的数据数为0");
                }
            }
            return "";
        }

        /**
         * 3、计算保存病症报告
         */
        Map<String,Object> reportMap = new HashMap<>();
        ReportDisease reportDisease = null;
        //获取血糖血压基准值
        String bloodGlucose = null;
        String bloodPress = null;
        try {
            // 血糖基准值
            bloodGlucose = bloodDatumValueMapper.selectBloodDatumValue(userId);
            // 血压基准值
            bloodPress = bloodDatumValueMapper.selectBloodPressValue(userId);
        } catch (Exception e) {
            logger.error("获取血糖血压基准值失败", e);
        }
        vo.setBloodGlucose(bloodGlucose);
        String[] sArray = bloodPress.split("/");
        vo.setHighPressure(sArray[0]);
        vo.setLowPressure(sArray[1]);
        //当前用户的上一组波形的特征值对象
        Map<String, Object> maps = new HashMap<>(2);
        maps.put("startTime", waveDataUpBean.getStarttime());
        maps.put("imei", imei);
        String beforeWaveId = commandMapper.getBeforeWaveIdByStarttime(maps);
        if(beforeWaveId != null){
            Map<String, Object> beforeEigenValueMap = eigenValueService.getNewEigenValuebyWaveId(beforeWaveId);
            if(!beforeEigenValueMap.isEmpty()){
                vo.setBeforeEigenValueMap(beforeEigenValueMap);
            }
        }
        //病症尺度值map对象
        vo.setDiseaseScaleMap(diseaseScaleMap);
        //当前用户的当天的血黏值
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("userId", userId);
        paramMap.put("startTime", vo.getStartTime().substring(0,10));
        List<Double> dayConsistencyList = reportDiseaseMapper.getDayConsistencyByUserId(paramMap);
        vo.setDayConsistencyList(dayConsistencyList);

        /** 血糖报告 */
        //获取当前用户以往测过的血糖参数定量值
        List<Double> bloodValueList = reportDiseaseMapper.getBloodGlucoseValueByUserId(userId);
        if(bloodValueList != null){
            //如果以往测过的血糖参数定量值集合不为空
            int size = bloodValueList.size();
            vo.setBloodValueArray(bloodValueList);
            //计算血糖报告
            reportDisease = calculateBloodGlucoseReport(vo);
            if (size < Constant.BASICKMEANS_VALUE - 1) {
                //这里不用size的原因:在下面的工具类中给bloodValueList添加了一个值
                logger.info("目前血糖值数量为"+bloodValueList.size()+"，少于计算个性化区间的最少数量，报告初始化中");
            }
        }
        if(reportDisease != null){
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("3");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_BLOODSUGAR,reportDisease);
        }
        /** 疲劳报告 */
        reportDisease = calculateTeriodReport(vo);
        if(reportDisease != null) {
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("0");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_TERIOD, reportDisease);
        }
        /** 血压报告 */
        //获取当前用户以往测过的高压值和低压值
        List<BloodPressValueVo> bloodPressList = reportDiseaseMapper.getBloodPressValueByUserId(userId);
        if(bloodPressList != null){
            //如果以往测过的血糖参数定量值集合不为空
            int size = bloodPressList.size();
            vo.setBloodPressList(bloodPressList);
            //计算血压报告
            reportDisease = calculateBloodPressReport(vo);
            if(size < (Constant.BASICKMEANS_VALUE - 1)){
                logger.info("目前血压的高压和低压值数量为"+(size + 1)+"，少于计算个性化区间的最少数量，报告初始化中");
            }
        }
        if(reportDisease != null) {
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("14");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_HIGHANDLOW, reportDisease);
        }
        /** 运动预警报告 */
        reportDisease = calculateSportHertRateReport(vo);
        if(reportDisease != null) {
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("17");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_SPORTHERTRATE, reportDisease);
        }
        /** 血液粘稠度报告 */
        /*reportDisease = calculateBloodConsistencyReport(vo);
        if(reportDisease != null) {
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("18");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_BLOODCONSISTENCY, reportDisease);
        }*/
        /** K值报告 */
        reportDisease = calculateKvalueReport(vo);
        if(reportDisease != null) {
            //处理病症建议
            String suggestList = diseaseTipsService.getRandomDiseaseTips("19");
            reportDisease.setSuggestList(suggestList);
            reportMap.put(MessageType.RETURN_TYPE_KVALUE, reportDisease);
        }

        for (Map.Entry<String, Object> entry : reportMap.entrySet()) {
            //将即时报告对象存进数据库
            ReportDisease obj = (ReportDisease) entry.getValue();
            reportDiseaseMapper.addReportDisease(obj);

            //将即时报告中的状态改为相应的汉字
            String code = obj.getDiseaseCode()+"";
            String status = obj.getStatus();
            if("3".equals(code)){
                //血糖
                if(DiseaseEnum.BLOODSUGAR_DOWN.getValue().equals(status)){
                    status = DiseaseEnum.BLOODSUGAR_DOWN.getLabel();
                }else if(DiseaseEnum.BLOODSUGAR_NOMAL.getValue().equals(status)){
                    status = DiseaseEnum.BLOODSUGAR_NOMAL.getLabel();
                }else if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(status)){
                    status = DiseaseEnum.BLOODSUGAR_UP.getLabel();
                }
            }else if("14".equals(code)){
                //血压
                if(DiseaseEnum.HIGHANDLOW_ONE.getValue().equals(status)){
                    status = DiseaseEnum.HIGHANDLOW_ONE.getLabel();
                }else if(DiseaseEnum.HIGHANDLOW_TWO.getValue().equals(status)){
                    status = DiseaseEnum.HIGHANDLOW_TWO.getLabel();
                }else if(DiseaseEnum.HIGHANDLOW_THREE.getValue().equals(status)){
                    status = DiseaseEnum.HIGHANDLOW_THREE.getLabel();
                }
            }else if("0".equals(code)){
                //疲劳
                if(DiseaseEnum.TERIOD_ONE.getValue().equals(status)){
                    status = DiseaseEnum.TERIOD_ONE.getLabel();
                }else if(DiseaseEnum.TERIOD_TWO.getValue().equals(status)){
                    status = DiseaseEnum.TERIOD_TWO.getLabel();
                }else if(DiseaseEnum.TERIOD_THREE.getValue().equals(status)){
                    status = DiseaseEnum.TERIOD_THREE.getLabel();
                }
            }else if("17".equals(code)){
                //运动预警
                if(DiseaseEnum.SPORTHERTRATE_ONE.getValue().equals(status)){
                    status = DiseaseEnum.SPORTHERTRATE_ONE.getLabel();
                }else if(DiseaseEnum.SPORTHERTRATE_TWO.getValue().equals(status)){
                    status = DiseaseEnum.SPORTHERTRATE_TWO.getLabel();
                }else if(DiseaseEnum.SPORTHERTRATE_THREE.getValue().equals(status)){
                    status = DiseaseEnum.SPORTHERTRATE_THREE.getLabel();
                }
            }else if("18".equals(code)){
                //血液黏稠度
                if(DiseaseEnum.BLOODCONSISTENCY_ONE.getValue().equals(status)){
                    status = DiseaseEnum.BLOODCONSISTENCY_ONE.getLabel();
                }else if(DiseaseEnum.BLOODCONSISTENCY_TWO.getValue().equals(status)){
                    status = DiseaseEnum.BLOODCONSISTENCY_TWO.getLabel();
                }else if(DiseaseEnum.BLOODCONSISTENCY_THREE.getValue().equals(status)){
                    status = DiseaseEnum.BLOODCONSISTENCY_THREE.getLabel();
                }
            }else if("19".equals(code)){
                //血液黏稠度
                if(DiseaseEnum.KVALUE_ONE.getValue().equals(status)){
                    status = DiseaseEnum.KVALUE_ONE.getLabel();
                }else if(DiseaseEnum.KVALUE_TWO.getValue().equals(status)){
                    status = DiseaseEnum.KVALUE_TWO.getLabel();
                }else if(DiseaseEnum.KVALUE_THREE.getValue().equals(status)){
                    status = DiseaseEnum.KVALUE_THREE.getLabel();
                }
            }
            obj.setStatus(status);
            //将血糖中的用餐状态改为相应的汉字
            if("0".equals(obj.getEatSataus())){
                obj.setEatSataus("餐前");
            }else if("1".equals(obj.getEatSataus())){
                obj.setEatSataus("餐后");
            }
            //将血压中的左右手改为相应的汉字
            if("0".equals(obj.getAdornType())){
                obj.setAdornType("左臂");
            }else if("1".equals(obj.getAdornType())){
                obj.setAdornType("右臂");
            }
        }

        //**************张亮负责特征值，尽度值，病症报告结束***************

        //********杨松林调用亲友团休发送通开始*****************
        //注:触发条件由张亮提供
        /**
         * 给用户本人、亲友、团体推送预警报告
         * 注：如果有预警就推送给手机，以前是每种病症一个预警，现在是所有病症只有一个预警报告，所以移到for循环外面
         */
        /*boolean warning = false;
        NotificationToRelatedPersonnelVo noticeVo = new NotificationToRelatedPersonnelVo();
        noticeVo.setUserId(user.getId());
        if(warning){
            //有预警的病症推送给手机
            noticeVo.setCellphone(user.getCellphone());
            noticeVo.setDiseaseCode(obj.getDiseaseCode());
            noticeVo.setHeadPortrait(obj.getHeadPortrait());
            noticeVo.setPushMessage(obj.getPushMessage());
            noticeVo.setStartTime(obj.getStartTime());
            noticeVo.setUserHeadPortrait(user.getHeadPortrait());

            if(reportDisease.getIsWarning().equals("1")){
                String msg = null;
                try {
                    msg = HttpUtils.doPost(noticeUrltoRelatedPersonnel, JSON.toJSONString(noticeVo));
                } catch (Exception e) {
                    logger.error(""+e.getStackTrace());
                }
                logger.debug(msg);
            }
        }*/
        //********杨松林调用亲友团体发送通知结束*****************

        //******杨松林调用给本人发送通知接口开始******
        /**
         * 病症计算完成给用户本人推送消息
         */
        if(reportMap.size() > 0){
            String msg = null;
            try {

                NotificationToRelatedPersonnelVo noticeVo = new NotificationToRelatedPersonnelVo();
                noticeVo.setUserId(user.getId());
                //有预警的病症推送给手机
                noticeVo.setCellphone(user.getCellphone());
                noticeVo.setDiseaseCode(0);
                noticeVo.setHeadPortrait("");
                noticeVo.setPushMessage("您的测量结果已计算完成，请查看。");
                noticeVo.setStartTime(DateUtils.timeStamp2Date(waveDataUpBean.getStarttime()+"", null));
                noticeVo.setUserHeadPortrait(user.getHeadPortrait());
                try {
                    msg = HttpUtils.doPost(noticeUrltoMine, JSON.toJSONString(noticeVo));
                    logger.info("短信接口调用："+msg);
                } catch (Exception e) {
                    logger.error(""+e.getStackTrace());
                }
                logger.info("短信接口调用:"+msg);
            } catch (Exception e) {
                logger.error(""+e.getStackTrace());
            }
            logger.debug(msg);
        }
        //******杨松林调用给本人发送通知接口结束******
        WaveDataDownBean waveDataDownBean = new WaveDataDownBean();
        waveDataDownBean.setDatatype("0");
        waveDataDownBean.setDataresult(reportMap);

        return waveDataDownBean;
    }


    //目标时间增加天数
    private Date dayAdd(Date date,int addNum){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, addNum);
        Date newDate = c.getTime();
        return newDate;
    }

    /**
     * 计算血糖报告
     * @param userWaveVo
     */
    @Override
    public ReportDisease calculateBloodGlucoseReport(UserWaveVo userWaveVo){
        try {
            double bloodGlucose = Double.parseDouble(userWaveVo.getBloodGlucose());
            Map<String, Object> diseaseScaleMap = userWaveVo.getDiseaseScaleMap();
            DiseaseScaleValueOne diseaseScaleValueOne = (DiseaseScaleValueOne) diseaseScaleMap.get("diseaseScaleValueOne");
            ReportDisease reportDisease = BloodSugarReport.calculateBloodReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    bloodGlucose,
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap(),
                    userWaveVo.getBloodValueArray(),
                    diseaseScaleValueOne.getCenterValueScale(),
                    diseaseScaleValueOne.getSpeedScale(),
                    diseaseScaleValueOne.getDowncenterValueScale());
            logger.info("计算血糖报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算血糖报告 失败",e);
        }
        return null;
    }

    /**
     * 计算疲劳报告
     * @param userWaveVo
     * @return
     */
    @Override
    public ReportDisease calculateTeriodReport(UserWaveVo userWaveVo){
        try {
            ReportDisease reportDisease = TeriodReport.calculateReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap());
            logger.info("计算疲劳报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算疲劳报告 失败",e);
        }
        return null;
    }

    /**
     * 计算血压报告
     * @param userWaveVo
     * @return
     */
    @Override
    public ReportDisease calculateBloodPressReport(UserWaveVo userWaveVo){
        try {
            Map<String, Object> diseaseScaleMap = userWaveVo.getDiseaseScaleMap();
            DiseaseScaleValueOne diseaseScaleValueOne = (DiseaseScaleValueOne) diseaseScaleMap.get("diseaseScaleValueOne");
            ReportDisease reportDisease = BloodPressReport.calculateReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    userWaveVo.getHighPressure(),
                    userWaveVo.getLowPressure(),
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap(),
                    userWaveVo.getBloodPressList(),
                    diseaseScaleValueOne.getAveragePressScale());
            reportDisease.setAdornType(userWaveVo.getAdornType());
            logger.info("计算血压报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算血压报告 失败",e);
        }
        return null;
    }

    /**
     * 计算运动预警报告
     * @param userWaveVo
     * @return
     */
    @Override
    public ReportDisease calculateSportHertRateReport(UserWaveVo userWaveVo){
        try {
            ReportDisease reportDisease = SportHertRateReport.calculateReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap());
            logger.info("计算运动预警报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算运动预警报告 失败",e);
        }
        return null;
    }

    /**
     * 计算血液粘稠度报告
     * @param userWaveVo
     * @return
     */
    @Override
    public ReportDisease calculateBloodConsistencyReport(UserWaveVo userWaveVo){
        try {
            ReportDisease reportDisease = BloodConsistencyReport.calculateReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap(),
                    userWaveVo.getDayConsistencyList());
            logger.info("计算血液粘稠度报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算血液粘稠度报告 失败",e);
        }
        return null;
    }

    /**
     * 计算K值报告
     * @param userWaveVo
     * @return
     */
    @Override
    public ReportDisease calculateKvalueReport(UserWaveVo userWaveVo){
        try {
            ReportDisease reportDisease = KvalueReport.calculateReportNew(
                    userWaveVo.getUser(),
                    userWaveVo.getStartTime(),
                    userWaveVo.getNowEigenValueMap(),
                    userWaveVo.getBeforeEigenValueMap());
            logger.info("计算K值报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算K值报告 失败",e);
        }
        return null;
    }

    /**
     * 根据imei号获取原始数据主键id集合
     * @param imei
     * @return
     */
    @Override
    public List<String> getWaveIdByimei(String imei){
        List<String> waveIdList = commandMapper.getWaveIdByimei(imei);
        if(waveIdList != null && waveIdList.size() > 0){
            return waveIdList;
        }
        return null;
    }

    /**
     * 根据主键id查询原始数据对象
     * @param waveId
     * @return
     */
    @Override
    public WaveDataUpBean getWaveDataUpBeanById(String waveId){
        return commandMapper.getWaveDataUpBeanById(waveId);
    }

    /**
     * 根据本次测量时间和设备号查询当前用户的上一组数据的主键id
     * @param imei 设备号
     * @param startTime 测量时间
     * @return
     */
    @Override
    public String getBeforeWaveIdByStarttime(String imei, double startTime){
        Map<String, Object> maps = new HashMap<>(2);
        maps.put("startTime", startTime);
        maps.put("imei", imei);
        return commandMapper.getBeforeWaveIdByStarttime(maps);
    }

    @Override
    public BloodBaselineBean isStartMeasure(BloodBaselineBean bloodBaselineBean) {
        BloodBaselineBean beanResult= new BloodBaselineBean();
        //传入datatype到bean
        beanResult.setDatatype(MessageType.MSG_BLOOD_BASELINE);
        int isBlood = bloodBaseIsValid(bloodBaselineBean);
        if(isBlood==MessageType.ISVALID_FALSE){
            beanResult.setIsvalid(MessageType.ISVALID_FALSE);
            beanResult.setMessage("血糖血压值无效，请到手机app端重新设置");
            return beanResult;
        }
        int isDiseascal = diseaseScaleIsValid(bloodBaselineBean);
        if(isDiseascal == MessageType.ISVALID_FALSE){
            beanResult.setIsvalid(MessageType.ISVALID_FALSE);
            beanResult.setMessage("尺度值无效，请到手机app端重新设置");
            return beanResult;
        }
        beanResult.setIsvalid(MessageType.ISVALID_TRUE);

        return beanResult;
    }


    /**
     * 血糖血压基准值是否有效判断
     */
    public int bloodBaseIsValid(BloodBaselineBean bloodBaselineBean) {
        int result = MessageType.ISVALID_TRUE;
        Map map  = commandMapper.bloodBaseSearch(bloodBaselineBean);
        if(null == map){
           result = MessageType.ISVALID_FALSE;
           return result;
        }
        String bloodValue = (String) map.get("bloodValue");
        String pressValue = (String) map.get("pressValue");
        if(StringUtils.isEmpty(bloodValue) || StringUtils.isEmpty(pressValue)){
            result = MessageType.ISVALID_FALSE;
            return result;
        }
//
//        //获取血糖血压查询信息
//        //获取间隔时间
//        int intervalDay =  (Integer) map.get("standard_interval");
//        //获取当前时间
//        Date createTime = (Date) map.get("create_time");
//        //计算获得对照时间
//        Date compareTime = dayAdd(createTime,intervalDay);
//
//        //判断当前时间和对照时间比较，根据对比结果传入不同的有效值
//        if(new Date().after(compareTime)){
//            result = MessageType.ISVALID_TRUE;
//        } else {
//            result = MessageType.ISVALID_FALSE;
//        }
        return result;
    }

    public int diseaseScaleIsValid(BloodBaselineBean bloodBaselineBean){
        int result = 0;
        String str = diseaseScaleValueService.getDiseaseScaleId(bloodBaselineBean);
        if(StringUtils.isEmpty(str)){
            result = MessageType.ISVALID_FALSE;
        } else {
           result = MessageType.ISVALID_TRUE;
        }
        return result;
    }


}
