package com.shxseer.watch.vo;

/**
 * 需要计算尺度值的特征值实体类
 * @author zhangliang
 * @since 2018-07-31 11:41
 */
public class EigenValueScaleVo {
    /**
     * 振幅值
     */
    private double centerValue;
    /**
     * 降中峡值
     */
    private double downcenterValue;
    /**
     * 单个脉搏波的速度
     */
    private double speed;

    public double getCenterValue() {
        return centerValue;
    }

    public void setCenterValue(double centerValue) {
        this.centerValue = centerValue;
    }

    public double getDowncenterValue() {
        return downcenterValue;
    }

    public void setDowncenterValue(double downcenterValue) {
        this.downcenterValue = downcenterValue;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    @Override
    public String toString() {
        return "EigenValueScaleVo{" +
                "centerValue=" + centerValue +
                ", downcenterValue=" + downcenterValue +
                ", speed=" + speed +
                '}';
    }
}
