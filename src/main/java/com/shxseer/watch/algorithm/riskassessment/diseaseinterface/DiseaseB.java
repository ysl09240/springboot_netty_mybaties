package com.shxseer.watch.algorithm.riskassessment.diseaseinterface;

public interface DiseaseB {
    //B1点后现、延长、缩短
    //右心衰竭引起的肝淤血
    boolean B1Length();
    //贫血
    boolean B1Shorten();

    //B2延长、缩短、阙如
    //胃肠淤带
    boolean B2Length();
    //胃肠粘膜猥琐
    boolean B2Shorten();

    //B3延长、缩短、阙如
    //下肢静脉曲张
    boolean B3Length();
    //下肢萎缩、下肢营养不良
    boolean B3Shorten();
    //髋关节病变（股骨头坏死）
    boolean B3Miss();
}
