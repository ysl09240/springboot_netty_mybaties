package com.shxseer.watch.service;

import com.shxseer.watch.model.BloodDatumValue;

import java.util.Map;

/**
 * 血糖血压基准值service接口
 * @author  zhangliang
 * @since 2018/3/1 11:47
*/

public interface IBloodDatumValueService {

    /**
     * 根据用户id和类型查询最新的血糖血压基准值
     * @param maps
     * @return
     */
    BloodDatumValue selectBloodDatumValueByCreateTimeandUserId(Map<String, String> maps);

    /**
     * 判断血糖或血压基准值是否需要更新
     * @param userId 用户id
     * @param nowDate 本次测量的日期
     * @param bloodType 类型（血糖3/血压14）
     * @return result(true代表需要更新，false代表不需要更新)
     */
    boolean checkBloodDatumValue(String userId, String nowDate, String bloodType);

}
