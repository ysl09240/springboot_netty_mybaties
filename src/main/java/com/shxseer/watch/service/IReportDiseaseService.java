package com.shxseer.watch.service;

import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.vo.BloodPressValueVo;

import java.util.List;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  疾病报告service接口
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.IReportDiseaseService
 * @date 2017年11月08日 17:34
 */
public interface IReportDiseaseService {

    /**
     * 添加疾病报告 记录
     * @param reportDisease
     */
    InvokeResult saveReportDisease(ReportDisease reportDisease)throws Exception;

    /**
     * 查询当前用户的所有血糖参数定量值
     * @param userId
     */
    List<Double> getBloodGlucoseValueByUserId(String userId);

    /**
     * 查询当前用户的所有血压的高压和低压值
     * @param userId
     */
    List<BloodPressValueVo> getBloodPressValueByUserId(String userId);
}
