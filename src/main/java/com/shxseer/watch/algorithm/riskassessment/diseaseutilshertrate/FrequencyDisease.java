package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

/**
 * 频变脉应
 */
public interface FrequencyDisease {
    boolean SlowDisease();//超迟搏
    boolean LateCardiac();//迟搏
    boolean SecondDisease();//亚迟搏
    boolean numberDisease();//亚数博
    boolean MoreDisese();//数博
    boolean jiDisease();//疾博
    boolean Chaobo();//潮波
}
