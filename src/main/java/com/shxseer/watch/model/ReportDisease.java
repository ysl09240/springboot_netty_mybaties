package com.shxseer.watch.model;

import com.shxseer.watch.vo.BloodGlucoseValueVo;
import com.shxseer.watch.vo.ReportDiseaseCurveVo;

import java.util.Date;
import java.util.List;

/**
 * 即时报告（病症报告）实体类
 * @author zhangliang
 * @since 2018-07-12 10:11
 */
public class ReportDisease {

    private String id;              //主键id
    private int diseaseCode;        //病症编号
    private String userId;          //用户id
    private String headMessage;     //头部提示信息
    private String status;          //精神状态
    private String exponent;        //指数
    private String riskAssessment;  //风险评估
    private String otherRisk;       //其他风险
    private String suggestList;     //测量建议
    private String timeScope;       //时间范围
    private String startTime;       //脉搏开始测量时间（yyyy-MM-dd HH:mm:ss）
    private Date createTime=new Date();     //创建时间
    private String cName;       //  中文名
    private String headPortrait;       //  图像

    //2017-11-13 添加 血糖参数定量
    private double bloodGlucoseValue; //餐前或餐后血糖参数定量值
    private List<BloodGlucoseValueVo> bloodGlucoseValueList; //餐前或餐后血糖参数定量值
    private List<ReportDiseaseCurveVo> bloodPressureValueList; //血压参数值 高压,低压,压差
    private String highPressure; //血压高压
    private String lowPressure; //血压低压
    private double bloodPressure; //压差

    private String isWarning; // 是否发送告警(1:发送,0:不发送)  11-20添加
    private String WarningDiseaseTypeName; // 发送告警的病症的告警级别名称 病症的告警等级  2018-01-02添加
    private String isRead; // 是否已经阅览(1:以阅览,0:未阅览) 11-20添加
    private String tempValue; // 这个属性没有表字段对应，只是传值
    private String pushMessage;   // 即时消息推送内容

    private String adornType;      //佩戴方式（0：左手 1：右手）

    private String diseaseName;      //病症名称
    private double maxValues;        //个性化区间上限(血糖/血压高压)
    private double minValue;        //个性化区间下限(血糖/血压高压)
    private String eatSataus;        //用餐状态（0：餐前/1：餐后）
    private double lowMaxValue;        //个性化区间上限(血压低压)
    private double lowMinValue;        //个性化区间下限(血压低压)
    private String warnReport;        //预警报告

    public ReportDisease() {
    }

    public ReportDisease(String userId, int type, String startTime) {
        this.userId=userId;
        this.diseaseCode=type;
        this.startTime=startTime;
    }

