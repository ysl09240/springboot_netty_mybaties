package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * B段疾病的所有方法
 */
public class DiseaseUtilsB extends BaseDiseaseUtils implements DiseaseB{
    public DiseaseUtilsB(WaveFormModel wfmone, WaveFormModel wfmtwo)
    {
        super(wfmone, wfmtwo);
    }
    @Override
    public boolean B1Length() {
        if(wfmone.getBoneIndex()*time>0.04 && wfmone.getBoneIndex()*time<0.05){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B1Shorten() {
        if(wfmone.getBoneIndex()*time<0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B2Length() {
        if(wfmone.getBtwoIndex()*time>0.06){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B2Shorten() {
        if(wfmone.getBtwoIndex()*time<0.06){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B3Length() {
        if(wfmone.getBthrIndex()*time>0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B3Shorten() {
        if(wfmone.getBthrIndex()*time<0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean B3Miss() {
        if(wfmone.getBthrIndex()==0){
            return true;
        }else{
            return false;
        }
    }
}
