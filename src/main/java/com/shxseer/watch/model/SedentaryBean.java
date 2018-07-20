package com.shxseer.watch.model;

/**
 * 久坐提醒
 *
 * @author yangsonglin
 * @create 2018-07-12 9:15
 **/
public class SedentaryBean {
    private String id;
    private Integer datatype;
    private String imei;
    private Long sittime; //久坐开始时间
    private Long sitduration;//久座时长 单位：秒


    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Long getSittime() {
        return sittime;
    }

    public void setSittime(Long sittime) {
        this.sittime = sittime;
    }

    public Long getSitduration() {
        return sitduration;
    }

    public void setSitduration(Long sitduration) {
        this.sitduration = sitduration;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
