package com.shxseer.watch.service.impl;

import com.github.pagehelper.util.StringUtil;
import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.dao.ReportDiseaseMapper;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.service.IReportDiseaseService;
import com.shxseer.watch.utils.IdUtils;
import com.shxseer.watch.vo.BloodPressValueVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  @author frank  braveheart1115@163.com
 *  @Description:  疾病报告service接口实现类
 *  @Package com.shxseer.seer.service
 *  @ClassName: com.shxseer.seer.service.ReportDiseaseService
 *  @date 2017年11月08日 17:35
 */
@Service("reportDiseaseService")
public class ReportDiseaseServiceImpl implements IReportDiseaseService {
    private static Logger log= LoggerFactory.getLogger(ReportDiseaseServiceImpl.class);

    @Autowired
    private ReportDiseaseMapper reportDiseaseMapper;

    /**
     * 添加疾病报告 记录
     * @param reportDisease
     */
    @Override
    public InvokeResult saveReportDisease(ReportDisease reportDisease)throws Exception{
        InvokeResult result;
        try {
            if(StringUtil.isEmpty(reportDisease.getId())){
                reportDisease.setId(IdUtils.uuid());
            }
            reportDiseaseMapper.addReportDisease(reportDisease);
            result = InvokeResult.SuccessResult("添加疾病报告 成功");
        } catch (Exception e) {
            result = InvokeResult.Fail("添加疾病报告 失败");
            log.error("添加疾病报告 失败", e);
        }
        return result;
    }

    /**
     * 查询当前用户的所有血糖参数定量值
     * @param userId
     */
    @Override
    public List<Double> getBloodGlucoseValueByUserId(String userId){
        List<Double> returnList = new ArrayList<Double>();
        try {
            returnList = reportDiseaseMapper.getBloodGlucoseValueByUserId(userId);
        } catch (Exception e) {
            log.error("查询当前用户的所有血糖参数定量值 失败", e);
        }
        return returnList;
    }

    /**
     * 查询当前用户的所有血压的高压和低压值
     * @param userId
     */
    @Override
    public List<BloodPressValueVo> getBloodPressValueByUserId(String userId){
        List<BloodPressValueVo> returnList = new ArrayList<BloodPressValueVo>();
        try {
            returnList = reportDiseaseMapper.getBloodPressValueByUserId(userId);
        } catch (Exception e) {
            log.error("查询当前用户的所有血压的高压和低压值 失败", e);
        }
        return returnList;
    }

    /**
     * 查询当前用户的当天的血黏值
     * @param userId
     * @param startTime
     */
    @Override
    public List<Double> getDayConsistencyByUserId(String userId, String startTime){
        List<Double> returnList = new ArrayList<>();
        try {
            Map<String, String> paramMap = new HashMap<>();
            paramMap.put("userId", userId);
            paramMap.put("startTime", startTime.substring(0,10));
            returnList = reportDiseaseMapper.getDayConsistencyByUserId(paramMap);
        } catch (Exception e) {
            log.error("查询当前用户的当天的血黏值 失败", e);
        }
        return returnList;
    }
}
