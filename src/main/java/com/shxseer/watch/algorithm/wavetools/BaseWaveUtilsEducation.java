package com.shxseer.watch.algorithm.wavetools;

import cn.edu.xidian.wave.ppgpreprocessor.PPGPreprocessor;
import cn.edu.xidian.wave.ppgpreprocessor.Wave;
import cn.edu.xidian.wave.ppgpreprocessor.Waveform;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorseerhuitao 这是脉搏波的算法工具包(李老师的工具类)
 * @create2018/7/16
 */
public class BaseWaveUtilsEducation {
    Wave wave = null;
    Double[] rawDCDataPoints = null;
    Waveform[] waveforms = null;
    Waveform[] validWaveforms = null;
    Waveform[] invalidWaveforms = null;
    PPGPreprocessor processor =null;
    public BaseWaveUtilsEducation(double[] d,String exe_path){
        processor = new PPGPreprocessor(exe_path);
        wave = processor.preprocess(d);
    }
    //获取有效的原始点个数
     public  Double[] getrawDCDataPoints(){
         rawDCDataPoints = wave.getRawDCDataPoints();
         return rawDCDataPoints;
     }
     //总波段的个数
     public Waveform[] getwaveforms(){
         waveforms = wave.getWaveforms();
         return waveforms;
     }
     //有效的波形
     public Waveform[] getvalidWaveforms(){
         validWaveforms = wave.getValidWaveforms();
         return validWaveforms;
     }
     //无效的波形
     public Waveform[] getinvalidWaveforms(){
         invalidWaveforms = wave.getInvalidWaveforms();
         return invalidWaveforms;
     }
     //获取有效波形
     public List<Double> getvalidWaveformsNum(){
         List<Double> eduList=new ArrayList<Double>();
         Waveform[] validWaveforms=getvalidWaveforms();
         // 获取第一个有效波形的所有数据
         for(int j=0;j<validWaveforms.length;j++)
         {
             double[] waveformDataPoints = validWaveforms[j].getWaveformDataPoints();
             for(double i : waveformDataPoints)
             {
                 eduList.add(i);
             }
         }
         return eduList;
     }

}
