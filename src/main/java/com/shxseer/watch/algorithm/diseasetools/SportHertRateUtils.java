package com.shxseer.watch.algorithm.diseasetools;

/**
 * 运动预警算法
 * @author zhangliang
 * @since 2018-07-23 17:35
 */
public class SportHertRateUtils {

    public static int getSportHertRate(double RateHert,int age){
        // 1提示用户目前心率适合运动 2提示用户心率过大，请适当调整，不适合继续剧烈运动 3提示用户目前心率很小，心率适合运动
        int count=0;
        double bigValue=0;
        double smallValue=0;
        double moreValue=220-age;
        bigValue=(moreValue-70)*0.5+70;
        smallValue=(moreValue-70)*0.4+70;
        if(RateHert>smallValue && RateHert<bigValue)
        {
            count=1;
        }else if(RateHert>bigValue){
            count=2;
        }else if(RateHert < smallValue){
            count=3;
        }
        return count;
    }
}
