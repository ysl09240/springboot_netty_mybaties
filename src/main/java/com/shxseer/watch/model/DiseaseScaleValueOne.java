package com.shxseer.watch.model;

import java.util.Date;

/**
 * 病症尺度值一实体类
 * @author zhangliang
 * @since 2018-07-31 10:12
 */
public class DiseaseScaleValueOne {
    /**
     * 主键id
     */
    private String id;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;
    /**
     * 用户id
     */
    private String userId;
    /**
     * 开始值尺度
     */
    private double startValueScale;
    /**
     * 开始点的下标尺度
     */
    private double startIndexScale;
    /**
     * 结束点值尺度
     */
    private double endValueScale;
    /**
     * 结束点的下标尺度
     */
    private double endIndexScale;
    /**
     * 振幅尺度
     */
    private double centerValueScale;
    /**
     * 振幅下标尺度
     */
    private double centerIndexScale;
    /**
     * 降中峡尺度
     */
    private double downcenterValueScale;
    /**
     * 降中峡的下标尺度
     */
    private double downcenterIndexScale;
    /**
     * 单个脉搏波的面积尺度
     */
    private double areScale;
    /**
     * 单个脉搏波的宽度尺度
     */
    private double widthScale;
    /**
     * 单个脉搏波的长度尺度
     */
    private double singleLengthScale;
    /**
     * 速度尺度
     */
    private double speedScale;
    /**
     * A1点的值尺度
     */
    private double aoneValueScale;
    /**
     * A1点的下标尺度
     */
    private double aoneIndexScale;
    /**
     * A2点的值尺度
     */
    private double atwoValueScale;
    /**
     * A2点的下标尺度
     */
    private double atwoIndexScale;
    /**
     * A3点的值尺度
     */
    private double athrValueScale;
    /**
     * A3点的下标尺度
     */
    private double athrIndexScale;
    /**
     * B1的值尺度
     */
    private double boneValueScale;
    /**
     * B1的下标尺度
     */
    private double boneIndexScale;
    /**
     * 平均动脉压尺度
     */
    private double averagePressScale;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public double getStartValueScale() {
        return startValueScale;
    }

    public void setStartValueScale(double startValueScale) {
        this.startValueScale = startValueScale;
    }

    public double getStartIndexScale() {
        return startIndexScale;
    }

    public void setStartIndexScale(double startIndexScale) {
        this.startIndexScale = startIndexScale;
    }

    public double getEndValueScale() {
        return endValueScale;
    }

    public void setEndValueScale(double endValueScale) {
        this.endValueScale = endValueScale;
    }

    public double getEndIndexScale() {
        return endIndexScale;
    }

    public void setEndIndexScale(double endIndexScale) {
        this.endIndexScale = endIndexScale;
    }

    public double getCenterValueScale() {
        return centerValueScale;
    }

    public void setCenterValueScale(double centerValueScale) {
        this.centerValueScale = centerValueScale;
    }

    public double getCenterIndexScale() {
        return centerIndexScale;
    }

    public void setCenterIndexScale(double centerIndexScale) {
        this.centerIndexScale = centerIndexScale;
    }

    public double getDowncenterValueScale() {
        return downcenterValueScale;
    }

    public void setDowncenterValueScale(double downcenterValueScale) {
        this.downcenterValueScale = downcenterValueScale;
    }

    public double getDowncenterIndexScale() {
        return downcenterIndexScale;
    }

    public void setDowncenterIndexScale(double downcenterIndexScale) {
        this.downcenterIndexScale = downcenterIndexScale;
    }

    public double getAreScale() {
        return areScale;
    }

    public void setAreScale(double areScale) {
        this.areScale = areScale;
    }

    public double getWidthScale() {
        return widthScale;
    }

    public void setWidthScale(double widthScale) {
        this.widthScale = widthScale;
    }

    public double getSingleLengthScale() {
        return singleLengthScale;
    }

    public void setSingleLengthScale(double singleLengthScale) {
        this.singleLengthScale = singleLengthScale;
    }

    public double getSpeedScale() {
        return speedScale;
    }

    public void setSpeedScale(double speedScale) {
        this.speedScale = speedScale;
    }

    public double getAoneValueScale() {
        return aoneValueScale;
    }

    public void setAoneValueScale(double aoneValueScale) {
        this.aoneValueScale = aoneValueScale;
    }

    public double getAoneIndexScale() {
        return aoneIndexScale;
    }

    public void setAoneIndexScale(double aoneIndexScale) {
        this.aoneIndexScale = aoneIndexScale;
    }

    public double getAtwoValueScale() {
        return atwoValueScale;
    }

    public void setAtwoValueScale(double atwoValueScale) {
        this.atwoValueScale = atwoValueScale;
    }

    public double getAtwoIndexScale() {
        return atwoIndexScale;
    }

    public void setAtwoIndexScale(double atwoIndexScale) {
        this.atwoIndexScale = atwoIndexScale;
    }

    public double getAthrValueScale() {
        return athrValueScale;
    }

    public void setAthrValueScale(double athrValueScale) {
        this.athrValueScale = athrValueScale;
    }

    public double getAthrIndexScale() {
        return athrIndexScale;
    }

    public void setAthrIndexScale(double athrIndexScale) {
        this.athrIndexScale = athrIndexScale;
    }

    public double getBoneValueScale() {
        return boneValueScale;
    }

    public void setBoneValueScale(double boneValueScale) {
        this.boneValueScale = boneValueScale;
    }

    public double getBoneIndexScale() {
        return boneIndexScale;
    }

    public void setBoneIndexScale(double boneIndexScale) {
        this.boneIndexScale = boneIndexScale;
    }

    public double getAveragePressScale() {
        return averagePressScale;
    }

    public void setAveragePressScale(double averagePressScale) {
        this.averagePressScale = averagePressScale;
    }

    @Override
    public String toString() {
        return "DiseaseScaleValueOne{" +
                "id='" + id + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", userId='" + userId + '\'' +
                ", startValueScale=" + startValueScale +
                ", startIndexScale=" + startIndexScale +
                ", endValueScale=" + endValueScale +
                ", endIndexScale=" + endIndexScale +
                ", centerValueScale=" + centerValueScale +
                ", centerIndexScale=" + centerIndexScale +
                ", downcenterValueScale=" + downcenterValueScale +
                ", downcenterIndexScale=" + downcenterIndexScale +
                ", areScale=" + areScale +
                ", widthScale=" + widthScale +
                ", singleLengthScale=" + singleLengthScale +
                ", speedScale=" + speedScale +
                ", aoneValueScale=" + aoneValueScale +
                ", aoneIndexScale=" + aoneIndexScale +
                ", atwoValueScale=" + atwoValueScale +
                ", atwoIndexScale=" + atwoIndexScale +
                ", athrValueScale=" + athrValueScale +
                ", athrIndexScale=" + athrIndexScale +
                ", boneValueScale=" + boneValueScale +
                ", boneIndexScale=" + boneIndexScale +
                ", averagePressScale=" + averagePressScale +
                '}';
    }
}
