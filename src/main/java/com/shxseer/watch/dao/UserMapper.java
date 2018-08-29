package com.shxseer.watch.dao;

import com.shxseer.watch.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  用户mapper接口
 * @Package com.shxseer.seer.mapper
 * @ClassName: com.shxseer.seer.mapper.UserMapper
 * @date 2017年09月27日 09:38
 */
@Mapper
@Component(value ="userMapper")
public interface UserMapper {

   /**
    * 根据id查询用户。
    * @param imei
    * @return
    */
   User queryUserByImei(String imei);

}
