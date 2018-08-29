package com.shxseer.watch.common;

import java.util.ArrayList;
import java.util.List;

/**
 * 原始数据处理相关的工具类
 * @author zhangliang
 * @since 2018-07-17 11:04
 */
public class SplitData {

    /**
     * 计算集合里的数字的平均数(Double)
     */
    public static double countDoubleListAvg(List<Double> ds){
        double d = 0;
        for (double d1 : ds) {
            d += d1;
        }
        d = d/ds.size();
        return d;
    }

    /**
     * 计算集合里的数字的平均数(Integer)
     */
    public static int countIntegerListAvg(List<Integer> is){
        int i = 0;
        for (int i1 : is) {
            i += i1;
        }
        i = i/is.size();
        return i;
    }

    /**
     * 将集合的内容按符号拼接成字符串(Double)
     */
    public static String doubleListToString(List<Double> datas, String regex){
        StringBuffer sb=new StringBuffer();
        for (Double t : datas) {
            sb.append(t).append(regex);
        }
        return sb.toString();
    }

    /**
     * 将集合的内容按符号拼接成字符串((Integer)
     */
    public static String integerListToString(List<Integer> datas, String regex){
        StringBuffer sb=new StringBuffer();
        for (Integer t : datas) {
            sb.append(t).append(regex);
        }
        return sb.toString();
    }

    /**
     * 按符号截取字符串放进集合中(Double)
     */
    public static List<Double> stringToDoubleList(String s, String regex){
        List<Double> datas = new ArrayList<Double>();
        String[] ss = s.split(regex);
        for (String s1 : ss) {
            datas.add(Double.parseDouble(s1));
        }
        return datas;
    }

    /**
     * 按符号截取字符串放进集合中(Integer)
     */
    public static List<Integer> stringToIntegerList(String s, String regex){
        List<Integer> datas = new ArrayList<Integer>();
        String[] ss = s.split(regex);
        for (String s1 : ss) {
            datas.add(Integer.parseInt(s1));
        }
        return datas;
    }

}
