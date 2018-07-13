package com.shxseer.watch.controller;

import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.service.HelloService;
import com.shxseer.watch.vo.DrugStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 测试
 *
 * @author yangsonglin
 * @create 2018-07-09 17:32
 **/
@Controller
public class HelloController {

    @Autowired
    HelloService helloService;

    @Autowired
    RedisDBHelper redisDBHelper;

    @RequestMapping("/hello")
    @ResponseBody
    public DrugStoreVo hello(@RequestParam String id){
        System.out.println(redisDBHelper.hashGet("firstMap","firstKey"));
        return helloService.findDrugStore(id);
    }
}
