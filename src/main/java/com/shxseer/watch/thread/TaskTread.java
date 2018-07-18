package com.shxseer.watch.thread;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.common.CommonQueue;
import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.WaveDataUpBean;
import com.shxseer.watch.netty.server.NettyUtils;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.utils.SpringContextBeanUtils;
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

    //数据对应的业务类型的键
    private static String DATATYPE_KEY = "datatype";
    //数据对应的业务类型的键
    private static String CHANNEL_ID_KEY = "channelId";

    private CommandService commandService;
    public TaskTread(){

    }

    @Override
    public void run() {
        commandService = (CommandService) SpringContextBeanUtils.getBean("commandService");
        while (true) {
            logger.debug("线程:" + Thread.currentThread().getName() + "  队列数：" + CommonQueue.queue.size());
            String msg = CommonQueue.getMsg();

            if (!StringUtils.isEmpty(msg)) {
                logger.debug("---------------------" + msg);
                //获取数据类型
                Integer datatypeKey = (Integer) JSON.parseObject(msg).get(DATATYPE_KEY);
                    //获取channelId
                String  channelId = String.valueOf(JSON.parseObject(msg).get(CHANNEL_ID_KEY));

                if (datatypeKey == MessageType.MSG_WAVE) {
                    //1.脉搏测量——上传
                    String returnJson = waveData(msg);
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }/*else if(datatypeKey.equals(MessageType.MSG_SEDENTARY)){
                //2.久坐提醒上传
                }else if(datatypeKey.equals(MessageType.MSG_DIRECT)){
                    //3.指令
                }else if(datatypeKey.equals(MessageType.MSG_NOTICE)){
                    //4.推送提醒
                }else if(datatypeKey.equals(MessageType.MSG_HEARTBEAT)){
                    //5.心跳保持
                }else if(datatypeKey.equals(MessageType.MSG_STEP)){
                    //6.计步上传
                }else if(datatypeKey.equals(MessageType.MSG_HEARTRATE_DATA)){
                    //7.心率上传
                }else if(datatypeKey.equals(MessageType.MSG_COMMON_PARAMETERS)){
                    //8.每次设备连接时服务器回复
                }*/ else if (datatypeKey == MessageType.MSG_BLOOD_BASELINE) {
                    //9.判断血糖血压基准是否有效
                    String returnJson = bloodBaseIsValid(msg);
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }
            } else {
                try {
                    Thread.currentThread().sleep(2000);
                } catch (InterruptedException e) {
                    logger.error(e.getMessage());
                }
            }
        }
    }

     //解析数据类型
    private String waveData(String json){
        //1.脉搏测量——上传
        commandService.waveSave(JSON.parseObject(json, WaveDataUpBean.class));

        return "OK\r\n8888888888888888\r\n";

    }

    private String bloodBaseIsValid(String json){
        //8.脉搏测量——上传
        return commandService.bloodBaseIsValid(JSON.parseObject(json, BloodBaselineBean.class));

    }


}
