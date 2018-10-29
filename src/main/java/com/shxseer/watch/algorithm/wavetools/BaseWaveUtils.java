package com.shxseer.watch.algorithm.wavetools;

import java.util.ArrayList;
import java.util.List;

/**
 * @authorseerhuitao 算法工具包
 * @create2018/7/16
 */
public class BaseWaveUtils {
    List<Double> listData=null;
    List<Double> listnum=null;
    BaseWaveUtilsEducation bwue;
    public BaseWaveUtils(BaseWaveUtilsEducation bwue){
        if(bwue!=null){
            this.bwue=bwue;
        }
        //做过滤波器的数据
        List<Double> listh=bwue.getvalidWaveformsNum();
        //有效波形转换成原始数据点
        this.listData=listh;
        double[] oldnew= SystemTools.getList(listh);
        double[] olds = BurterworthFilter.getStart(oldnew);
        List<Double> listc= SystemTools.getArray(olds);
        //把里面的负值处理成正值，进行规整
        List<Double> listF= SystemTools.PlusTools(listc);
        this.listnum =listF;
    }
    //计算所有的特征值
    public List<WaveFormModel>  getAllAmplitude(){
        List<WaveFormModel> formValue=new ArrayList<>();
        //计算单个脉搏下标
        double total=0;
        //计算下标
        double count=0;
        for(int j=0;j<bwue.validWaveforms.length;j++)
        {
        //初始化数据
        double athreeLength=0;
        double bthreeLength=0;
        double bsecspeed=0;
        double are=0;//计算单个脉搏波的面积
        double length=0;//计算单个脉搏波的长度
        double[] waveformDataPoints = bwue.validWaveforms[j].getWaveformDataPoints();
        if(j>0){
//            count=+waveformDataPoints.length;
        }
            //脉搏波的特性
            WaveFormModel wfm=new WaveFormModel();
            //获取脉搏波的8个动点的密度
            WaveDenty wd=wfm.getDenty();
            //计算振幅
            List<Double> listc= SystemTools.getArray(waveformDataPoints);
            double num= SystemTools.getMax(listc);
            wfm.setCenterValue(num);
            int centerBase=0;

            int vtl=20;
            int vth=15;
            //判断振幅的下标以及获取
            for(int i=0;i<waveformDataPoints.length;i++){
                //每一个小波看成是一个波形
                wfm.setStartIndex(count);
                wfm.setStartValue(waveformDataPoints[0]);
                wfm.setEndIndex(count+waveformDataPoints.length-1);
                wfm.setEndValue(waveformDataPoints[waveformDataPoints.length-1]);
                //计算A3点和B3点的速度
                if(i>0){
                   double xx=(waveformDataPoints[i]-waveformDataPoints[i-1])*(waveformDataPoints[i]-waveformDataPoints[i-1])+5*5;
                   double yy=(waveformDataPoints[i]-waveformDataPoints[i-1])*(waveformDataPoints[i]-waveformDataPoints[i-1])+5*5;
                   double zz=(waveformDataPoints[i]-waveformDataPoints[i-1])*(waveformDataPoints[i]-waveformDataPoints[i-1])+5*5;
                   double x1=Math.sqrt(xx);
                   double x2=Math.sqrt(yy);
                   double z3=Math.sqrt(zz);
                   athreeLength += Math.abs(x1);
                   bthreeLength += Math.abs(x2);
                   bsecspeed += Math.abs(z3);
                }

                if(num==waveformDataPoints[i])
                {
                   wfm.setCenterIndex(count+i);
                   centerBase=i;
                   //计算上支时间
                   wfm.setUpTime(i*0.002);
                   //A3点的速度（长度除以时间）
                   wfm.setAThreeSpeed(athreeLength/(i*2));

                   wfm.setBSconeSpeed(centerBase+vth);

                   //获取降中峡
                   wfm.setDowncenterIndex(centerBase+vtl);
                   wfm.setDowncenterValue(waveformDataPoints[centerBase+vtl]);
                }

                if(centerBase>0 && i<=centerBase+vtl){
                    wfm.setBThreeSpeed(bthreeLength/(i*2)-1.8);
                }
                //计算下支时间
                wfm.setDownTime((waveformDataPoints.length*0.002)/2);
                wfm.setSingleWaveLength(waveformDataPoints.length);
                if(i>0){
                    length+=Math.abs(waveformDataPoints[i]-waveformDataPoints[i-1]);
                }
                are += waveformDataPoints[i]/1000;

            }
            //脉搏波的面积
            wfm.setAre(are);
            //脉搏波的宽度
            wfm.setWidth(waveformDataPoints.length*0.002);
            //脉搏波的长度
            wfm.setSingleLength(length);
            //脉搏波的速度
            wfm.setSpeed(length/waveformDataPoints.length*0.002);
            //求取具体特征
            getSingleWave(waveformDataPoints,wfm);
            //每秒钟500个点
            wfm.setHertrate(60*500/waveformDataPoints.length);
            formValue.add(wfm);
        }

        return formValue;
    }
    //获取脉搏波的每一个波形的具体分段(先对整体分段，再对每段分发)
    public void getSingleWave(double[] num,WaveFormModel wfm){
        SmallSingleWave ssw=new SmallSingleWave();
        //c段长度
        double l1=0;
        //b段长度
        double l2=0;
        //a段长度
        double l3=0;
        //总长度
        double l=0;
        for(int i=0;i<num.length;i++){
            if(i>0){
                l+=Math.abs(num[i]-num[i-1]);
            }
            if(num[i]==wfm.getDowncenterValue()){
                l1=l;
                l=0;
                ssw.setConeL(l1);
            }
            if(num[i]==wfm.getCenterValue()){
                l2=l;
                l=0;
                ssw.setBoneL(l2);
            }
            if(num[i]==wfm.getEndValue()){
                l3=l;
                l=0;
                ssw.setAoneL(l3);
            }
        }
        //获取8个动区的动点
        BaseWaveLength bwl=getEightLength(ssw,1);
        BaseWaveLength bwl2=getEightLength(ssw,2);
        getEightDenty(num,wfm,bwl);
        getSixSentyValue(num,wfm,bwl,bwl2);
    }

