package com.shxseer.watch.model;

/**
 * 病症尺度值四实体类
 * @author zhangliang
 * @since 2018-09-26 15:01
 */
public class DiseaseScaleValueFour {
    /**
     * 主键id
     */
    private String id;
    /**
     * 病症尺度值一主键id
     */
    private String diseaseScaleValueOneId;
    /**
     * A3点的速度尺度
     */
    private double athreeSpeedScale;
    /**
     * b3点的速度尺度
     */
    private double bthreeSpeedScale;
    /**
     * b2点的速度尺度
     */
    private double bsconeSpeedScale;
    /**
     * K值尺度
     */
    private double kvalueScale;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDiseaseScaleValueOneId() {
        return diseaseScaleValueOneId;
    }

    public void setDiseaseScaleValueOneId(String diseaseScaleValueOneId) {
        this.diseaseScaleValueOneId = diseaseScaleValueOneId;
    }

    public double getAthreeSpeedScale() {
        return athreeSpeedScale;
    }

    public void setAthreeSpeedScale(double athreeSpeedScale) {
        this.athreeSpeedScale = athreeSpeedScale;
    }

    public double getBthreeSpeedScale() {
        return bthreeSpeedScale;
    }

    public void setBthreeSpeedScale(double bthreeSpeedScale) {
        this.bthreeSpeedScale = bthreeSpeedScale;
    }

    public double getBsconeSpeedScale() {
        return bsconeSpeedScale;
    }

    public void setBsconeSpeedScale(double bsconeSpeedScale) {
        this.bsconeSpeedScale = bsconeSpeedScale;
    }

    public double getKvalueScale() {
        return kvalueScale;
    }

    public void setKvalueScale(double kvalueScale) {
        this.kvalueScale = kvalueScale;
    }

    @Override
    public String toString() {
        return "DiseaseScaleValueFour{" +
                "id='" + id + '\'' +
                ", diseaseScaleValueOneId='" + diseaseScaleValueOneId + '\'' +
                ", athreeSpeedScale=" + athreeSpeedScale +
                ", bthreeSpeedScale=" + bthreeSpeedScale +
                ", bsconeSpeedScale=" + bsconeSpeedScale +
                ", kvalueScale=" + kvalueScale +
                '}';
    }
}
