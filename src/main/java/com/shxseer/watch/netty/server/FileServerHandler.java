package com.shxseer.watch.netty.server;

import com.shxseer.watch.utils.FileUtils;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileOutputStream;
import java.util.Calendar;


public class FileServerHandler extends SimpleChannelInboundHandler<String> {

    private Logger logger = LoggerFactory.getLogger(FileServerHandler.class);
    private static final String CR = System.getProperty("line.separator");

    private String path = "/Users/slin/dumps/upload/data/";

    private FileOutputStream fos;

    /*
     * (non-Javadoc)
     *
     * @see
     * io.netty.channel.ChannelHandlerAdapter#exceptionCaught(io.netty.channel
     * .ChannelHandlerContext, java.lang.Throwable)
     */
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause)
            throws Exception {
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        String filename = "_"+Calendar.getInstance().getTimeInMillis()+".txt";
        FileUtils.writeFile(path,filename,msg);

        logger.info("------------------:"+ctx.channel().id());
    }
}
