package com.shxseer.watch.controller;

import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.model.WaveDataUpBean;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.vo.DrugStoreVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 测试
 *
 * @author yangsonglin
 * @create 2018-07-09 17:32
 **/
@Controller
public class CommandController {

    private static Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    CommandService commandService;

    @Autowired
    RedisDBHelper redisDBHelper;

    @RequestMapping("/hello")
    @ResponseBody
    public DrugStoreVo hello(@RequestParam String id) {
        logger.debug(String.valueOf(redisDBHelper.get("aaaaa")));
        return commandService.findDrugStore(id);
    }

    /**
     * 波形保存
     */
    @RequestMapping("/waveSave")
    @ResponseBody
    public void save(@RequestParam String imei) {
        logger.debug(String.valueOf(redisDBHelper.hashGet("firstmap", "firstkey")));
        //WaveDataUpBean waveDataUpBean = JSON.parseObject(json, WaveDataUpBean.class);
        WaveDataUpBean waveDataUpBean = new WaveDataUpBean();
        waveDataUpBean.setImei(imei);
        commandService.waveSave(waveDataUpBean);
    }



}
