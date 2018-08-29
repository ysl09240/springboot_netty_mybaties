package com.shxseer.watch;

import com.shxseer.watch.netty.server.NettyServer;
import com.shxseer.watch.thread.ExecutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author yangsonglin
 * @create 2018-07-09 15:34
 **/
@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    NettyServer nettyServer;

    @Autowired
    ExecutorService executorService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        executorService.start();
        nettyServer.start();
    }
}
