package com.shxseer.watch.algorithm.diseasetools;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import com.shxseer.watch.common.DiseaseEnum;

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
    public static String getMovementValue(int hertRate, WaveFormModel wfparam, WaveFormModel wfsacret){
        //状态
        String pl = null;
        double pp=getMessage(wfparam,wfsacret);
        if(pp>0.25) {
            //适不适合运动主要看脉搏速度、心率、和振幅之间的变化关系
            if (hertRate > 40 && hertRate < 60) {
                //运动正常
                pl = DiseaseEnum.SPORTHERTRATE_TWO.getValue();
            } else if (hertRate > 60 && hertRate < 100) {
                //提高强度
                pl = DiseaseEnum.SPORTHERTRATE_ONE.getValue();
            } else if (hertRate > 100) {
                //过于剧烈
                pl = DiseaseEnum.SPORTHERTRATE_THREE.getValue();
            }
        }else if(pp<=0.25){
            //和惠涛、陈占勇确定过此项问题，最终决定改成这样2018-08-31
            //运动正常
            pl = DiseaseEnum.SPORTHERTRATE_TWO.getValue();
        }
        return pl;
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
