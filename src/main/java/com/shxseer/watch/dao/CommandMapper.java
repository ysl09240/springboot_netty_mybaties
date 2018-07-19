package com.shxseer.watch.dao;

import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.SedentaryBean;
import com.shxseer.watch.model.StepBean;
import com.shxseer.watch.model.WaveDataUpBean;
import com.shxseer.watch.vo.DrugStoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;


@Mapper
@Component(value ="commandMapper")
public interface CommandMapper {

    DrugStoreVo findDrugStore(String id);

    //波形保存
    void waveSave(WaveDataUpBean waveDataUpBean);

    //久坐提醒上传
    void sedentarySave(SedentaryBean sedentaryBean);

    //久坐提醒上传
    void stepCountSave(StepBean stepBean);

    //血糖血压基准值查询
    List<HashMap> bloodBaseSearch(BloodBaselineBean bloodBaselineBean);
}
