package com.shxseer.watch.model;

/**
 * 计步类
 * @author yangsonglin
 * @create 2018-07-12 9:35
 **/
public class StepBean {

    private String id;
    private Integer datatype;
    private String  imei;
    private Integer stepcount;
    private Long uploadtime;


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

    public Integer getStepcount() {
        return stepcount;
    }

    public void setStepcount(Integer stepcount) {
        this.stepcount = stepcount;
    }

    public Long getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Long uploadtime) {
        this.uploadtime = uploadtime;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
