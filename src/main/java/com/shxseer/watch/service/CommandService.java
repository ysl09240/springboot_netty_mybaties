package com.shxseer.watch.service;

import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.NoticeBean;
import com.shxseer.watch.model.SedentaryBean;
import com.shxseer.watch.model.StepBean;
import com.shxseer.watch.model.WaveDataUpBean;
import com.shxseer.watch.vo.DrugStoreVo;

/**
 * @author yangsonglin
 * @create 2018-07-09 17:33
 **/
public interface CommandService {

    DrugStoreVo findDrugStore(String id);
    
    /**
     * 波形保存
     */
    void waveSave(WaveDataUpBean waveDataUpBean);

    /**
     * 久坐提醒上传
     */
    boolean sedentarySave(SedentaryBean sedentaryBean);

    /**
     * 指令转发
     */
    String noticeTranspond(NoticeBean noticeBean);

    /**
     * 计步上传
     */
    boolean stepCountSave(StepBean stepBean);

    /**
     * 血糖血压基准值是否有效判断
     */
    String bloodBaseIsValid(BloodBaselineBean bloodBaselineBean);



}
