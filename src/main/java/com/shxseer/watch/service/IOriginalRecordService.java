package com.shxseer.watch.service;

import com.shxseer.watch.model.OriginalRecord;

import java.util.List;
import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  原始数据service接口
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.IOriginalRecordService
 * @date 2017年10月19日 15:05
 */
public interface IOriginalRecordService {

    /**
     * 添加原始数据
     * @param originalRecord
     * @return
     * @throws Exception
     */
    void insertOriginalRecord(OriginalRecord originalRecord) throws Exception;

    /**
     * 根据date获取心率集合 参数：startDate、endDate、userId。
     * @param param
     * @return
     * @throws Exception
     */
    List<String> findPulseValuesByDate(Map<String, String> param) throws Exception;
    /**
     * 根据开始时间和用户id获取多条数据
     * @param maps
     * @return
     * @throws Exception
     */
    List<OriginalRecord> findOriginalRecordListByTime(Map<String, String> maps)throws Exception;

    /**
     * 根据开始时间和用户id获取某条数据
     * @param maps
     * @return
     * @throws Exception
     */
    OriginalRecord findSingleOriginalByTime(Map<String, String> maps)throws Exception;

}
