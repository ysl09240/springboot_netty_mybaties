package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.BaseDiseaseUtils;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * @authorseerhuitao 位变脉搏波的编程
 * @create2018/5/26
 */
public class LocationWave extends BaseDiseaseUtils implements Location
{
    int shall=0;
    int center=0;
    int deep=0;

    int shallone=0;
    int centerone=0;
    int deepone=0;
    public LocationWave(WaveFormModel wfmone, WaveFormModel wfmtwo)
    {
        super(wfmone, wfmtwo);
        this.shall=wfmone.getDenty().getAoneShallowDwon()+wfmone.getDenty().getAoneShallowUp()+
                wfmone.getDenty().getAthrShallowDwon()+wfmone.getDenty().getAthrShallowUp()+
                wfmone.getDenty().getAtwoShallowDwon()+wfmone.getDenty().getAtwoShallowUp();

        this.center=wfmone.getDenty().getAoneCenterDwon()+wfmone.getDenty().getAoneCenterUp()+
                wfmone.getDenty().getAtwoCenterDwon()+wfmone.getDenty().getAtwoCenterUp()+
                wfmone.getDenty().getAthrCenterDwon()+wfmone.getDenty().getAthrCenterUp();

        this.deep=wfmone.getDenty().getAoneDeepDwon()+wfmone.getDenty().getAoneDeepUp()+
                wfmone.getDenty().getAtwoDeepDwon()+wfmone.getDenty().getAtwoDeepUp()+
                wfmone.getDenty().getAthrDeepDwon()+wfmone.getDenty().getAthrDeepUp();

        this.shallone=wfmtwo.getDenty().getAoneShallowDwon()+wfmtwo.getDenty().getAoneShallowUp()+
                wfmtwo.getDenty().getAthrShallowDwon()+wfmtwo.getDenty().getAthrShallowUp()+
                wfmtwo.getDenty().getAtwoShallowDwon()+wfmtwo.getDenty().getAtwoShallowUp();

        this.centerone=wfmtwo.getDenty().getAoneCenterDwon()+wfmtwo.getDenty().getAoneCenterUp()+
                wfmtwo.getDenty().getAtwoCenterDwon()+wfmtwo.getDenty().getAtwoCenterUp()+
                wfmtwo.getDenty().getAthrCenterDwon()+wfmtwo.getDenty().getAthrCenterUp();

        this.deepone=wfmtwo.getDenty().getAoneDeepDwon()+wfmtwo.getDenty().getAoneDeepUp()+
                wfmtwo.getDenty().getAtwoDeepDwon()+wfmtwo.getDenty().getAtwoDeepUp()+
                wfmtwo.getDenty().getAthrDeepDwon()+wfmtwo.getDenty().getAthrDeepUp();

    }
    @Override
    public boolean upDisease() {
        if(this.shall>this.shallone){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean centerDisease() {
        if(this.center>this.centerone){
            return true;
        }else{
            return false;
        }

    }

    @Override
    public boolean lowDisease() {
        if(this.deep>this.deepone){
            return true;
        }else{
            return false;
        }
    }
    //底层先不做
    @Override
    public boolean SlowDisease() {
        return false;
    }
}
