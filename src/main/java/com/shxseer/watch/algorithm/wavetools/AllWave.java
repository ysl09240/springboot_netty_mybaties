package com.shxseer.watch.algorithm.wavetools;


import cn.edu.xidian.wave.ppgpreprocessor.Waveform;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorseerhuitao 描述所有波形的特征
 * @create2018/7/16
 */
public class AllWave {
    //整体心率
    int hertRate;
    //整体的脉形
    List<WaveFormModel> list=new ArrayList<WaveFormModel>();
    BaseWaveUtilsEducation bwue;
    //面积
    double are;
    //速度
    double speed;
    public AllWave(BaseWaveUtilsEducation bwue){
        this.bwue=bwue;
        compute();
    }
    //计算心率和整体脉形的特征量
    public void compute(){
        BaseWaveUtils bwu=new BaseWaveUtils(bwue);
        List<WaveFormModel> datalist=bwu.getAllAmplitude();
        this.list=datalist;
        Waveform[] waveformss=bwue.getwaveforms();
        Waveform[] valideWave=bwue.getvalidWaveforms();
        int hert=0;
        if(datalist.size()!=0)
        {
            for(int i=0;i<datalist.size();i++)
            {
                hert+=datalist.get(i).getHertrate();
            }
            this.hertRate=hert/datalist.size();
        }

        getAre(valideWave);
    }
    //计算脉搏波的面积和速度
    public void getAre(Waveform[] valideWave)
    {
           double are=0;
           for(int i=0;i<valideWave.length;i++)
           {
               double[] waveformDataPoints = valideWave[i].getWaveformDataPoints();
               for(int j=0;j<waveformDataPoints.length;j++)
               {
                   if(j>0){
                       are+= Math.abs(waveformDataPoints[j]-waveformDataPoints[j-1]);
                   }
               }
           }
           this.are=are;
           this.speed=are/3;
    }

    public int getHertRate() {
        return hertRate;
    }

    public void setHertRate(int hertRate) {
        this.hertRate = hertRate;
    }

    public List<WaveFormModel> getList() {
        return list;
    }

    public void setList(List<WaveFormModel> list) {
        this.list = list;
    }

    public void setAre(double are) {
        this.are = are;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

	public double getAre() {
        return are;
    }

    public double getSpeed() {
        return speed;
    }
    //获取平均动脉压
    public double getAveragePress(){
        double Pm=this.are/this.list.size();
        double PPm=Pm/2;
        return PPm;
    }

    //获取脉搏波的外周阻力
    /**
     *
     * @param jzx //降中峡的均值
     * @param zf  //振幅的均值
     * @return
     */
    public double getPeripheralResistance(double jzx,double zf){
        double _value=0;
        _value=jzx/zf;
        return _value;
    }
    //计算心搏出量
    /**
     *
     * @param zf //振幅均值
     * @param upTime//上支时间均值
     * @param downTime//下支时间均值
     * @return
     */
    public double getHeartBeatingVolume(double zf,double upTime,double downTime){
           double volume=zf*(1+upTime/downTime);
           return volume;
    }
}
