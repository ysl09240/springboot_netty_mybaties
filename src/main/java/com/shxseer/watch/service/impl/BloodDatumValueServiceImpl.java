package com.shxseer.watch.service.impl;

import com.shxseer.watch.common.DateUtils;
import com.shxseer.watch.dao.BloodDatumValueMapper;
import com.shxseer.watch.model.BloodDatumValue;
import com.shxseer.watch.service.IBloodDatumValueService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 血糖血压基准值service实现类
 * @author  zhangliang
 * @since 2018/3/1 11:51
 */
@Service("bloodDatumValueService")
public class BloodDatumValueServiceImpl implements IBloodDatumValueService {

    private static final Logger log = LoggerFactory.getLogger(BloodDatumValueServiceImpl.class);

    @Autowired
    private BloodDatumValueMapper bloodDatumValueMapper;

    /**
     * 根据用户id和类型查询最新的血糖血压基准值
     * @param maps
     * @return
     */
    @Override
    public BloodDatumValue selectBloodDatumValueByCreateTimeandUserId(Map<String,String> maps){
        BloodDatumValue bloodDatumValue=null;
        try {
            bloodDatumValue=bloodDatumValueMapper.selectBloodDatumValueByCreateTimeandUserId(maps);
        } catch (Exception e) {
            log.error("查询血糖血压基准值 失败", e);
        }
        return bloodDatumValue;
    }

    /**
     * 判断血糖或血压基准值是否需要更新
     * @param userId 用户id
     * @param nowDate 本次测量的日期
     * @param bloodType 类型（血糖3/血压14）
     * @return result(true代表需要更新，false代表不需要更新)
     */
    @Override
    public boolean checkBloodDatumValue(String userId, String nowDate, String bloodType){
        //方法的返回值，true代表需要更新，false代表不需要更新
        boolean result = false;
        Map<String,String> maps = new HashMap<String, String>();
        maps.put("userId", userId);
        maps.put("bloodType", bloodType);
        BloodDatumValue bloodDatumValue = null;
        try {
            bloodDatumValue = bloodDatumValueMapper.selectBloodDatumValueByCreateTimeandUserId(maps);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //计算用户设定好的提醒日期（创建日期+标准间隔）
        String settingDate =null;
        if(null != bloodDatumValue){
            settingDate = DateUtils.getAfterDate(bloodDatumValue.getCreateTime(), bloodDatumValue.getStandardInterval());
            //判断两个日期的先后
            result = DateUtils.checkDateSuccessively(nowDate, settingDate);
        }
        return result;
    }

}
