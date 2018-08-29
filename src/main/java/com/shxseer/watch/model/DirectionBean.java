package com.shxseer.watch.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 指令类
 *
 * @author yangsonglin
 * @create 2018-07-12 9:21
 **/
@ApiModel
public class DirectionBean {
    @ApiModelProperty(value="数据类型")
    private Integer datatype;
    @ApiModelProperty(value="设备号")
    private String imei;
    @ApiModelProperty(value="0：修改测量间隔时常 1:修改测量时常2：socket服务地址修改 3：立即测量")
    private Integer commandtype;//0：修改测量间隔时常 1:修改测量时常2：socket服务地址修改 3：立即测量
    @ApiModelProperty(value="各个类型对应值:时常单位：分钟 ip和端口连接符：")
    private String commandvalue;//各个类型对应值:时常单位：分钟 ip和端口连接符：


    public Integer getDatatype() {
        return datatype;
    }

    public void setDatatype(Integer datatype) {
        this.datatype = datatype;
    }

    public String getImei() {
        return imei;
    }

    public void setImei(String imei) {
        this.imei = imei;
    }

    public Integer getCommandtype() {
        return commandtype;
    }

    public void setCommandtype(Integer commandtype) {
        this.commandtype = commandtype;
    }

    public String getCommandvalue() {
        return commandvalue;
    }

    public void setCommandvalue(String commandvalue) {
        this.commandvalue = commandvalue;
    }
}
