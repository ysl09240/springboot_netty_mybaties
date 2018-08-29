package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.BaseDiseaseUtils;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * @authorseerhuitao 力变脉搏波的编程
 * @create2018/7/28
 */
public class ForceDisease extends BaseDiseaseUtils implements ForceWave
{
    public ForceDisease(WaveFormModel wfmone, WaveFormModel wfmtwo)
    {
        super(wfmone, wfmtwo);
    }

    @Override
    public boolean strongStrike() {
        return false;
    }

    @Override
    public boolean weakStrike() {
        return false;
    }

    @Override
    public boolean samllStrike() {
        return false;
    }

    @Override
    public boolean neckChangeStrike() {
        return false;
    }

    @Override
    public boolean alternatetionStrike() {
        return false;
    }

    @Override
    public boolean softStrike() {
        return false;
    }

    @Override
    public boolean hardStrike() {
        return false;
    }

    @Override
    public boolean tightStrike() {
        return false;
    }

    @Override
    public boolean blankStrike() {
        return false;
    }

    @Override
    public boolean blankStrikeone() {
        return false;
    }

    @Override
    public boolean floodStrike() {
        return false;
    }

    @Override
    public boolean punchingStrike() {
        return false;
    }

    @Override
    public boolean pumpStrike() {
        return false;
    }

    @Override
    public boolean shakeStrike() {
        return false;
    }

    @Override
    public boolean trembleStrike() {
        return false;
    }

    @Override
    public boolean breakStrike() {
        return false;
    }

    @Override
    public boolean upStrike() {
        return false;
    }

    @Override
    public boolean downStrike() {
        return false;
    }
}
