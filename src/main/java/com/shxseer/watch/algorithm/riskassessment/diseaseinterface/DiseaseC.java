package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

public interface DiseaseC {

    //C1前、C1后、C1延长、C1缩短
    //血管外围阻力减小
    boolean C1Before();
    //血液粘滞度增大
    boolean C1After();
    //动脉硬化、高血压、高血脂
    boolean C1Length();
    //休克、肺心病、房颤
    boolean C1Shorten();

    //C2缓变、C2急变、C2缩短、C2阙如
    //动脉硬化、高血压、高血脂
    boolean C2SlowSpeed();
    //重症肌无力、贫血
    boolean C2FastSpeed();
    //发热性疾病
    boolean C2Shorten();
    //甲状腺危象、阵发性心动过速
    boolean C2Miss();
}
