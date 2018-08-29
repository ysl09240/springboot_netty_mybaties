package com.shxseer.watch.model;

import java.util.Date;

/**
 * @author frank  braveheart1115@163.com
 * @Description:  用户bean。
 * @Package com.shxseer.seer.po
 * @ClassName: com.shxseer.seer.po.User
 * @date 2017年09月27日 09:29
 */
public class User {
    
    private String id;              //  主鍵id
    private String loginName;       //  登录名
    private String sex;             //  性别 1:男,0:女
    private String cellphone;       //  电话
    private String cName;           //  中文名
    private String password;        //  密码
    private String headPortrait;    //  图像
    private Date headPortraitTime=new Date();    //  图像上传时间
    private String birthday;        //  生日
    private int age;                //  用户年龄
    private double stature;            //  身高
    private double weight;             //  体重
    private String medicalHistory;  //  以往病史
    private Date createTime=new Date();        //  创建时间
    private Date updateTime;        //  修改时间
    private String createBy;        //  创建人
    private String location;        //  用户位置信息，即城市
    private String validateCode;        //  用户注册时候手机接收的验证码
    private String inputValidateCode;        //  用户注册时候填写的验证码

//  2017-11-13 添加
    private double bloodGlucose;  // 血糖基准值

//  2018-04-09 添加
    private String accid;  // 云信的验证信息
    private String token;  // 云信的验证信息

//  2018-05-08 添加
    private String wallet;  // 个人钱包

    public String getAccid() {
        return accid;
    }

    public void setAccid(String accid) {
        this.accid = accid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCellphone() {
        return cellphone;
    }

    public void setCellphone(String cellphone) {
        this.cellphone = cellphone;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadPortrait() {
        return headPortrait;
    }

    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public double getStature() {
        return stature;
    }

    public void setStature(double stature) {
        this.stature = stature;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getMedicalHistory() {
        return medicalHistory;
    }

    public void setMedicalHistory(String medicalHistory) {
        this.medicalHistory = medicalHistory;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreateBy() {
        return createBy;
    }

    public void setCreateBy(String createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getValidateCode() {
        return validateCode;
    }

    public void setValidateCode(String validateCode) {
        this.validateCode = validateCode;
    }

    public String getInputValidateCode() {
        return inputValidateCode;
    }

    public void setInputValidateCode(String inputValidateCode) {
        this.inputValidateCode = inputValidateCode;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getBloodGlucose() {
        return bloodGlucose;
    }

    public void setBloodGlucose(double bloodGlucose) {
        this.bloodGlucose = bloodGlucose;
    }

    public Date getHeadPortraitTime() {
        return headPortraitTime;
    }

    public void setHeadPortraitTime(Date headPortraitTime) {
        this.headPortraitTime = headPortraitTime;
    }

    public String getWallet() {
        return wallet;
    }

    public void setWallet(String wallet) {
        this.wallet = wallet;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", loginName='" + loginName + '\'' +
                ", sex='" + sex + '\'' +
                ", cellphone='" + cellphone + '\'' +
                ", cName='" + cName + '\'' +
                ", password='" + password + '\'' +
                ", headPortrait='" + headPortrait + '\'' +
                ", headPortraitTime=" + headPortraitTime +
                ", birthday='" + birthday + '\'' +
                ", age=" + age +
                ", stature=" + stature +
                ", weight=" + weight +
                ", medicalHistory='" + medicalHistory + '\'' +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", createBy='" + createBy + '\'' +
                ", location='" + location + '\'' +
                ", validateCode='" + validateCode + '\'' +
                ", inputValidateCode='" + inputValidateCode + '\'' +
                ", bloodGlucose=" + bloodGlucose +
                ", accid='" + accid + '\'' +
                ", token='" + token + '\'' +
                ", wallet=" + wallet +
                '}';
    }
}
