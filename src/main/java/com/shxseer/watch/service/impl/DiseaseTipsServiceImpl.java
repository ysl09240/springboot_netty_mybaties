package com.shxseer.watch.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.shxseer.watch.dao.DiseaseTipsMapper;
import com.shxseer.watch.service.IDiseaseTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  病症service
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.DiseaseService
 * @date 2018年01月26日 15:37
 */
@Service
public class DiseaseTipsServiceImpl implements IDiseaseTipsService {

    private static final Logger log = LoggerFactory.getLogger(DiseaseTipsServiceImpl.class);

    @Autowired
    private DiseaseTipsMapper diseaseTipsMapper;

    /**
     * 根据diseaseCode返回三种类型的建议各一条
     */
    @Override
    public String getRandomDiseaseTips(String diseaseCode) {
        // 存放查询出的各种建议
        List<String> tipsList = new ArrayList<String>();
        // 存放查询出每种类型的建议
        List<String> temp;
        //方法返回的数据
        String suggest = null;
        Map<String, String> params = new HashMap<String, String>();
        params.put("diseaseCode", diseaseCode);
        try {
            for (int i = 1; i < 4; i++) {
                params.put("type", i + "");
                temp = diseaseTipsMapper.selectDiseaseTips(params);
                if (temp != null && temp.size() > 0) {
                    tipsList.add(temp.get(new Random().nextInt(temp.size())));
                }
            }
            if(tipsList != null && tipsList.size() > 0) {
                suggest = JSONArray.toJSONString(tipsList).toString();
            }else{
                tipsList.add("请保持");
                suggest = JSONArray.toJSONString(tipsList).toString();
            }
            log.info("根据diseaseCode为："+diseaseCode+"返回三种类型的建议各一条 成功");
        } catch (Exception e) {
            log.error("根据diseaseCode为："+diseaseCode+"返回三种类型的建议各一条 失败", e);
        }
        return suggest;
    }

}