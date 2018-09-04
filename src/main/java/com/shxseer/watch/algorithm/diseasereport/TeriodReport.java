package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.FatigueComputeUtils;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.SplitData;
import com.shxseer.watch.model.*;
import com.shxseer.watch.utils.IdUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 疲劳即时报告相关工具类
 * @author zhangliang
 * @since 2018-08-13 17:07
 */
public class TeriodReport {

    /**
     * 疲劳即时报告
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
        List<Integer> singleWaveLengthList = SplitData.stringToIntegerList(eigenValueOne.getSingleWaveLength(), Constant.EIGENVALUE_SPLIT);
        int singleWaveLength = SplitData.countIntegerListAvg(singleWaveLengthList);
        int centerDenty = getCenterDenty(nowEigenValueMap);
        String regex = Constant.EIGENVALUE_SPLIT;
        List<Integer> heartRateList = SplitData.stringToIntegerList(eigenValueOne.getHeartRate(), regex);
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_TERIOD;
        data.put("diseaseName", diseaseName);
        Map<String,String> returnData = FatigueComputeUtils.getFatigueValue(heartRateList,singleWaveLength, centerDenty);
        //指数
        String number = returnData.get("number");
        data.put("number", number);
        //状态
        String VP = returnData.get("VP");
        data.put("VP", VP);
        //病症分级
        Map<String,Object> dsmaps = DiseaseSuggest.tiredSuggest(Integer.parseInt(number));
        data.put("diseaseType", dsmaps.get("diseaseType"));
        //是否提示预警
        /*if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(VP)){
            data.put("isWarning",1);
            data.put("pushMessage","建议您适当休息。查看详情>>");
            data.put("WarningDiseaseTypeName","适当休息一会");
        }else{
            data.put("isWarning",0);
        }*/
        data.put("isWarning",0);
        //风险评估
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(1);
        maps.put("data", data);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"0");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

    /**
     * 计算中层的点
     * @param eigenValueMap
     * @return
     */
    public static int getCenterDenty(Map<String, Object> eigenValueMap){
        int sum = 0;
        EigenValueThree eigenValueThree = (EigenValueThree) eigenValueMap.get("eigenValueThree");
        EigenValueFour eigenValueFour = (EigenValueFour) eigenValueMap.get("eigenValueFour");
        EigenValueFive eigenValueFive = (EigenValueFive) eigenValueMap.get("eigenValueFive");
        String aoneCenterUp = eigenValueThree.getAoneCenterUp();
        sum += getListSum(aoneCenterUp);
        sum += getListSum(eigenValueThree.getAoneCenterDwon());
        sum += getListSum(eigenValueThree.getAtwoCenterUp());
        sum += getListSum(eigenValueThree.getAtwoCenterDwon());
        sum += getListSum(eigenValueThree.getAthrCenterUp());
        sum += getListSum(eigenValueThree.getAthrCenterDwon());
        sum += getListSum(eigenValueFour.getBoneCenterUp());
        sum += getListSum(eigenValueFour.getBoneCenterDwon());
        sum += getListSum(eigenValueFour.getBtwoCenterUp());
        sum += getListSum(eigenValueFour.getBtwoCenterDwon());
        sum += getListSum(eigenValueFour.getBthrCenterUp());
        sum += getListSum(eigenValueFive.getBthrCenterDwon());
        sum += getListSum(eigenValueFive.getConeCenterUp());
        sum += getListSum(eigenValueFive.getConeCenterDwon());
        sum += getListSum(eigenValueFive.getCtwoCenterUp());
        sum += getListSum(eigenValueFive.getCtwoCenterDwon());
        List<Integer> list = SplitData.stringToIntegerList(aoneCenterUp, Constant.EIGENVALUE_SPLIT);
        int avg = sum/list.size();
        return avg;
    }

    /**
     * 计算集合中的值的总和
     * @param s
     * @return
     */
    public static int getListSum(String s){
        int sum = 0;
        List<Integer> list = SplitData.stringToIntegerList(s, Constant.EIGENVALUE_SPLIT);
        for (int i : list) {
            sum += i;
        }
        return sum;
    }

}
