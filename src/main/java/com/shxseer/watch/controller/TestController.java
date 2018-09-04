package com.shxseer.watch.controller;

import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseScaleUtils;
import com.shxseer.watch.algorithm.eigenvalue.EigenvalueUtils;
import com.shxseer.watch.algorithm.wavetools.Test;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.DiseaseEnum;
import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.model.*;
import com.shxseer.watch.service.*;
import com.shxseer.watch.vo.BloodPressValueVo;
import com.shxseer.watch.vo.UserWaveVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试特征值或即时报告用的接口
 * @author zhangliang
 * @since 2018-07-16 10:12
 */
@RestController
@RequestMapping(value="/test")
@Api(value = "测试用接口", description = "测试")
public class TestController {

    private static Logger log = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private IEigenValueService eigenValueService;

    @Autowired
    private IUserService userService;

    @Autowired
    CommandService commandService;

    @Autowired
    IReportDiseaseService reportDiseaseService;

    @Autowired
    IBloodDatumValueService bloodDatumValueService;

    @Autowired
    private IDiseaseScaleValueService diseaseScaleValueService;

    @Autowired
    private IDiseaseTipsService diseaseTipsService;

    @RequestMapping(value = "/calculateReport", method= RequestMethod.GET)
    @ApiOperation(value = "测试是否能生成报告", notes = "author：zhangliang")
    @ApiImplicitParams({
            @ApiImplicitParam(name="imei",value="设备号",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="startTime",value="测量时间",dataType="String", paramType = "query", required = true),
            @ApiImplicitParam(name="waveId",value="原始波形主键id",dataType="String", paramType = "query", required = true)})
    public InvokeResult calculateReport(String imei, String startTime, String waveId){
        InvokeResult result ;
        try {
            User user = userService.queryUserByImei(imei);
            String userId = user.getId();

            /**
             * 尺度值计算部分
             */
            //查询病症计算所需的尺度值
            Map<String, Object> diseaseScaleMap = diseaseScaleValueService.getDiseaseScaleValueByUserId(userId);
            if(diseaseScaleMap == null) {
                //计算病症所需的尺度值
                List<String> waveIdList = commandService.getWaveIdByimei(imei);
                if (waveIdList != null && waveIdList.size() > 0) {
                    //如果计算尺度值的原始数据id集合不为空
                    int size = waveIdList.size();
                    if (size == Constant.DISEASESCALE_VALUE) {
                        //如果计算尺度值的原始数据id集合的size符合计算尺度值的条件
                        List<Map<String,Object>> eigenValueMapList = new ArrayList<Map<String, Object>>();
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
                        log.info("您测量的数据数为" + size + "，数据量较少，报告正在初始化");
                        return InvokeResult.SuccessResult("您测量的数据数为" + size + "，数据量较少，报告正在初始化");
                    }
                }else{
                    log.info("您测量过的数据数为0");
                    return InvokeResult.SuccessResult("您测量过的数据数为0");
                }
            }
            UserWaveVo userWaveVo = new UserWaveVo();
            userWaveVo.setUser(user);
            userWaveVo.setStartTime(startTime);
            Map<String, String> maps = new HashMap<String, String>(2);
            maps.put("userId", userId);
            maps.put("bloodType", "3");
            BloodDatumValue bsBloodDatumValue = bloodDatumValueService.selectBloodDatumValueByCreateTimeandUserId(maps);
            userWaveVo.setBloodGlucose(bsBloodDatumValue.getDatumValue());
            maps.put("bloodType", "14");
            BloodDatumValue bpBloodDatumValue = bloodDatumValueService.selectBloodDatumValueByCreateTimeandUserId(maps);
            String[] sArray = bpBloodDatumValue.getDatumValue().split("/");
            userWaveVo.setHighPressure(sArray[0]);
            userWaveVo.setLowPressure(sArray[1]);
            //左手
            userWaveVo.setAdornType("0");
            //本次波形的特征值对象
            Map<String, Object> nowEigenValueMap = eigenValueService.getNewEigenValuebyWaveId(waveId);
            userWaveVo.setNowEigenValueMap(nowEigenValueMap);
            //当前用户的上一组波形的特征值对象
            WaveDataUpBean waveDataUpBean = commandService.getWaveDataUpBeanById(waveId);
            String beforeWaveId = commandService.getBeforeWaveIdByStarttime(waveDataUpBean.getImei(), waveDataUpBean.getStarttime());
            if(beforeWaveId != null){
                Map<String, Object> beforeEigenValueMap = eigenValueService.getNewEigenValuebyWaveId(beforeWaveId);
                if(!beforeEigenValueMap.isEmpty()){
                    userWaveVo.setBeforeEigenValueMap(beforeEigenValueMap);
                }
            }
            //病症尺度值map对象
            userWaveVo.setDiseaseScaleMap(diseaseScaleMap);
            //当前用户的当天的血黏值
            List<Double> dayConsistencyList = reportDiseaseService.getDayConsistencyByUserId(userId, startTime);
            userWaveVo.setDayConsistencyList(dayConsistencyList);

            /**
             * 病症即时报告部分
             */
            Map<String,Object> diseaseMap = new HashMap<>();
            /** 血糖报告 */
            //获取当前用户以往测过的血糖参数定量值
            List<Double> bloodValueList = reportDiseaseService.getBloodGlucoseValueByUserId(userId);
            ReportDisease reportDisease = null;
            if(bloodValueList != null){
                //如果以往测过的血糖参数定量值集合不为空
                int size = bloodValueList.size();
                userWaveVo.setBloodValueArray(bloodValueList);
                //计算血糖报告
                reportDisease = commandService.calculateBloodGlucoseReport(userWaveVo);
                if(size < (Constant.BASICKMEANS_VALUE - 1)){
                    //这里不用size的原因:在下面的工具类中给bloodValueList添加了一个值
                    log.info("目前血糖值数量为"+bloodValueList.size()+"，少于计算个性化区间的最少数量，报告初始化中");
                }
            }
            if(reportDisease != null) {
                //处理病症建议
                String suggestList = diseaseTipsService.getRandomDiseaseTips("3");
                reportDisease.setSuggestList(suggestList);
                diseaseMap.put(MessageType.RETURN_TYPE_BLOODSUGAR, reportDisease);
            }
            /** 疲劳报告 */
            reportDisease = commandService.calculateTeriodReport(userWaveVo);
            if(reportDisease != null) {
                //处理病症建议
                String suggestList = diseaseTipsService.getRandomDiseaseTips("0");
                reportDisease.setSuggestList(suggestList);
                diseaseMap.put(MessageType.RETURN_TYPE_TERIOD, reportDisease);
            }
            /** 血压报告 */
            //获取当前用户以往测过的高压值和低压值
            List<BloodPressValueVo> bloodPressList = reportDiseaseService.getBloodPressValueByUserId(userId);
            if(bloodPressList != null){
                //如果以往测过的血糖参数定量值集合不为空
                int size = bloodPressList.size();
                userWaveVo.setBloodPressList(bloodPressList);
                //计算血压报告
                reportDisease = commandService.calculateBloodPressReport(userWaveVo);
                if(size < (Constant.BASICKMEANS_VALUE - 1)){
                    log.info("目前血压的高压和低压值数量为"+(size + 1)+"，少于计算个性化区间的最少数量，报告初始化中");
                }
            }
            if(reportDisease != null) {
                //处理病症建议
                String suggestList = diseaseTipsService.getRandomDiseaseTips("14");
                reportDisease.setSuggestList(suggestList);
                diseaseMap.put(MessageType.RETURN_TYPE_HIGHANDLOW, reportDisease);
            }
            /** 运动预警报告 */
            reportDisease = commandService.calculateSportHertRateReport(userWaveVo);
            if(reportDisease != null) {
                //处理病症建议
                String suggestList = diseaseTipsService.getRandomDiseaseTips("17");
                reportDisease.setSuggestList(suggestList);
                diseaseMap.put(MessageType.RETURN_TYPE_SPORTHERTRATE, reportDisease);
            }
            /** 血液粘稠度报告 */
            reportDisease = commandService.calculateBloodConsistencyReport(userWaveVo);
            if(reportDisease != null) {
                //处理病症建议
                String suggestList = diseaseTipsService.getRandomDiseaseTips("18");
                reportDisease.setSuggestList(suggestList);
                diseaseMap.put(MessageType.RETURN_TYPE_BLOODCONSISTENCY, reportDisease);
            }

            //将病症对象存进数据库表中
            for (Map.Entry<String, Object> entry : diseaseMap.entrySet()) {
                //将即时报告对象存进数据库
                ReportDisease obj = (ReportDisease) entry.getValue();
                reportDiseaseService.saveReportDisease(obj);

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
            result = InvokeResult.SuccessResult("测试是否能生成健康报告 成功,目前血糖值数量为:"+bloodValueList.size(), diseaseMap);
        } catch (Exception e) {
            log.error("测试是否能生成健康报告 失败", e);
            result = InvokeResult.Fail("测试是否能生成健康报告 失败");
        }
        return result;
    }

    @RequestMapping(value = "/calculateNewEigenvalue", method= RequestMethod.GET)
    @ApiOperation(value = "测试是否能生成新特征值", notes = "author：zhangliang")
    @ApiImplicitParam(name="waveId",value="原始数据id",dataType="String", paramType = "query", required = true)
    public InvokeResult calculateNewEigenvalue(String waveId){
        InvokeResult result ;
        try {
            String path = "D:\\Wave\\before.txt";
            String exePath = "D:\\Wave\\preprocess.exe";
            UserWaveVo userWaveVo = new UserWaveVo();
            //WaveDataUpBean waveDataUpBean = commandService.getWaveDataUpBeanById(waveId);
            //double[] d = Test.getArray(waveDataUpBean.getData());
            double[] d = Test.getDoubleArray(path, exePath);
            userWaveVo.setExePath(exePath);
            userWaveVo.setWaveArray(d);
            Map<String,Object> returnMap = EigenvalueUtils.getNewEigenValue(userWaveVo);
            EigenValueOne eigenValueOne = (EigenValueOne) returnMap.get("eigenValueOne");
            EigenValueTwo eigenValueTwo = (EigenValueTwo) returnMap.get("eigenValueTwo");
            EigenValueThree eigenValueThree = (EigenValueThree) returnMap.get("eigenValueThree");
            EigenValueFour eigenValueFour = (EigenValueFour) returnMap.get("eigenValueFour");
            EigenValueFive eigenValueFive = (EigenValueFive) returnMap.get("eigenValueFive");
            if(eigenValueOne != null){
                eigenValueOne.setWaveId(waveId);
            }
            eigenValueService.saveNewEigenRecord(eigenValueOne, eigenValueTwo, eigenValueThree, eigenValueFour, eigenValueFive);
            result = InvokeResult.SuccessResult("测试是否能生成新特征值 成功");
        } catch (Exception e) {
            e.printStackTrace();
            result = InvokeResult.Fail("测试是否能生成新特征值 失败");
        }
        return result;
    }

}
