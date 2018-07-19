package com.shxseer.watch.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shxseer.watch.common.CommonQueue;
import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.SedentaryBean;
import com.shxseer.watch.model.StepBean;
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
    private static String IMEI_KEY = "imei";

    private CommandService commandService;

    private RedisDBHelper redisDBHelper;
    public TaskTread(){

    }

    @Override
    public void run() {
        commandService = (CommandService) SpringContextBeanUtils.getBean("commandService");
        redisDBHelper = (RedisDBHelper) SpringContextBeanUtils.getBean("redisDBHelper");
        while (true) {
            logger.debug("线程:" + Thread.currentThread().getName() + "  队列数：" + CommonQueue.queue.size());
            String msg = CommonQueue.getMsg();

            if (!StringUtils.isEmpty(msg)) {
                logger.debug("---------------------" + msg);
                JSONObject object = JSONObject.parseObject(msg);
                //获取数据类型
                Integer datatypeKey = (Integer) object.get(DATATYPE_KEY);
                 //获取channelId
                String imei = String.valueOf(object.get(IMEI_KEY));

                String  channelId = String.valueOf(redisDBHelper.hashGet(MessageType.IMEI_AND_CHANEL_MAP,imei));

                if (datatypeKey == MessageType.MSG_WAVE) {
                    //1.脉搏测量——上传
                    String returnJson = waveData(object);
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }else if(datatypeKey.equals(MessageType.MSG_SEDENTARY)){
                //2.久坐提醒上传
                    String returnJson = sedentarySave(object);
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }/*else if(datatypeKey.equals(MessageType.MSG_DIRECT)){
                    //3.指令
                }else if(datatypeKey.equals(MessageType.MSG_NOTICE)){
                    //4.推送提醒
                }else if(datatypeKey.equals(MessageType.MSG_HEARTBEAT)){
                    //5.心跳保持
                }*/ else if(datatypeKey.equals(MessageType.MSG_STEP)){
                    //6.计步上传
                    String returnJson = stepCountSave(object);
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }else if(datatypeKey.equals(MessageType.MSG_HEARTRATE_DATA)){
                    //7.心率上传
                }else if(datatypeKey.equals(MessageType.MSG_COMMON_PARAMETERS)){
                    //8.每次设备连接时服务器回复
                } else if (datatypeKey == MessageType.MSG_BLOOD_BASELINE) {
                    //9.判断血糖血压基准是否有效
                    String returnJson = bloodBaseIsValid(object);
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
    private String waveData(JSON json){
        //1.脉搏测量——上传
        commandService.waveSave(JSON.toJavaObject(json,WaveDataUpBean.class));
        return "OK\r\n8888888888888888\r\n";
    }

    private String sedentarySave(JSON json){
        //2.久坐提醒——上传
        commandService.sedentarySave(JSON.toJavaObject(json, SedentaryBean.class));
        return "OK\r\n8888888888888888\r\n";
    }

    private String stepCountSave(JSON json){
        //5.计步——上传
        commandService.stepCountSave(JSON.toJavaObject(json, StepBean.class));
        return "OK\r\n8888888888888888\r\n";
    }

    private String bloodBaseIsValid(JSON json){
        //8.血糖血压基准值是否有效判断
        return commandService.bloodBaseIsValid(JSON.toJavaObject(json, BloodBaselineBean.class));

    }


}
