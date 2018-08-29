package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * C段疾病的所有方法
 */
public class DiseaseUtilsC extends BaseDiseaseUtils implements DiseaseC{

    public DiseaseUtilsC(WaveFormModel wfmone, WaveFormModel wfmtwo) {
        super(wfmone, wfmtwo);
    }


    @Override
    public boolean C1Before() {
        if(wfmone.getConeIndex()*time<wfmtwo.getConeIndex()*time){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean C1After() {
        if(wfmone.getConeIndex()*time>wfmtwo.getConeIndex()*time){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean C1Length() {
        if(wfmone.getConeIndex()*time > wfmtwo.getConeIndex()*time+0.02){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean C1Shorten() {
        if(wfmone.getConeIndex()*time < wfmtwo.getConeIndex()*time-0.02){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean C2SlowSpeed() {

        return false;
    }

    @Override
    public boolean C2FastSpeed() {

        return false;
    }

    @Override
    public boolean C2Shorten() {
        if(wfmone.getCtwoIndex()*time < wfmtwo.getCtwoIndex()*time){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean C2Miss() {
        if(wfmtwo.getCtwoIndex()*time == 0){
            return true;
        }else{
            return false;
        }
    }
}
