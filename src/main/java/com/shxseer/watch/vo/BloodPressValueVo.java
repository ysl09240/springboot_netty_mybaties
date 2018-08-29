package com.shxseer.watch.vo;

/**
 * 计算血压个性化区间的条件Vo
 * @author zhangliang
 * @since 2018-08-24 14:40
 */
public class BloodPressValueVo {
    /**
     * 血压高压
     */
    private String highPressure;
    /**
     * 血压低压
     */
    private String lowPressure;

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

    @Override
    public String toString() {
        return "BloodPressValueVo{" +
                "highPressure='" + highPressure + '\'' +
                ", lowPressure='" + lowPressure + '\'' +
                '}';
    }
}
