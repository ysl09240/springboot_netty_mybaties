package com.shxseer.watch.thread;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import com.shxseer.watch.common.CommonQueue;
import com.shxseer.watch.common.RedisDBHelper;
import com.shxseer.watch.model.*;
import com.shxseer.watch.netty.server.NettyUtils;
import com.shxseer.watch.service.CommandService;

import com.shxseer.watch.utils.SpringContextBeanUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.util.logging.SimpleFormatter;


/**
 * 任务线程
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
                JSONObject object = JSONObject.parseObject(msg);
                //获取数据类型
                Integer datatypeKey = (Integer) object.get(DATATYPE_KEY);
                 //获取channelId
                String imei = String.valueOf(object.get(IMEI_KEY));

                String  channelId = (String) redisDBHelper.hashGet(MessageType.IMEI_AND_CHANEL_MAP,imei);

                if(StringUtils.isEmpty(channelId)){
                    logger.info("channelId:"+channelId);
                    continue;
                }
                if (datatypeKey == MessageType.MSG_WAVE) {
                    long startTime=System.currentTimeMillis();
                    //0.脉搏测量——上传
                    String returnJson = waveData(object);
                    long endTime=System.currentTimeMillis();//记录结束时间
                    float excTime=(float)(endTime-startTime)/1000;
                    logger.info("波型处理时间："+excTime+"秒");
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                }else if(datatypeKey.equals(MessageType.MSG_SEDENTARY)){
                //1.久坐提醒上传
                    sedentarySave(object);
                }else if(datatypeKey.equals(MessageType.MSG_HEARTBEAT)){
                    //4.心跳保持
                    String returnJson = heartbeat(object);
                    logger.info("--心跳:"+msg);
                    NettyUtils.pushMsg(channelId,returnJson+MessageType.STOP_LINE);
                }else if(datatypeKey.equals(MessageType.MSG_STEP)){
                    //5.计步上传
                    stepCountSave(object);
                }else if(datatypeKey.equals(MessageType.MSG_HEARTRATE_DATA)){
                    //6.心率上传
                    heartRateDataSave(object);
                }else if(datatypeKey.equals(MessageType.MSG_COMMON_PARAMETERS)){
                    //7,公共参数配置
                    String returnJson = "";
                    NettyUtils.pushMsg(channelId, returnJson + MessageType.STOP_LINE);
                } else if (datatypeKey == MessageType.MSG_BLOOD_BASELINE) {
                    //8.判断血糖血压基准是否有效
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

    /**
     * 心跳保持
     * @param json
     * @return
     */
    private String heartbeat(JSONObject json) {
        HeartBeatBean heartBeatBean = JSON.toJavaObject(json,HeartBeatBean.class);
        WatchUserRecordBean watchUserRecordBean = commandService.findWatchUserRecordByImei(heartBeatBean);
        if(null == watchUserRecordBean){
            heartBeatBean.setBind(0);
            heartBeatBean.setDescription("手表未绑定用户");
        }else {
            heartBeatBean.setBind(1);
            heartBeatBean.setDescription("手表己绑定用户");
        }
        return JSON.toJSONString(heartBeatBean);
    }

    /**
     * 心率上传
     * @param json
     */
    private void heartRateDataSave(JSONObject json) {
        commandService.heartRateDataSave(JSON.toJavaObject(json,HeartRateDataBean.class));
    }


    //解析数据类型
    private String waveData(JSON json){
        WaveDataUpBean waveDataUpBean = JSON.toJavaObject(json,WaveDataUpBean.class);
        String imei = waveDataUpBean.getImei();
        User user = commandService.queryUserByImei(imei);
        //1.脉搏测量——上传
        waveDataUpBean = commandService.waveSave(waveDataUpBean,user);
        logger.info("波型保存成功...");
        Object waveDataDownBean = commandService.waveDealData(waveDataUpBean,user);
        logger.info(JSON.toJSONString(waveDataDownBean));
        return JSON.toJSONString(waveDataDownBean);
    }

    private void sedentarySave(JSON json){
        //2.久坐提醒——上传
        commandService.sedentarySave(JSON.toJavaObject(json, SedentaryBean.class));
    }

    private void stepCountSave(JSON json){
        //5.计步——上传
        commandService.stepCountSave(JSON.toJavaObject(json,StepBean.class));
    }

    private String bloodBaseIsValid(JSON json){
        //8.血糖血压基准值是否有效判断
        return commandService.bloodBaseIsValid(JSON.toJavaObject(json, BloodBaselineBean.class));

    }






}
