package com.shxseer.watch.thread;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 线程池启动类
 *
 * @author yangsonglin
 * @create 2018-07-14 14:26
 **/
@Component
public class ExecutorService {

    @PostConstruct
    public void start(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2));
        for (int i=0;i<2;i++){
            executor.execute(new TaskTread());
            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
    }
}
