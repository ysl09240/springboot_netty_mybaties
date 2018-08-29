package com.shxseer.watch.algorithm.wavetools;


/**
 * @authorseerhuitao 波形实体类
 * @create2018/7/16
 */
public class WaveFormModel {
    double startValue;//开始值
    double startIndex;//开始点的下标
    double endValue;//结束点值
    double endIndex;//结束点的下标
    double centerValue;//振幅值
    double centerIndex;//振幅下标
    double downcenterValue;//降中峡值
    double downcenterIndex;//降中峡的下标
    double are;//单个脉搏波的面积
    double width;//单个脉搏波的宽度
    double singleLength;//单个脉搏波的长度
    double speed;//单个脉搏波的速度
    double AoneValue;//A1点的值
    double AoneIndex;//A1点的下标
    double AtwoValue;//A2点的值
    double AtwoIndex;//A2点的下标
    double AthrValue;//A3点的值
    double AthrIndex;//A3点的下标
    double BoneValue;//B1的值
    double BoneIndex;//B1的下标
    double BtwoValue;//B2的值
    double BtwoIndex;//B2的下标
    double BthrValue;//B3点的值
    double BthrIndex;//B3的下标
    double ConeValue;//C1的值
    double ConeIndex;//C1的下标
    double CtwoValue;//C2点的值
    double CtwoIndex;//C2点的下标
    int hertrate;//心率多值

    double UpTime;//上支时间
    double DownTime;//下肢时间
    WaveDenty denty=new WaveDenty();//每个动点6个区的密度
    WaveEightDenty eight=new WaveEightDenty();//8个动点的密度

    int singleWaveLength;//单个波形的密度

    public double getUpTime() {
        return UpTime;
    }

    public void setUpTime(double upTime) {
        UpTime = upTime;
    }

    public double getDownTime() {
        return DownTime;
    }

    public void setDownTime(double downTime) {
        DownTime = downTime;
    }

    public double getBtwoIndex() {
        return BtwoIndex;
    }

    public void setBtwoIndex(double btwoIndex) {
        BtwoIndex = btwoIndex;
    }

    public double getStartValue() {
        return startValue;
    }

    public void setStartValue(double startValue) {
        this.startValue = startValue;
    }

    public double getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(double startIndex) {
        this.startIndex = startIndex;
    }

    public double getEndValue() {
        return endValue;
    }

    public void setEndValue(double endValue) {
        this.endValue = endValue;
    }

    public double getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(double endIndex) {
        this.endIndex = endIndex;
    }

    public double getCenterValue() {
        return centerValue;
    }

    public void setCenterValue(double centerValue) {
        this.centerValue = centerValue;
    }

    public double getCenterIndex() {
        return centerIndex;
    }

    public void setCenterIndex(double centerIndex) {
        this.centerIndex = centerIndex;
    }

    public double getDowncenterValue() {
        return downcenterValue;
    }

    public void setDowncenterValue(double downcenterValue) {
        this.downcenterValue = downcenterValue;
    }

    public double getDowncenterIndex() {
        return downcenterIndex;
    }

    public void setDowncenterIndex(double downcenterIndex) {
        this.downcenterIndex = downcenterIndex;
    }

    public double getAre() {
        return are;
    }

    public void setAre(double are) {
        this.are = are;
    }

    public double getWidth() {
        return width;
    }

    public void setWidth(double width) {
        this.width = width;
    }

    public double getAoneValue() {
        return AoneValue;
    }

    public void setAoneValue(double aoneValue) {
        AoneValue = aoneValue;
    }

    public double getAoneIndex() {
        return AoneIndex;
    }

    public void setAoneIndex(double aoneIndex) {
        AoneIndex = aoneIndex;
    }

    public double getAtwoValue() {
        return AtwoValue;
    }

    public void setAtwoValue(double atwoValue) {
        AtwoValue = atwoValue;
    }

    public double getAtwoIndex() {
        return AtwoIndex;
    }

    public void setAtwoIndex(double atwoIndex) {
        AtwoIndex = atwoIndex;
    }

