package com.shxseer.watch.algorithm.diseasetools;

import com.shxseer.watch.common.DiseaseEnum;

/**
 * @authorseerhuitao K值算法相关
 * @create2018/9/28
 */
public class KvalueUtils {
    /**
     * k值文案
     * @param kk
     * @return
     */
    public static String getK_Value(double kk){
        String str="";
        if(kk<0.45){
            //血管及微循环状况良好
            str= DiseaseEnum.KVALUE_ONE.getValue();
        }else if(kk>0.45 && kk<0.5){
            //血管及微循环状况中等
            str= DiseaseEnum.KVALUE_TWO.getValue();
        }else if(kk>0.5){
            //血管及微循环状况相对较差
            str= DiseaseEnum.KVALUE_THREE.getValue();
        }
        return str;
    }
}
