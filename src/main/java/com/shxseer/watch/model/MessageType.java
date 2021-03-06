package com.shxseer.watch.model;

/**
 * 消息基础类
 *
 * @author yangsonglin
 * @create 2018-07-11 15:34
 **/
public class MessageType {

    public final static String STOP_LINE="\r\n";

    public final static Integer MSG_WAVE = 0;
    public final static Integer MSG_SEDENTARY = 1;
    public final static Integer MSG_DIRECT= 2;
    public final static Integer MSG_NOTICE= 3;
    public final static Integer MSG_HEARTBEAT= 4;
    public final static Integer MSG_STEP= 5;
    public final static Integer MSG_HEARTRATE_DATA= 6; //心率数据
    public final static Integer MSG_COMMON_PARAMETERS= 7;
    public final static Integer MSG_BLOOD_BASELINE= 8; //血糖血压基准值

    public final static Integer ISVALID_FALSE = 0;//是否有效——无效
    public final static Integer ISVALID_TRUE = 1;//是否有效——有效

    public final static String RETURN_TYPE_TERIOD = "teriod" ; //疲劳
    public final static String RETURN_TYPE_HOLTCOLD  = "holtCold"; // 风热感冒
    public final static String RETURN_TYPE_COLD  = "cold"; //风寒感冒
    public final static String RETURN_TYPE_BLOODSUGAR  = "bloodSugar"; // 血糖
    public final static String RETURN_TYPE_HEARTATTACK  = "heartAttack"; // 心肌梗死
    public final static String RETURN_TYPE_CORONARYHEARTDISEASE  = "coronaryHeartDisease";   // 冠心病
    public final static String RETURN_TYPE_HYPERLIPAEMIA  = "hyperlipaemia";     // 血脂
    public final static String RETURN_TYPE_MENSTRUATION  = "menstruation";      // 月经前期
    public final static String RETURN_TYPE_CEREBRALINFARCTION  = "cerebralInfarction";       // 脑梗塞
    public final static String RETURN_TYPE_CEREBRALHEMORRHAGE  = "cerebralHemorrhage";    // 脑出血
    public final static String RETURN_TYPE_ARTERIOSCLEROSIS  = "arteriosclerosis";      // 动脉硬化
    public final static String RETURN_TYPE_DRINKWATER  = "drinkWater";    // 喝酒检测
    public final static String RETURN_TYPE_ARTERIOSCLEROSISDEGREE  = "arteriosclerosisDegree";    // 血管阻滞度
    public final static String RETURN_TYPE_HIGHANDLOW  = "highAndLow";    // 血压
    public final static String RETURN_TYPE_FORTHWITH  = "forthwith"; // 积食
    public final static String RETURN_TYPE_SLEEPUALITYQ  = "sleepualityQ";  // 睡眠监测
    public final static String RETURN_TYPE_SPORTHERTRATE  = "sportHertRate"; // 运动预警
    public final static String RETURN_TYPE_BLOODCONSISTENCY  = "bloodConsistency"; // 血液粘稠度
    public final static String RETURN_TYPE_KVALUE  = "kvalue"; // k值

    public final static String IMEI_AND_CHANEL_MAP = "imeiAndChannelMap";

}