    //8个动点具体再进行分段
    public void getEightDenty(double[] num, WaveFormModel wfm, BaseWaveLength ssw){
           WaveEightDenty wed=new WaveEightDenty();

           //每个分区进行自己添加密度算法
               double l=0;
               int count1=0;
               int count2=0;
               int count3=0;
               int count4=0;
               int count5=0;
               int count6=0;
               int count7=0;
               int count8=0;
               for(int i=0;i<num.length;i++) {
                   if (i > 0) {
                       l += Math.abs(num[i] - num[i - 1]);
                   }

                   if (l <= ssw.getCtwoLength()) {
                       count1++;
                       wfm.setCtwoValue(num[i]);
                       wfm.setCtwoIndex(i);
                       wed.setCtwoSenty(count1);
                   }


                   if (l <= ssw.getConeLength() && l > ssw.getCtwoLength()) {
                       count2++;
                       wfm.setConeValue(num[i]);
                       wfm.setConeIndex(i);
                       wed.setConeSenty(count2);
                   }


                   if (l <= ssw.getBthrLength() && l > ssw.getConeLength()) {
                       count3++;
                       wfm.setBthrValue(num[i]);
                       wfm.setBthrIndex(i);
                       wed.setBthrSenty(count3);
                   }


                   if (l <= ssw.getBtwoLength() && l > ssw.getBthrLength()) {
                       count4++;
                       wfm.setBtwoValue(num[i]);
                       wfm.setBtwoIndex(i);
                       wed.setBtwoSenty(count4);
                   }


                   if (l <= ssw.getBoneLength() && l > ssw.getBtwoLength()) {
                       count5++;
                       wfm.setBoneValue(num[i]);
                       wfm.setBoneIndex(i);
                       wed.setBoneSenty(count5);
                   }


                   if (l <= ssw.getAthrLength() && l > ssw.getBoneLength()) {
                       count6++;
                       wfm.setAthrValue(num[i]);
                       wfm.setAthrIndex(i);
                       wed.setAtheSenty(count6);
                   }


                   if (l <= ssw.getAtwoLength() && l > ssw.getAthrLength()) {
                       count7++;
                       wfm.setAtwoValue(num[i]);
                       wfm.setAtwoIndex(i);
                       wed.setAtwoSenty(count7);
                   }

                   if (l <= ssw.getAoneLength() && l > ssw.getAtwoLength()) {
                       count8++;
                       wfm.setAoneValue(num[i]);
                       wfm.setAoneIndex(i);
                       wed.setAoneSenty(count8);
                   }
               }
           wfm.setEight(wed);
    }

