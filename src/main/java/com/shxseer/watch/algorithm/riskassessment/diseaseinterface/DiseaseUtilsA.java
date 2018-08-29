package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * A段疾病的所有方法
 */
public class DiseaseUtilsA extends BaseDiseaseUtils implements DiseaseA{


    public DiseaseUtilsA(WaveFormModel wfmone, WaveFormModel wfmtwo) {
        super(wfmone, wfmtwo);
    }

    @Override
    public boolean A1Bfore() {
        if(wfmone.getAoneIndex()*time<wfmtwo.getAoneIndex()*time){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean A1After() {
        if(wfmone.getAoneIndex()*time>wfmtwo.getAoneIndex()*time){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A1Length() {
        return false;
    }

    @Override
    public boolean A1Drifting() {
        if(wfmone.getAoneIndex()*time>0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A1Shorten() {
        if(wfmone.getAoneIndex()*time<0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A1Miss() {
        return false;
    }

    @Override
    public boolean A2Length() {
        if(wfmone.getAtwoIndex()*time>0.05){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A2Shorten() {
        if(wfmone.getAtwoIndex()*time<0.04 && wfmone.getAtwoIndex()*time>0.03){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A2Miss() {
        if(wfmone.getAtwoIndex()*time<0.03){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A3Drifting() {

        return false;
    }

    @Override
    public boolean A3Length() {
        if(wfmone.getAthrIndex()*time>0.04){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public boolean A3Shorten() {
        if(wfmone.getAthrIndex()*time<0.03){
            return true;
        }else{
            return false;
        }
    }
    //A1点时变脉应



}
