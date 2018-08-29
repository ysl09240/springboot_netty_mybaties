package com.shxseer.watch.service.impl;

import com.shxseer.watch.dao.DiseaseScaleValueMapper;
import com.shxseer.watch.model.DiseaseScaleValueOne;
import com.shxseer.watch.model.DiseaseScaleValueThree;
import com.shxseer.watch.model.DiseaseScaleValueTwo;
import com.shxseer.watch.service.IDiseaseScaleValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 病症尺度值service实现类
 * @author zhangliang
 * @since 2018-07-31 10:35
 */
@Service("diseaseScaleValueService")
public class DiseaseScaleValueServiceImpl implements IDiseaseScaleValueService {

    private static Logger log = LoggerFactory.getLogger(DiseaseScaleValueServiceImpl.class);

    @Autowired
    private DiseaseScaleValueMapper diseaseScaleValueMapper;

    /**
     * 添加病症尺度值
     * @param diseaseScaleValueOne 病症尺度值实体类一对象
     * @param diseaseScaleValueOne 病症尺度值实体类二对象
     * @param diseaseScaleValueThree 病症尺度值实体类三对象
     */
    @Override
    public void addDiseaseScaleValue(DiseaseScaleValueOne diseaseScaleValueOne,
                                     DiseaseScaleValueTwo diseaseScaleValueTwo,
                                     DiseaseScaleValueThree diseaseScaleValueThree){
        try {
            diseaseScaleValueMapper.addDiseaseScaleValueOne(diseaseScaleValueOne);
            log.info("向病症尺度值表一中插入数据 成功");
            diseaseScaleValueMapper.addDiseaseScaleValueTwo(diseaseScaleValueTwo);
            log.info("向病症尺度值表二中插入数据 成功");
            diseaseScaleValueMapper.addDiseaseScaleValueThree(diseaseScaleValueThree);
            log.info("向病症尺度值表三中插入数据 成功");
        } catch (Exception e) {
            log.error("向病症尺度值表中插入数据 失败", e);
        }
    }

    /**
     * 根据用户id查询此用户的尺度值对象
     * @param userId
     * @return
     */
    @Override
    public Map<String, Object> getDiseaseScaleValueByUserId(String userId){
        try {
            Map<String, Object> returnMap = new HashMap<String, Object>();
            DiseaseScaleValueOne diseaseScaleValueOne = diseaseScaleValueMapper.getDiseaseScaleValueOneByUserId(userId);
            if(diseaseScaleValueOne != null){
                DiseaseScaleValueTwo diseaseScaleValueTwo = diseaseScaleValueMapper.getDiseaseScaleValueTwoByOneId(diseaseScaleValueOne.getId());
                DiseaseScaleValueThree diseaseScaleValueThree = diseaseScaleValueMapper.getdiseaseScaleValueThreeByOneId(diseaseScaleValueOne.getId());
                returnMap.put("diseaseScaleValueOne", diseaseScaleValueOne);
                returnMap.put("diseaseScaleValueTwo", diseaseScaleValueTwo);
                returnMap.put("diseaseScaleValueThree", diseaseScaleValueThree);
                log.info("根据用户id查询此用户的尺度值对象 成功");
                return returnMap;
            }
        } catch (Exception e) {
            log.error("根据用户id查询此用户的尺度值对象 失败", e);
        }
        return null;
    }
}
