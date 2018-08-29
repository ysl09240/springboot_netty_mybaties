package com.shxseer.watch.service;

import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.model.*;
import com.shxseer.watch.vo.EigenValueScaleVo;

import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  特征值service接口
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.IEigenValueService
 * @date 2017年10月19日 15:15
 */
public interface IEigenValueService {

    /**
     * 添加新特征值
     * @param eigenValueOne 新特征值一实体类
     * @param eigenValueTwo 新特征值二实体类
     * @param eigenValueThree 新特征值三实体类
     * @param eigenValueFour 新特征值四实体类
     * @param eigenValueFive 新特征值五实体类
     */
    InvokeResult saveNewEigenRecord(EigenValueOne eigenValueOne, EigenValueTwo eigenValueTwo,
                                    EigenValueThree eigenValueThree, EigenValueFour eigenValueFour,
                                    EigenValueFive eigenValueFive);

    /**
     * 根据原始数据id查询新特征值五个对象
     * @param waveId
     * @return
     */
    Map<String, Object> getNewEigenValuebyWaveId(String waveId);

    /**
     * 根据原始数据主键id查询需要计算尺度值的特征值对象
     * @param waveId
     * @return
     * @throws Exception
     */
    EigenValueScaleVo getEigenValueScalebyWaveId(String waveId);

}