    public String getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(String pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(int diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeadMessage() {
        return headMessage;
    }

    public void setHeadMessage(String headMessage) {
        this.headMessage = headMessage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExponent() {
        return exponent;
    }

    public void setExponent(String exponent) {
        this.exponent = exponent;
    }

    public double getMaxValues() {
        return maxValues;
    }

    public void setMaxValues(double maxValues) {
        this.maxValues = maxValues;
    }

    public double getMinValue() {
        return minValue;
    }

    public void setMinValue(double minValue) {
        this.minValue = minValue;
    }

    public String getRiskAssessment() {
        return riskAssessment;
    }

    public void setRiskAssessment(String riskAssessment) {
        this.riskAssessment = riskAssessment;
    }

    public String getOtherRisk() {
        return otherRisk;
    }

    public void setOtherRisk(String otherRisk) {
        this.otherRisk = otherRisk;
    }

    public String getSuggestList() {
        return suggestList;
    }

    public void setSuggestList(String suggestList) {
        this.suggestList = suggestList;
    }

    public String getTimeScope() {
        return timeScope;
    }

    public void setTimeScope(String timeScope) {
        this.timeScope = timeScope;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
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

    public double getBloodGlucoseValue() {
        return bloodGlucoseValue;
    }

    public void setBloodGlucoseValue(double bloodGlucoseValue) {
        this.bloodGlucoseValue = bloodGlucoseValue;
    }

    public List<BloodGlucoseValueVo> getBloodGlucoseValueList() {
        return bloodGlucoseValueList;
    }

    public void setBloodGlucoseValueList(List<BloodGlucoseValueVo> bloodGlucoseValueList) {
        this.bloodGlucoseValueList = bloodGlucoseValueList;
    }

    public List<ReportDiseaseCurveVo> getBloodPressureValueList() {
        return bloodPressureValueList;
    }

    public void setBloodPressureValueList(List<ReportDiseaseCurveVo> bloodPressureValueList) {
        this.bloodPressureValueList = bloodPressureValueList;
    }

    public String getIsWarning() {
        return isWarning;
    }

    public void setIsWarning(String isWarning) {
        this.isWarning = isWarning;
    }

    public String getIsRead() {
        return isRead;
    }

    public void setIsRead(String isRead) {
        this.isRead = isRead;
    }

    public String getTempValue() {
        return tempValue;
    }

    public void setTempValue(String tempValue) {
        this.tempValue = tempValue;
    }

    public String getWarningDiseaseTypeName() {
        return WarningDiseaseTypeName;
    }

    public void setWarningDiseaseTypeName(String warningDiseaseTypeName) {
        WarningDiseaseTypeName = warningDiseaseTypeName;
    }

    public String getAdornType() {
        return adornType;
    }

    public void setAdornType(String adornType) {
        this.adornType = adornType;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public String getEatSataus() {
        return eatSataus;
    }

    public void setEatSataus(String eatSataus) {
        this.eatSataus = eatSataus;
    }

    public double getLowMaxValue() {
        return lowMaxValue;
    }

    public void setLowMaxValue(double lowMaxValue) {
        this.lowMaxValue = lowMaxValue;
    }

    public double getLowMinValue() {
        return lowMinValue;
    }

    public void setLowMinValue(double lowMinValue) {
        this.lowMinValue = lowMinValue;
    }

    public String getWarnReport() {
        return warnReport;
    }

    public void setWarnReport(String warnReport) {
        this.warnReport = warnReport;
    }

    @Override
    public String toString() {
        return "ReportDisease{" +
                "id='" + id + '\'' +
                ", diseaseCode=" + diseaseCode +
                ", userId='" + userId + '\'' +
                ", headMessage='" + headMessage + '\'' +
                ", status='" + status + '\'' +
                ", exponent='" + exponent + '\'' +
                ", maxValues=" + maxValues +
                ", minValue=" + minValue +
                ", riskAssessment='" + riskAssessment + '\'' +
                ", otherRisk='" + otherRisk + '\'' +
                ", suggestList='" + suggestList + '\'' +
                ", timeScope='" + timeScope + '\'' +
                ", startTime='" + startTime + '\'' +
                ", createTime=" + createTime +
                ", cName='" + cName + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", bloodGlucoseValue=" + bloodGlucoseValue +
                ", bloodGlucoseValueList=" + bloodGlucoseValueList +
                ", bloodPressureValueList=" + bloodPressureValueList +
                ", highPressure='" + highPressure + '\'' +
                ", lowPressure='" + lowPressure + '\'' +
                ", bloodPressure=" + bloodPressure +
                ", isWarning='" + isWarning + '\'' +
                ", WarningDiseaseTypeName='" + WarningDiseaseTypeName + '\'' +
                ", isRead='" + isRead + '\'' +
                ", tempValue='" + tempValue + '\'' +
                ", pushMessage='" + pushMessage + '\'' +
                ", adornType='" + adornType + '\'' +
                ", diseaseName='" + diseaseName + '\'' +
                ", eatSataus='" + eatSataus + '\'' +
                ", lowMaxValue='" + lowMaxValue + '\'' +
                ", lowMinValue='" + lowMinValue + '\'' +
                ", warnReport='" + warnReport + '\'' +
                '}';
    }
}
