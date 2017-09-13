package com.keaper.vote.persistence.po;

import java.util.Date;

public class VoteRecord {
    /**
     * 主键ID
     */
    int id;
    /**
     * 投票ID
     */
    int voteId;
    /**
     * 选项ID
     */
    int voteOptionId;
    /**
     * IP
     */
    String  IP;
    /**
     * 设备标识，暂时为MAC地址
     */
    String device;
    /**
     * 邮箱
     */
    String email;
    /**
     * 手机号
     */
    String phone;
    /**
     * QQ登录唯一标识
     */
    String QQ;
    /**
     * 微信登录唯一标识
     */
    String WX;
    /**
     * 如果开启了投票者信息收集,标识ID
     */
    String voterId;
    /**
     * 投票时间
     */
    Date createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getVoteOptionId() {
        return voteOptionId;
    }

    public void setVoteOptionId(int voteOptionId) {
        this.voteOptionId = voteOptionId;
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
    }

    public String getdevice() {
        return device;
    }

    public void setdevice(String device) {
        this.device = device;
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

    public String getQQ() {
        return QQ;
    }

    public void setQQ(String QQ) {
        this.QQ = QQ;
    }

    public String getWX() {
        return WX;
    }

    public void setWX(String WX) {
        this.WX = WX;
    }

    public String getVoterId() {
        return voterId;
    }

    public void setVoterId(String voterId) {
        this.voterId = voterId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "VoteRecord{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", voteOptionId=" + voteOptionId +
                ", IP='" + IP + '\'' +
                ", device='" + device + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", WX='" + WX + '\'' +
                ", voterId='" + voterId + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
