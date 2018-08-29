package com.shxseer.watch.vo;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  病症报告曲线需要的属性
 * @Package com.shxseer.seer.vo
 * @ClassName: com.shxseer.seer.vo.ReportDiseaseCurveVo
 * @date 2017年11月28日 11:12
 */
public class ReportDiseaseCurveVo {
    private String userId;          //用户id
    private int diseaseCode;     //病症编号
    private String exponent;        //指数
    private String startTime;       //脉搏开始测量时间（yyyy-MM-dd HH:mm:ss）
    private double bloodGlucoseValue; //餐前或餐后血糖参数定量值
    private String highPressure; //血压高压
    private String lowPressure; //血压低压
    private double bloodPressure; // 血压差(高压-低压)
    private String adornType;      //佩戴方式

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(int diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getBloodGlucoseValue() {
        return bloodGlucoseValue;
    }

    public void setBloodGlucoseValue(double bloodGlucoseValue) {
        this.bloodGlucoseValue = bloodGlucoseValue;
    }

    public String getHighPressure() {
        return highPressure;
    }

    public void setHighPressure(String highPressure) {
        this.highPressure = highPressure;
    }

    public String getLowPressure() {
        return lowPressure;
    }

    public void setLowPressure(String lowPressure) {
        this.lowPressure = lowPressure;
    }

    public double getBloodPressure() {
        return bloodPressure;
    }

    public void setBloodPressure(double bloodPressure) {
        this.bloodPressure = bloodPressure;
    }

    public String getAdornType() {
        return adornType;
    }

    public void setAdornType(String adornType) {
        this.adornType = adornType;
    }

    @Override
    public String toString() {
        return "ReportDiseaseCurveVo{" +
                "userId='" + userId + '\'' +
                ", diseaseCode=" + diseaseCode +
                ", exponent='" + exponent + '\'' +
                ", startTime='" + startTime + '\'' +
                ", bloodGlucoseValue=" + bloodGlucoseValue +
                ", highPressure='" + highPressure + '\'' +
                ", lowPressure='" + lowPressure + '\'' +
                ", bloodPressure=" + bloodPressure +
                ", adornType='" + adornType + '\'' +
                '}';
    }
}
