package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.BloodSugarUtils;
import com.shxseer.watch.algorithm.diseasetools.Htest;
import com.shxseer.watch.algorithm.diseasetools.TextPlan;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.SplitData;
import com.shxseer.watch.model.*;
import com.shxseer.watch.utils.IdUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 计算血糖即时报告算法相关的工具类
 * @author zhangliang
 * @since 2018-07-17 10:43
 */
public class BloodSugarReport {
    /**
     * 血糖即时报告
     * @param user 用户
     * @param startTime 开始测量时间
     * @param bloodGlucose  血糖基准值
     * @param nowEigenValueMap  当前用户的本组波形的五个特征值对象的集合
     * @param beforeEigenValueMap  当前用户的上一组波形的五个特征值对象的集合
     * @return
     * @throws Exception
     */
    public static ReportDisease calculateBloodReportNew(User user, String startTime, double bloodGlucose,
                                                        Map<String, Object> nowEigenValueMap, Map<String, Object> beforeEigenValueMap, List<Double> bloodValueArray,
                                                        double altitudeScale, double speedScale, double jzxScale) throws Exception {
        //获取计算血糖参数定量值的条件
        EigenValueOne eigenValueOne = (EigenValueOne) nowEigenValueMap.get("eigenValueOne");
        EigenValueTwo eigenValueTwo = (EigenValueTwo) nowEigenValueMap.get("eigenValueTwo");

        //1、计算血糖参数定量值
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_BLOODSUGAR;
        String regex = Constant.EIGENVALUE_SPLIT;
        //振幅均值
        List<Double> centerValueList = SplitData.stringToDoubleList(eigenValueOne.getCenterValue(), regex);
        double centerValue = SplitData.countDoubleListAvg(centerValueList);
        //速度均值
        List<Double> speedList = SplitData.stringToDoubleList(eigenValueTwo.getSpeed(), regex);
        double speed = SplitData.countDoubleListAvg(speedList);
        //降中峽均值
        List<Double> downcenterValueList = SplitData.stringToDoubleList(eigenValueOne.getDowncenterValue(), regex);
        double downcenterValue = SplitData.countDoubleListAvg(downcenterValueList);
        //血糖参数定量值
        Map<String, Object> returnMap = BloodSugarUtils.getPointSugar(centerValue, bloodGlucose,
                altitudeScale, speedScale, jzxScale, speed, downcenterValue);
        //血糖参数定量值
        double bloodGlucoseValue = (Double) returnMap.get("d_value");
        //用餐状态（0：餐前/1：餐后）
        String eatSataus = (String) returnMap.get("eatSataus");
        double maxValue = 0;
        double minValue = 0;
        String VP = null;
        String diseaseType = null;
        //将本次计算出的血糖参数定量值加入到血糖值集合中
        bloodValueArray.add(bloodGlucoseValue);
        //实例化存放病症对应的三种建议的集合suggestList
        List<String> suggestList = new ArrayList<String>();
        if(bloodValueArray.size() >= Constant.BASICKMEANS_VALUE){
            Htest h=new Htest();
            double[] res = h.getFade(bloodValueArray, Constant.BASICKMEANS_VALUE);
            //个性化区间上限
            maxValue = res[1];
            //个性化区间下限
            minValue = res[0];
            //个性化风险等级
            VP = TextPlan.getSugarTextPlan(minValue, maxValue, bloodGlucoseValue);
            //2、返回状态、分级、建议
            Map<String,Object> bloodSugarMaps = DiseaseSuggest.judgeBloodSugar1(VP);
            //病症的等级
            //病症等级的状态
            diseaseType = (String) bloodSugarMaps.get("diseaseType");
            String dietSuggest = (String) bloodSugarMaps.get("dietSuggest");
            String healthProtectionSuggest = (String) bloodSugarMaps.get("healthProtectionSuggest");
            String otherSuggest = (String) bloodSugarMaps.get("otherSuggest");
            if(dietSuggest!=null){
                suggestList.add(dietSuggest);
            }
            if(healthProtectionSuggest!=null){
                suggestList.add(healthProtectionSuggest);
            }
            if(otherSuggest!=null){
                suggestList.add(otherSuggest);
            }
        }
		//将建议集合返回给前端，不管有没有都要返回（上面的suggest先不要删）
        if(suggestList.size()==0){
            suggestList.add("请保持！");
        }
        //实例化maps里要放的json对象data
        JSONObject data = new JSONObject();
        data.put("suggestList", suggestList);
        data.put("diseaseType", diseaseType);
        //目前血糖里没用到number，但是其他病症用到了所以得有一个默认值
        data.put("number", "0");
        data.put("maxValue", maxValue);
        data.put("minValue", minValue);
        data.put("VP", VP);
        data.put("diseaseName", diseaseName);
        data.put("eatSataus", eatSataus);

        //3、消息推送相关
        /*当有【糖尿病风险】的时候，将数据状态设置后，再推送给自己与群组创建人，最后将数据保存在通知表中*/
        /*if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(VP)){
            data.put("isWarning",1);
            data.put("pushMessage","血糖存在糖尿病风险，建议就医，查看详情>>");
            data.put("WarningDiseaseTypeName","糖尿病风险");
        }else{
        }*/
        data.put("isWarning",0);

		/*4加入风险评估部分*/
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(2);
        maps.put("data", data);
        maps.put("bloodGlucoseValue", bloodGlucoseValue);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"3");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

}
