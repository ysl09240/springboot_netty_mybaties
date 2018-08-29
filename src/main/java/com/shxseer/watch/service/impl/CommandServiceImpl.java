package com.shxseer.watch.service.impl;

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

    @Value("${notice.url}")
    private String noticeUrl;

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

    @Override
    public DrugStoreVo findDrugStore(String id) {
        return commandMapper.findDrugStore(id);
    }

    /**
     * 波形保存
     */
    @Override
    public WaveDataUpBean waveSave(WaveDataUpBean waveDataUpBean,User user) {
        waveDataUpBean.setId(IdUtils.uuid());
        Calendar now = Calendar.getInstance();
        String year = String.valueOf(now.get(Calendar.YEAR));
        String month = String.valueOf((now.get(Calendar.MONTH)+1));
        String day = String.valueOf(now.get(Calendar.DAY_OF_MONTH));
        StringBuilder path = new StringBuilder("");
        path.append(fileUrl)
            .append(year).append(File.separator)
            .append(month).append(File.separator)
            .append(day).append(File.separator);

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
     * 血糖血压基准值是否有效判断
     */
    @Override
    public String bloodBaseIsValid(BloodBaselineBean bloodBaselineBean) {

        //获取血糖血压查询信息
        HashMap map = commandMapper.bloodBaseSearch(bloodBaselineBean).get(0);
        //获取间隔时间
        int intervalDay =  (Integer) map.get("standard_interval");
        //获取当前时间
        Date createTime = (Date) map.get("create_time");
        //计算获得对照时间
        Date compareTime = dayAdd(createTime,intervalDay);

        BloodBaselineBean beanResult = new BloodBaselineBean();
        //判断当前时间和对照时间比较，根据对比结果传入不同的有效值
        if(new Date().after(compareTime)){
            beanResult.setIsvalid(MessageType.ISVALID_TRUE);
        } else {
            beanResult.setIsvalid(MessageType.ISVALID_FALSE);
        }
        //传入datatype到bean
        beanResult.setDatatype(MessageType.MSG_BLOOD_BASELINE);

        return JSON.toJSON(beanResult).toString();
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
    public Object waveDealData(WaveDataUpBean waveDataUpBean,User user) {
        UserWaveVo vo = new UserWaveVo();
        String imei = waveDataUpBean.getImei();
        vo.setAdornType(String.valueOf(waveDataUpBean.getLrhand()));
        vo.setUser(user);
        double[] d = Test.getArray(waveDataUpBean.getData());
        if(null == d || d.length<=0){
             NoticeBean noticeBean = new NoticeBean();
             noticeBean.setContent("波型数据有误");
             noticeBean.setTime(System.currentTimeMillis() / 1000);
             noticeBean.setDatatype(3);
             return noticeBean;
        }

        /**
         * 1、计算保存特征值
         */
        String exePath = preprocess;
        vo.setExePath(exePath);
        vo.setWaveArray(d);
        vo.setStartTime(DateUtils.timeStamp2Date(waveDataUpBean.getStarttime()+"", null));
        //获取特征值
        Map<String,Object> returnMap = EigenvalueUtils.getNewEigenValue(vo);
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

        /**
         * 2、计算保存病症所需的尺度值
         */
        String userId = user.getId();
        Map<String, Object> diseaseScaleMap = diseaseScaleValueService.getDiseaseScaleValueByUserId(userId);
        if(diseaseScaleMap == null) {
            //计算病症所需的尺度值
            List<String> waveIdList = getWaveIdByimei(imei);
            if (waveIdList != null && waveIdList.size() > 0) {
                //如果计算尺度值的原始数据id集合不为空
                int size = waveIdList.size();
                if (size == Constant.DISEASESCALE_VALUE) {
                    //如果计算尺度值的原始数据id集合的size符合计算尺度值的条件
                    List<Map<String, Object>> eigenValueMapList = new ArrayList<Map<String, Object>>();
                    for (String waveId1 : waveIdList) {
                        Map<String, Object> eigenValueMap = eigenValueService.getNewEigenValuebyWaveId(waveId1);
                        eigenValueMapList.add(eigenValueMap);
                    }
                    diseaseScaleMap = DiseaseScaleUtils.getDiseaseScaleValue(eigenValueMapList, userId);
                    DiseaseScaleValueOne diseaseScaleValueOne = (DiseaseScaleValueOne) diseaseScaleMap.get("diseaseScaleValueOne");
                    DiseaseScaleValueTwo diseaseScaleValueTwo = (DiseaseScaleValueTwo) diseaseScaleMap.get("diseaseScaleValueTwo");
                    DiseaseScaleValueThree diseaseScaleValueThree = (DiseaseScaleValueThree) diseaseScaleMap.get("diseaseScaleValueThree");
                    diseaseScaleValueService.addDiseaseScaleValue(diseaseScaleValueOne, diseaseScaleValueTwo, diseaseScaleValueThree);

                } else if (size < Constant.DISEASESCALE_VALUE) {
                    logger.info("您测量的数据数为" + size + "，数据量较少，报告正在初始化");
                    NoticeBean noticeBean = new NoticeBean();
                    noticeBean.setContent("报告初始化中");
                    noticeBean.setTime(System.currentTimeMillis() / 1000);
                    noticeBean.setDatatype(3);
                    return noticeBean;
                }else{
                    logger.info("您测量过的数据数为0");
                    NoticeBean noticeBean = new NoticeBean();
                    noticeBean.setContent("报告初始化中");
                    noticeBean.setTime(System.currentTimeMillis() / 1000);
                    noticeBean.setDatatype(3);
                    return noticeBean;
                }
            }
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
            reportMap.put(MessageType.RETURN_TYPE_BLOODSUGAR,reportDisease);
        }
        /** 疲劳报告 */
        reportDisease = calculateTeriodReport(vo);
        if(reportDisease != null) {
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
                //这里不用size的原因:在下面的工具类中给bloodPressList添加了一个值
                logger.info("目前血压的高压和低压值数量为"+bloodPressList.size()+"，少于计算个性化区间的最少数量，报告初始化中");
            }
        }
        if(reportDisease != null) {
            reportMap.put(MessageType.RETURN_TYPE_HIGHANDLOW, reportDisease);
        }
        /** 血液粘稠度报告 */
        reportDisease = calculateBloodConsistencyReport(vo);
        if(reportDisease != null) {
            reportMap.put(MessageType.RETURN_TYPE_BLOODCONSISTENCY, reportDisease);
        }

        NotificationToRelatedPersonnelVo noticeVo = new NotificationToRelatedPersonnelVo();
        noticeVo.setUserId(user.getId());
        for (Map.Entry<String, Object> entry : reportMap.entrySet()) {
            //将即时报告对象存进数据库
            ReportDisease obj = (ReportDisease) entry.getValue();
            reportDiseaseMapper.addReportDisease(obj);

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
                    msg = HttpUtils.doPost(noticeUrl, JSON.toJSONString(noticeVo));
                } catch (Exception e) {
                    logger.error(""+e.getStackTrace());
                }
                logger.debug(msg);
            }

            //将即时报告中的状态改为相应的汉字
            if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(obj.getStatus())){
                obj.setStatus(DiseaseEnum.BLOODSUGAR_UP.getLabel());
            }else if(DiseaseEnum.BLOODSUGAR_DOWN.getValue().equals(obj.getStatus())){
                obj.setStatus(DiseaseEnum.BLOODSUGAR_DOWN.getLabel());
            }else if(DiseaseEnum.BLOODSUGAR_NOMAL.getValue().equals(obj.getStatus())){
                obj.setStatus(DiseaseEnum.BLOODSUGAR_NOMAL.getLabel());
            }
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
                    userWaveVo.getBeforeEigenValueMap());
            logger.info("计算血液粘稠度报告 成功");
            return reportDisease;
        } catch (Exception e) {
            logger.error("计算血液粘稠度报告 失败",e);
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
    public User queryUserByImei(String imei) {
        return userMapper.queryUserByImei(imei);
    }

}
