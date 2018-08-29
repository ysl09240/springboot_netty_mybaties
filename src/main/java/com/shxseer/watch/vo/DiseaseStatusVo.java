package com.shxseer.watch.vo;

/**
 *
 *  @author
 */
public class DiseaseStatusVo {

    private String name;    // 状态名称
    private String code;    // 状态编码
    private String suggest; // 对应建议

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getSuggest() {
        return suggest;
    }

    public void setSuggest(String suggest) {
        this.suggest = suggest;
    }

    @Override
    public String toString() {
        return "DiseaseStatusVo{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", suggest='" + suggest + '\'' +
                '}';
    }
}
