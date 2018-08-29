package com.shxseer.watch.algorithm.diseasetools;

import java.text.DecimalFormat;

/**
 * @authorseerhuitao 血压算法
 * @create2018/7/20
 */
public class BloodPressUtils {
    private double bsp=0;//收缩压基准
    private double dsp=0;//舒张压基准
    private double PmValue=0; //波形面积的中点尺度
    private double Pm;//本次波形的面积中点
    public BloodPressUtils(double b, double d, double PmValue,double Pm){
        this.bsp=b;
        this.dsp=d;
        this.PmValue=PmValue;
        this.Pm=Pm;
    }
    //血压
    public BloodPress getPressValueAverage(){
        BloodPress bp=new BloodPress();
        //Ps+2Pd=3Pm,假设Ps为1，
        double bspp=bsp*(Pm/PmValue);//获取收缩压
        double dspp=dsp*(Pm/PmValue);//获取舒张压
        DecimalFormat df = new DecimalFormat("######");
        double bsppo = Double.parseDouble(df.format(bspp));
        double dsppo = Double.parseDouble(df.format(dspp));
        bp.setBSP(bsppo);
        bp.setDBP(dsppo);
        return bp;
    }
}
