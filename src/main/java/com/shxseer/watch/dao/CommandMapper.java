package com.shxseer.watch.dao;

import com.shxseer.watch.model.*;
import com.shxseer.watch.vo.DrugStoreVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    /**
     * 查询公共参数配置
     * @param commonType
     * @return
     */
    CommonParamsBean findCommonParams(String commonType);

    /**
     * 心率上传
     * @param heartRateDataBean
     */
    void heartRateDataSave(HeartRateDataBean heartRateDataBean);

    /**
     * 根据设备号查询用户对应关系
     * @param heartBeatBean
     * @return
     */
    WatchUserRecordBean findWatchUserRecordByImei(HeartBeatBean heartBeatBean);

    /**
     * 根据imei号获取原始数据主键id集合
     */
    List<String> getWaveIdByimei(String imei);

    /**
     * 根据主键id查询原始数据对象
     * @param waveId
     * @return
     */
    WaveDataUpBean getWaveDataUpBeanById(String waveId);

    /**
     * 根据本次测量时间和设备号查询当前用户的上一组数据的主键id
     * @param maps（包括测量时间和设备号）
     * @return
     */
    String getBeforeWaveIdByStarttime(Map<String, Object> maps);

}
