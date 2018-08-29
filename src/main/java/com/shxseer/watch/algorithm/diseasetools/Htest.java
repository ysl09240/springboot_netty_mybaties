package com.shxseer.watch.algorithm.diseasetools;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @authorseerhuitao 血糖个性化区间
 * @create2018/7/31
 */
public class Htest {

    /**
     * 计算血糖个性化区间
     * 调用这个方法必须要数据量大于k值，k值最好是选择大于9以上的数字
     * 数组下标为0的是下限，为1的是上限
     */
    public  double[] getFade(List<Double> list, int k) {
        //存放结果集的数据
        double[] base=new double[2];
        //存放分段的数据
        List<Double> getLits=new ArrayList<Double>();
        //排序集合
        Collections.sort(list);
        //最小值
        double min=list.get(0);
        //获取最大值和最小值之间的差值
        double cj=list.get(list.size()-1);
        //给差值分段
        double xt=cj/(double)k;
        //循环保存分段数值
        for(int i=0;i<k;i++)
        {
            getLits.add(xt*(i+1));
        }
        List<Count> backList=getSpileData(list,getLits);//返回分段数据的区间值多少
        //找出分布区间
        double[] result=getDoubleValue( backList);
        return result;
    }
    public  double[] getDoubleValue( List<Count> backList){
        //存放结果集的数据
        double[] base=new double[2];
        //存放数据做多的数目
        List<Integer> num=new ArrayList<Integer>();
        List<Count> numx=new ArrayList<Count>();
        for(int i=0;i<backList.size();i++){
            int bus=backList.get(i).getTotal();
            num.add(bus);
            numx.add(backList.get(i));
        }
        //排序
        Collections.sort(num);
        int bunm=num.get(num.size()-1);
        for(int i=0;i<numx.size();i++)
        {
            if(numx.get(i).getTotal()==bunm)
            {
                base[0]=numx.get(i).getDown();
                base[1]=numx.get(i).getUp();
            }
        }
        return base;
    }
    //计数分点
    public List<Count> getSpileData(List<Double> listone, List<Double> listtwo)
    {
        //存放区间值
        List<Count> getLits=new ArrayList<Count>();
        int numone=0;
        int numtwo=0;
        int numthre=0;
        int numfour=0;
        int numfive=0;
        int numsix=0;
        int numsenve=0;
        int numeight=0;
        int numnine=0;
        Count cone=new Count();
        Count ctwo=new Count();
        Count cthre=new Count();
        Count cfour=new Count();
        Count cfive=new Count();
        Count csix=new Count();
        Count csenve=new Count();
        Count ceight=new Count();
        Count cnine=new Count();
        for (int j=0;j<listone.size();j++)
        {
            double y=listone.get(j);
            if(y<listtwo.get(0)){
                if(numone==0){
                    cone.setDown(0);
                    cone.setUp(listtwo.get(0));
                }
                ++numone;
            }else if(y>=listtwo.get(0)&&y<listtwo.get(1)){
                if(numtwo==0){
                    ctwo.setUp(listtwo.get(1));
                    ctwo.setDown(listtwo.get(0));
                }
                ++numtwo;
            }else if(y>=listtwo.get(1)&&y<listtwo.get(2)){
                if(numthre==0){
                    cthre.setUp(listtwo.get(2));
                    cthre.setDown(listtwo.get(1));
                }
                ++numthre;
            }else if(y>=listtwo.get(2)&&y<listtwo.get(3)){
                if(numfour==0){
                    cfour.setUp(listtwo.get(3));
                    cfour.setDown(listtwo.get(2));
                }
                numfour++;
            }else if(y>=listtwo.get(3)&&y<listtwo.get(4)){
                if(numfive==0){
                    cfive.setUp(listtwo.get(4));
                    cfive.setDown(listtwo.get(3));
                }
                ++numfive;
            }else if(y>=listtwo.get(4)&&y<listtwo.get(5)){
                if(numsix==0){
                    csix.setUp(listtwo.get(5));
                    csix.setDown(listtwo.get(4));
                }
                ++numsix;
            }else if(y>=listtwo.get(5)&&y<listtwo.get(6)){
                if(numsenve==0){
                    csenve.setUp(listtwo.get(6));
                    csenve.setDown(listtwo.get(5));
                }
                ++numsenve;
            }else if(y>=listtwo.get(6)&&y<listtwo.get(7)){
                if(numeight==0){
                    ceight.setUp(listtwo.get(7));
                    ceight.setDown(listtwo.get(6));
                }
                ++numeight;
            }else if(y>=listtwo.get(7)&&y<listtwo.get(8)){
                if(numnine==0){
                    cnine.setUp(listtwo.get(8));
                    cnine.setDown(listtwo.get(7));
                }
                ++numnine;
            }
        }
        cone.setTotal(numone);
        ctwo.setTotal(numtwo);
        cthre.setTotal(numthre);
        cfour.setTotal(numfour);
        cfive.setTotal(numfive);
        csix.setTotal(numsix);
        csenve.setTotal(numsenve);
        ceight.setTotal(numeight);
        cnine.setTotal(numnine);
        getLits.add(cone);
        getLits.add(ctwo);
        getLits.add(cthre);
        getLits.add(cfour);
        getLits.add(cfive);
        getLits.add(csix);
        getLits.add(csenve);
        getLits.add(ceight);
        getLits.add(cnine);
        return getLits;
    }
    class Count{
        int total;
        double down;
        double up;

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public double getDown() {
            return down;
        }

        public void setDown(double down) {
            this.down = down;
        }

        public double getUp() {
            return up;
        }

        public void setUp(double up) {
            this.up = up;
        }

    }

}
