package com.shxseer.watch.algorithm.diseasetools;

/**
 * @authorseerhuitao 血压的对象
 * @create2018/5/14
 */
public class BloodPress{
    private double BSP;//收缩压
    private double DBP;//舒张压
    private double Pm;//平均动脉压
    private double Pm_Value; //平均动脉压的幅值

    public double getPm_Value() {
        return Pm_Value;
    }

    public void setPm_Value(double pm_Value) {
        Pm_Value = pm_Value;
    }

    public double getBSP() {
        return BSP;
    }

    public void setBSP(double BSP) {
        this.BSP = BSP;
    }

    public double getDBP() {
        return DBP;
    }

    public void setDBP(double DBP) {
        this.DBP = DBP;
    }

    public double getPm() {
        return Pm;
    }

    public void setPm(double pm) {
        Pm = pm;
    }

    @Override
    public String toString() {
        return "BloodPress{" +
                "BSP=" + BSP +
                ", DBP=" + DBP +
                ", Pm=" + Pm +
                ", Pm_Value=" + Pm_Value +
                '}';
    }
}
