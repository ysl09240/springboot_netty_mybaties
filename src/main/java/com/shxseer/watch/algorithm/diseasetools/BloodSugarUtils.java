package com.shxseer.watch.algorithm.diseasetools;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * @authorseerhuitao 血糖的计算方法
 * @create2018/7/19
 */
public class BloodSugarUtils {
    /**
     *
     * @param thisAltitude//本次振幅
     * @param sugarBenchmark//血糖基准值
     * @param altitudeScale//振幅尺度
     * @param speedScale/速度尺度
     * @param jzxScale//降中峡尺度
     * @param thisSpeedValue//本次速度
     * @param thisjzxValue//本次降中峽
     * @return
     */
    public static Map<String, Object> getPointSugar(double thisAltitude, double sugarBenchmark, double altitudeScale, double speedScale, double jzxScale,
                                                    double thisSpeedValue, double thisjzxValue) {
        Map<String, Object> returnMap = new HashMap<String, Object>(2);
        //获取每一小份的具体的值
        double aliquot_value = getTargetValue(sugarBenchmark, altitudeScale);
        //格式化值
        double d_value = 0;
        //計算出來的血糖值
        double blood_value=0;
        //用餐状态（0：餐前/1：餐后）
        String eatSataus = "0";
        //餐后(分别取降中峡和速度，主波振幅进行比较)
        if(speedScale <= thisSpeedValue && jzxScale<=thisjzxValue)
        {
            System.out.println("餐后");
            eatSataus = "1";
            blood_value=thisAltitude*aliquot_value;
        }
        else if(speedScale > thisSpeedValue && jzxScale > thisjzxValue)
        {
            //餐前
            System.out.println("餐前");
            blood_value=thisAltitude*aliquot_value;
        }else{
            blood_value=5;
        }
        double num1 = Math.abs(blood_value);
        DecimalFormat df = new DecimalFormat("######0.00");
        d_value = Double.parseDouble(df.format(num1));

        returnMap.put("d_value", d_value);
        returnMap.put("eatSataus", eatSataus);

        return returnMap ;
    }

    /**
     * @param sugarBenchmark
     * @param sugarScale
     * @return
     */
    public static double getTargetValue(double sugarBenchmark, double sugarScale) {
        double aliquot = sugarBenchmark / sugarScale;
        return aliquot;
    }
}
