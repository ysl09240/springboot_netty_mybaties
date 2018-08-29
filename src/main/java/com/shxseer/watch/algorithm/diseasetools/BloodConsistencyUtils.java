package com.shxseer.watch.algorithm.diseasetools;

/**
 * @authorseerhuitao 血液粘稠度算法
 * @create2018/7/26
 */
public class BloodConsistencyUtils {
    /**
     * 计算血液粘稠度
     * @param peripheralResistance 外周阻力
     * @return
     */
    public static double getBloodConsistencyValue(double peripheralResistance){
           double R=1;
           double r=1;
           double i=peripheralResistance;
           double pr=0;
           pr=R/(8*i* Math.PI* Math.pow(r,4));
           return pr;
    }
}
