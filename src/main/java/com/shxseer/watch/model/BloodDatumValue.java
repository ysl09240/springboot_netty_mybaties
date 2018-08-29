package com.shxseer.watch.model;

import java.util.Date;

/**
 * 血糖血压基准值实体类
 * @author  zhangliang
 * @since 2018/3/1 11:05
 */
public class BloodDatumValue {
    /**
        主键id
     */
    private String id;
    /**
     * 类型（血糖3/血压14）
     */
    private String bloodType;
    /**
     * 基准值
     */
    private String datumValue;
    /**
     * 标准间隔
     */
    private Integer standardInterval;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 备注
     */
    private String remark;
    /**
     * 用户id
     */
    private String userId;

    public String getId() {
        return id;
    }

    public String getBloodType() {
        return bloodType;
    }

    public String getDatumValue() {
        return datumValue;
    }

    public Integer getStandardInterval() {
        return standardInterval;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public String getRemark() {
        return remark;
    }

    public String getUserId() {
        return userId;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setBloodType(String bloodType) {
        this.bloodType = bloodType;
    }

    public void setDatumValue(String datumValue) {
        this.datumValue = datumValue;
    }

    public void setStandardInterval(Integer standardInterval) {
        this.standardInterval = standardInterval;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BloodDatumValueController{" +
                "id='" + id + '\'' +
                ", bloodType='" + bloodType + '\'' +
                ", datumValue='" + datumValue + '\'' +
                ", standardInterval=" + standardInterval +
                ", createTime=" + createTime +
                ", remark='" + remark + '\'' +
                ", userId='" + userId + '\'' +
                '}';
    }
}
