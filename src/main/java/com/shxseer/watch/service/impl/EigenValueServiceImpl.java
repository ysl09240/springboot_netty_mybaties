package com.shxseer.watch.service.impl;

import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.dao.EigenValueMapper;
import com.shxseer.watch.model.*;
import com.shxseer.watch.service.IEigenValueService;
import com.shxseer.watch.utils.IdUtils;
import com.shxseer.watch.vo.EigenValueScaleVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  特征值service接口实现类
 * @date 2017年10月19日 15:17
 */
@Service("eigenValueService")
public class EigenValueServiceImpl implements IEigenValueService {

    private static  Logger log=LoggerFactory.getLogger(EigenValueServiceImpl.class);
    @Autowired
    private EigenValueMapper eigenValueMapper;

    /**
     * 添加新特征值
     * @param eigenValueOne 新特征值一实体类
     * @param eigenValueTwo 新特征值二实体类
     * @param eigenValueThree 新特征值三实体类
     * @param eigenValueFour 新特征值四实体类
     * @param eigenValueFive 新特征值五实体类
     */
    @Override
    public InvokeResult saveNewEigenRecord(EigenValueOne eigenValueOne, EigenValueTwo eigenValueTwo,
                                           EigenValueThree eigenValueThree, EigenValueFour eigenValueFour,
                                           EigenValueFive eigenValueFive){
        InvokeResult result;
        try {
            String eigenValueOneId = IdUtils.uuid();
            eigenValueOne.setId(eigenValueOneId);
            eigenValueOne.setCreateTime(new Date());
            eigenValueTwo.setId(IdUtils.uuid());
            eigenValueTwo.setEigenValueOneId(eigenValueOneId);
            eigenValueThree.setId(IdUtils.uuid());
            eigenValueThree.setEigenValueOneId(eigenValueOneId);
            eigenValueFour.setId(IdUtils.uuid());
            eigenValueFour.setEigenValueOneId(eigenValueOneId);
            eigenValueFive.setId(IdUtils.uuid());
            eigenValueFive.setEigenValueOneId(eigenValueOneId);
            eigenValueMapper.addEigenValueOne(eigenValueOne);
            eigenValueMapper.addEigenValueTwo(eigenValueTwo);
            eigenValueMapper.addEigenValueThree(eigenValueThree);
            eigenValueMapper.addEigenValueFour(eigenValueFour);
            eigenValueMapper.addEigenValueFive(eigenValueFive);
            result = InvokeResult.SuccessResult("添加新特征值 成功");
            log.info("添加新特征值 成功");
        } catch (Exception e) {
            result = InvokeResult.SuccessResult("添加新特征值 失败");
            log.error("添加新特征值 失败", e);
        }
        return result;
    }

    /**
     * 根据原始数据id查询新特征值五个对象
     * @param waveId
     * @return
     */
    @Override
    public Map<String, Object> getNewEigenValuebyWaveId(String waveId){
        Map<String, Object> returnMap = new HashMap<String, Object>(5);
        try {
            EigenValueOne eigenValueOne = eigenValueMapper.getEigenValueOnebyWaveId(waveId);
            if(eigenValueOne != null ){
                String eigenValueOneId = eigenValueOne.getId();
                EigenValueTwo eigenValueTwo = eigenValueMapper.getEigenValueTwobyEigenValueOneId(eigenValueOneId);
                EigenValueThree eigenValueThree = eigenValueMapper.getEigenValueThreebyEigenValueOneId(eigenValueOneId);
                EigenValueFour eigenValueFour = eigenValueMapper.getEigenValueFourbyEigenValueOneId(eigenValueOneId);
                EigenValueFive eigenValueFive = eigenValueMapper.getEigenValueFivebyEigenValueOneId(eigenValueOneId);
                returnMap.put("eigenValueOne", eigenValueOne);
                returnMap.put("eigenValueTwo", eigenValueTwo);
                returnMap.put("eigenValueThree", eigenValueThree);
                returnMap.put("eigenValueFour", eigenValueFour);
                returnMap.put("eigenValueFive", eigenValueFive);
                log.info("根据原始数据id查询新特征值五个对象 成功");
            }else{
                log.error("根据原始数据id查询新特征值五个对象 当前waveId无对应特征值数据");
            }
        } catch (Exception e) {
            log.error("根据原始数据id查询新特征值五个对象 失败", e);
        }
        return returnMap;
    }

    /**
     * 根据原始数据主键id查询需要计算尺度值的特征值对象
     * @param waveId
     * @return
     * @throws Exception
     */
    @Override
    public EigenValueScaleVo getEigenValueScalebyWaveId(String waveId){
        try {
            EigenValueScaleVo eigenValueScaleVo = eigenValueMapper.getEigenValueScalebyWaveId(waveId);
            return eigenValueScaleVo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
