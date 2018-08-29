package com.shxseer.watch.vo;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  血糖,血压与对应的时间
 * @Package com.shxseer.seer.vo
 * @ClassName: com.shxseer.seer.vo.BloodValueVo
 * @date 2017年11月20日 10:19
 */
public class BloodGlucoseValueVo {
    private String startTime;       //脉搏开始测量时间（yyyy-MM-dd HH:mm:ss）
    private double bloodGlucoseValue; //餐前或餐后血糖参数定量值

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public double getBloodGlucoseValue() {
        return bloodGlucoseValue;
    }

    public void setBloodGlucoseValue(double bloodGlucoseValue) {
        this.bloodGlucoseValue = bloodGlucoseValue;
    }

    @Override
    public String toString() {
        return "BloodGlucoseValue{" +
                "startTime='" + startTime + '\'' +
                ", bloodGlucoseValue=" + bloodGlucoseValue +
                '}';
    }
}
