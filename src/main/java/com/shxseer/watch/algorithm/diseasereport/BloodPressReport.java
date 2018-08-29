package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.BloodPress;
import com.shxseer.watch.algorithm.diseasetools.BloodPressUtils;
import com.shxseer.watch.algorithm.diseasetools.Htest;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.model.EigenValueFive;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.model.User;
import com.shxseer.watch.utils.IdUtils;
import com.shxseer.watch.vo.BloodPressValueVo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 血压即时报告相关工具类
 * @author zhangliang
 * @since 2018-08-13 17:06
 */
public class BloodPressReport {

    /**
     * 血压即时报告
     * @param user 用户
     * @param startTime 开始测量时间
     * @param nowEigenValueMap  当前用户的本组波形的五个特征值对象的集合
     * @param beforeEigenValueMap  当前用户的上一组波形的五个特征值对象的集合
     * @return
     * @throws Exception
     */
    public static ReportDisease calculateReportNew(User user, String startTime, String highPressure,
                                                   String lowPressure, Map<String, Object> nowEigenValueMap,
                                                   Map<String, Object> beforeEigenValueMap, List<BloodPressValueVo> bloodPressList,
                                                   double averagePressScale
    ) throws Exception {
        JSONObject data = new JSONObject();
        //获取计算指数的条件
        EigenValueFive eigenValueFive = (EigenValueFive) nowEigenValueMap.get("eigenValueFive");
        double high = Double.parseDouble(highPressure);
        double low = Double.parseDouble(lowPressure);
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_HIGHANDLOW;
        data.put("diseaseName", diseaseName);
        BloodPressUtils bloodPressUtils = new BloodPressUtils(high, low, eigenValueFive.getAveragePress(), averagePressScale);
        BloodPress bloodPress = bloodPressUtils.getPressValueAverage();
        //计算出来的本次高压
        double thisHigh = bloodPress.getBSP();
        //计算出来的本次低压
        double thisLow = bloodPress.getDBP();
        data.put("high", thisHigh);
        data.put("low", thisLow);
        data.put("pressureMinus", thisHigh-thisLow);

        //计算血压的个性化区间
        List<Double> highList = new ArrayList<Double>();
        List<Double> lowList = new ArrayList<Double>();
        double highMaxValue = 0;
        double highMinValue = 0;
        double lowMaxValue = 0;
        double lowMinValue = 0;
        for(BloodPressValueVo bp : bloodPressList){
            highList.add(Double.parseDouble(bp.getHighPressure()));
            lowList.add(Double.parseDouble(bp.getLowPressure()));
        }
        highList.add(thisHigh);
        lowList.add(thisLow);
        if(highList.size() >= Constant.BASICKMEANS_VALUE){
            Htest h=new Htest();
            double[] highRes = h.getFade(highList,Constant.BASICKMEANS_VALUE);
            //高压个性化区间上限
            highMaxValue = highRes[1];
            //高压个性化区间下限
            highMinValue = highRes[0];
            double[] lowRes = h.getFade(lowList,Constant.BASICKMEANS_VALUE);
            //低压个性化区间上限
            lowMaxValue = lowRes[1];
            //低压个性化区间下限
            lowMinValue = lowRes[0];
            data.put("highMaxValue", highMaxValue);
            data.put("highMinValue", highMinValue);
            data.put("lowMaxValue", lowMaxValue);
            data.put("lowMinValue", lowMinValue);
            //个性化风险等级
        }
        int number = 0;
        data.put("number", number+"");
        Map<String,Object> bloodShowMaps = DiseaseSuggest.judgeBloodShow(number);
        //状态
        String VP = (String) bloodShowMaps.get("result");
        data.put("VP", VP);
        //病症分级
        String diseaseType = (String) bloodShowMaps.get("diseaseType");;
        data.put("diseaseType", diseaseType);
        //病症建议
        List<String> suggestList = new ArrayList<String>();
        String dietSuggest = (String) bloodShowMaps.get("dietSuggest");
        String sportSuggest = (String) bloodShowMaps.get("sportSuggest");
        if(dietSuggest!=null){
            suggestList.add(dietSuggest);
        }
        if(sportSuggest!=null){
            suggestList.add(sportSuggest);
        }
        data.put("suggestList", suggestList);
        //是否提示预警
        /*if(VP.equals("三级高血压")){
            data.put("isWarning",1);
            data.put("pushMessage","可能存在3级高血压的风险。查看详情>>");
            data.put("WarningDiseaseTypeName","三级高血压");
        }else{
            data.put("isWarning",0);
        }*/
        data.put("isWarning",0);
        //风险评估
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(1);
        maps.put("data", data);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"14");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

}
