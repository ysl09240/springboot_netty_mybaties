package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @authorseerhuitao 父类
 * @create2018/6/27
 */
public class BaseDiseaseUtils {
    @Autowired
    public WaveFormModel wfmone;//本次脉搏波的特征值
    public WaveFormModel wfmtwo;//这是上一次脉搏波的特征值
    double time=0.002;
    public   BaseDiseaseUtils(WaveFormModel wfmone, WaveFormModel wfmtwo){
        this.wfmone = wfmone;
        this.wfmtwo = wfmtwo;
    }

}
