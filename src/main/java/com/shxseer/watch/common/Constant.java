package com.shxseer.watch.common;

/**
 * 常量值
 * @author zhangliang
 * @since 2018-07-17 11:20
 */
public class Constant {

    public final static String ANDROID="android";
    public final static String IOS="ios";

    public final static String SUCCESS="1";    // 成功
    public final static String ERROR="0";      // 失败
    public final static String NO_VALUE ="2";  // 没有值

    public final static int SUCCESS_INT= 1;    // 成功
    public final static int ERROR_INT= 0;      // 失败
    public final static int NO_VALUE_INT = 2;  // 没有值

    //    性别 1:男,0:女
    public final static String MAN="1";
    public final static String WOMAN="0";

    //血糖状态(风险等级)
    public final static String BLOODSUGAR_DOWN="1"; //血糖降低
    public final static String BLOODSUGAR_NOMAL="2"; //血糖正常
    public final static String BLOODSUGAR_UP="3"; //血糖升高

    //计算血糖个性化区间的血糖值最少数量
    public final static int BASICKMEANS_VALUE = 9;

    //计算病症尺度值的特征值（原始数据）最少数量
    public final static int DISEASESCALE_VALUE = 3;

    //特征值多值进行拼接和拆分时用的符号(因为特征值有负数所以不能用“-”)
    public final static String EIGENVALUE_SPLIT = ";";

}