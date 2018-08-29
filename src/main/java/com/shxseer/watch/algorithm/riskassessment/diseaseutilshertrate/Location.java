package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

/**
 * 位变脉应
 */
public interface Location {
    boolean upDisease();//浅搏
    boolean centerDisease();//中搏
    boolean lowDisease();//沉搏
    boolean SlowDisease();//底搏
}
