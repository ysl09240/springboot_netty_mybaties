package com.shxseer.watch.algorithm.diseasetools;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

import java.util.HashMap;
import java.util.Map;

/**
 * @authorseerhuitao 运动状态监视
 * @create2018/8/25
 */
public class MovementUtils {

    /**
     * 根据脉搏速度大，血流速度小，脉搏速度小血流速度大，反比关系可知道运动状态
     * @param hertRate
     * @param wfparam 尺度
     * @param wfsacret
     * @return
     */
    public static Map<String, String> getMovementValue(int hertRate, WaveFormModel wfparam, WaveFormModel wfsacret){
        //状态
        String pl = null;
        //指数
        String number = "0";
        double pp=getMessage(wfparam,wfsacret);
        if(pp>0.25) {
            //适不适合运动主要看脉搏速度、心率、和振幅之间的变化关系
            if (hertRate > 40 && hertRate < 60) {
                pl = "提高运动";
                number = "4";
            } else if (hertRate > 60 && hertRate < 100) {
                pl = "适当运动";
                number = "3";
            } else if (hertRate > 100) {
                pl = "不要剧烈运动";
                number = "2";
            }
        }else if(pp<=0.25){
            pl="不适合运动";
            number = "1";
        }
        Map<String, String> returnMap = new HashMap<String, String>();
        returnMap.put("VP", pl);
        returnMap.put("number", number);
        return returnMap;
    }

    /**
     * 得到俩个波型参数
     * @param wfparam
     * @param wfsacret
     * @return
     */
    public static double getMessage(WaveFormModel wfparam, WaveFormModel wfsacret){
           double perfet=0;
           if(wfsacret.getAoneIndex() < wfparam.getAoneIndex()){
               perfet+=0.25;
           }
           if(wfsacret.getAthrValue() > wfparam.getAthrValue()){
               perfet+=0.25;
           }
           if(wfsacret.getHertrate() > wfparam.getHertrate()){
               perfet+=0.25;
           }
           if(wfsacret.getBthrIndex()<wfparam.getBthrIndex()){
               perfet+=0.25;
           }
           return perfet;
    }
}
