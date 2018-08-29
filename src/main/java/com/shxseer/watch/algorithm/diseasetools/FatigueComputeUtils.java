package com.shxseer.watch.algorithm.diseasetools;

/**
 * @authorseerhuitao 疲劳算法
 * @create2018/8/13
 */
public class FatigueComputeUtils {
    /**
     * 疲劳算法
     * @param lengthDenty//每个波形的点
     * @param centerDenty//每个中层的点
     * @return
     */
    public static String getFatigueValue(double lengthDenty, int centerDenty){
           double less=(double)centerDenty/lengthDenty;
            String str=null;
            //平均每个大概占了1/8,,1/24,1/48；
            if(less>0.125){
                str="身体状态极佳";
            }else if(less>0.021 && less<=0.042){
                str="你已处于疲劳，请您适当的调整";
            }else if(less>0.042 && less<=0.125){
                str="正常，请保持";
            }else if(less>0 && less<=0.021){
                str="您已经相当疲劳，请注意休息";
            }
           return str;
    }
}
