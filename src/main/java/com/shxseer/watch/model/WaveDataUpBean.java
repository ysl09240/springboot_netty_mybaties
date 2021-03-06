package com.shxseer.watch.model;

/**
 * 波型数据上传
 *
 * @author yangsonglin
 * @create 2018-07-11 16:38
 **/
public class WaveDataUpBean {
    private String id;
    private Integer datatype;
    private String imei;
    private Integer sleepy;
    private Integer lrhand;
    private Integer filesize;
    private Integer datanum;
    private Long starttime;
    private Long uploadtime;
    private Integer istestbpbs;
    private Integer sportstatus;
    private String data;
    private String fileUrl;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

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

    public Integer getSleepy() {
        return sleepy;
    }

    public void setSleepy(Integer sleepy) {
        this.sleepy = sleepy;
    }

    public Integer getLrhand() {
        return lrhand;
    }

    public void setLrhand(Integer lrhand) {
        this.lrhand = lrhand;
    }

    public Integer getFilesize() {
        return filesize;
    }

    public void setFilesize(Integer filesize) {
        this.filesize = filesize;
    }

    public Integer getDatanum() {
        return datanum;
    }

    public void setDatanum(Integer datanum) {
        this.datanum = datanum;
    }

    public Long getStarttime() {
        return starttime;
    }

    public void setStarttime(Long starttime) {
        this.starttime = starttime;
    }

    public Long getUploadtime() {
        return uploadtime;
    }

    public void setUploadtime(Long uploadtime) {
        this.uploadtime = uploadtime;
    }

    public Integer getIstestbpbs() {
        return istestbpbs;
    }

    public void setIstestbpbs(Integer istestbpbs) {
        this.istestbpbs = istestbpbs;
    }

    public Integer getSportstatus() {
        return sportstatus;
    }

    public void setSportstatus(Integer sportstatus) {
        this.sportstatus = sportstatus;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }






}
