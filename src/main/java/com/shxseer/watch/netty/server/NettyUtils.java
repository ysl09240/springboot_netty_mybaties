package com.shxseer.watch.netty.server;

import io.netty.channel.Channel;

import java.util.HashMap;
import java.util.Map;

/**
 * netty消息处理工具类
 *
 * @author yangsonglin
 * @create 2018-07-11 9:03
 **/
public class NettyUtils {

    public static Map<String, Channel> channelCache = new HashMap<>();



    public static void pushMsg(String channelId,Object bean){
        if(channelCache.containsKey(channelId)){
            Channel channel = channelCache.get(channelId);
            channel.writeAndFlush(bean);
        }
   }

    public static void closeChannel(String channelId){
        if(channelCache.containsKey(channelId)){
            Channel channel = channelCache.get(channelId);
            channel.close();
        }
    }


}
