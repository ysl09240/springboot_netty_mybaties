package com.shxseer.watch.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 常用工具类
 *
 * @author yangsonglin
 * @create 2018-10-29 9:28
 **/
public class CommonUtils {

    /**
     * 获取两个List的不同元素
     * @param list1
     * @param list2
     * @return
     */
    private static List<String> getDiffrent(List<String> list1, List<String> list2) {
        long st = System.nanoTime();
        List<String> diff = new ArrayList<String>();
        List<String> maxList = list1;
        List<String> minList = list2;
        if(list2.size()>list1.size())
        {
            maxList = list2;
            minList = list1;
        }
        Map<String,Integer> map = new HashMap<String,Integer>(maxList.size());
        for (String string : maxList) {
            map.put(string, 1);
        }
        for (String string : minList) {
            if(map.get(string)!=null)
            {
                map.put(string, 2);
                continue;
            }
            diff.add(string);
        }
        for(Map.Entry<String, Integer> entry:map.entrySet())
        {
            if(entry.getValue()==1)
            {
                diff.add(entry.getKey());
            }
        }
        System.out.println("getDiffrent total times "+(System.nanoTime()-st));
        return diff;

    }

}
