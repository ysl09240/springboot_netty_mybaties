package com.shxseer.watch.netty.server;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.common.CommonQueue;
import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.utils.SpringContextBeanUtils;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;


/**
 * 服务端处理器
 *
 * @author yangsonglin
 * @create 2018-07-10 17:25
 **/
public class NettyServerHandler extends SimpleChannelInboundHandler<String> {


    private Logger logger = LoggerFactory.getLogger(NettyServerHandler.class);


    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if(event.state() == IdleState.READER_IDLE){
                //清除超时会话
                ChannelFuture writeAndFlush = ctx.writeAndFlush("超时，you will close");
                writeAndFlush.addListener(new ChannelFutureListener() {
                    @Override
                    public void operationComplete(ChannelFuture future) throws Exception {
                        ctx.channel().close();
                    }
                });
            }
        }else{
            super.userEventTriggered(ctx, evt);
        }
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        logger.debug("channelReadComplete");
        super.channelReadComplete(ctx);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.debug("exceptionCaught");
        if(null != cause) {
            logger.info(cause.getMessage());
        }
        if(null != ctx) ctx.close();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        final String channelId = channel.id().toString();
        Map<String,Object> msg = new HashMap<>();
        msg.put("channelId",channelId);
        channel.writeAndFlush(JSON.toJSONString(msg) +"\r\n");
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        final String channelId = channel.id().toString();
        logger.debug("-------消息来啦 channelId:" + channelId + " msg:" + msg + " cache:" + NettyUtils.channelCache.size());
        if (!NettyUtils.channelCache.containsKey(channelId)) {
            RedisDBHelper redisDBHelper = (RedisDBHelper) SpringContextBeanUtils.getBean("redisDBHelper");
            //获取数据类型
            //获取channelId
            String imei = String.valueOf(JSON.parseObject(msg).get("imei"));
            channel.closeFuture().addListener(future -> {
                logger.debug("channel close, remove key:" + channelId);
                NettyUtils.channelCache.remove(channelId);
                redisDBHelper.hashRemove(MessageType.IMEI_AND_CHANEL_MAP,imei);
            });
//            ScheduledFuture scheduledFuture = ctx.executor().schedule(
//                    () -> {
//                        logger.debug("schedule runs, close channel:" + channelId);
//                        channel.close();
//                    }, 20, TimeUnit.SECONDS);
            NettyUtils.channelCache.put(channelId, channel);
            redisDBHelper.hashPut(MessageType.IMEI_AND_CHANEL_MAP,imei,channelId);

        }
        CommonQueue.addMsg(msg);
        channel.flush();
    }



}
