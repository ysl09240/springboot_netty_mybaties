package com.shxseer.watch.service;

import com.shxseer.watch.model.*;
import com.shxseer.watch.vo.DrugStoreVo;
import com.shxseer.watch.vo.UserWaveVo;

import java.util.List;

/**
 * @author yangsonglin
 * @create 2018-07-09 17:33
 **/
public interface CommandService {

    DrugStoreVo findDrugStore(String id);
    
    /**
     * 波形保存
     */
    WaveDataUpBean waveSave(WaveDataUpBean waveDataUpBean,User user) throws Exception;

    /**
     * 久坐提醒上传
     */
    boolean sedentarySave(SedentaryBean sedentaryBean);


    /**
     * 计步上传
     */
    void stepCountSave(StepBean stepBean);



    /**
     * 查询公共参数
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
     * 查询手表和用户对应记录
     * @param heartBeatBean
     * @return
     */
    WatchUserRecordBean findWatchUserRecordByImei(HeartBeatBean heartBeatBean);

    /**
     * 处理波型数据
     * @param waveDataUpBean
     * @return
     */
    Object waveDealData(WaveDataUpBean waveDataUpBean,User user) throws Exception;


    /**
     * 计算血糖报告
     * @param userWaveVo
     */
    ReportDisease calculateBloodGlucoseReport(UserWaveVo userWaveVo);

    /**
     * 计算疲劳报告
     * @param userWaveVo
     */
    ReportDisease calculateTeriodReport(UserWaveVo userWaveVo);

    /**
     * 计算血压报告
     * @param userWaveVo
     */
    ReportDisease calculateBloodPressReport(UserWaveVo userWaveVo);

    /**
     * 计算运动预警报告
     * @param userWaveVo
     */
    ReportDisease calculateSportHertRateReport(UserWaveVo userWaveVo);

    /**
     * 计算血液粘稠度报告
     * @param userWaveVo
     */
    ReportDisease calculateBloodConsistencyReport(UserWaveVo userWaveVo);

    /**
     * 计算K值报告
     * @param userWaveVo
     * @return
     */
    ReportDisease calculateKvalueReport(UserWaveVo userWaveVo);

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
     * @param imei 设备号
     * @param startTime 测量时间
     * @return
     */
    String getBeforeWaveIdByStarttime(String imei, double startTime);


    /**
     * 是否开始测量
     * @param bloodBaselineBean
     * @return
     */
    BloodBaselineBean isStartMeasure(BloodBaselineBean bloodBaselineBean);
}
