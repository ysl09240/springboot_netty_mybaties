package com.shxseer.watch.netty.client;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 客户端测试
 *
 * @author yangsonglin
 * @create 2018-07-11 10:56
 **/
@Component
public class NettyClient {
    public static final String IP_ADDR = "127.0.0.1";//服务器地址
    public static final int PORT = 9997;//服务器端口号

//    @PostConstruct
    public static void start(){
        System.out.println("客户端启动...");
        System.out.println("当接收到服务器端字符为 \"OK\" 的时候, 客户端将终止\n");
        while (true) {
            Socket socket = null;
            try {
                //创建一个流套接字并将其连接到指定主机上的指定端口号
                socket = new Socket(IP_ADDR, PORT);
                Scanner scanner = new Scanner(System.in);
                String p = scanner.nextLine();
                if (p.equals("bye")) {
                    socket.close();
                    break;
                }
                //读取服务器端数据
                BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream(), "UTF-8"));
                //向服务器端发送数据
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());


//                Map<String, Object> map = new HashMap<String, Object>();
////                map.put("name", "admin");
////                map.put("age", "23");
////                String mapJson = JSON.toJSONString(map);
////
////                out.writeBytes(mapJson);

                out.writeBytes(p);

                out.flush();
                StringBuilder result = new StringBuilder();
                /**
                 * 注释的这种方法，由于阻塞函数read()的原因，最后一次如果没有读到内容，会阻塞
                 */
//                String line;
//                String newLine = System.getProperty("line.separator");
//                boolean flag = false;
//                while ((line = input.readLine()) != null) {
//                    result.append(flag ? newLine : "").append(line);
//                    flag = true;
//                }
                /**
                 *用下面这种方法比较好
                 */
                do {
                    result.append(input.readLine());
                }while (input.ready());

                String ret = result.toString();
                System.out.println("服务器端返回过来的是: " + ret);
                // 如接收到 "OK" 则断开连接
                if ("OK".equals(ret)) {
                    System.out.println("客户端将关闭连接");
                    Thread.sleep(500);
                }


                out.close();
                input.close();
            } catch (Exception e) {
                System.out.println("客户端异常:" + e.getMessage());
            } finally {
                if (socket != null) {
                    try {
                        socket.close();
                    } catch (IOException e) {
                        socket = null;
                        System.out.println("客户端 finally 异常:" + e.getMessage());
                    }
                }
            }
        }
    }

}