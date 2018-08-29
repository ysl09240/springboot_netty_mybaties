package com.shxseer.watch.dao;

import com.shxseer.watch.model.BloodDatumValue;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * 血糖血压基准值dao接口
 * @author  zhangliang
 * @since 2018/3/1 11:05
 */
@Mapper
@Component(value ="bloodDatumValueMapper")
public interface BloodDatumValueMapper {

    /**
     * 根据用户id和类型查询最新的血糖血压基准值
     * @param maps
     * @return
     */
    BloodDatumValue selectBloodDatumValueByCreateTimeandUserId(Map<String, String> maps)throws Exception;

    /**
     * 查询血压基准值 zmm 添加 2018-03-02
     * @return
     * @throws Exception
     */
    String selectBloodDatumValue(String userId)throws Exception;

    /**
     * 获取血压的基准值 zmm 添加 2018-03-02
     * @param userId
     * @throws Exception
     */
    String selectBloodPressValue(String userId)throws Exception;
}
