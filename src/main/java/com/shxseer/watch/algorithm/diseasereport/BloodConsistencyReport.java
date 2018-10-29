package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.BloodConsistencyUtils;
import com.shxseer.watch.model.EigenValueThree;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.model.User;
import com.shxseer.watch.utils.IdUtils;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 血液粘稠度即时报告相关工具类
 * @author zhangliang
 * @since 2018-08-13 17:05
 */
public class BloodConsistencyReport {

    /**
     * 血液粘稠度即时报告
     * @param user 用户
     * @param startTime 开始测量时间
     * @param nowEigenValueMap  当前用户的本组波形的五个特征值对象的集合
     * @param beforeEigenValueMap  当前用户的上一组波形的五个特征值对象的集合
     * @return
     * @throws Exception
     */
    public static ReportDisease calculateReportNew(User user, String startTime, Map<String, Object> nowEigenValueMap,
                                                   Map<String, Object> beforeEigenValueMap, List<Double> dayConsistencyList) throws Exception {
        JSONObject data = new JSONObject();
        //获取计算指数的条件
        EigenValueThree eigenValueThree = (EigenValueThree) nowEigenValueMap.get("eigenValueThree");
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_BLOODCONSISTENCY;
        data.put("diseaseName", diseaseName);
        //血粘值
        double bloodConsistencyValue = BloodConsistencyUtils.getBloodConsistencyValue(eigenValueThree.getPeresistance());
        DecimalFormat df = new DecimalFormat("######0.00");
        bloodConsistencyValue = Double.parseDouble(df.format(bloodConsistencyValue));
        //指数
        data.put("number", "0");
        //状态
        dayConsistencyList.add(bloodConsistencyValue);
        String VP = BloodConsistencyUtils.getLossGo(dayConsistencyList);
        data.put("VP", VP);
        //病症分级
        Map<String,Object> returnMap = DiseaseSuggest.judgeBloodConsistency(VP);
        data.put("diseaseType", returnMap.get("diseaseType"));
        //是否提示预警
        /*if(DiseaseEnum.BLOODSUGAR_UP.getValue().equals(VP)){
            data.put("isWarning",1);
            data.put("pushMessage","建议您适当提高血液粘稠度。查看详情>>");
            data.put("WarningDiseaseTypeName","提高血液粘稠度");
        }else{
            data.put("isWarning",0);
        }*/
        data.put("isWarning",0);
		//风险评估
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(2);
        maps.put("data", data);
        //将血黏值存放进血糖参数定量值字段中
        maps.put("bloodGlucoseValue", bloodConsistencyValue);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"18");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

}
