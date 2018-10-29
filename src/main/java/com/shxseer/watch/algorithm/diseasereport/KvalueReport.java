package com.shxseer.watch.algorithm.diseasereport;

import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.algorithm.diseasereport.reportutils.DiseaseSuggest;
import com.shxseer.watch.algorithm.diseasetools.KvalueUtils;
import com.shxseer.watch.model.EigenValueOne;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.model.User;
import com.shxseer.watch.utils.IdUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * K值即时报告相关工具类
 * @author zhangliang
 * @since 2018-09-25 11:47
 */
public class KvalueReport {

    /**
     * K值即时报告
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
        //病症名称
        String diseaseName = MessageType.RETURN_TYPE_KVALUE;
        data.put("diseaseName", diseaseName);
        //K值
        double kvalue = eigenValueOne.getKvalue();
        //指数
        data.put("number", "0");
        //状态
        String VP = KvalueUtils.getK_Value(kvalue);
        data.put("VP", VP);
        //病症分级
        Map<String,Object> returnMap = DiseaseSuggest.judgeKvalue(VP);
        data.put("diseaseType", returnMap.get("diseaseType"));
        //是否提示预警
        data.put("isWarning",0);
        //风险评估
        String riskAssessment = DiseaseReportUtils.concludeRiskAssessment(nowEigenValueMap, beforeEigenValueMap);
        data.put("riskAssessment", riskAssessment);

        Map<String,Object> maps = new HashMap<String,Object>(2);
        maps.put("data", data);
        //将K值存放进血糖参数定量值字段中
        maps.put("bloodGlucoseValue", kvalue);

        ReportDisease reportDisease = DiseaseReportUtils.returnFinalResultBean(user,maps,startTime,"19");
        reportDisease.setId(IdUtils.uuid());
        return reportDisease;
    }

}
