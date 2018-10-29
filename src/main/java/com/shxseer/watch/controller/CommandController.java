package com.shxseer.watch.controller;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.common.InvokeResult;
import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.DirectionBean;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.netty.server.NettyUtils;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.utils.HttpUtils;
import com.shxseer.watch.vo.DrugStoreVo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/**
 * 测试
 *
 * @author yangsonglin
 * @create 2018-07-09 17:32
 **/
@RestController
@Api(value = "手机app接口", description = "commandService")
public class CommandController {

    private static Logger logger = LoggerFactory.getLogger(CommandController.class);

    @Autowired
    CommandService commandService;

    @Autowired
    RedisDBHelper redisDBHelper;

    @RequestMapping(value = "/hello" ,method= RequestMethod.POST)
    @ApiOperation(value = "指令下发接口", notes = "author：yangsonglin")
    @ResponseBody
    public String hello(@RequestParam String id) {
//        logger.debug(String.valueOf(redisDBHelper.get("aaaaa")));
        BloodBaselineBean bloodBaselineBean = new BloodBaselineBean();
        bloodBaselineBean.setImei("333333333333333");
        Object obj = commandService.isStartMeasure(bloodBaselineBean);
        return JSON.toJSONString(obj);
    }



    /**
     * 下发指令
     * @param directionBean
     */
    @RequestMapping(value = "/direct" ,method= RequestMethod.POST)
    @ApiOperation(value = "指令下发接口", notes = "author：yangsonglin")
    @ResponseBody
    public String direct(DirectionBean directionBean){
        InvokeResult result = new InvokeResult();
        String imei = directionBean.getImei();
        String channelId = (String) redisDBHelper.hashGet(MessageType.IMEI_AND_CHANEL_MAP,imei);

        if(StringUtils.isEmpty(channelId)){
            result.setCode(0); //false
            result.setMessage("指令下发错误，手表连接己断开");
            return JSON.toJSONString(result);
        }
        NettyUtils.pushMsg(channelId,JSON.toJSONString(directionBean)+MessageType.STOP_LINE);
        result.setCode(1); //true
        result.setMessage("指令己发送");

        return JSON.toJSONString(result);
    }


}
