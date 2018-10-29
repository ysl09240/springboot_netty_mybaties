package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.eigenvalue.EigenvalueUtils;
import com.shxseer.watch.algorithm.riskassessment.DiseaseGetValue;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import com.shxseer.watch.common.DateUtils;
import com.shxseer.watch.common.StringUtils;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * 即时报告main工具类
 * @author zhangliang
 * @since 2018-07-15 16:25
 */
public class DiseaseReportUtils {

    private static Logger log = LoggerFactory.getLogger(DiseaseReportUtils.class);

    /**
     * 返回即时报告实体类对象
     * @param user
     * @param result
     * @param startTime
     * @param diseaseCode
     * @return
     * @throws Exception
     */
    public static ReportDisease returnFinalResultBean(User user,Map<String,Object> result,String startTime,String diseaseCode) throws Exception {
        String userId = user.getId();
        JSONObject obj= (JSONObject) result.get("data");
        String VP= (String) obj.get("VP");
        String diseaseType= obj.get("diseaseType")+"";
        String riskAssessment=obj.get("riskAssessment")+"";
        String isWarning= obj.get("isWarning")+"";
        String number= obj.get("number") + "";
        //病症达到告警对应级别的名称
        String warningDiseaseTypeName= obj.get("WarningDiseaseTypeName")+"";
        //即时消息推送内容
        String pushMessage= obj.get("pushMessage")+"";
        String diseaseName = obj.get("diseaseName")+"";
        int code = Integer.parseInt(diseaseCode);

        ReportDisease reportDisease=new ReportDisease();
        reportDisease.setDiseaseCode(code);
        reportDisease.setHeadPortrait("/icon/"+diseaseCode+"b.png");
        reportDisease.setUserId(userId);
        reportDisease.setHeadMessage(diseaseType);
        reportDisease.setStatus(VP);
        reportDisease.setExponent(number);
        reportDisease.setRiskAssessment(riskAssessment);
        reportDisease.setOtherRisk(null);
        reportDisease.setTimeScope(DateUtils.getDateMassge(startTime,0.5f));
        reportDisease.setStartTime(startTime);
        reportDisease.setIsWarning(isWarning);
        reportDisease.setDiseaseName(diseaseName);
        if(StringUtils.isNotEmpty(warningDiseaseTypeName)){
            if(!"null".equals(warningDiseaseTypeName)){
                reportDisease.setWarningDiseaseTypeName(warningDiseaseTypeName);
            }
        }else{
            reportDisease.setWarningDiseaseTypeName("");
        }
        if(StringUtils.isNotEmpty(pushMessage)){
            if(!"null".equals(pushMessage)){
                reportDisease.setPushMessage(pushMessage);
            }else{
                reportDisease.setPushMessage("");
            }
        }else{
            reportDisease.setPushMessage("");
        }

        //给报告中的特殊属性赋值
        if(code == 3){
            //血糖的特殊属性
            String tem=result.get("bloodGlucoseValue")+"";
            if(StringUtils.isNotEmpty(tem) && !"null".equals(tem)){
                reportDisease.setBloodGlucoseValue(Double.parseDouble(tem));
            }
            double maxValue = (Double) obj.get("maxValue");
            double minValue = (Double) obj.get("minValue");
            String eatSataus = (String) obj.get("eatSataus");
            reportDisease.setMaxValues(maxValue);
            reportDisease.setMinValue(minValue);
            reportDisease.setEatSataus(eatSataus);
        }else if(code == 14){
            //血压的特殊属性
            double high = (Double) obj.get("high");
            double low = (Double) obj.get("low");
            double pressureMinus = (Double) obj.get("pressureMinus");
            double highMaxValue = (Double) obj.get("highMaxValue");
            double highMinValue = (Double) obj.get("highMinValue");
            double lowMaxValue = (Double) obj.get("lowMaxValue");
            double lowMinValue = (Double) obj.get("lowMinValue");
            reportDisease.setHighPressure(high + "");
            reportDisease.setLowPressure(low + "");
            reportDisease.setBloodPressure(pressureMinus);
            reportDisease.setMaxValues(highMaxValue);
            reportDisease.setMinValue(highMinValue);
            reportDisease.setLowMaxValue(lowMaxValue);
            reportDisease.setLowMinValue(lowMinValue);
        }else if(code == 18){
            //血黏值
            String tem=result.get("bloodGlucoseValue")+"";
            if(StringUtils.isNotEmpty(tem) && !"null".equals(tem)){
                reportDisease.setBloodGlucoseValue(Double.parseDouble(tem));
            }
        }else if(code == 19){
            //K值
            String tem=result.get("bloodGlucoseValue")+"";
            if(StringUtils.isNotEmpty(tem) && !"null".equals(tem)){
                reportDisease.setBloodGlucoseValue(Double.parseDouble(tem));
            }
        }
        return reportDisease;
    }

    /**
     * 得出风险评估
     * @param nowEigenValueMap  当前用户的当前波形的五个特征值对象的集合
     * @param beforeEigenValueMap  当前用户的上一组波形的五个特征值对象的集合
     * @return
     */
    public static String concludeRiskAssessment(Map<String, Object> nowEigenValueMap, Map<String, Object> beforeEigenValueMap){
        String riskAssessment = null;
        if(nowEigenValueMap == null || beforeEigenValueMap == null){
        }else{
            List<WaveFormModel> nowWaveFormModelList = EigenvalueUtils.newEigenValueToWaveFormModel(nowEigenValueMap);
            List<WaveFormModel> beforeWaveFormModelList = EigenvalueUtils.newEigenValueToWaveFormModel(beforeEigenValueMap);
            DiseaseGetValue diseaseGetValue = new DiseaseGetValue(nowWaveFormModelList.get(0), beforeWaveFormModelList.get(0));
            List<String> riskAssessmentList = diseaseGetValue.getDiseaseTimeChangge();
            riskAssessment = StringUtils.userCharJoinString(riskAssessmentList);
        }
        return riskAssessment;
    }

}
