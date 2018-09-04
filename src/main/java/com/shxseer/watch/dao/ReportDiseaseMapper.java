package com.shxseer.watch.dao;

import com.shxseer.watch.model.ReportDisease;
import com.shxseer.watch.vo.BloodPressValueVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  疾病报告mapper接口
 * @Package com.shxseer.seer.mapper
 * @ClassName: com.shxseer.seer.mapper.ReportDiseaseMapper
 * @date 2017年11月08日 16:35
 */
@Mapper
@Component(value ="reportDiseaseMapper")
public interface ReportDiseaseMapper {

    /**
     * 将各种病症计算后的结果保存起来
     * @param reportDisease
     */
    void addReportDisease(ReportDisease reportDisease);

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

    /**
     * 查询当前用户的当天的血黏值
     * @param maps
     */
    List<Double> getDayConsistencyByUserId(Map<String, String> maps);

}