package com.shxseer.watch.service.impl;

import com.shxseer.watch.dao.OriginalRecordMapper;
import com.shxseer.watch.model.OriginalRecord;
import com.shxseer.watch.service.IOriginalRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  原始数据service接口实现类
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.OriginalRecordService
 * @date 2017年10月19日 15:05
 */
@Service("originalRecordService")
public class OriginalRecordServiceImpl implements IOriginalRecordService {

    private static Logger log=LoggerFactory.getLogger(OriginalRecordServiceImpl.class);

    @Autowired
    private OriginalRecordMapper originalRecordMapper;

    /**
     * 添加原始数据
     * @param originalRecord
     * @return
     * @throws Exception
     */
    @Override
    public void insertOriginalRecord(OriginalRecord originalRecord) throws Exception{
        originalRecordMapper.insertOriginalRecord(originalRecord);
    }

    /**
     * 根据date获取心率集合 参数：startDate、endDate、userId。
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public List<String> findPulseValuesByDate(Map<String, String> param) throws Exception {
        return originalRecordMapper.findPulseValuesByDate(param);
    }

    /**
     * 根据开始时间和用户id获取记录列表。
     * @param param
     * @return
     * @throws Exception
     */
    @Override
    public List<OriginalRecord> findOriginalRecordListByTime(Map<String, String> param) throws Exception {
        return originalRecordMapper.findOriginalRecordListByTime(param);
    }

    /**
     * 根据开始时间和用户id获取某条数据
     * @param maps
     * @return
     * @throws Exception
     */
    @Override
    public OriginalRecord findSingleOriginalByTime(Map<String,String> maps)throws Exception{
        return originalRecordMapper.findSingleOriginalByTime(maps);
    }

}
