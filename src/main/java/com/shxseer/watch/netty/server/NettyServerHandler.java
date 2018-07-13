package com.shxseer.watch.netty.server;

import com.shxseer.watch.service.HelloService;
import com.shxseer.watch.utils.SpringContextBeanUtils;
import io.netty.channel.*;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.util.concurrent.ScheduledFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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
        ctx.channel().writeAndFlush("OK\r\n88888888888888\r\n");
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
            logger.debug("channelCache.containsKey(channelId), put key:" + channelId);
            channel.closeFuture().addListener(future -> {
                logger.debug("channel close, remove key:" + channelId);
                NettyUtils.channelCache.remove(channelId);
            });
//            ScheduledFuture scheduledFuture = ctx.executor().schedule(
//                    () -> {
//                        logger.debug("schedule runs, close channel:" + channelId);
//                        channel.close();
//                    }, 20, TimeUnit.SECONDS);
            NettyUtils.channelCache.put(channelId, channel);
        }
        super.channelActive(ctx);
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        logger.debug("-------消息来啦："+msg);
        Channel channel = ctx.channel();
        final String channelId = channel.id().toString();
        logger.debug("channelId:" + channelId + " msg:" + msg + " cache:" + NettyUtils.channelCache.size());




//        switch (msg.getType()) {
//            case LiveMessage.TYPE_HEART: {
//                LiveChannelCache cache = channelCache.get(channelId);
//                ScheduledFuture scheduledFuture = ctx.executor().schedule(
//                        () -> channel.close(), 5, TimeUnit.SECONDS);
//                cache.getScheduledFuture().cancel(true);
//                cache.setScheduledFuture(scheduledFuture);
//                ctx.channel().writeAndFlush(msg);
//                break;
//            }
//            case LiveMessage.TYPE_MESSAGE: {
//                channelCache.entrySet().stream().forEach(entry -> {
//                    Channel otherChannel = entry.getValue().getChannel();
//                    otherChannel.writeAndFlush(msg);
//                });
//                break;
//            }
//        }
    }
}
