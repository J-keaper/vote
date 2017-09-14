package com.keaper.vote.model;

public class VoteRecordParam {
    /**
     * 投票ID
     */
    int voteId;
    /**
     * 选项ID
     */
    int optionId;
    /**
     * 邮箱
     */
    String email;
    /**
     * 手机
     */
    String phone;
    /**
     * QQ
     */
    String QQ;
    /**
     * 微信
     */
    String WX;

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
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

    @Override
    public String toString() {
        return "VoteRecordParam{" +
                "voteId=" + voteId +
                ", optionId=" + optionId +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", QQ='" + QQ + '\'' +
                ", WX='" + WX + '\'' +
                '}';
    }
}
