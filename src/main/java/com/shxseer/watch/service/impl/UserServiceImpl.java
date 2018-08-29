package com.shxseer.watch.service.impl;

import com.shxseer.watch.common.StringUtils;
import com.shxseer.watch.dao.UserMapper;
import com.shxseer.watch.model.User;
import com.shxseer.watch.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author frank  braveheart1115@163.com
 * @Description: 用户service
 * @Package com.shxseer.seer.user.service
 * @ClassName: com.shxseer.seer.user.service.UserService
 * @date 2017年09月27日 09:37
 */

@Service("userService")
public class UserServiceImpl implements IUserService {

    private static Logger log= LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private UserMapper userMapper;

    /**
     * 根据设备号查询用户。
     * @param imei
     * @return
     */
    @Override
    public User queryUserByImei(String imei) throws Exception {
        User user = new User();
        try {
            user=userMapper.queryUserByImei(imei);
            if(null != user){
                user.setHeadPortrait(StringUtils.getBaseURL() + user.getHeadPortrait());
            }
        } catch (Exception e) {
            log.error("查询用户 出错了",e);
        }
        return user;
    }

}
