package com.shxseer.watch.thread;

import com.shxseer.watch.utils.HttpUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static Logger logger = LoggerFactory.getLogger(ExecutorService.class);

//    @PostConstruct
    public void start(){
        ThreadPoolExecutor executor = new ThreadPoolExecutor(4, 4, 200, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(2));
        for (int i=0;i<3;i++){
            executor.execute(new TaskTread());
        }
    }

}
