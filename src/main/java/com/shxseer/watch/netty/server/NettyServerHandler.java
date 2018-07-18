package com.shxseer.watch.netty.server;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.common.CommonQueue;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;
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
        if (!NettyUtils.channelCache.containsKey(channelId)) {
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
            String time1 = (df.format(new Date()));// new Date()为获取当前系统时间
            logger.debug("time:"+time1+" channelCache.containsKey(channelId), put key:" + channelId);
            channel.closeFuture().addListener(future -> {
                String time2 = (df.format(new Date()));// new Date()为获取当前系统时间
                logger.debug("time:"+time2+" channel close, remove key:" + channelId);
                NettyUtils.channelCache.remove(channelId);
            });
//            ScheduledFuture scheduledFuture = ctx.executor().schedule(
//                    () -> {
//                        logger.debug("schedule runs, close channel:" + channelId);
//                        channel.close();
//                    }, 20, TimeUnit.SECONDS);
            NettyUtils.channelCache.put(channelId, channel);
        }
        Map<String,Object> msg = new HashMap<>();
        msg.put("channelId",channelId);
        channel.writeAndFlush(JSON.toJSONString(msg) +"\r\n");
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();
        final String channelId = channel.id().toString();
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String time = (df.format(new Date()));// new Date()为获取当前系统时间
        logger.debug("-------消息来啦 time:"+time+" channelId:" + channelId + " msg:" + msg + " cache:" + NettyUtils.channelCache.size());
        CommonQueue.addMsg(msg);
        channel.flush();
    }



}
