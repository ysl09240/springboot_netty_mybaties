package com.shxseer.watch.service;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  病症service接口
 * @Package com.shxseer.seer.service
 * @ClassName: com.shxseer.seer.service.IDiseaseTipsService
 * @date 2017年10月27日 16:31
 */
public interface IDiseaseTipsService {

    /**
     * 根据diseaseCode返回三种类型的建议各一条
     * @param diseaseCode
     * @return
     */
    String getRandomDiseaseTips(String diseaseCode);

}
