package com.shxseer.watch.common;

import java.util.List;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  字符串工具类
 * @Package com.shxseer.seer.common
 * @ClassName: com.shxseer.seer.common.StringUtils
 * @date 2017年09月27日 18:12
 */
public class StringUtils extends org.apache.commons.lang3.StringUtils{

    /**
     * 获取默认的URL地址
     * @return
     */
    public static String getBaseURL(){
        String ip= PropertiesLoader.getProperty("ip");
        String port= PropertiesLoader.getProperty("port");
        String appName= PropertiesLoader.getProperty("proName");
        String url="http://"+ip+":"+port+"/"+appName;
        return url;
    }

    /**
     * 使用"-"将数据拼接起来并返回。
     * @param list
     */
    public static String userCharJoinString(List<String> list){
        if(list != null && list.size() > 0){
            StringBuffer sb=new StringBuffer();
            String temp=null;
            for(int i=0,len=list.size();i<len;i++){
                temp= list.get(i);
                sb.append(temp).append("-");
            }
            return sb.toString();
        }
        return null;
    }

}
