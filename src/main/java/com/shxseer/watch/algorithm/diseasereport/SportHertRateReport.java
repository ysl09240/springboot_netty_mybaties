package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.MovementUtils;
import com.shxseer.watch.algorithm.eigenvalue.EigenvalueUtils;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.SplitData;
import com.shxseer.watch.model.EigenValueOne;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.model.User;
import com.shxseer.watch.utils.IdUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 运动预警即时报告相关工具类
 * @author zhangliang
 * @since 2018-08-13 17:42
 */
public class SportHertRateReport {

    /**
     * 运动预警即时报告
     * @param user 用户
     * @param startTime 开始测量时间
     * @param nowEigenValueMap  当前用户的本组波形的五个特征值对象的集合
     * @param beforeEigenValueMap  当前用户的上一组波形的五个特征值对象的集合
     * @return
     * @throws Exception
     */
    public static ReportDisease calculateReportNew(User user, String startTime, Map<String, Object> nowEigenValueMap,
                                                   Map<String, Object> beforeEigenValueMap) throws Exception {
        JSONObject data = new JSONObject();
        //获取计算指数的条件
        EigenValueOne eigenValueOne = (EigenValueOne) nowEigenValueMap.get("eigenValueOne");
        String regex = Constant.EIGENVALUE_SPLIT;
        List<Integer> heartRateList = SplitData.stringToIntegerList(eigenValueOne.getHeartRate(), regex);
        int heartRate = SplitData.countIntegerListAvg(heartRateList);
        List<WaveFormModel> nowWaveFormModelList = EigenvalueUtils.newEigenValueToWaveFormModel(nowEigenValueMap);
        List<WaveFormModel> beforeWaveFormModelList = EigenvalueUtils.newEigenValueToWaveFormModel(beforeEigenValueMap);
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_SPORTHERTRATE;
        data.put("diseaseName", diseaseName);
        //指数
        Map<String, String> returnData = MovementUtils.getMovementValue(heartRate, nowWaveFormModelList.get(0), beforeWaveFormModelList.get(0));
        String number = returnData.get("number");
        data.put("number", number);
        //状态
        data.put("VP", returnData.get("VP"));
        //病症分级
        Map<String,Object> returnMap = DiseaseSuggest.judgeSportHertRate(Integer.parseInt(number));
        data.put("diseaseType", returnMap.get("diseaseType"));
        //是否提示预警
        /*if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(VP)){
            data.put("isWarning",1);
            data.put("pushMessage","建议您适当提高运动强度。查看详情>>");
            data.put("WarningDiseaseTypeName","提高运动强度");
        }else{
        }*/
        data.put("isWarning",0);
        //风险评估
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(1);
        maps.put("data", data);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"17");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

}
