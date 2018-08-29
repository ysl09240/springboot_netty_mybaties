package com.shxseer.watch.dao;

import com.shxseer.watch.model.OriginalRecord;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  原始数据 mapper
 * @Package com.shxseer.seer.mapper
 * @ClassName: com.shxseer.seer.mapper.ArticleMapper
 * @date 2018年01月26日 15:38
 */
@Mapper
@Component(value ="originalRecordMapper")
public interface OriginalRecordMapper {
    /**
     * 添加原始数据
     * @param originalRecord
     * @return
     * @throws Exception
     */
    public void insertOriginalRecord(OriginalRecord originalRecord) throws Exception;

    public List<OriginalRecord> findOriginalRecordListByTime(Map<String, String> param) throws Exception;

    public List<String> findPulseValuesByDate(Map<String, String> param) throws Exception;

    public OriginalRecord findSingleOriginalByTime(Map<String, String> maps)throws Exception;

    //根据日期模糊查询多条数据
    public List<OriginalRecord> findOriginalRecordListByStartDate(Map<String, Object> maps) throws Exception;

}
