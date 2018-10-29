package com.shxseer.watch.service;

import com.shxseer.watch.model.*;

import java.util.Map;

/**
 * 病症尺度值service接口
 * @author zhangliang
 * @since 2018-07-31 10:34
 */
public interface IDiseaseScaleValueService {
    /**
     * 添加病症尺度值
     * @param diseaseScaleValueOne 病症尺度值实体类一对象
     * @param diseaseScaleValueOne 病症尺度值实体类二对象
     * @param diseaseScaleValueThree 病症尺度值实体类三对象
     * @param diseaseScaleValueThree 病症尺度值实体类三对象
     * @param diseaseScaleValueFour 病症尺度值实体类四对象
     */
    void addDiseaseScaleValue(DiseaseScaleValueOne diseaseScaleValueOne,
                              DiseaseScaleValueTwo diseaseScaleValueTwo,
                              DiseaseScaleValueThree diseaseScaleValueThree,
                              DiseaseScaleValueFour diseaseScaleValueFour);

    /**
     * 根据用户id查询此用户的尺度值对象
     * @param userId
     * @return
     */
    Map<String, Object> getDiseaseScaleValueByUserId(String userId);

    /**
     * 根据设备号查询用户是否有尺度值
     * @param bloodBaselineBean
     * @return
     */
    String getDiseaseScaleId(BloodBaselineBean bloodBaselineBean);
}
