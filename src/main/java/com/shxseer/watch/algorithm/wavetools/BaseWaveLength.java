package com.shxseer.watch.algorithm.wavetools;

/**
 * @authorseerhuitao 脉搏波算法特征量
 * @create2018/7/16
 */
public class BaseWaveLength {
double AoneLength;
double AtwoLength;
double AthrLength;
double BoneLength;
double BtwoLength;
double BthrLength;
double ConeLength;
double CtwoLength;

    public double getAoneLength() {
        return AoneLength;
    }

    public void setAoneLength(double aoneLength) {
        AoneLength = aoneLength;
    }

    public double getAtwoLength() {
        return AtwoLength;
    }

    public void setAtwoLength(double atwoLength) {
        AtwoLength = atwoLength;
    }

    public double getAthrLength() {
        return AthrLength;
    }

    public void setAthrLength(double athrLength) {
        AthrLength = athrLength;
    }

    public double getBoneLength() {
        return BoneLength;
    }

    public void setBoneLength(double boneLength) {
        BoneLength = boneLength;
    }

    public double getBtwoLength() {
        return BtwoLength;
    }

    public void setBtwoLength(double btwoLength) {
        BtwoLength = btwoLength;
    }

    public double getBthrLength() {
        return BthrLength;
    }

    public void setBthrLength(double bthrLength) {
        BthrLength = bthrLength;
    }

    public double getConeLength() {
        return ConeLength;
    }

    public void setConeLength(double coneLength) {
        ConeLength = coneLength;
    }

    public double getCtwoLength() {
        return CtwoLength;
    }

    public void setCtwoLength(double ctwoLength) {
        CtwoLength = ctwoLength;
    }

    @Override
    public String toString() {
        return "BaseWaveLength{" +
                "AoneLength=" + AoneLength +
                ", AtwoLength=" + AtwoLength +
                ", AthrLength=" + AthrLength +
                ", BoneLength=" + BoneLength +
                ", BtwoLength=" + BtwoLength +
                ", BthrLength=" + BthrLength +
                ", ConeLength=" + ConeLength +
                ", CtwoLength=" + CtwoLength +
                '}';
    }
}
