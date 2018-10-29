package com.shxseer.watch.common;

/**
 * 病症状态枚举类
 * @author zhangliang
 * @since 2018-08-07 11:32
 */
public enum DiseaseEnum {
    //血糖状态(风险等级)
    BLOODSUGAR_DOWN("1","降低"),
    BLOODSUGAR_NOMAL("2", "正常"),
    BLOODSUGAR_UP("3", "升高"),

    //疲劳状态(风险等级)
    TERIOD_ONE("1","精神较好"),
    TERIOD_TWO("2", "比较疲劳"),
    TERIOD_THREE("3", "非常疲惫"),

    //血压状态(风险等级)
    HIGHANDLOW_ONE("1","低血压"),
    HIGHANDLOW_TWO("2", "正常血压"),
    HIGHANDLOW_THREE("3", "高血压"),

    //运动预警状态(风险等级)
    SPORTHERTRATE_ONE("1","提高强度"),
    SPORTHERTRATE_TWO("2", "运动正常"),
    SPORTHERTRATE_THREE("3", "过于剧烈"),

    //血液黏稠度状态(风险等级)
    BLOODCONSISTENCY_ONE("1","偏高"),
    BLOODCONSISTENCY_TWO("2", "正常"),
    BLOODCONSISTENCY_THREE("3", "偏低"),

    //K值状态(风险等级)
    KVALUE_ONE("1","血管及微循环状况良好"),
    KVALUE_TWO("2", "血管及微循环状况中等"),
    KVALUE_THREE("3", "血管及微循环状况相对较差");

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
