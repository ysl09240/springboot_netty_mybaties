package com.shxseer.watch.model;

/**
 * 新特征值二实体类2018-07-17
 * @author zhangliang
 * @since 2018-07-17 14:38
 */
public class EigenValueTwo {
    /**
     * 主键id
     */
    private String id;
    /**
     * 特征值OneId
     */
    private String eigenValueOneId;
    /**
     * 单个脉搏波的宽度
     */
    private String width;
    /**
     * 单个脉搏波的长度
     */
    private String singleLength;
    /**
     * 单个脉搏波的速度
     */
    private String speed;
    /**
     * A1点的值
     */
    private String aoneValue;
    /**
     * A1点的下标
     */
    private String aoneIndex;
    /**
     * A2点的值
     */
    private String atwoValue;
    /**
     * A2点的下标
     */
    private String atwoIndex;
    /**
     * A3点的值
     */
    private String athrValue;
    /**
     * A3点的下标
     */
    private String athrIndex;
    /**
     * B1的值
     */
    private String boneValue;
    /**
     * B1的下标
     */
    private String boneIndex;
    /**
     * B2的值
     */
    private String btwoValue;
    /**
     * B2的下标
     */
    private String btwoIndex;
    /**
     * B3点的值
     */
    private String bthrValue;
    /**
     * B3的下标
     */
    private String bthrIndex;
    /**
     * C1的值
     */
    private String coneValue;
    /**
     * C1的下标
     */
    private String coneIndex;
    /**
     * C2点的值
     */
    private String ctwoValue;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEigenValueOneId() {
        return eigenValueOneId;
    }

    public void setEigenValueOneId(String eigenValueOneId) {
        this.eigenValueOneId = eigenValueOneId;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getSingleLength() {
        return singleLength;
    }

    public void setSingleLength(String singleLength) {
        this.singleLength = singleLength;
    }

    public String getSpeed() {
        return speed;
    }

    public void setSpeed(String speed) {
        this.speed = speed;
    }

    public String getAoneValue() {
        return aoneValue;
    }

    public void setAoneValue(String aoneValue) {
        this.aoneValue = aoneValue;
    }

    public String getAoneIndex() {
        return aoneIndex;
    }

    public void setAoneIndex(String aoneIndex) {
        this.aoneIndex = aoneIndex;
    }

    public String getAtwoValue() {
        return atwoValue;
    }

    public void setAtwoValue(String atwoValue) {
        this.atwoValue = atwoValue;
    }

    public String getAtwoIndex() {
        return atwoIndex;
    }

    public void setAtwoIndex(String atwoIndex) {
        this.atwoIndex = atwoIndex;
    }

    public String getAthrValue() {
        return athrValue;
    }

    public void setAthrValue(String athrValue) {
        this.athrValue = athrValue;
    }

    public String getAthrIndex() {
        return athrIndex;
    }

    public void setAthrIndex(String athrIndex) {
        this.athrIndex = athrIndex;
    }

    public String getBoneValue() {
        return boneValue;
    }

    public void setBoneValue(String boneValue) {
        this.boneValue = boneValue;
    }

    public String getBoneIndex() {
        return boneIndex;
    }

    public void setBoneIndex(String boneIndex) {
        this.boneIndex = boneIndex;
    }

    public String getBtwoValue() {
        return btwoValue;
    }

    public void setBtwoValue(String btwoValue) {
        this.btwoValue = btwoValue;
    }

    public String getBtwoIndex() {
        return btwoIndex;
    }

    public void setBtwoIndex(String btwoIndex) {
        this.btwoIndex = btwoIndex;
    }

    public String getBthrValue() {
        return bthrValue;
    }

    public void setBthrValue(String bthrValue) {
        this.bthrValue = bthrValue;
    }

    public String getBthrIndex() {
        return bthrIndex;
    }

    public void setBthrIndex(String bthrIndex) {
        this.bthrIndex = bthrIndex;
    }

    public String getConeValue() {
        return coneValue;
    }

    public void setConeValue(String coneValue) {
        this.coneValue = coneValue;
    }

    public String getConeIndex() {
        return coneIndex;
    }

    public void setConeIndex(String coneIndex) {
        this.coneIndex = coneIndex;
    }

    public String getCtwoValue() {
        return ctwoValue;
    }

    public void setCtwoValue(String ctwoValue) {
        this.ctwoValue = ctwoValue;
    }

    @Override
    public String toString() {
        return "EigenValueTwo{" +
                "id='" + id + '\'' +
                ", eigenValueOneId='" + eigenValueOneId + '\'' +
                ", width=" + width +
                ", singleLength=" + singleLength +
                ", speed=" + speed +
                ", aoneValue=" + aoneValue +
                ", aoneIndex=" + aoneIndex +
                ", atwoValue=" + atwoValue +
                ", atwoIndex=" + atwoIndex +
                ", athrValue=" + athrValue +
                ", athrIndex=" + athrIndex +
                ", boneValue=" + boneValue +
                ", boneIndex=" + boneIndex +
                ", btwoValue=" + btwoValue +
                ", bthrValue=" + bthrValue +
                ", bthrIndex=" + bthrIndex +
                ", coneValue=" + coneValue +
                ", coneIndex=" + coneIndex +
                ", ctwoValue=" + ctwoValue +
                '}';
    }
}
