package com.shxseer.watch.algorithm.diseasetools;

import com.shxseer.watch.common.DiseaseEnum;

/**
 * @authorseerhuitao 所有病症风险
 * @create2018/7/27
 */
public class TextPlan {
    //血糖风险

    /**
     *
     * @param downValue//个性化血糖下限值
     * @param upValue//个性化血糖上限值
     * @param sugarValue//本次血糖值
     * @return
     */
    public static String getSugarTextPlan(double downValue,double upValue,double sugarValue){
        String str=null;
        if(sugarValue<downValue){
            str = DiseaseEnum.BLOODSUGAR_DOWN.getValue();
        }else if(sugarValue>=downValue && sugarValue<=upValue){
            str = DiseaseEnum.BLOODSUGAR_NOMAL.getValue();
        }else if(sugarValue>upValue){
            str = DiseaseEnum.BLOODSUGAR_UP.getValue();
        }
        return str;
    }
}
