package com.shxseer.watch.model;

import java.util.Date;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  手环上传的原始数据。
 * @Package com.shxseer.seer.po
 * @ClassName: com.shxseer.seer.po.OriginalRecord
 * @date 2017年10月13日 14:57
 */
public class OriginalRecord {
    private String id;//原始数据主键id
    private String dataBody;//原始数据主体（需要将90个包拼接成一个String存进数据库）
    private String startTime;//开始测量时间（yyyy-MM-dd HH:mm:ss）
    private String endTime;// 结束测量时间（yyyy-MM-dd HH:mm:ss）    2017-11-06 添加
    private String deviceId;//设备号
    private String deviceType;//设备类型 (健康仪：ring，手环：bracelet)
    private String userId;//所属用户主键id
    private String totalFrame;//本次上传的所有数据包总个数（90）
    private String frameId;//本次上传的所有数据包的编号
    private String fs;//每个包里的数据总量(500)
    private String feel;//感觉
    private String sportStatus;//运动状态 01、剧烈运动02、运动03、静止
    private String pulseValue;//脉搏值 90个值使用-拼接
    private String heartRate;//心率值
    private String heartRateTime;//心率测量时间      2017-11-06 添加
    private String mac;//Mac地址
    private String highPressure;//血压高压       2017-11-06 添加
    private String lowPressure;//血压低压        2017-11-06 添加
    private String bloodPressureTime;//血压测量完成时间      2017-11-06 添加

    private String dataFile;//数据文件名称 存储在服务器上的磁盘上。
    private Date createTime=new Date();//创建时间
    private String createBy;//创建人
    private double bodyTemperature;//体温      2017-11-06 添加
    private String steps;//步数        2017-11-06 添加
    private String miles;//里程        2017-11-06 添加
    private String calories;//卡路里        2017-11-06 添加
    private String sleepStartTime;//  睡眠开始时间         2017-11-06 添加
    private String sleepEndTime;// 睡眠结束时间        2017-11-06 添加
    private String sleepType;// 睡眠类型（01：深睡，02:浅睡，03:清醒）     2017-11-06 添加
    private double sleepTime;// 睡眠时间         2017-11-06 添加

    public OriginalRecord() {}

    public OriginalRecord(String startTime, String userId) {
        this.startTime = startTime;
        this.userId = userId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDataBody() {
        return dataBody;
    }

    public void setDataBody(String dataBody) {
        this.dataBody = dataBody;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }


    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTotalFrame() {
        return totalFrame;
    }

    public void setTotalFrame(String totalFrame) {
        this.totalFrame = totalFrame;
    }

    public String getFrameId() {
        return frameId;
    }

    public void setFrameId(String frameId) {
        this.frameId = frameId;
    }

    public String getFs() {
        return fs;
    }

    public void setFs(String fs) {
        this.fs = fs;
    }

    public String getFeel() {
        return feel;
    }

    public void setFeel(String feel) {
        this.feel = feel;
    }

    public String getSportStatus() {
        return sportStatus;
    }

    public void setSportStatus(String sportStatus) {
        this.sportStatus = sportStatus;
    }


    public String getPulseValue() {
        return pulseValue;
    }

    public void setPulseValue(String pulseValue) {
        this.pulseValue = pulseValue;
    }


    public String getMac() {
        return mac;
    }

    public void setMac(String mac) {
        this.mac = mac;
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

    public String getBloodPressureTime() {
        return bloodPressureTime;
    }

    public void setBloodPressureTime(String bloodPressureTime) {
        this.bloodPressureTime = bloodPressureTime;
    }

    public String getDataFile() {
        return dataFile;
    }

    public void setDataFile(String dataFile) {
        this.dataFile = dataFile;
    }


    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public double getBodyTemperature() {
        return bodyTemperature;
    }

    public void setBodyTemperature(double bodyTemperature) {
        this.bodyTemperature = bodyTemperature;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public String getMiles() {
        return miles;
    }

    public void setMiles(String miles) {
        this.miles = miles;
    }

    public String getCalories() {
        return calories;
    }

    public void setCalories(String calories) {
        this.calories = calories;
    }

    public String getSleepStartTime() {
        return sleepStartTime;
    }

    public void setSleepStartTime(String sleepStartTime) {
        this.sleepStartTime = sleepStartTime;
    }

    public String getSleepEndTime() {
        return sleepEndTime;
    }

    public void setSleepEndTime(String sleepEndTime) {
        this.sleepEndTime = sleepEndTime;
    }

    public String getSleepType() {
        return sleepType;
    }

    public void setSleepType(String sleepType) {
        this.sleepType = sleepType;
    }

    public double getSleepTime() {
        return sleepTime;
    }

    public void setSleepTime(double sleepTime) {
        this.sleepTime = sleepTime;
    }

    public String getHeartRate() {
        return heartRate;
    }

    public void setHeartRate(String heartRate) {
        this.heartRate = heartRate;
    }

    public String getHeartRateTime() {
        return heartRateTime;
    }

    public void setHeartRateTime(String heartRateTime) {
        this.heartRateTime = heartRateTime;
    }

    @Override
    public String toString() {
        return "OriginalRecord{" +
                "id='" + id + '\'' +
                ", dataBody='" + dataBody + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", deviceId='" + deviceId + '\'' +
                ", deviceType='" + deviceType + '\'' +
                ", userId='" + userId + '\'' +
                ", totalFrame='" + totalFrame + '\'' +
                ", frameId='" + frameId + '\'' +
                ", fs='" + fs + '\'' +
                ", feel='" + feel + '\'' +
                ", sportStatus='" + sportStatus + '\'' +
                ", pulseValue='" + pulseValue + '\'' +
                ", heartRate='" + heartRate + '\'' +
                ", heartRateTime='" + heartRateTime + '\'' +
                ", mac='" + mac + '\'' +
                ", highPressure='" + highPressure + '\'' +
                ", lowPressure='" + lowPressure + '\'' +
                ", bloodPressureTime='" + bloodPressureTime + '\'' +
                ", dataFile='" + dataFile + '\'' +
                ", createTime=" + createTime +
                ", createBy='" + createBy + '\'' +
                ", bodyTemperature=" + bodyTemperature +
                ", steps='" + steps + '\'' +
                ", miles='" + miles + '\'' +
                ", calories='" + calories + '\'' +
                ", sleepStartTime='" + sleepStartTime + '\'' +
                ", sleepEndTime='" + sleepEndTime + '\'' +
                ", sleepType='" + sleepType + '\'' +
                ", sleepTime='" + sleepTime + '\'' +
                "} ";
    }
}
