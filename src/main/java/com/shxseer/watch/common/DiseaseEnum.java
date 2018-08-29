package com.shxseer.watch.common;

/**
 * 病症状态枚举类
 * @author zhangliang
 * @since 2018-08-07 11:32
 */
public enum DiseaseEnum {
    //血糖状态(风险等级)
    BLOODSUGAR_DOWN("1","降低"), //血糖降低
    BLOODSUGAR_NOMAL("2", "正常"), //血糖正常
    BLOODSUGAR_UP("3", "升高"); //血糖升高

    private String value;
    private String label;

    DiseaseEnum(String value, String label){
        this.value = value;
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
