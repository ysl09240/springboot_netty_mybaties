package com.shxseer.watch.model;

/**
 * 指令类
 *
 * @author yangsonglin
 * @create 2018-07-12 9:21
 **/
public class DirectionBean {

    private Integer datatype;
    private Integer cammandtype;//0：修改测量间隔时常 1:修改测量时常2：socket服务地址修改 3：立即测量
    private String cammandvalue;//各个类型对应值:时常单位：分钟 ip和端口连接符：


    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public Integer getCammandtype() {
        return cammandtype;
    }

    public void setCammandtype(Integer cammandtype) {
        this.cammandtype = cammandtype;
    }

    public String getCammandvalue() {
        return cammandvalue;
    }

    public void setCammandvalue(String cammandvalue) {
        this.cammandvalue = cammandvalue;
    }
}
