package com.shxseer.watch.algorithm.eigenvalue;

import com.shxseer.watch.algorithm.wavetools.WaveDenty;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.SplitData;
import com.shxseer.watch.model.*;
import com.shxseer.watch.vo.UserWaveVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 特征值main工具类
 * @author zhangliang
 * @since 2018-07-17 11:14
 */
public class EigenvalueUtils {

    private static Logger log = LoggerFactory.getLogger(EigenvalueUtils.class);

    /**
     * 保存新特征值的方法
     * @param userWaveVo
     * @throws Exception
     */
    public static Map<String,Object> getNewEigenValue(UserWaveVo userWaveVo){
        Map<String, Object> returnMap = NewPlusWaveUtils.getNewEigenValue(userWaveVo.getWaveArray(), userWaveVo.getExePath());
        return returnMap;
    }

    /**
     * 将新特征值五个对象转为算法WaveFormModel类对象集合
     * @param eigenValueMap
     * @return
     */
    public static List<WaveFormModel> newEigenValueToWaveFormModel(Map<String, Object> eigenValueMap){
        List<WaveFormModel> waveFormModelList = new ArrayList<WaveFormModel>();
        WaveFormModel waveFormModel = new WaveFormModel();
        WaveDenty waveDenty=new WaveDenty();
        EigenValueOne eigenValueOne = (EigenValueOne) eigenValueMap.get("eigenValueOne");
        EigenValueTwo eigenValueTwo = (EigenValueTwo) eigenValueMap.get("eigenValueTwo");
        EigenValueThree eigenValueThree = (EigenValueThree) eigenValueMap.get("eigenValueThree");
        EigenValueFour eigenValueFour = (EigenValueFour) eigenValueMap.get("eigenValueFour");
        EigenValueFive eigenValueFive = (EigenValueFive) eigenValueMap.get("eigenValueFive");
        //拆分多值数据的分隔符，因为特征值有负数所以不能用“-”
        String regex = Constant.EIGENVALUE_SPLIT;
        List<Double> startValueList = SplitData.stringToDoubleList(eigenValueOne.getStartValue(), regex);
        for (int i = 0 ; i < startValueList.size() ; i++) {
            waveFormModel.setHertrate(SplitData.stringToIntegerList(eigenValueOne.getHeartRate(), regex).get(i));
            waveFormModel.setStartValue(startValueList.get(i));
            waveFormModel.setStartIndex(SplitData.stringToDoubleList(eigenValueOne.getStartIndex(), regex).get(i));
            waveFormModel.setEndValue(SplitData.stringToDoubleList(eigenValueOne.getEndValue(), regex).get(i));
            waveFormModel.setEndIndex(SplitData.stringToDoubleList(eigenValueOne.getEndIndex(), regex).get(i));
            waveFormModel.setCenterValue(SplitData.stringToDoubleList(eigenValueOne.getCenterValue(), regex).get(i));
            waveFormModel.setCenterIndex(SplitData.stringToDoubleList(eigenValueOne.getCenterIndex(), regex).get(i));
            waveFormModel.setDowncenterValue(SplitData.stringToDoubleList(eigenValueOne.getDowncenterValue(), regex).get(i));
            waveFormModel.setDowncenterIndex(SplitData.stringToDoubleList(eigenValueOne.getDowncenterIndex(), regex).get(i));
            waveFormModel.setAre(SplitData.stringToDoubleList(eigenValueOne.getArea(), regex).get(i));
            waveFormModel.setWidth(SplitData.stringToDoubleList(eigenValueTwo.getWidth(), regex).get(i));
            waveFormModel.setSingleLength(SplitData.stringToDoubleList(eigenValueTwo.getSingleLength(), regex).get(i));
            waveFormModel.setSpeed(SplitData.stringToDoubleList(eigenValueTwo.getSpeed(), regex).get(i));
            waveFormModel.setAoneValue(SplitData.stringToDoubleList(eigenValueTwo.getAoneValue(), regex).get(i));
            waveFormModel.setAoneIndex(SplitData.stringToDoubleList(eigenValueTwo.getAoneIndex(), regex).get(i));
            waveFormModel.setAtwoValue(SplitData.stringToDoubleList(eigenValueTwo.getAtwoValue(), regex).get(i));
            waveFormModel.setAtwoIndex(SplitData.stringToDoubleList(eigenValueTwo.getAtwoIndex(), regex).get(i));
            waveFormModel.setAthrValue(SplitData.stringToDoubleList(eigenValueTwo.getAthrValue(), regex).get(i));
            waveFormModel.setAthrIndex(SplitData.stringToDoubleList(eigenValueTwo.getAthrIndex(), regex).get(i));
            waveFormModel.setBoneValue(SplitData.stringToDoubleList(eigenValueTwo.getBoneValue(), regex).get(i));
            waveFormModel.setBoneIndex(SplitData.stringToDoubleList(eigenValueTwo.getBoneIndex(), regex).get(i));
            waveFormModel.setBtwoValue(SplitData.stringToDoubleList(eigenValueTwo.getBtwoValue(), regex).get(i));
            waveFormModel.setBtwoIndex(SplitData.stringToDoubleList(eigenValueTwo.getBtwoIndex(), regex).get(i));
            waveFormModel.setBthrValue(SplitData.stringToDoubleList(eigenValueTwo.getBthrValue(), regex).get(i));
            waveFormModel.setBthrIndex(SplitData.stringToDoubleList(eigenValueTwo.getBthrIndex(), regex).get(i));
            waveFormModel.setConeValue(SplitData.stringToDoubleList(eigenValueTwo.getConeValue(), regex).get(i));
            waveFormModel.setConeIndex(SplitData.stringToDoubleList(eigenValueTwo.getConeIndex(), regex).get(i));
            waveFormModel.setCtwoValue(SplitData.stringToDoubleList(eigenValueTwo.getCtwoValue(), regex).get(i));
            waveFormModel.setCtwoIndex(SplitData.stringToDoubleList(eigenValueThree.getCtwoIndex(), regex).get(i));
            waveDenty.setAoneShallowUp(SplitData.stringToIntegerList(eigenValueThree.getAoneShallowUp(), regex).get(i));
            waveDenty.setAoneShallowDwon(SplitData.stringToIntegerList(eigenValueThree.getAoneShallowDwon(), regex).get(i));
            waveDenty.setAoneCenterUp(SplitData.stringToIntegerList(eigenValueThree.getAoneCenterUp(), regex).get(i));
            waveDenty.setAoneCenterDwon(SplitData.stringToIntegerList(eigenValueThree.getAoneCenterDwon(), regex).get(i));
            waveDenty.setAoneDeepUp(SplitData.stringToIntegerList(eigenValueThree.getAoneDeepUp(), regex).get(i));
            waveDenty.setAoneDeepDwon(SplitData.stringToIntegerList(eigenValueThree.getAoneDeepDwon(), regex).get(i));
            waveDenty.setAtwoShallowUp(SplitData.stringToIntegerList(eigenValueThree.getAtwoShallowUp(), regex).get(i));
            waveDenty.setAtwoShallowDwon(SplitData.stringToIntegerList(eigenValueThree.getAtwoShallowDwon(), regex).get(i));
            waveDenty.setAtwoCenterUp(SplitData.stringToIntegerList(eigenValueThree.getAtwoCenterUp(), regex).get(i));
            waveDenty.setAtwoCenterDwon(SplitData.stringToIntegerList(eigenValueThree.getAtwoCenterDwon(), regex).get(i));
            waveDenty.setAtwoDeepUp(SplitData.stringToIntegerList(eigenValueThree.getAtwoDeepUp(), regex).get(i));
            waveDenty.setAtwoDeepDwon(SplitData.stringToIntegerList(eigenValueThree.getAtwoDeepDwon(), regex).get(i));
            waveDenty.setAthrShallowUp(SplitData.stringToIntegerList(eigenValueThree.getAthrShallowUp(), regex).get(i));
            waveDenty.setAthrShallowDwon(SplitData.stringToIntegerList(eigenValueThree.getAthrShallowDwon(), regex).get(i));
            waveDenty.setAthrCenterUp(SplitData.stringToIntegerList(eigenValueThree.getAthrCenterUp(), regex).get(i));
            waveDenty.setAthrCenterDwon(SplitData.stringToIntegerList(eigenValueThree.getAthrCenterDwon(), regex).get(i));
            waveDenty.setAthrDeepUp(SplitData.stringToIntegerList(eigenValueFour.getAthrDeepUp(), regex).get(i));
            waveDenty.setAthrDeepDwon(SplitData.stringToIntegerList(eigenValueFour.getAthrDeepDwon(), regex).get(i));
            waveDenty.setBoneShallowUp(SplitData.stringToIntegerList(eigenValueFour.getBoneShallowUp(), regex).get(i));
            waveDenty.setBoneShallowDwon(SplitData.stringToIntegerList(eigenValueFour.getBoneShallowDwon(), regex).get(i));
            waveDenty.setBoneCenterUp(SplitData.stringToIntegerList(eigenValueFour.getBoneCenterUp(), regex).get(i));
            waveDenty.setBoneCenterDwon(SplitData.stringToIntegerList(eigenValueFour.getBoneCenterDwon(), regex).get(i));
            waveDenty.setBoneDeepUp(SplitData.stringToIntegerList(eigenValueFour.getBoneDeepUp(), regex).get(i));
            waveDenty.setBoneDeepDwon(SplitData.stringToIntegerList(eigenValueFour.getBoneDeepDwon(), regex).get(i));
            waveDenty.setBtwoShallowUp(SplitData.stringToIntegerList(eigenValueFour.getBtwoShallowUp(), regex).get(i));
            waveDenty.setBtwoShallowDwon(SplitData.stringToIntegerList(eigenValueFour.getBtwoShallowDwon(), regex).get(i));
            waveDenty.setBtwoCenterUp(SplitData.stringToIntegerList(eigenValueFour.getBtwoCenterUp(), regex).get(i));
            waveDenty.setBtwoCenterDwon(SplitData.stringToIntegerList(eigenValueFour.getBtwoCenterDwon(), regex).get(i));
            waveDenty.setBtwoDeepUp(SplitData.stringToIntegerList(eigenValueFour.getBtwoDeepUp(), regex).get(i));
            waveDenty.setBtwoDeepDwon(SplitData.stringToIntegerList(eigenValueFour.getBtwoDeepDwon(), regex).get(i));
            waveDenty.setBthrShallowUp(SplitData.stringToIntegerList(eigenValueFour.getBthrShallowUp(), regex).get(i));
            waveDenty.setBthrShallowDwon(SplitData.stringToIntegerList(eigenValueFour.getBthrShallowDwon(), regex).get(i));
            waveDenty.setBthrCenterUp(SplitData.stringToIntegerList(eigenValueFour.getBthrCenterUp(), regex).get(i));
            waveDenty.setBthrCenterDwon(SplitData.stringToIntegerList(eigenValueFive.getBthrCenterDwon(), regex).get(i));
            waveDenty.setBthrDeepUp(SplitData.stringToIntegerList(eigenValueFive.getBthrDeepUp(), regex).get(i));
            waveDenty.setBthrDeepDwon(SplitData.stringToIntegerList(eigenValueFive.getBthrDeepDwon(), regex).get(i));
            waveDenty.setConeShallowUp(SplitData.stringToIntegerList(eigenValueFive.getConeShallowUp(), regex).get(i));
            waveDenty.setConeShallowDwon(SplitData.stringToIntegerList(eigenValueFive.getConeShallowDwon(), regex).get(i));
            waveDenty.setConeCenterUp(SplitData.stringToIntegerList(eigenValueFive.getConeCenterUp(), regex).get(i));
            waveDenty.setConeCenterDwon(SplitData.stringToIntegerList(eigenValueFive.getConeCenterDwon(), regex).get(i));
            waveDenty.setConeDeepUp(SplitData.stringToIntegerList(eigenValueFive.getConeDeepUp(), regex).get(i));
            waveDenty.setConeDeepDwon(SplitData.stringToIntegerList(eigenValueFive.getConeDeepDwon(), regex).get(i));
            waveDenty.setCtwoShallowUp(SplitData.stringToIntegerList(eigenValueFive.getCtwoShallowUp(), regex).get(i));
            waveDenty.setCtwoShallowDwon(SplitData.stringToIntegerList(eigenValueFive.getCtwoShallowDwon(), regex).get(i));
            waveDenty.setCtwoCenterUp(SplitData.stringToIntegerList(eigenValueFive.getCtwoCenterUp(), regex).get(i));
            waveDenty.setCtwoCenterDwon(SplitData.stringToIntegerList(eigenValueFive.getCtwoCenterDwon(), regex).get(i));
            waveDenty.setCtwoDeepUp(SplitData.stringToIntegerList(eigenValueFive.getCtwoDeepUp(), regex).get(i));
            waveDenty.setCtwoDeepDwon(SplitData.stringToIntegerList(eigenValueFive.getCtwoDeepDwon(), regex).get(i));
            waveFormModel.setUpTime(SplitData.stringToDoubleList(eigenValueFour.getRiseTime(), regex).get(i));
            waveFormModel.setDownTime(SplitData.stringToDoubleList(eigenValueFour.getFallTime(), regex).get(i));
            waveFormModel.setSingleWaveLength(SplitData.stringToIntegerList(eigenValueOne.getSingleWaveLength(), regex).get(i));
            waveFormModel.setDenty(waveDenty);
            waveFormModelList.add(waveFormModel);
        }
        return waveFormModelList;
    }

}
