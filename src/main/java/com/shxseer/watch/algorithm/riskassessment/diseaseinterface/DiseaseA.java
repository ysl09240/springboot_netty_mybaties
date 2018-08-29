package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

public interface DiseaseA {
    //(A1点前现、后现、漂移、延长、缩短、阙如(que ru) 丢失的意思)
    //心动过速
    boolean A1Bfore();
    //心动过缓
    boolean A1After();
    //动脉硬化以及高血压
    boolean A1Length();
    //心律不齐
    boolean A1Drifting();
    //高热、贫血、低血压
    boolean A1Shorten();
    //贫血
    boolean A1Miss();

    //(A2点延长、A2点缩短、A2点前半阙如（丢失）)
    //肺淤血、肺气肿、矽肺、高血压、高血脂
    boolean A2Length();
    //胸内压降低、贫血
    boolean A2Shorten();
    //贫血
    boolean A2Miss();

    //(A3点漂移、A3点延长、A3点缩短)
    //心律不齐
    boolean A3Drifting();
    //高血糖、高血脂
    boolean A3Length();
    //各种原因导致的外周阻力减小
    boolean A3Shorten();
}
