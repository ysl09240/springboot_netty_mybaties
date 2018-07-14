package com.shxseer.watch.thread;

import com.shxseer.watch.common.CommonQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * 任务线程
 *
 * @author yangsonglin
 * @create 2018-07-14 14:20
 **/
public class TaskTread implements Runnable{

    private static Logger logger = LoggerFactory.getLogger(TaskTread.class);

    @Override
    public void run() {
        while (true){
            logger.debug("线程:"+Thread.currentThread().getName()+"  队列数："+CommonQueue.queue.size());
            String msg = CommonQueue.getMsg();
            if(!StringUtils.isEmpty(msg)){
                logger.debug("---------------------"+msg);
            }else{
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                   logger.error(e.getMessage());
                }
            }
        }
    }
}
