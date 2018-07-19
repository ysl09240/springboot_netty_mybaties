package com.shxseer.watch.service.impl;

import com.alibaba.fastjson.JSON;
import com.shxseer.watch.dao.CommandMapper;
import com.shxseer.watch.model.BloodBaselineBean;
import com.shxseer.watch.model.MessageType;
import com.shxseer.watch.model.NoticeBean;
import com.shxseer.watch.model.SedentaryBean;
import com.shxseer.watch.model.StepBean;
import com.shxseer.watch.model.WaveDataUpBean;
import com.shxseer.watch.service.CommandService;
import com.shxseer.watch.vo.DrugStoreVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;


/**
 * @author yangsonglin
 * @create 2018-07-09 17:33
 **/
@Service("commandService")
public class CommandServiceImpl implements CommandService {

    @Autowired
    CommandMapper commandMapper;

    @Override
    public DrugStoreVo findDrugStore(String id) {
        return commandMapper.findDrugStore(id);
    }

    /**
     * 波形保存
     */
    @Override
    public void waveSave(WaveDataUpBean waveDataUpBean) {
        commandMapper.waveSave(waveDataUpBean);
    }

    /**
     * 久坐提醒上传
     */
    @Override
    public boolean sedentarySave(SedentaryBean sedentaryBean) {
        commandMapper.sedentarySave(sedentaryBean);
        return true;
    }

    /**
     * 指令转发
     */
    @Override
    public String noticeTranspond(NoticeBean noticeBean) {
        return null;
    }

    /**
     * 计步上传
     */
    @Override
    public boolean stepCountSave(StepBean stepBean) {
        commandMapper.stepCountSave(stepBean);
        return true;
    }

    /**
     * 血糖血压基准值是否有效判断
     */
    @Override
    public String bloodBaseIsValid(BloodBaselineBean bloodBaselineBean) {

        //获取血糖血压查询信息
        HashMap map = commandMapper.bloodBaseSearch(bloodBaselineBean).get(0);
        //获取间隔时间
        int intervalDay =  (Integer) map.get("standard_interval");
        //获取当前时间
        Date createTime = (Date) map.get("create_time");
        //计算获得对照时间
        Date compareTime = dayAdd(createTime,intervalDay);

        BloodBaselineBean beanResult = new BloodBaselineBean();
        //判断当前时间和对照时间比较，根据对比结果传入不同的有效值
        if(new Date().after(compareTime)){
            beanResult.setIsvalid(MessageType.ISVALID_TRUE);
        } else {
            beanResult.setIsvalid(MessageType.ISVALID_FALSE);
        }
        //传入datatype到bean
        beanResult.setDatatype(MessageType.MSG_BLOOD_BASELINE);

        return JSON.toJSON(beanResult).toString();
    }




    //目标时间增加天数
    private Date dayAdd(Date date,int addNum){
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, addNum);
        Date newDate = c.getTime();
        return newDate;
    }


}
