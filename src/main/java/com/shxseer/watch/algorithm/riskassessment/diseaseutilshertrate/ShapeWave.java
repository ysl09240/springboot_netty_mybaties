package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

import com.shxseer.watch.algorithm.riskassessment.diseaseinterface.BaseDiseaseUtils;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;

/**
 * @authorseerhuitao
 * @create2018/5/28
 */
public class ShapeWave extends BaseDiseaseUtils implements ShapeDisease
{

    public ShapeWave(WaveFormModel wfmone, WaveFormModel wfmtwo)
    {
        super(wfmone, wfmtwo);
    }

    @Override
    public boolean Sliding()
    {
        return false;
    }

    @Override
    public boolean Shibuya()
    {
        return false;
    }

    @Override
    public boolean SlidingAndShibuya()
    {
        return false;
    }

    @Override
    public boolean superpositionBo()
    {
        return false;
    }

    @Override
    public boolean lengthBo()
    {
        return false;
    }

    @Override
    public boolean ShortBo()
    {
        return false;
    }

    @Override
    public boolean Ruthless()
    {
        return false;
    }

    @Override
    public boolean Paddle()
    {
        return false;
    }

    @Override
    public boolean neckBecameTachycardic()
    {
        return false;
    }

    @Override
    public boolean Douba()
    {
        return false;
    }
}
