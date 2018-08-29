package com.shxseer.watch.algorithm.diseasetools;

import java.util.List;

/**
 * @authorseerhuitao 尺度计算(一定是返回来的前三组波形)
 * @create2018/7/27
 */
public class ScaleCompute {
    /**
     * 血糖尺度的获取（第一次）,默认是三次，先以三次作为依据开始测试，三次的血糖值都放到list里面
     * @param list 前三组的振幅
     * @return
     */
    public static double getScaleSugarValue(List<Double> list){
           double bas=0;
           double scale=0;
           for(int i=0;i<list.size();i++)
           {
               bas+=list.get(i);
           }
           scale=bas/3;//去均值
           return scale;
    }
}