    public double getAthrValue() {
        return AthrValue;
    }

    public void setAthrValue(double athrValue) {
        AthrValue = athrValue;
    }

    public double getAthrIndex() {
        return AthrIndex;
    }

    public void setAthrIndex(double athrIndex) {
        AthrIndex = athrIndex;
    }

    public double getBoneValue() {
        return BoneValue;
    }

    public void setBoneValue(double boneValue) {
        BoneValue = boneValue;
    }

    public double getBoneIndex() {
        return BoneIndex;
    }

    public void setBoneIndex(double boneIndex) {
        BoneIndex = boneIndex;
    }

    public double getBtwoValue() {
        return BtwoValue;
    }

    public void setBtwoValue(double btwoValue) {
        BtwoValue = btwoValue;
    }

    public double getBthrValue() {
        return BthrValue;
    }

    public void setBthrValue(double bthrValue) {
        BthrValue = bthrValue;
    }

    public double getBthrIndex() {
        return BthrIndex;
    }

    public void setBthrIndex(double bthrIndex) {
        BthrIndex = bthrIndex;
    }

    public double getConeValue() {
        return ConeValue;
    }

    public void setConeValue(double coneValue) {
        ConeValue = coneValue;
    }

    public double getConeIndex() {
        return ConeIndex;
    }

    public void setConeIndex(double coneIndex) {
        ConeIndex = coneIndex;
    }

    public double getCtwoValue() {
        return CtwoValue;
    }

    public void setCtwoValue(double ctwoValue) {
        CtwoValue = ctwoValue;
    }

    public double getCtwoIndex() {
        return CtwoIndex;
    }

    public void setCtwoIndex(double ctwoIndex) {
        CtwoIndex = ctwoIndex;
    }

    public WaveDenty getDenty() {
        return denty;
    }

    public void setDenty(WaveDenty denty) {
        this.denty = denty;
    }

    public double getSingleLength() {
        return singleLength;
    }

    public void setSingleLength(double singleLength) {
        this.singleLength = singleLength;
    }

    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public WaveEightDenty getEight() {
        return eight;
    }

    public void setEight(WaveEightDenty eight) {
        this.eight = eight;
    }

    public int getHertrate() {
        return hertrate;
    }

    public void setHertrate(int hertrate) {
        this.hertrate = hertrate;
    }

    public int getSingleWaveLength() {
        return singleWaveLength;
    }

    public void setSingleWaveLength(int singleWaveLength) {
        this.singleWaveLength = singleWaveLength;
    }

    @Override
    public String toString() {
        return "WaveFormModel{" +
                "startValue=" + startValue +
                ", startIndex=" + startIndex +
                ", endValue=" + endValue +
                ", endIndex=" + endIndex +
                ", centerValue=" + centerValue +
                ", centerIndex=" + centerIndex +
                ", downcenterValue=" + downcenterValue +
                ", downcenterIndex=" + downcenterIndex +
                ", are=" + are +
                ", width=" + width +
                ", singleLength=" + singleLength +
                ", speed=" + speed +
                ", AoneValue=" + AoneValue +
                ", AoneIndex=" + AoneIndex +
                ", AtwoValue=" + AtwoValue +
                ", AtwoIndex=" + AtwoIndex +
                ", AthrValue=" + AthrValue +
                ", AthrIndex=" + AthrIndex +
                ", BoneValue=" + BoneValue +
                ", BoneIndex=" + BoneIndex +
                ", BtwoValue=" + BtwoValue +
                ", BtwoIndex=" + BtwoIndex +
                ", BthrValue=" + BthrValue +
                ", BthrIndex=" + BthrIndex +
                ", ConeValue=" + ConeValue +
                ", ConeIndex=" + ConeIndex +
                ", CtwoValue=" + CtwoValue +
                ", CtwoIndex=" + CtwoIndex +
                ", denty=" + denty +
                ", eight=" + eight +
                ", hertrate=" + hertrate +
                ", singleWaveLength=" + singleWaveLength +
                '}';
    }
}
