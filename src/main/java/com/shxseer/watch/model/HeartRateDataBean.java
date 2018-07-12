package com.shxseer.watch.model;

/**
 * 心率数据上传
 *
 * @author yangsonglin
 * @create 2018-07-12 9:37
 **/
public class HeartRateDataBean {


    private Integer datatype;
    private String imei;
    private Integer heart;
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

    public Integer getHeart() {
        return heart;
    }

    public void setHeart(Integer heart) {
        this.heart = heart;
    }

    public Long getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Long uploadtime) {
        this.uploadtime = uploadtime;
    }
}
