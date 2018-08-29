package com.shxseer.watch.algorithm.wavetools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @authorseerhuitao 转换系统工具类
 * @create2018/7/16
 */
public class SystemTools {
    public static List<Double> getArray(double[] d){
        List<Double> list=new ArrayList<Double>();
        for(int i=0;i<d.length;i++){
            list.add(d[i]);
        }
        return list;
    }
    public static double[] getList(List<Double> list){
        double[] d=new double[list.size()];
        for(int i=0;i<list.size();i++){
            d[i]=list.get(i);
        }
        return d;
    }
    //对数值做加法器保证都是在正数
    public static List<Double> PlusTools(List<Double> list)
    {
        List<Double> listc=new ArrayList<Double>();
        List<Double> listB=new ArrayList<Double>();
        for(int i=0;i<list.size();i++)
        {
            listB.add(list.get(i));
        }
        Collections.sort(listB);
        for(int i=0;i<list.size();i++)
        {
            listc.add(list.get(i)+ Math.abs(listB.get(0)));
        }
        return listc;
    }
    //数组取极大值
    public static double getMax(List<Double> numbers){
        double max = (double) Collections.max(numbers);
        return max;
    }
    //数组取极小值
    public static double getMin(List<Double> numbers){
        double min = (double) Collections.min(numbers);
        return min;
    }
    //对集合进行排序
    public static List<Double> getAllSort(List<Double> numbers){
        Collections.sort(numbers);
        return numbers;
    }
}
