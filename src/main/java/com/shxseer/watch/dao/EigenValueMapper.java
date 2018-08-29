package com.shxseer.watch.dao;

import com.shxseer.watch.model.*;
import com.shxseer.watch.vo.EigenValueScaleVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 特征值mapper接口
 * @author zhangliang
 * @since 2018-07-12 11:20
 */
@Mapper
@Component(value ="eigenValueMapper")
public interface EigenValueMapper {

    /**
     * 添加特征值一
     * @param eigenValueOne
     * @throws Exception
     */
    void addEigenValueOne(EigenValueOne eigenValueOne)throws Exception;

    /**
     * 添加特征值二
     * @param eigenValueTwo
     * @throws Exception
     */
    void addEigenValueTwo(EigenValueTwo eigenValueTwo)throws Exception;

    /**
     * 添加特征值三
     * @param eigenValueThree
     * @throws Exception
     */
    void addEigenValueThree(EigenValueThree eigenValueThree)throws Exception;

    /**
     * 添加特征值四
     * @param eigenValueFour
     * @throws Exception
     */
    void addEigenValueFour(EigenValueFour eigenValueFour)throws Exception;

    /**
     * 添加特征值五
     * @param eigenValueFive
     * @throws Exception
     */
    void addEigenValueFive(EigenValueFive eigenValueFive)throws Exception;

    /**
     * 根据原始数据主键id查询特征值一对象
     * @param waveId
     * @return
     * @throws Exception
     */
    EigenValueOne getEigenValueOnebyWaveId(String waveId)throws Exception;

    /**
     * 根据特征值一主键id查询特征值二对象
     * @param eigenValueOneId
     * @return
     * @throws Exception
     */
    EigenValueTwo getEigenValueTwobyEigenValueOneId(String eigenValueOneId)throws Exception;

    /**
     * 根据特征值一主键id查询特征值三对象
     * @param eigenValueOneId
     * @return
     * @throws Exception
     */
    EigenValueThree getEigenValueThreebyEigenValueOneId(String eigenValueOneId)throws Exception;

    /**
     * 根据特征值一主键id查询特征值四对象
     * @param eigenValueOneId
     * @return
     * @throws Exception
     */
    EigenValueFour getEigenValueFourbyEigenValueOneId(String eigenValueOneId)throws Exception;

    /**
     * 根据特征值一主键id查询特征值五对象
     * @param eigenValueOneId
     * @return
     * @throws Exception
     */
    EigenValueFive getEigenValueFivebyEigenValueOneId(String eigenValueOneId)throws Exception;

    /**
     * 根据原始数据主键id查询需要计算尺度值的特征值对象
     * @param waveId
     * @return
     * @throws Exception
     */
    EigenValueScaleVo getEigenValueScalebyWaveId(String waveId)throws Exception;

}