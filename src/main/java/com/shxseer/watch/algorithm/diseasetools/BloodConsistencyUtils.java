package com.shxseer.watch.algorithm.diseasetools;

import com.shxseer.watch.common.DiseaseEnum;

import java.util.ArrayList;
import java.util.List;

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

    /**
     * 计算血粘度的历史趋势一天以内的（只计算当天的）
     * @param list
     * @return
     */
    public static String getLossGo(List<Double> list){
        String str=null;
        List<Double> x=new ArrayList<Double>();
        List<Double> y=new ArrayList<Double>();
        for(int i=0;i<list.size();i++){
            x.add((double)i);
            y.add(list.get(i));
        }
        //判断离散系数
        int restCou=judgeDataChanged(y,x);
        if(restCou==1){
            str= DiseaseEnum.BLOODCONSISTENCY_ONE.getValue();
        }else if(restCou==2){
            str= DiseaseEnum.BLOODCONSISTENCY_TWO.getValue();
        }else if(restCou==3){
            str= DiseaseEnum.BLOODCONSISTENCY_THREE.getValue();
        }
        return str;
    }

    //线性回归方程(处理double)
    public static int judgeDataChanged(List<Double> dly, List<Double> dlx){
        //返回去变化的值
        int f=0;
        double a=0;
        double b=0;
        double c=0;
        @SuppressWarnings("unused")
        double d=0;
        double v1=0;
        double v2=0;
        double v3=0;
        double v4=0;
        for(int i=0;i<dly.size();i++){
            v1=+(dly.get(i));
            a=v1/dly.size();

            v2=+dlx.get(i);
            b=v2/dlx.size();

        }
        for(int j=0;j<dlx.size();j++){
            v3=+((dly.get(j)-a)*(dlx.get(j)-b));
            v4=+((dlx.get(j)-b)*(dlx.get(j)-b));
        }
        c=v3/v4;
        d=a+b*c;

        if(c>0){
            //升高
            f=1;
        }else if(c<0){
            //降低
            f=2;
        }else{
            //没变
            f=3;
        }
        return f;
    }
}
