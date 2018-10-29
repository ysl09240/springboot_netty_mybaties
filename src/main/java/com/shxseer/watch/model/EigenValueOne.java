package com.shxseer.watch.model;

import java.util.Date;

/**
 * 新特征值一实体类2018-07-17
 * @author zhangliang
 * @since 2018-07-17 14:38
 */
public class EigenValueOne {
    /**
     * 特征值主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 原始数据主键id
     */
    private String waveId;
    /**
     * 脉搏速度
     */
    private double pulseSpeed;
    /**
     * 脉搏面积
     */
    private double pulseArea;
    /**
     * 心率
     */
    private String heartRate;
    /**
     * 开始值
     */
    private String startValue;
    /**
     * 开始点的下标
     */
    private String startIndex;
    /**
     * 结束点值
     */
    private String endValue;
    /**
     * 结束点的下标
     */
    private String endIndex;
    /**
     * 振幅值
     */
    private String centerValue;
    /**
     * 振幅下标
     */
    private String centerIndex;
    /**
     * 降中峡值
     */
    private String downcenterValue;
    /**
     * 降中峡的下标
     */
    private String downcenterIndex;
    /**
     * 单个脉搏波的面积
     */
    private String area;

    /**
     * 单个波形的密度
     */
    private String singleWaveLength;

    /**
     * K值
     */
    private double kvalue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getWaveId() {
        return waveId;
    }

    public void setWaveId(String waveId) {
        this.waveId = waveId;
    }

    public double getPulseSpeed() {
        return pulseSpeed;
    }

    public void setPulseSpeed(double pulseSpeed) {
        this.pulseSpeed = pulseSpeed;
    }

    public double getPulseArea() {
        return pulseArea;
    }

    public void setPulseArea(double pulseArea) {
        this.pulseArea = pulseArea;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getStartValue() {
        return startValue;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public String getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(String startIndex) {
        this.startIndex = startIndex;
    }

    public String getEndValue() {
        return endValue;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public String getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(String endIndex) {
        this.endIndex = endIndex;
    }

    public String getCenterValue() {
        return centerValue;
    }

    public void setCenterValue(String centerValue) {
        this.centerValue = centerValue;
    }

    public String getCenterIndex() {
        return centerIndex;
    }

    public void setCenterIndex(String centerIndex) {
        this.centerIndex = centerIndex;
    }

    public String getDowncenterValue() {
        return downcenterValue;
    }

    public void setDowncenterValue(String downcenterValue) {
        this.downcenterValue = downcenterValue;
    }

    public String getDowncenterIndex() {
        return downcenterIndex;
    }

    public void setDowncenterIndex(String downcenterIndex) {
        this.downcenterIndex = downcenterIndex;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getSingleWaveLength() {
        return singleWaveLength;
    }

    public void setSingleWaveLength(String singleWaveLength) {
        this.singleWaveLength = singleWaveLength;
    }

    public double getKvalue() {
        return kvalue;
    }

    public void setKvalue(double kvalue) {
        this.kvalue = kvalue;
    }

    @Override
    public String toString() {
        return "EigenValueOne{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", waveId='" + waveId + '\'' +
                ", pulseSpeed='" + pulseSpeed + '\'' +
                ", pulseArea='" + pulseArea + '\'' +
                ", heartRate=" + heartRate +
                ", startValue=" + startValue +
                ", startIndex=" + startIndex +
                ", endValue=" + endValue +
                ", endIndex=" + endIndex +
                ", centerValue=" + centerValue +
                ", centerIndex=" + centerIndex +
                ", downcenterValue=" + downcenterValue +
                ", downcenterIndex=" + downcenterIndex +
                ", area=" + area +
                ", singleWaveLength=" + singleWaveLength +
                ", kvalue=" + kvalue +
                '}';
    }
}
