package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

/**
 * 形变脉应
 */
public interface ShapeDisease {
    boolean Sliding();//滑搏
    boolean Shibuya();//涩搏
    boolean SlidingAndShibuya();//涩滑搏与滑涩搏
    boolean superpositionBo();//叠搏
    boolean lengthBo();//长搏
    boolean ShortBo();//短搏
    boolean Ruthless();//粗博
    boolean Paddle();//细搏
    boolean neckBecameTachycardic();//颈变细搏
    boolean Douba();//豆搏
}
