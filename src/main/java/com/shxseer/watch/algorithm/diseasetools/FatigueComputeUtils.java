package com.shxseer.watch.algorithm.diseasetools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @authorseerhuitao 疲劳算法
 * @create2018/8/13
 */
public class FatigueComputeUtils {
    /**
     * 疲劳算法
     * @param rateList//心率的集合
     * @param lengthDenty//每个波形的密度
     * @param centerDenty//每个中层的密度
     * @return
     */
    public static Map<String,String> getFatigueValue(List<Integer> rateList, double lengthDenty, int centerDenty){
        double less=centerDenty/(double)lengthDenty;
        //状态
        String str = null;
        //指数
        String number = "0";
        List<Double> x=new ArrayList<Double>();
        List<Double> y=new ArrayList<Double>();
        for(int i=0;i<rateList.size();i++){
            x.add((double)i);
            y.add((double)rateList.get(i));
        }
        //判断离散系数
        double restCou=judgeDataChangedValue(y,x);
        if(restCou>0.3||restCou<-0.3){
            if(less>0.1 && less<=0.15){
                str="处于疲劳";
                number = "2";
            }else if(less>0.15 && less<=0.2){
                str="正常";
                number = "1";
            }else if(less>0.05 && less<=0.1){
                str="相当疲劳";
                number = "3";
            }
        }else{
            str="正常";
            number = "1";
        }
        Map<String,String> returnMap = new HashMap<String, String>();
        returnMap.put("VP", str);
        returnMap.put("number", number);
        return returnMap;
    }

    //研发趋势
    //返回预判值(double)
    public static double judgeDataChangedValue(List<Double> dly, List<Double> dlx){
        //返回去变化的值
        double a=0;
        double b=0;
        double c=0;
        double d=0;
        double v1=0;
        double v2=0;
        double v3=0;
        double v4=0;
        for(int i=0;i<dly.size();i++){
            v1=+dly.get(i);
            a=v1/dly.size();
        }
        for(int i=0;i<dlx.size();i++){
            v2=+dlx.get(i);
            b=v2/dlx.size();

        }
        for(int j=0;j<dlx.size();j++){
            v3=+((dly.get(j)-a)*(dlx.get(j)-b));
            v4=+((dlx.get(j)-b)*(dlx.get(j)-b));
        }
        c=v3/v4;
        d=a+b*c;
        return c;
    }
}
