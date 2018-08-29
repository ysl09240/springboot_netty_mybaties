package com.shxseer.watch.algorithm.riskassessment.diseaseutilshertrate;

/**
 * 力变脉应
 */
public interface ForceWave {
    boolean strongStrike();//强搏击（中层）5.4pa-6.0pa
    boolean weakStrike();//软弱搏击（中层）3.5-4.0pa
    boolean samllStrike();//微搏击(条件不明确)
    boolean neckChangeStrike();//颈变搏击（条件不明确）
    boolean alternatetionStrike();//交替搏击（条件不明确）
    boolean softStrike();//软搏击（中层和底层）
    boolean hardStrike();//硬搏击（中底层）
    boolean tightStrike();//紧搏（中底层）
    boolean blankStrike();//空搏击（没条件）
    boolean blankStrikeone();//空搏击（条件不明确）
    boolean floodStrike();//洪搏（不明确）
    boolean punchingStrike();//冲搏（不明确）
    boolean pumpStrike();//抽搏击（A3点增强）
    boolean shakeStrike();//抖搏击（不明确）
    boolean trembleStrike();//颤搏击（不明确）
    boolean breakStrike();//断搏击（不明确）
    boolean upStrike();//陡升搏击（不明确）
    boolean downStrike();//跌搏击（不明确）
}
