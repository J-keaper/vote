package com.keaper.vote.model;

import com.keaper.vote.common.model.ValidateRule;
import com.keaper.vote.persistence.po.VoteOption;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class CreateVoteParam {
    /**
     * 标题
     */
    String title;
    /**
     * 描述
     */
    String description;
    /**
     * 投票后显示信息
     */
    String textAfterVote;

    /**
     * 最少选择项数
     */
    int choiceMin;
    /**
     * 最多选择项数，为1表示单选，为0表示一键投票
     */
    int choiceMax;
    /**
     * 排版，每行显示选项数
     */
    int countPerRow;
    /**
     * 分页数,0表示不分页
     */
    int paginationCount;
    /**
     * 投票者信息收集
     */
    boolean voterInfoCollect;
    /**
     * 开始时间，如果开始时间不限，设为1970-01-01 00:00:00(Asia/Shanghai),时间戳为-28800
     */
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date startTime;
    /**
     * 结束时间，如果结束时间不限，设为3000-01-01 00:00:00(Asia/Shanghai),时间戳为32503651200
     */
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    Date endTime;
    /**
     * 网页验证码
     */
    boolean captchaValidate;
    /**
     * IP验证规则代码
     */
    int IPValidateRuleCode;
    /**
     * 设备验证规则代码
     */
    int deviceValidateRuleCode;
    /**
     * 邮箱验证规则代码
     */
    int emailValidateRuleCode;
    /**
     * 手机验证规则代码
     */
    int phoneValidateRuleCode;
    /**
     * QQ验证规则代码
     */
    int QQValidateRuleCode;
    /**
     * 微信验证规则代码
     */
    int WXValidateRuleCode;
    /**
     * 投票密码，空表示不设
     */
    String votePassword;

    /**
     * 投票选项参数列表
     */
    List<VoteOptionParam> voteOptionParamList;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTextAfterVote() {
        return textAfterVote;
    }

    public void setTextAfterVote(String textAfterVote) {
        this.textAfterVote = textAfterVote;
    }

    public int getChoiceMin() {
        return choiceMin;
    }

    public void setChoiceMin(int choiceMin) {
        this.choiceMin = choiceMin;
    }

    public int getChoiceMax() {
        return choiceMax;
    }

    public void setChoiceMax(int choiceMax) {
        this.choiceMax = choiceMax;
    }

    public int getCountPerRow() {
        return countPerRow;
    }

    public void setCountPerRow(int countPerRow) {
        this.countPerRow = countPerRow;
    }

    public int getPaginationCount() {
        return paginationCount;
    }

    public void setPaginationCount(int paginationCount) {
        this.paginationCount = paginationCount;
    }

    public boolean isVoterInfoCollect() {
        return voterInfoCollect;
    }

    public void setVoterInfoCollect(boolean voterInfoCollect) {
        this.voterInfoCollect = voterInfoCollect;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public boolean isCaptchaValidate() {
        return captchaValidate;
    }

    public void setCaptchaValidate(boolean captchaValidate) {
        this.captchaValidate = captchaValidate;
    }

    public int getIPValidateRuleCode() {
        return IPValidateRuleCode;
    }

    public void setIPValidateRuleCode(int IPValidateRuleCode) {
        this.IPValidateRuleCode = IPValidateRuleCode;
    }

    public int getDeviceValidateRuleCode() {
        return deviceValidateRuleCode;
    }

    public void setDeviceValidateRuleCode(int deviceValidateRuleCode) {
        this.deviceValidateRuleCode = deviceValidateRuleCode;
    }

    public int getEmailValidateRuleCode() {
        return emailValidateRuleCode;
    }

    public void setEmailValidateRuleCode(int emailValidateRuleCode) {
        this.emailValidateRuleCode = emailValidateRuleCode;
    }

    public int getPhoneValidateRuleCode() {
        return phoneValidateRuleCode;
    }

    public void setPhoneValidateRuleCode(int phoneValidateRuleCode) {
        this.phoneValidateRuleCode = phoneValidateRuleCode;
    }

    public int getQQValidateRuleCode() {
        return QQValidateRuleCode;
    }

    public void setQQValidateRuleCode(int QQValidateRuleCode) {
        this.QQValidateRuleCode = QQValidateRuleCode;
    }

    public int getWXValidateRuleCode() {
        return WXValidateRuleCode;
    }

    public void setWXValidateRuleCode(int WXValidateRuleCode) {
        this.WXValidateRuleCode = WXValidateRuleCode;
    }

    public String getVotePassword() {
        return votePassword;
    }

    public void setVotePassword(String votePassword) {
        this.votePassword = votePassword;
    }


    public List<VoteOptionParam> getVoteOptionParamList() {
        return voteOptionParamList;
    }

    public void setVoteOptionParamList(List<VoteOptionParam> voteOptionParamList) {
        this.voteOptionParamList = voteOptionParamList;
    }


    @Override
    public String toString() {
        return "CreateVoteParam{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", textAfterVote='" + textAfterVote + '\'' +
                ", choiceMin=" + choiceMin +
                ", choiceMax=" + choiceMax +
                ", countPerRow=" + countPerRow +
                ", paginationCount=" + paginationCount +
                ", voterInfoCollect=" + voterInfoCollect +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", captchaValidate=" + captchaValidate +
                ", IPValidateRuleCode=" + IPValidateRuleCode +
                ", deviceValidateRuleCode=" + deviceValidateRuleCode +
                ", emailValidateRuleCode=" + emailValidateRuleCode +
                ", phoneValidateRuleCode=" + phoneValidateRuleCode +
                ", QQValidateRuleCode=" + QQValidateRuleCode +
                ", WXValidateRuleCode=" + WXValidateRuleCode +
                ", votePassword='" + votePassword + '\'' +
                ", voteOptionParamList=" + voteOptionParamList +
                '}';
    }
}
