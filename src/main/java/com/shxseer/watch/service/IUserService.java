package com.shxseer.watch.service;

import com.shxseer.watch.model.User;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  用户service
 * @Package com.shxseer.seer.user.service
 * @ClassName: com.shxseer.seer.user.service.IUserService
 * @date 2017年09月27日 09:36
 */
public interface IUserService {

    /**
     * 根据设备号查询用户。
     * @param imei
     * @return
     */
    User queryUserByImei(String imei)throws Exception ;

}
