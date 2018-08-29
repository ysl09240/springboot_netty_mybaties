package com.shxseer.watch.algorithm.eigenvalue;

import com.shxseer.watch.algorithm.wavetools.AllWave;
import com.shxseer.watch.algorithm.wavetools.BaseWaveUtilsEducation;
import com.shxseer.watch.algorithm.wavetools.WaveDenty;
import com.shxseer.watch.algorithm.wavetools.WaveFormModel;
import com.shxseer.watch.common.Constant;
import com.shxseer.watch.common.SplitData;
import com.shxseer.watch.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 新的调用算法提取特征值的工具类2018-07-18
 * @author zhangliang
 * @since 2018-07-18 19:23
 */
public class NewPlusWaveUtils {

    private static final Logger log = LoggerFactory.getLogger(EigenvalueUtils.class);
    /**
     * 获取新特征值
     * @param waveArray 原始波形double数组
     * @param exePath 算法包的绝对路径
     * @return
     */
    public static Map<String, Object> getNewEigenValue(double[] waveArray, String exePath){
        Map<String, Object> returnMap = new HashMap<String, Object>(5);
        BaseWaveUtilsEducation baseWaveUtilsEducation = new BaseWaveUtilsEducation(waveArray, exePath);
        AllWave allWave = new AllWave(baseWaveUtilsEducation);
        List<WaveFormModel> waveFormModelList = allWave.getList();
        if(waveFormModelList != null && waveFormModelList.size() > 0){
            EigenValueOne eigenValueOne = new EigenValueOne();
            EigenValueTwo eigenValueTwo = new EigenValueTwo();
            EigenValueThree eigenValueThree = new EigenValueThree();
            EigenValueFour eigenValueFour = new EigenValueFour();
            EigenValueFive eigenValueFive = new EigenValueFive();

            List<Double> startValueList = new ArrayList<Double>();
            List<Double> startIndexList = new ArrayList<Double>();
            List<Double> endValueList = new ArrayList<Double>();
            List<Double> endIndexList = new ArrayList<Double>();
            List<Double> centerValueList = new ArrayList<Double>();
            List<Double> centerIndexList = new ArrayList<Double>();
            List<Double> downcenterValueList = new ArrayList<Double>();
            List<Double> downcenterIndexList = new ArrayList<Double>();
            List<Double> areaList = new ArrayList<Double>();
            List<Double> widthList = new ArrayList<Double>();
            List<Double> singleLengthList = new ArrayList<Double>();
            List<Double> speedList = new ArrayList<Double>();
            List<Double> aoneValueList = new ArrayList<Double>();
            List<Double> aoneIndexList = new ArrayList<Double>();
            List<Double> atwoValueList = new ArrayList<Double>();
            List<Double> atwoIndexList = new ArrayList<Double>();
            List<Double> athrValueList = new ArrayList<Double>();
            List<Double> athrIndexList = new ArrayList<Double>();
            List<Double> boneValueList = new ArrayList<Double>();
            List<Double> boneIndexList = new ArrayList<Double>();
            List<Double> btwoValueList = new ArrayList<Double>();
            List<Double> btwoIndexList = new ArrayList<Double>();
            List<Double> bthrValueList = new ArrayList<Double>();
            List<Double> bthrIndexList = new ArrayList<Double>();
            List<Double> coneValueList = new ArrayList<Double>();
            List<Double> coneIndexList = new ArrayList<Double>();
            List<Double> ctwoValueList = new ArrayList<Double>();
            List<Double> ctwoIndexList = new ArrayList<Double>();
            List<Integer> aoneShallowUpList = new ArrayList<Integer>();
            List<Integer> aoneShallowDwonList = new ArrayList<Integer>();
            List<Integer> aoneCenterUpList = new ArrayList<Integer>();
            List<Integer> aoneCenterDwonList = new ArrayList<Integer>();
            List<Integer> aoneDeepUpList = new ArrayList<Integer>();
            List<Integer> aoneDeepDwonList = new ArrayList<Integer>();
            List<Integer> atwoShallowUpList = new ArrayList<Integer>();
            List<Integer> atwoShallowDwonList = new ArrayList<Integer>();
            List<Integer> atwoCenterUpList = new ArrayList<Integer>();
            List<Integer> atwoCenterDwonList = new ArrayList<Integer>();
            List<Integer> atwoDeepUpList = new ArrayList<Integer>();
            List<Integer> atwoDeepDwonList = new ArrayList<Integer>();
            List<Integer> athrShallowUpList = new ArrayList<Integer>();
            List<Integer> athrShallowDwonList = new ArrayList<Integer>();
            List<Integer> athrCenterUpList = new ArrayList<Integer>();
            List<Integer> athrCenterDwonList = new ArrayList<Integer>();
            List<Integer> athrDeepUpList = new ArrayList<Integer>();
            List<Integer> athrDeepDwonList = new ArrayList<Integer>();
            List<Integer> boneShallowUpList = new ArrayList<Integer>();
            List<Integer> boneShallowDwonList = new ArrayList<Integer>();
            List<Integer> boneCenterUpList = new ArrayList<Integer>();
            List<Integer> boneCenterDwonList = new ArrayList<Integer>();
            List<Integer> boneDeepUpList = new ArrayList<Integer>();
            List<Integer> boneDeepDwonList = new ArrayList<Integer>();
            List<Integer> btwoShallowUpList = new ArrayList<Integer>();
            List<Integer> btwoShallowDwonList = new ArrayList<Integer>();
            List<Integer> btwoCenterUpList = new ArrayList<Integer>();
            List<Integer> btwoCenterDwonList = new ArrayList<Integer>();
            List<Integer> btwoDeepUpList = new ArrayList<Integer>();
            List<Integer> btwoDeepDwonList = new ArrayList<Integer>();
            List<Integer> bthrShallowUpList = new ArrayList<Integer>();
            List<Integer> bthrShallowDwonList = new ArrayList<Integer>();
            List<Integer> bthrCenterUpList = new ArrayList<Integer>();
            List<Integer> bthrCenterDwonList = new ArrayList<Integer>();
            List<Integer> bthrDeepUpList = new ArrayList<Integer>();
            List<Integer> bthrDeepDwonList = new ArrayList<Integer>();
            List<Integer> coneShallowUpList = new ArrayList<Integer>();
            List<Integer> coneShallowDwonList = new ArrayList<Integer>();
            List<Integer> coneCenterUpList = new ArrayList<Integer>();
            List<Integer> coneCenterDwonList = new ArrayList<Integer>();
            List<Integer> coneDeepUpList = new ArrayList<Integer>();
            List<Integer> coneDeepDwonList = new ArrayList<Integer>();
            List<Integer> ctwoShallowUpList = new ArrayList<Integer>();
            List<Integer> ctwoShallowDwonList = new ArrayList<Integer>();
            List<Integer> ctwoCenterUpList = new ArrayList<Integer>();
            List<Integer> ctwoCenterDwonList = new ArrayList<Integer>();
            List<Integer> ctwoDeepUpList = new ArrayList<Integer>();
            List<Integer> ctwoDeepDwonList = new ArrayList<Integer>();
            List<Double> riseTimeList = new ArrayList<Double>();
            List<Double> fallTimeList = new ArrayList<Double>();
            List<Integer> heartRateList = new ArrayList<Integer>();
            List<Integer> singleWaveLengthList = new ArrayList<Integer>();

            for (WaveFormModel waveFormModel : waveFormModelList) {
                startValueList.add(waveFormModel.getStartValue());
                startIndexList.add(waveFormModel.getStartIndex());
                endValueList.add(waveFormModel.getEndValue());
                endIndexList.add(waveFormModel.getEndIndex());
                centerValueList.add(waveFormModel.getCenterValue());
                centerIndexList.add(waveFormModel.getCenterIndex());
                downcenterValueList.add(waveFormModel.getDowncenterValue());
                downcenterIndexList.add(waveFormModel.getDowncenterIndex());
                areaList.add(waveFormModel.getAre());
                widthList.add(waveFormModel.getWidth());
                singleLengthList.add(waveFormModel.getSingleLength());
                speedList.add(waveFormModel.getSpeed());
                aoneValueList.add(waveFormModel.getAoneValue());
                aoneIndexList.add(waveFormModel.getAoneIndex());
                atwoValueList.add(waveFormModel.getAtwoValue());
                atwoIndexList.add(waveFormModel.getAtwoIndex());
                athrValueList.add(waveFormModel.getAthrValue());
                athrIndexList.add(waveFormModel.getAthrIndex());
                boneValueList.add(waveFormModel.getBoneValue());
                boneIndexList.add(waveFormModel.getBoneIndex());
                btwoValueList.add(waveFormModel.getBtwoValue());
                btwoIndexList.add(waveFormModel.getBtwoIndex());
                bthrValueList.add(waveFormModel.getBthrValue());
                bthrIndexList.add(waveFormModel.getBthrIndex());
                coneValueList.add(waveFormModel.getConeValue());
                coneIndexList.add(waveFormModel.getConeIndex());
                ctwoValueList.add(waveFormModel.getCtwoValue());
                ctwoIndexList.add(waveFormModel.getCtwoIndex());
                WaveDenty waveDenty = waveFormModel.getDenty();
                aoneShallowUpList.add(waveDenty.getAoneShallowUp());
                aoneShallowDwonList.add(waveDenty.getAoneShallowDwon());
                aoneCenterUpList.add(waveDenty.getAoneCenterUp());
                aoneCenterDwonList.add(waveDenty.getAoneCenterDwon());
                aoneDeepUpList.add(waveDenty.getAoneDeepUp());
                aoneDeepDwonList.add(waveDenty.getAoneDeepDwon());
                atwoShallowUpList.add(waveDenty.getAtwoShallowUp());
                atwoShallowDwonList.add(waveDenty.getAtwoShallowDwon());
                atwoCenterUpList.add(waveDenty.getAtwoCenterUp());
                atwoCenterDwonList.add(waveDenty.getAtwoCenterDwon());
                atwoDeepUpList.add(waveDenty.getAtwoDeepUp());
                atwoDeepDwonList.add(waveDenty.getAtwoDeepDwon());
                athrShallowUpList.add(waveDenty.getAthrShallowUp());
                athrShallowDwonList.add(waveDenty.getAthrShallowDwon());
                athrCenterUpList.add(waveDenty.getAthrCenterUp());
                athrCenterDwonList.add(waveDenty.getAthrCenterDwon());
                athrDeepUpList.add(waveDenty.getAthrDeepUp());
                athrDeepDwonList.add(waveDenty.getAthrDeepDwon());
                boneShallowUpList.add(waveDenty.getBoneShallowUp());
                boneShallowDwonList.add(waveDenty.getBoneShallowDwon());
                boneCenterUpList.add(waveDenty.getBoneCenterUp());
                boneCenterDwonList.add(waveDenty.getBoneCenterDwon());
                boneDeepUpList.add(waveDenty.getBoneDeepUp());
                boneDeepDwonList.add(waveDenty.getBoneDeepDwon());
                btwoShallowUpList.add(waveDenty.getBtwoShallowUp());
                btwoShallowDwonList.add(waveDenty.getBtwoShallowDwon());
                btwoCenterUpList.add(waveDenty.getBtwoCenterUp());
                btwoCenterDwonList.add(waveDenty.getBtwoCenterDwon());
                btwoDeepUpList.add(waveDenty.getBtwoDeepUp());
                btwoDeepDwonList.add(waveDenty.getBtwoDeepDwon());
                bthrShallowUpList.add(waveDenty.getBthrShallowUp());
                bthrShallowDwonList.add(waveDenty.getBthrShallowDwon());
                bthrCenterUpList.add(waveDenty.getBthrCenterUp());
                bthrCenterDwonList.add(waveDenty.getBthrCenterDwon());
                bthrDeepUpList.add(waveDenty.getBthrDeepUp());
                bthrDeepDwonList.add(waveDenty.getBthrDeepDwon());
                coneShallowUpList.add(waveDenty.getConeShallowUp());
                coneShallowDwonList.add(waveDenty.getConeShallowDwon());
                coneCenterUpList.add(waveDenty.getConeCenterUp());
                coneCenterDwonList.add(waveDenty.getConeCenterDwon());
                coneDeepUpList.add(waveDenty.getConeDeepUp());
                coneDeepDwonList.add(waveDenty.getConeDeepDwon());
                ctwoShallowUpList.add(waveDenty.getCtwoShallowUp());
                ctwoShallowDwonList.add(waveDenty.getCtwoShallowDwon());
                ctwoCenterUpList.add(waveDenty.getCtwoCenterUp());
                ctwoCenterDwonList.add(waveDenty.getCtwoCenterDwon());
                ctwoDeepUpList.add(waveDenty.getCtwoDeepUp());
                ctwoDeepDwonList.add(waveDenty.getCtwoDeepDwon());
                riseTimeList.add(waveFormModel.getUpTime());
                fallTimeList.add(waveFormModel.getDownTime());
                heartRateList.add(waveFormModel.getHertrate());
                singleWaveLengthList.add(waveFormModel.getSingleWaveLength());
            }

            //拼接多值数据的分隔符，因为特征值有负数所以不能用“-”
            String regex = Constant.EIGENVALUE_SPLIT;
            //心率
            eigenValueOne.setHeartRate(SplitData.integerListToString(heartRateList, regex));
            //整组波的速度
            eigenValueOne.setPulseSpeed(allWave.getSpeed());
            //整组波的面积
            eigenValueOne.setPulseArea(allWave.getAre());
            //开始值
            eigenValueOne.setStartValue(SplitData.doubleListToString(startValueList, regex));
            //开始点的下标
            eigenValueOne.setStartIndex(SplitData.doubleListToString(startIndexList, regex));
            //结束点值
            eigenValueOne.setEndValue(SplitData.doubleListToString(endValueList, regex));
            //结束点的下标
            eigenValueOne.setEndIndex(SplitData.doubleListToString(endIndexList, regex));
            //振幅值
            eigenValueOne.setCenterValue(SplitData.doubleListToString(centerValueList, regex));
            //振幅下标
            eigenValueOne.setCenterIndex(SplitData.doubleListToString(centerIndexList, regex));
            //降中峡值 -- 10
            eigenValueOne.setDowncenterValue(SplitData.doubleListToString(downcenterValueList, regex));
            //降中峡的下标
            eigenValueOne.setDowncenterIndex(SplitData.doubleListToString(downcenterIndexList, regex));
            //单个脉搏波的面积
            eigenValueOne.setArea(SplitData.doubleListToString(areaList, regex));
            //单个脉搏波的宽度
            eigenValueTwo.setWidth(SplitData.doubleListToString(widthList, regex));
            //单个脉搏波的长度
            eigenValueTwo.setSingleLength(SplitData.doubleListToString(singleLengthList, regex));
            //单个脉搏波的速度
            eigenValueTwo.setSpeed(SplitData.doubleListToString(speedList, regex));
            //A1点的值
            eigenValueTwo.setAoneValue(SplitData.doubleListToString(aoneValueList, regex));
            //A1点的下标
            eigenValueTwo.setAoneIndex(SplitData.doubleListToString(aoneIndexList, regex));
            //A2点的值
            eigenValueTwo.setAtwoValue(SplitData.doubleListToString(atwoValueList, regex));
            //A2点的下标
            eigenValueTwo.setAtwoIndex(SplitData.doubleListToString(atwoIndexList, regex));
            //A3点的值 -- 20
            eigenValueTwo.setAthrValue(SplitData.doubleListToString(athrValueList, regex));
            //A3点的下标
            eigenValueTwo.setAthrIndex(SplitData.doubleListToString(athrIndexList, regex));
            //B1的值
            eigenValueTwo.setBoneValue(SplitData.doubleListToString(boneValueList, regex));
            //B1的下标
            eigenValueTwo.setBoneIndex(SplitData.doubleListToString(boneIndexList, regex));
            //B2的值
            eigenValueTwo.setBtwoValue(SplitData.doubleListToString(btwoValueList, regex));
            //B2的下标
            eigenValueTwo.setBtwoIndex(SplitData.doubleListToString(btwoIndexList, regex));
            //B3点的值
            eigenValueTwo.setBthrValue(SplitData.doubleListToString(bthrValueList, regex));
            //B3的下标
            eigenValueTwo.setBthrIndex(SplitData.doubleListToString(bthrIndexList, regex));
            //C1的值
            eigenValueTwo.setConeValue(SplitData.doubleListToString(coneValueList, regex));
            //C1的下标
            eigenValueTwo.setConeIndex(SplitData.doubleListToString(coneIndexList, regex));
            //C2点的值 -- 30
            eigenValueTwo.setCtwoValue(SplitData.doubleListToString(ctwoValueList, regex));
            //C2点的下标
            eigenValueThree.setCtwoIndex(SplitData.doubleListToString(ctwoIndexList, regex));
            //a1的浅上密度
            eigenValueThree.setAoneShallowUp(SplitData.integerListToString(aoneShallowUpList, regex));
            //a1的浅下密度
            eigenValueThree.setAoneShallowDwon(SplitData.integerListToString(aoneShallowDwonList, regex));
            //a1的中上密度
            eigenValueThree.setAoneCenterUp(SplitData.integerListToString(aoneCenterUpList, regex));
            //a1的中下密度
            eigenValueThree.setAoneCenterDwon(SplitData.integerListToString(aoneCenterDwonList, regex));
            //a1的深上密度
            eigenValueThree.setAoneDeepUp(SplitData.integerListToString(aoneDeepUpList, regex));
            //a1的深下密度
            eigenValueThree.setAoneDeepDwon(SplitData.integerListToString(aoneDeepDwonList, regex));
            //a2的浅上密度
            eigenValueThree.setAtwoShallowUp(SplitData.integerListToString(atwoShallowUpList, regex));
            //a2的浅下密度
            eigenValueThree.setAtwoShallowDwon(SplitData.integerListToString(atwoShallowDwonList, regex));
            //a2的中上密度 -- 40
            eigenValueThree.setAtwoCenterUp(SplitData.integerListToString(atwoCenterUpList, regex));
            //a2的中下密度
            eigenValueThree.setAtwoCenterDwon(SplitData.integerListToString(atwoCenterDwonList, regex));
            //a2的深上密度
            eigenValueThree.setAtwoDeepUp(SplitData.integerListToString(atwoDeepUpList, regex));
            //a2的深下密度
            eigenValueThree.setAtwoDeepDwon(SplitData.integerListToString(atwoDeepDwonList, regex));
            //a3的浅上密度
            eigenValueThree.setAthrShallowUp(SplitData.integerListToString(athrShallowUpList, regex));
            //a3的浅下密度
            eigenValueThree.setAthrShallowDwon(SplitData.integerListToString(athrShallowDwonList, regex));
            //a3的中上密度
            eigenValueThree.setAthrCenterUp(SplitData.integerListToString(athrCenterUpList, regex));
            //a3的中下密度
            eigenValueThree.setAthrCenterDwon(SplitData.integerListToString(athrCenterDwonList, regex));
            //a3的深上密度
            eigenValueFour.setAthrDeepUp(SplitData.integerListToString(athrDeepUpList, regex));
            //a3的深下密度
            eigenValueFour.setAthrDeepDwon(SplitData.integerListToString(athrDeepDwonList, regex));
            //b1的浅上密度 -- 50
            eigenValueFour.setBoneShallowUp(SplitData.integerListToString(boneShallowUpList, regex));
            //b1的浅下密度
            eigenValueFour.setBoneShallowDwon(SplitData.integerListToString(boneShallowDwonList, regex));
            //b1的中上密度
            eigenValueFour.setBoneCenterUp(SplitData.integerListToString(boneCenterUpList, regex));
            //b1的中下密度
            eigenValueFour.setBoneCenterDwon(SplitData.integerListToString(boneCenterDwonList, regex));
            //b1的深上密度
            eigenValueFour.setBoneDeepUp(SplitData.integerListToString(boneDeepUpList, regex));
            //b1的深下密度
            eigenValueFour.setBoneDeepDwon(SplitData.integerListToString(boneDeepDwonList, regex));
            //b2的浅上密度
            eigenValueFour.setBtwoShallowUp(SplitData.integerListToString(btwoShallowUpList, regex));
            //b2的浅下密度
            eigenValueFour.setBtwoShallowDwon(SplitData.integerListToString(btwoShallowDwonList, regex));
            //b2的中上密度
            eigenValueFour.setBtwoCenterUp(SplitData.integerListToString(btwoCenterUpList, regex));
            //b2的中下密度
            eigenValueFour.setBtwoCenterDwon(SplitData.integerListToString(btwoCenterDwonList, regex));
            //b2的深上密度 -- 60
            eigenValueFour.setBtwoDeepUp(SplitData.integerListToString(btwoDeepUpList, regex));
            //b2的深下密度
            eigenValueFour.setBtwoDeepDwon(SplitData.integerListToString(btwoDeepUpList, regex));
            //b3的浅上密度
            eigenValueFour.setBthrShallowUp(SplitData.integerListToString(bthrShallowUpList, regex));
            //b3的浅下密度
            eigenValueFour.setBthrShallowDwon(SplitData.integerListToString(bthrShallowDwonList, regex));
            //b3的中上密度
            eigenValueFour.setBthrCenterUp(SplitData.integerListToString(bthrCenterUpList, regex));
            //b3的中下密度
            eigenValueFive.setBthrCenterDwon(SplitData.integerListToString(bthrCenterDwonList, regex));
            //b3的深上密度
            eigenValueFive.setBthrDeepUp(SplitData.integerListToString(bthrDeepUpList, regex));
            //b3的深下密度
            eigenValueFive.setBthrDeepDwon(SplitData.integerListToString(bthrDeepDwonList, regex));
            //c1的浅上密度
            eigenValueFive.setConeShallowUp(SplitData.integerListToString(coneShallowUpList, regex));
            //c1的浅下密度
            eigenValueFive.setConeShallowDwon(SplitData.integerListToString(coneShallowDwonList, regex));
            //c1的中上密度 -- 70
            eigenValueFive.setConeCenterUp(SplitData.integerListToString(coneCenterUpList, regex));
            //c1的中下密度
            eigenValueFive.setConeCenterDwon(SplitData.integerListToString(coneCenterDwonList, regex));
            //c1的深上密度
            eigenValueFive.setConeDeepUp(SplitData.integerListToString(coneDeepUpList, regex));
            //c1的深下密度
            eigenValueFive.setConeDeepDwon(SplitData.integerListToString(coneDeepDwonList, regex));
            //c2的浅上密度
            eigenValueFive.setCtwoShallowUp(SplitData.integerListToString(ctwoShallowUpList, regex));
            //c2的浅下密度
            eigenValueFive.setCtwoShallowDwon(SplitData.integerListToString(ctwoShallowDwonList, regex));
            //c2的中上密度
            eigenValueFive.setCtwoCenterUp(SplitData.integerListToString(ctwoCenterUpList, regex));
            //c2的中下密度
            eigenValueFive.setCtwoCenterDwon(SplitData.integerListToString(ctwoCenterDwonList, regex));
            //c2的深上密度
            eigenValueFive.setCtwoDeepUp(SplitData.integerListToString(ctwoDeepUpList, regex));
            //c2的深下密度
            eigenValueFive.setCtwoDeepDwon(SplitData.integerListToString(ctwoDeepDwonList, regex));
            //上升时间 -- 80
            eigenValueFour.setRiseTime(SplitData.doubleListToString(riseTimeList, regex));
            //下降时间
            eigenValueFour.setFallTime(SplitData.doubleListToString(fallTimeList, regex));
            //血管外围阻力
            double downcenterValue = SplitData.countDoubleListAvg(downcenterValueList);
            double centerValue = SplitData.countDoubleListAvg(centerValueList);
            eigenValueThree.setPeresistance(allWave.getPeripheralResistance(downcenterValue, centerValue));
            //心搏出量
            double fallTime = SplitData.countDoubleListAvg(fallTimeList);
            double riseTime = SplitData.countDoubleListAvg(riseTimeList);
            eigenValueFour.setStrokeVolume(allWave.getHeartBeatingVolume(centerValue, riseTime, fallTime));
            //平均动脉压
            eigenValueFive.setAveragePress(allWave.getAveragePress());
            //单个波形的密度
            eigenValueOne.setSingleWaveLength(SplitData.integerListToString(singleWaveLengthList, regex));

            returnMap.put("eigenValueOne", eigenValueOne);
            returnMap.put("eigenValueTwo", eigenValueTwo);
            returnMap.put("eigenValueThree", eigenValueThree);
            returnMap.put("eigenValueFour", eigenValueFour);
            returnMap.put("eigenValueFive", eigenValueFive);
        }
        return returnMap;
    }
}
