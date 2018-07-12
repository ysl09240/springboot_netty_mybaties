package com.shxseer.watch.service.impl;

import com.shxseer.watch.dao.HelloMapper;
import com.shxseer.watch.service.HelloService;
import com.shxseer.watch.vo.DrugStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @author yangsonglin
 * @create 2018-07-09 17:33
 **/
@Service
public class HelloServiceImpl implements HelloService {

    @Autowired
    HelloMapper helloMapper;

    @Override
    public DrugStoreVo findDrugStore(String id) {
        return helloMapper.findDrugStore(id);
    }
}
