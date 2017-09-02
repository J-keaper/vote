package com.keaper.vote.persistence.po;

import com.keaper.vote.common.enums.ActivateStatus;

import java.util.Date;

public class User {
    /**
     * 主键
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 密码
     */
    private String password;
    /**
     * 注册时间
     */
    private Date registerTime;
    /**
     * 激活状态
     */
    private ActivateStatus activateStatus;
    /**
     * 激活码
     */
    private String activateCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Date registerTime) {
        this.registerTime = registerTime;
    }

    public ActivateStatus getActivateStatus() {
        return activateStatus;
    }

    public void setActivateStatus(ActivateStatus activateStatus) {
        this.activateStatus = activateStatus;
    }

    public String getActivateCode() {
        return activateCode;
    }

    public void setActivateCode(String activateCode) {
        this.activateCode = activateCode;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", registerTime=" + registerTime +
                ", activateStatus=" + activateStatus +
                ", activateCode='" + activateCode + '\'' +
                '}';
    }
}
