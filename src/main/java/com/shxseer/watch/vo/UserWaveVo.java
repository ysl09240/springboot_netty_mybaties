package com.shxseer.watch.vo;

import com.shxseer.watch.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 计算特征值和即时报告时用的参数实体类
 * @author zhangliang
 * @since 2018-07-17 11:17
 */
public class UserWaveVo {

    private User user;    // 用户对象
    private Map<String,Object> nowEigenValueMap; //当前用户的本组波形的五个特征值对象的集合
    private Map<String,Object> beforeEigenValueMap; //当前用户的上一组波形的五个特征值对象的集合
    private String startTime;    // 测量开始时间
    private double[] waveArray;               // double类型的波形文件数组
    private String exePath;               // 解析文件的exe的路径
    private String bloodGlucose;    // 血糖基准值
    private String highPressure;       // 血压基准值 高压
    private String lowPressure;        // 血压基准值 低压
    private String adornType;      //佩戴方式（0：左手 1：右手）
    private List<Double> bloodValueArray;      //当前用户之前的所有血糖参数定量值
    private Map<String,Object> diseaseScaleMap;  //病症尺度值对象
    private List<BloodPressValueVo> bloodPressList;      //当前用户的所有血压的高压和低压值
    private List<Double> dayConsistencyList;      //当前用户的当天的血黏值

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Map<String, Object> getNowEigenValueMap() {
        return nowEigenValueMap;
    }

    public void setNowEigenValueMap(Map<String, Object> nowEigenValueMap) {
        this.nowEigenValueMap = nowEigenValueMap;
    }

    public Map<String, Object> getBeforeEigenValueMap() {
        return beforeEigenValueMap;
    }

    public void setBeforeEigenValueMap(Map<String, Object> beforeEigenValueMap) {
        this.beforeEigenValueMap = beforeEigenValueMap;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double[] getWaveArray() {
        return waveArray;
    }

    public void setWaveArray(double[] waveArray) {
        this.waveArray = waveArray;
    }

    public String getExePath() {
        return exePath;
    }

    public void setExePath(String exePath) {
        this.exePath = exePath;
    }

    public String getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(String bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
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

    public String getAdornType() {
        return adornType;
    }

    public void setAdornType(String adornType) {
        this.adornType = adornType;
    }

    public List<Double> getBloodValueArray() {
        return bloodValueArray;
    }

    public void setBloodValueArray(List<Double> bloodValueArray) {
        this.bloodValueArray = bloodValueArray;
    }

    public Map<String, Object> getDiseaseScaleMap() {
        return diseaseScaleMap;
    }

    public void setDiseaseScaleMap(Map<String, Object> diseaseScaleMap) {
        this.diseaseScaleMap = diseaseScaleMap;
    }

    public List<BloodPressValueVo> getBloodPressList() {
        return bloodPressList;
    }

    public void setBloodPressList(List<BloodPressValueVo> bloodPressList) {
        this.bloodPressList = bloodPressList;
    }

    public List<Double> getDayConsistencyList() {
        return dayConsistencyList;
    }

    public void setDayConsistencyList(List<Double> dayConsistencyList) {
        this.dayConsistencyList = dayConsistencyList;
    }

    @Override
    public String toString() {
        return "UserWaveVo{" +
                "user=" + user +
                ", nowEigenValueMap=" + nowEigenValueMap +
                ", beforeEigenValueMap=" + beforeEigenValueMap +
                ", startTime='" + startTime + '\'' +
                ", waveArray=" + Arrays.toString(waveArray) +
                ", exePath='" + exePath + '\'' +
                ", bloodGlucose='" + bloodGlucose + '\'' +
                ", highPressure='" + highPressure + '\'' +
                ", lowPressure='" + lowPressure + '\'' +
                ", adornType='" + adornType + '\'' +
                ", bloodValueArray=" + bloodValueArray +
                ", diseaseScaleMap=" + diseaseScaleMap +
                ", bloodPressList=" + bloodPressList +
                ", dayConsistencyList=" + dayConsistencyList +
                '}';
    }
}
