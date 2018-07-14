package com.shxseer.watch.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 常量
 *
 * @author yangsonglin
 * @create 2018-07-10 10:00
 **/
public class CommonQueue {

    private static Logger logger = LoggerFactory.getLogger(CommonQueue.class);

    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>(10000);

    public static void addMsg(String msg){
        Boolean flag = queue.offer(msg);
        if(!flag){
            logger.info("队列数己满:"+queue.size());
        }

    }

    public static String getMsg(){
        String msg = queue.poll();
        if(StringUtils.isEmpty(msg)){
            logger.info("队列己空:"+queue.size());
        }
        return msg;
    }

}
