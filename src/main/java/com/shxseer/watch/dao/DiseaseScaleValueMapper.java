package com.shxseer.watch.dao;

import com.shxseer.watch.model.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 病症尺度值mapper接口
 * @author zhangliang
 * @since 2018-07-31 10:18
 */
@Mapper
@Component(value ="diseaseScaleValueMapper")
public interface DiseaseScaleValueMapper {
    /**
     * 添加病症尺度值一
     * @param diseaseScaleValueOne 病症尺度值一实体类对象
     */
    void addDiseaseScaleValueOne(DiseaseScaleValueOne diseaseScaleValueOne) throws Exception;

    /**
     * 添加病症尺度值二
     * @param diseaseScaleValueTwo 病症尺度值二实体类对象
     */
    void addDiseaseScaleValueTwo(DiseaseScaleValueTwo diseaseScaleValueTwo) throws Exception;

    /**
     * 添加病症尺度值三
     * @param diseaseScaleValueThree 病症尺度值三实体类对象
     */
    void addDiseaseScaleValueThree(DiseaseScaleValueThree diseaseScaleValueThree) throws Exception;

    /**
     * 添加病症尺度值四
     * @param diseaseScaleValueFour 病症尺度值四实体类对象
     */
    void addDiseaseScaleValueFour(DiseaseScaleValueFour diseaseScaleValueFour) throws Exception;

    /**
     * 根据用户id查询此用户的尺度值一对象
     * @param userId
     */
    DiseaseScaleValueOne getDiseaseScaleValueOneByUserId(String userId) throws Exception;

    /**
     * 根据用户id查询此用户的尺度值二对象
     * @param diseaseScaleValueOneId
     */
    DiseaseScaleValueTwo getDiseaseScaleValueTwoByOneId(String diseaseScaleValueOneId) throws Exception;

    /**
     * 根据用户id查询此用户的尺度值三对象
     * @param diseaseScaleValueOneId
     */
    DiseaseScaleValueThree getdiseaseScaleValueThreeByOneId(String diseaseScaleValueOneId) throws Exception;

    /**
     * 根据尺度值一id查询此用户的尺度值四对象
     * @param diseaseScaleValueOneId
     */
    DiseaseScaleValueFour getDiseaseScaleValueFourByOneId(String diseaseScaleValueOneId) throws Exception;

    /**
     * 根据设备号查询用户是否有尺度值
     * @param bloodBaselineBean
     * @return
     */
    String getDiseaseScaleId(BloodBaselineBean bloodBaselineBean);
}
