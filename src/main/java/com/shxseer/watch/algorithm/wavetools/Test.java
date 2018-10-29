package com.shxseer.watch.algorithm.wavetools;

import cn.edu.xidian.wave.ppgpreprocessor.PPGPreprocessor;
import cn.edu.xidian.wave.ppgpreprocessor.Wave;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorseerhuitao ceshi
 * @create2018/7/24
 */
public class Test
{
    public static double[] getDoubleArray(String path, String exe_path){
        // wave就是去直流之后的波对象
        PPGPreprocessor processor = new PPGPreprocessor(exe_path);
        Wave wave = processor.preprocess(path);
        Double[] rawDCDataPoints = wave.getRawDCDataPoints();
        double[] data = new double[rawDCDataPoints.length];
        for(int i=0; i<rawDCDataPoints.length; i++){
            data[i] = rawDCDataPoints[i];
        }
        return data;
    }

    public static double[] getArray1(String s){
        List<Double> list=new ArrayList<Double>();
        String[] template=s.split("PPG, ");
        String[] tes=new String[template.length-1];
        for(int i=0;i<template.length;i++){
            if(i>0)
            {
                String[] tesone=template[i].split("MEMS, ");
                tes[i-1]=tesone[0];
            }
        }
        for(int j=0;j<tes.length;j++){
            String[] dou=tes[j].split(", ");
            getListString(dou, list);
        }
        double[] des=getList(list);
        return des;
    }

    /**
     * 手表新算法获得数组
     * @param num
     * @return
     */
    public static double[] getArray(String num){
        num = num.replaceAll("\r|\n", "");
        String[] str=num.split(" ");
        List<Double> listNum=new ArrayList<>();
        for(int i=0;i<str.length;i++){
            if(i%5==0 || i%5==1 || i%5==2){
                double dat=Double.parseDouble(str[i]);
                listNum.add(dat);
            }
        }
        double[] des=getList(listNum);
        return des;
    }

    public static void getListString(String[] str, List<Double> list){
        for(int k=0;k<str.length;k++){
            if(k<str.length-2){
                if(!str[k].equals("1")&&!str[k].equals("10")){
                    double dd= Double.parseDouble(str[k]);
                    list.add(dd);
                }
            }
        }
    }

    public static double[] getList(List<Double> list){
        double[] d=new double[list.size()];
        for(int i=0;i<list.size();i++){
            d[i]=list.get(i);
        }
        return d;
    }

}
