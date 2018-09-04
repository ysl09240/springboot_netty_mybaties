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
     * 研发血糖算法
     * @param bloodFirst 血糖基准值
     * @param HT 本次的振幅均值
     * @param altitude 振幅尺度
     * @return
     */
    public static Map<String, Object> getNumBlood(double bloodFirst, double HT, String altitude) {
        Map<String, Object> returnMap = new HashMap<String, Object>();
        double blood_value1 = 0;
        double aliquot_value = getTargetValue(bloodFirst, altitude, HT);
        double d_value = 0;
        //用餐状态（0：餐前/1：餐后）
        String eatSataus = "0";
        double k = getCoefficient(altitude, HT);
        if (aliquot_value < 100) {
            //餐后
            System.out.println("餐后");
            eatSataus = "1";
            blood_value1 = bloodFirst + Math.abs(aliquot_value)*k;
        } else if (aliquot_value > 100) {
            //餐前
            System.out.println("餐前");
            blood_value1 = bloodFirst - Math.abs(aliquot_value)*k;
        }
        double num1 = Math.abs(blood_value1);
        DecimalFormat df = new DecimalFormat("######0.00");
        d_value = Double.parseDouble(df.format(num1));
        returnMap.put("d_value", d_value);
        returnMap.put("eatSataus", eatSataus);
        return returnMap;
    }


    /**
     * 通过目标血糖获取每一小等分的具体值，这里需要上传血糖基准值和对应的波势高度差
     * 获取基准值的每一小等分代表的血糖值
     *
     * @param bloodFirst
     * @return
     */
    public static double getTargetValue(double bloodFirst, String oldaltitude, double newaltitude) {
        double aliquot1 = Double.parseDouble(oldaltitude) - newaltitude;
        return aliquot1;
    }

    //粘滞度和脉搏波的波形变化对比值系数
    public static double getCoefficient(String parameter, double altitudeScale) {
        //粘度血糖系数
        double k = 0;
        double mo=10000;
        double no=980;
        //本次测量值减去尺度值产生的结果
        double c_value = altitudeScale - Double.parseDouble(parameter);
        //如果c_value小于0，那么说明血糖升高，大于0说明血糖减小
        if (c_value < 0) {
            k = Math.abs(c_value)/(mo*no)*0.6;
        } else if (c_value > 0) {
            k = c_value/(mo*no)*0.6;
        }
        return k;
    }
}
