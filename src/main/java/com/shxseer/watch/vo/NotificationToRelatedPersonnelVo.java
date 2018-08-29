package com.shxseer.watch.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;

/**
 * 病症计算完成后给用户本人、好友、亲友组、团体推送消息接口的请求参数Vo
 * @author zhangliang
 * @since 2018-07-18 11:25
 */
@ApiModel
public class NotificationToRelatedPersonnelVo {
    @ApiModelProperty(value = "即时消息推送内容", required = true)
    private String pushMessage;
    @ApiModelProperty(value = "脉搏开始测量时间（yyyy-MM-dd HH:mm:ss）", required = true)
    private String startTime;
    @ApiModelProperty(value = "病症编号", required = true)
    private int diseaseCode;
    @ApiModelProperty(value = "用户id", required = true)
    private String userId;
    @ApiModelProperty(value = "病症图标", required = true)
    private String headPortrait;
    @ApiModelProperty(value = "用户头像", required = true)
    private String userHeadPortrait;
    @ApiModelProperty(value = "电话", required = true)
    private String cellphone;

    public String getPushMessage() {
        return pushMessage;
    }

    public void setPushMessage(String pushMessage) {
        this.pushMessage = pushMessage;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public int getDiseaseCode() {
        return diseaseCode;
    }

    public void setDiseaseCode(int diseaseCode) {
        this.diseaseCode = diseaseCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getUserHeadPortrait() {
        return userHeadPortrait;
    }

    public void setUserHeadPortrait(String userHeadPortrait) {
        this.userHeadPortrait = userHeadPortrait;
    }

    @Override
    public String toString() {
        return "NotificationToRelatedPersonnelVo{" +
                "pushMessage='" + pushMessage + '\'' +
                ", startTime='" + startTime + '\'' +
                ", diseaseCode=" + diseaseCode +
                ", userId='" + userId + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", userHeadPortrait='" + userHeadPortrait + '\'' +
                ", cellphone='" + cellphone + '\'' +
                '}';
    }
}
