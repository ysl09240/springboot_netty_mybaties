package com.shxseer.watch.model;

/**
 * 消息基础类
 *
 * @author yangsonglin
 * @create 2018-07-11 15:34
 **/
public class MessageType {
    public final static Integer MSG_WAVE = 0;
    public final static Integer MSG_SEDENTARY = 1;
    public final static Integer MSG_DIRECT= 2;
    public final static Integer MSG_NOTICE= 3;
    public final static Integer MSG_HEARTBEAT= 4;
    public final static Integer MSG_STEP= 5;
    public final static Integer MSG_HEARTRATE_DATA= 6; //心率数据
    public final static Integer MSG_COMMON_PARAMETERS= 7;
    public final static Integer MSG_BLOOD_BASELINE= 8; //血糖血压基准值
}
