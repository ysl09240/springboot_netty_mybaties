package com.shxseer.watch.netty.server;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.common.CommonQueue;
import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.common.StringUtils;
import com.shxseer.watch.model.CommonParamsBean;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.NoticeBean;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.utils.SpringContextBeanUtils;
import com.shxseer.watch.utils.ZipUtils;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
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

    private RedisDBHelper redisDBHelper;
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent){
            IdleStateEvent event = (IdleStateEvent)evt;
            if(event.state() == IdleState.READER_IDLE){
                NoticeBean noticeBean = new NoticeBean();
                noticeBean.setDatatype(MessageType.MSG_NOTICE);
                noticeBean.setContent("超时，you will close");
                noticeBean.setTime(System.currentTimeMillis());
                //清除超时会话
                ChannelFuture writeAndFlush = ctx.writeAndFlush(JSON.toJSONString(noticeBean)+MessageType.STOP_LINE);
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
        CommandService commandService = (CommandService) SpringContextBeanUtils.getBean("commandService");
        CommonParamsBean commonParamsBean = commandService.findCommonParams("ALL");
        if(null != commonParamsBean){
            //7.每次设备连接时服务器公共参数返回
            commonParamsBean.setDatatype(7);
            channel.writeAndFlush(JSON.toJSONString(commonParamsBean)+MessageType.STOP_LINE);
        }
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
            if(msg.length()>2000) {
                //进行解压操作
                msg = ZipUtils.gunzip(msg);
            }
            if (redisDBHelper == null) {
                redisDBHelper = (RedisDBHelper) SpringContextBeanUtils.getBean("redisDBHelper");
            }
            DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String time = df.format(new Date());
            Channel channel = ctx.channel();
            final String channelId = channel.id().toString();
            logger.info("-------消息来啦 time:" + time + " channelId:" + channelId + " msg:" + msg + " cache:" + NettyUtils.channelCache.size());
            String imei = String.valueOf(JSON.parseObject(msg).get("imei"));
            if (!NettyUtils.channelCache.containsKey(channelId)) {
                //获取数据类型
                //获取channelId
                channel.closeFuture().addListener(future -> {
                    logger.info("channel close, remove key:" + channelId);
                    NettyUtils.channelCache.remove(channelId);
                    redisDBHelper.hashRemove(MessageType.IMEI_AND_CHANEL_MAP, imei);
                });
//            ScheduledFuture scheduledFuture = ctx.executor().schedule(
//                    () -> {
//                        logger.debug("schedule runs, close channel:" + channelId);
//                        channel.close();
//                    }, 20, TimeUnit.SECONDS);
                NettyUtils.channelCache.put(channelId, channel);
                //将imei和channeId放入缓存
                redisDBHelper.hashPut(MessageType.IMEI_AND_CHANEL_MAP, imei, channelId);
            } else {
                String rChannelId = (String) redisDBHelper.hashGet(MessageType.IMEI_AND_CHANEL_MAP, imei);
                if (StringUtils.isEmpty(rChannelId)) {
                    redisDBHelper.hashPut(MessageType.IMEI_AND_CHANEL_MAP, imei, channel.id().toString());
                }

            }
            CommonQueue.addMsg(msg);
            channel.flush();
              //可以发送到下一个handler
//            ctx.fireChannelRead(msg);
    }



}
