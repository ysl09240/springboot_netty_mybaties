package com.shxseer.watch.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * 病症建议文案 mapper
 * @author zhangliang
 * @since 2018-08-31
 */
@Mapper
@Component(value ="diseaseTipsMapper")
public interface DiseaseTipsMapper {

    /**
     * 查询指定病症下的指定类型的建议文案
     * @param params
     * @return
     * @throws Exception
     */
    List<String> selectDiseaseTips(Map<String, String> params)throws Exception;

}
