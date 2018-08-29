package com.shxseer.watch.netty.server;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.*;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.handler.timeout.IdleStateHandler;
import io.netty.util.CharsetUtil;

import java.util.concurrent.TimeUnit;


/**
 * 服务端初始化
 *
 * @author yangsonglin
 * @create 2018-07-10 17:24
 **/
public class NettyServerInitializer extends ChannelInitializer<SocketChannel> {

    /**
     * 初始化channel
     */
    @Override
    public void initChannel(SocketChannel ch) throws Exception {
        ByteBuf buf = Unpooled.copiedBuffer("$_".getBytes());
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new IdleStateHandler(600,0,0,TimeUnit.SECONDS));
        pipeline.addLast(new StringEncoder(CharsetUtil.UTF_8));
        pipeline.addLast(new DelimiterBasedFrameDecoder(Integer.MAX_VALUE, buf));
        pipeline.addLast(new StringDecoder(CharsetUtil.UTF_8));
        pipeline.addLast(new NettyServerHandler());
        pipeline.addLast(new FileServerHandler());
    }

}