    //对8个动点分没俩个动点之间的长度
    public BaseWaveLength getEightLength(SmallSingleWave ssw, int code){
        BaseWaveLength bwl=null;
        if(code==1){
            bwl=new BaseWaveLength();
            bwl.setAoneLength(ssw.getAoneL()+ssw.getBoneL()+ssw.getConeL());
            bwl.setAtwoLength(ssw.getAoneL()*3/4+ssw.getBoneL()+ssw.getConeL());
            bwl.setAthrLength(ssw.getAoneL()/4+ssw.getBoneL()+ssw.getConeL());
            bwl.setBoneLength(ssw.getBoneL()+ssw.getConeL());
            bwl.setBtwoLength(ssw.getBoneL()*3/4+ssw.getConeL());
            bwl.setBthrLength(ssw.getBoneL()/4+ssw.getConeL());
            bwl.setConeLength(ssw.getConeL());
            bwl.setCtwoLength(ssw.getConeL()/2);
        }else if(code==2){
            bwl=new BaseWaveLength();
            bwl.setAoneLength(ssw.getAoneL());
            bwl.setAtwoLength(ssw.getAoneL()*3/4);
            bwl.setAthrLength(ssw.getAoneL()/4);
            bwl.setBoneLength(ssw.getBoneL());
            bwl.setBtwoLength(ssw.getBoneL()*3/4);
            bwl.setBthrLength(ssw.getBoneL()/4);
            bwl.setConeLength(ssw.getConeL());
            bwl.setCtwoLength(ssw.getConeL()/2);
        }

        return bwl;
    }
    //获取每个动点6个分区的密度
    public void getSixSentyValue(double[] num, WaveFormModel wfm, BaseWaveLength bwl, BaseWaveLength bwl2){
        WaveDenty wd=new WaveDenty();
        //提取6个层的密度
        double l=0;
        int a10=0;
        int a11=0;
        int a12=0;
        int a13=0;
        int a14=0;
        int a15=0;

        int a20=0;
        int a21=0;
        int a22=0;
        int a23=0;
        int a24=0;
        int a25=0;

        int a30=0;
        int a31=0;
        int a32=0;
        int a33=0;
        int a34=0;
        int a35=0;

        int a40=0;
        int a41=0;
        int a42=0;
        int a43=0;
        int a44=0;
        int a45=0;

        int a50=0;
        int a51=0;
        int a52=0;
        int a53=0;
        int a54=0;
        int a55=0;

        int a60=0;
        int a61=0;
        int a62=0;
        int a63=0;
        int a64=0;
        int a65=0;

        int a70=0;
        int a71=0;
        int a72=0;
        int a73=0;
        int a74=0;
        int a75=0;

        int a80=0;
        int a81=0;
        int a82=0;
        int a83=0;
        int a84=0;
        int a85=0;
               for(int i=0;i<num.length;i++) {
                   if (i > 0) {
                       l += Math.abs(num[i] - num[i - 1]);
                   }
                   if (i < wfm.getCtwoIndex()){
                   if (l <= bwl2.getCtwoLength() / 6) {
                       a10++;
                       wd.setCtwoDeepDwon(a10);
                   }

                   if (l <= bwl2.getCtwoLength() * 2 / 6 && l > bwl2.getCtwoLength() / 6) {
                       a11++;
                       wd.setCtwoDeepUp(a11);
                   }

                   if (l <= bwl2.getCtwoLength() * 3 / 6 && l > bwl2.getCtwoLength() *2/ 6) {
                       a12++;
                       wd.setCtwoCenterDwon(a12);
                   }

                   if (l > bwl2.getCtwoLength() * 3 / 6 && l < bwl2.getCtwoLength() * 4 / 6) {
                       a13++;
                   }
                       wd.setCtwoCenterUp(a13);
                   if (l <= bwl2.getCtwoLength() * 5 / 6 && l > bwl2.getCtwoLength() * 4 / 6) {
                       a14++;
                   }
                       wd.setCtwoShallowDwon(a14);
                   if (l <= bwl2.getCtwoLength() && l > bwl2.getCtwoLength() * 5 / 6) {
                       a15++;
                       wd.setCtwoShallowUp(a15);
                   }
                   }
                   if(i >wfm.getCtwoIndex() && i<wfm.getConeIndex()) {
                       if (l <= bwl2.getConeLength() / 6) {
                           a20++;
                           wd.setCtwoDeepDwon(a20);
                       }

                       if (l>bwl2.getConeLength() / 6 && l > bwl2.getConeLength() * 2 / 6) {
                           a21++;
                           wd.setCtwoDeepUp(a21);
                       }

                       if (l <= bwl2.getConeLength() * 3 / 6 && l > bwl2.getConeLength() * 2 / 6) {
                           a22++;
                           wd.setCtwoCenterDwon(a22);
                       }

                       if (l <= bwl2.getConeLength() * 4 / 6&&l > bwl2.getConeLength() * 3 / 6 ) {
                           a23++;
                           wd.setCtwoCenterUp(a23);
                       }

                       if (l <= bwl2.getConeLength() * 5 / 6 && l > bwl2.getConeLength() * 4 / 6) {
                           a24++;
                           wd.setCtwoShallowDwon(a24);
                       }

                       if (l <= bwl2.getConeLength() && l > bwl2.getConeLength() * 5 / 6 ) {
                           a25++;
                           wd.setCtwoShallowUp(a25);
                       }

                   }

                   if(i >wfm.getConeIndex() && i<wfm.getBthrIndex()){
                       if (l <= bwl2.getBthrLength()/ 6+bwl.getConeLength()) {
                           a30++;
                           wd.setBthrDeepDwon(a30);
                       }

                       if (l>bwl2.getBthrLength()/ 6 +bwl.getConeLength()&& l > bwl2.getBthrLength()* 2 / 6+bwl.getConeLength()) {
                           a31++;
                           wd.setBthrDeepUp(a31);
                       }

                       if (l <= bwl2.getBthrLength() * 3 / 6+bwl.getConeLength() && l > bwl2.getBthrLength() * 2 / 6+bwl.getConeLength()) {
                           a32++;
                           wd.setBthrCenterDwon(a32);
                       }

                       if (l <= bwl2.getBthrLength() * 4 / 6+bwl.getConeLength()&&l > bwl2.getBthrLength() * 3 / 6 +bwl.getConeLength()) {
                           a33++;
                           wd.setBthrCenterUp(a33);
                       }

                       if (l <= bwl2.getBthrLength() * 5 / 6+bwl.getConeLength() && l > bwl2.getBthrLength() * 4 / 6+bwl.getConeLength()) {
                           a34++;
                           wd.setBthrShallowDwon(a34);
                       }

                       if (l <= bwl2.getBthrLength()+bwl.getConeLength() && l > bwl2.getBthrLength()* 5 / 6+bwl.getConeLength() ) {
                           a35++;
                           wd.setBthrShallowUp(a35);
                       }

                   }

                   if(i >wfm.getBthrIndex() && i<wfm.getBtwoIndex()){
                       if (l <= bwl2.getBtwoLength()/ 6 +bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a40++;
                           wd.setBtwoDeepDwon(a40);
                       }

                       if (l>bwl2.getBtwoLength()/ 6 +bwl2.getBthrLength()+bwl2.getConeLength()&& l > bwl2.getBtwoLength()* 2 / 6+bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a41++;
                           wd.setBtwoDeepUp(a41);
                       }

                       if (l <= bwl2.getBtwoLength() * 3 / 6 +bwl2.getBthrLength()+bwl2.getConeLength()&& l > bwl2.getBtwoLength() * 2 / 6+bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a42++;
                           wd.setBtwoCenterDwon(a42);
                       }

                       if (l <= bwl.getBtwoLength() * 4 / 6+bwl2.getBthrLength()+bwl2.getConeLength()&&l > bwl2.getBtwoLength() * 3 / 6 +bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a43++;
                           wd.setBtwoCenterUp(a43);
                       }

                       if (l <= bwl.getBtwoLength() * 5 / 6+bwl2.getBthrLength()+bwl2.getConeLength() && l > bwl2.getBtwoLength() * 4 / 6+bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a44++;
                           wd.setBtwoShallowDwon(a44);
                       }

                       if (l <= bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() && l > bwl2.getBtwoLength()* 5 / 6 +bwl2.getBthrLength()+bwl2.getConeLength()) {
                           a45++;
                           wd.setBtwoShallowUp(a45);
                       }

                   }

                   if(i >wfm.getBtwoIndex() && i<wfm.getBoneIndex()){
                       if (l <= bwl2.getBoneLength()/ 6 +bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a50++;
                           wd.setBoneDeepDwon(a50);
                       }

                       if (l>bwl2.getBoneLength()/ 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength()  && l > bwl2.getBoneLength()* 2 / 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a51++;
                           wd.setBoneDeepUp(a51);
                       }

                       if (l <= bwl2.getBoneLength() * 3 / 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength()  && l > bwl2.getBoneLength() * 2 / 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a52++;
                           wd.setBoneCenterDwon(a52);
                       }

                       if (l <= bwl2.getBoneLength() * 4 / 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() &&l > bwl2.getBoneLength() * 3 / 6 +bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a53++;
                           wd.setBoneCenterUp(a53);
                       }

                       if (l <= bwl2.getBoneLength() * 5 / 6 +bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() && l > bwl2.getBoneLength() * 4 / 6+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a54++;
                           wd.setBtwoShallowDwon(a54);
                       }

                       if (l <= bwl2.getBoneLength()+bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength()  && l > bwl2.getBoneLength()* 5 / 6 +bwl2.getBtwoLength()+bwl2.getBthrLength()+bwl2.getConeLength() ) {
                           a55++;
                           wd.setBoneShallowUp(a55);
                       }

                   }

                   if(i >wfm.getBoneIndex() && i<wfm.getAthrIndex()){
                       if (l <= bwl2.getAthrLength()/ 6+bwl.getConeLength()+bwl.getBoneLength()) {
                           a60++;
                           wd.setAthrDeepDwon(a60);
                       }

                       if (l>bwl2.getAthrLength()/ 6 +bwl.getConeLength()+bwl.getBoneLength()&& l > bwl2.getAthrLength()* 2 / 6+bwl.getConeLength()+bwl.getBoneLength()) {
                           a61++;
                           wd.setAthrDeepUp(a61);
                       }

                       if (l <= bwl2.getAthrLength() * 3 / 6+bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAthrLength() * 2 / 6+bwl.getConeLength()+bwl.getBoneLength()) {
                           a62++;
                           wd.setAthrCenterDwon(a62);
                       }

                       if (l <= bwl2.getAthrLength() * 4 / 6+bwl.getConeLength()+bwl.getBoneLength()&&l > bwl2.getAthrLength() * 3 / 6 +bwl.getConeLength()+bwl.getBoneLength()) {
                           a63++;
                           wd.setAthrCenterUp(a63);
                       }

                       if (l <= bwl2.getAthrLength() * 5 / 6+bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAthrLength() * 4 / 6+bwl.getConeLength()+bwl.getBoneLength()) {
                           a64++;
                           wd.setAthrShallowDwon(a64);
                       }

                       if (l <= bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&& l > bwl2.getAthrLength()* 5 / 6+bwl.getConeLength()+bwl.getBoneLength() ) {
                           a65++;
                           wd.setAthrShallowUp(a65);
                       }


                   }

                   if(i >wfm.getAthrIndex() && i<wfm.getAtwoIndex()){
                       if (l <= bwl2.getAtwoLength()/ 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a70++;
                           wd.setAtwoDeepDwon(a70);
                       }

                       if (l>bwl2.getAtwoLength()/ 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAtwoLength()* 2 / 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a71++;
                           wd.setAtwoDeepUp(a71);
                       }

                       if (l <= bwl2.getAtwoLength() * 3 / 6 +bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&& l > bwl2.getAtwoLength() * 2 / 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a72++;
                           wd.setAtwoCenterDwon(a72);
                       }

                       if (l <= bwl2.getAtwoLength() * 4 / 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&&l > bwl2.getAtwoLength() * 3 / 6 +bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a73++;
                           wd.setAtwoCenterUp(a73);
                       }

                       if (l <= bwl2.getAtwoLength() * 5 / 6 +bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&& l > bwl2.getAtwoLength() * 4 / 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a74++;
                           wd.setAtwoShallowDwon(a74);
                       }

                       if (l <= bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAtwoLength()* 5 / 6+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() ) {
                           a75++;
                           wd.setAtwoShallowUp(a75);
                       }


                   }

                   if(i >wfm.getAtwoIndex() && i<wfm.getAoneIndex()){
                       if (l <= bwl2.getAoneLength()/ 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a80++;
                           wd.setAoneDeepDwon(a80);
                       }

                       if (l>bwl2.getAoneLength()/ 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAoneLength()* 2 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a81++;
                           wd.setAoneDeepUp(a81);
                       }

                       if (l <= bwl2.getAoneLength() * 3 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAoneLength() * 2 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a82++;
                           wd.setAoneCenterDwon(a82);
                       }

                       if (l <= bwl2.getAoneLength() * 4 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&&l > bwl2.getAoneLength() * 3 / 6 +bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a83++;
                           wd.setAoneCenterUp(a83);
                       }

                       if (l <= bwl2.getAoneLength() * 5 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() && l > bwl2.getAoneLength() * 4 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()) {
                           a84++;
                           wd.setAoneShallowDwon(a84);
                       }

                       if (l <= bwl2.getAoneLength() +bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength()&& l > bwl2.getAoneLength()* 5 / 6+bwl2.getAtwoLength()+bwl2.getAthrLength() +bwl.getConeLength()+bwl.getBoneLength() ) {
                           a85++;
                           wd.setAoneShallowUp(a85);
                       }
                   }
           }
           wfm.setDenty(wd);
    }



}
