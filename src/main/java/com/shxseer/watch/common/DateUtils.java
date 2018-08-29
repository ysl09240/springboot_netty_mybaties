package com.shxseer.watch.common;

import org.apache.commons.lang3.time.DateFormatUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 时间工具类。
 * @author zhangliang
 * @since 2018-07-17 11:20
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils {

    private static  Logger log=LoggerFactory.getLogger(DateUtils.class);

    private static String[] parsePatterns = {
            "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm", "yyyy-MM",
            "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm", "yyyy/MM",
            "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm", "yyyy.MM"};

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd）
     */
    public static String getDate() {
        return getDate("yyyy-MM-dd");
    }

    /**
     * 得到当前日期字符串 格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String getDate(String pattern) {
        return DateFormatUtils.format(new Date(), pattern);
    }

    /**
     * 得到日期字符串 默认格式（yyyy-MM-dd） pattern可以为："yyyy-MM-dd" "HH:mm:ss" "E"
     */
    public static String formatDate(Date date, Object... pattern) {
        String formatDate = null;
        if (pattern != null && pattern.length > 0) {
            formatDate = DateFormatUtils.format(date, pattern[0].toString());
        } else {
            formatDate = DateFormatUtils.format(date, "yyyy-MM-dd");
        }
        return formatDate;
    }

    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd HH:mm:ss）
     */
    public static String formatDateTime(Date date) {
        return formatDate(date, "yyyy-MM-dd HH:mm:ss");
    }
    /**
     * 得到日期时间字符串，转换格式（yyyy-MM-dd）
     */
    public static String formatDate(Date date) {
        return formatDate(date, "yyyy-MM-dd");
    }

    public static String formatDateTime4China(Date date) {
        return formatDate(date, "yyyy年MM月dd日HH:mm:ss");
    }

    /**
     * 日期型字符串转化为日期 格式
     * { "yyyy-MM-dd", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd HH:mm",
     *   "yyyy/MM/dd", "yyyy/MM/dd HH:mm:ss", "yyyy/MM/dd HH:mm",
     *   "yyyy.MM.dd", "yyyy.MM.dd HH:mm:ss", "yyyy.MM.dd HH:mm" }
     */
    public static Date parseDate(Object str) {
        if (str == null){
            return null;
        }
        try {
            return parseDate(str.toString(), parsePatterns);
        } catch (ParseException e) {
            return null;
        }
    }

    /**
     * 获取指定时间的后day 天,返回时间 年月日时分秒。
     * @author zhangliang
     * @param curDate 指定日期
     * @param day 往后几天
     * @return
     */
    public static String getAfterDate(Date curDate,int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String createDate = sdf.format(curDate);
        long temp=parseDate(createDate).getTime();
        temp=temp+day*24*60*60*1000;
        Date dd=new Date(temp);
        return formatDateTime(dd);
    }

    /**
     * 获取指定时间的后 hour 小时的时间
     * @param nowDate 现在的时间
     * @param hour  前/后 hour小时的时间，如果是指定时间之后的时间值为﹢，否则为-
     * @return
     */
    public static String getAfterDateTime(String nowDate,float hour){
        long temp=parseDate(nowDate).getTime();
        Float dd=hour*60*60*1000;
        String tem=dd.toString();
        tem=tem.substring(0,tem.indexOf("."));
        temp=temp+Long.parseLong(tem);
        Date dd1=new Date(temp);
        return formatDateTime(dd1);
    }

    /**
     * 返回综合报告上需要的测试时间范围。
     * @param nowDate
     * @param hour
     * @return
     */
    public static String getDateMassge(String nowDate,float hour){
        StringBuffer sf=new StringBuffer();
        String currentDate = DateUtils.formatDateTime4China(DateUtils.parseDate(nowDate));
        currentDate=currentDate.substring(0,currentDate.lastIndexOf(":"));
        String dateAfter=getAfterDateTime(nowDate,hour);
        dateAfter=dateAfter.substring(dateAfter.indexOf(" ")+1,dateAfter.lastIndexOf(":"));
        sf.append("基于").append(currentDate).append("至").append(dateAfter).append("的数据");
        return sf.toString();
    }

    /**
     * 根据传入的出生日期得到用户的年龄。
     * @param date
     * @return
     */
    public static int getAgeByDate(String date){
        Date birthDay=null;
        if(date.contains(" ")){
            date=date.substring(0,date.indexOf(" "));
        }
        birthDay=parseDate(date);
        Calendar cal = Calendar.getInstance();
        if (cal.before(birthDay)) {
            throw new IllegalArgumentException(
                    "The birthDay is before Now.It's unbelievable!");
        }
        int yearNow = cal.get(Calendar.YEAR);
        int monthNow = cal.get(Calendar.MONTH);
        int dayOfMonthNow = cal.get(Calendar.DAY_OF_MONTH);
        cal.setTime(birthDay);
        int yearBirth = cal.get(Calendar.YEAR);
        int monthBirth = cal.get(Calendar.MONTH);
        int dayOfMonthBirth = cal.get(Calendar.DAY_OF_MONTH);
        int age = yearNow - yearBirth;
        if (monthNow <= monthBirth) {
            if (monthNow == monthBirth) {
                if (dayOfMonthNow < dayOfMonthBirth){ age--;}
            }else{
                age--;
            }
        }
        return age;
    }

    /**
     * 判断两个日期的先后
     * @author zhangliang
     * @param nowDate 当前日期
     * @param settingDate 用户已经设定好的日期
     * @return result（true代表nowTime在settingTime之后; false代表nowTime在settingTime之前或相等）
     */
    public static boolean checkDateSuccessively(String nowDate, String settingDate){
        boolean resultBoolean = false;
        try {
            //将字符串格式的日期格式化
            SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
            //将日期转成Date对象作比较
            Date fomatDate1=sdf.parse(nowDate);
            Date fomatDate2=sdf.parse(settingDate);
            //比较两个日期
            int result=fomatDate2.compareTo(fomatDate1);
            /*
            result = 0代表两个时间相等
            result < 0代表nowDate就是在settingDate之后
            result > 0代表参数nowDate就是在settingDate之前
             */
            if(result < 0){
                resultBoolean = true;
            }
        }catch (Exception e){
            e.getStackTrace();
        }
        return resultBoolean;
    }

    /**
     * 时间戳转换成日期格式字符串
     * @param seconds 精确到秒的字符串
     * @param format 要转换成的格式
     * @return
     */
    public static String timeStamp2Date(String seconds,String format) {
         if(seconds == null || seconds.isEmpty() || seconds.equals("null")){
             return "";
         }
        if(format == null || format.isEmpty()){
            format = "yyyy-MM-dd HH:mm:ss";
        }
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        return sdf.format(new Date(Long.valueOf(seconds+"000")));
    }

}
