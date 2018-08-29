package com.shxseer.watch.netty.client;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.utils.FileUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 消息类
 *
 * @author yangsonglin
 * @create 2018-07-17 9:01
 **/
public class Message {

    public static String channelId = "";

    public static String waveData(String json){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("datatype", 0);
        map.put("imei", "TEST1q2w3e4r5t6y");
        map.put("sleepy",0);
        map.put("lrhand",0);
        map.put("filesize","1078650");
        map.put("datanum","90000");
        map.put("starttime",System.currentTimeMillis());
        map.put("uploadtime",System.currentTimeMillis());
        map.put("istestbpbs",0);
        map.put("sportstatus",0);
        String str = FileUtils.readFile("E://shoubiao_data.txt");
        map.put("data",str);
        String mapJson = JSON.toJSONString(map);

        return mapJson;
    }

    public static String bloodBaseIsValid(String json){

        Map<String, Object> map = new HashMap<String, Object>();
        map.put("datatype", 8);
        map.put("imei", "1314");
        String mapJson = JSON.toJSONString(map);

        return mapJson;
    }
}
