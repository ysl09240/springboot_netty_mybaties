package com.shxseer.watch.algorithm.wavetools;

import biz.source_code.dsp.filter.FilterPassType;
import biz.source_code.dsp.filter.IirFilterCoefficients;
import biz.source_code.dsp.filter.IirFilterDesignExstrom;

/**
 * @authorseerhuitao 巴特沃斯滤波器
 * @create2018/6/19
 */
public class BurterworthFilter {
    static double[] h1={1,2,3,4,9,2,5,1,3};
    //其中包含 5Hz 和 15Hz 两个频率分量,信号的采样率为 50Hz ：
    public static void getBH(){
        double[] time = new double[150];
        double[] valueA = new double[150];
        for (int i = 0; i < 50 * 3; i++) {
            time[i] = i / 50.0;
            valueA[i] = Math.sin(2 * Math.PI * 5 * time[i])+ Math.sin(2 * Math.PI * 15 * time[i]);
        }
    }
    //生成滤波器：
    public static double[] getStart(double[] single){
        IirFilterCoefficients iirFilterCoefficients;
        iirFilterCoefficients = IirFilterDesignExstrom.design(FilterPassType.lowpass, 4,
                8.0 / 500, 8.0 / 500);

        double[] singled=IIRFilter(single, iirFilterCoefficients.a, iirFilterCoefficients.b);
        return singled;
    }
    //查看系数的值：
    public static void main(String[] args)
    {
        IirFilterCoefficients iirFilterCoefficients;
        iirFilterCoefficients = IirFilterDesignExstrom.design(FilterPassType.lowpass, 10,
                1.0 / 5, 1.0 / 5);
        double[] singled=IIRFilter(h1, iirFilterCoefficients.a, iirFilterCoefficients.b);
        for(int i=0;i<singled.length-1;i++)
        {
            System.out.println("--------"+singled[i]+"--------");
        }

    }

    //封装的滤波器函数,里面的数据类型可以改为 float ：
    public static synchronized double[] IIRFilter(double[] signal, double[] a, double[] b) {

        double[] in = new double[b.length];
        double[] out = new double[a.length-1];

        double[] outData = new double[signal.length];

        for (int i = 0; i < signal.length; i++) {

            System.arraycopy(in, 0, in, 1, in.length - 1);
            in[0] = signal[i];

            //calculate y based on a and b coefficients
            //and in and out.
            float y = 0;
            for(int j = 0 ; j < b.length ; j++)
            {
                y += b[j] * in[j];
            }

            for(int j = 0;j < a.length-1;j++)
            {
                y -= a[j+1] * out[j];
            }

            //shift the out array
            System.arraycopy(out, 0, out, 1, out.length - 1);
            out[0] = y;

            outData[i] = y;

        }
        return outData;
    }
}
