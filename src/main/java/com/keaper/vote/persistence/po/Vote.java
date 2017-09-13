package com.keaper.vote.persistence.po;

import com.keaper.vote.common.model.ValidateRule;

import java.util.Date;

public class Vote {

    int id;

    int creatorId;

    String title;

    String description;

    String textAfterVote;

    long accessCount;

    int choiceMin;

    int choiceMax;

    int countPerRow;

    int paginationCount;

    int voterInfoCollect;

    Date startTime;

    Date endTime;

    ValidateRule IPValidateRule;

    ValidateRule deviceValidateRule;

    ValidateRule emailValidateRule;

    ValidateRule phoneValidateRule;

    ValidateRule QQValidateRule;

    ValidateRule WXValidateRule;

    String votePassword;

    Date createTime;

    public Vote() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(int creatorId) {
        this.creatorId = creatorId;
    }

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

    public long getAccessCount() {
        return accessCount;
    }

    public void setAccessCount(long accessCount) {
        this.accessCount = accessCount;
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

    public int getVoterInfoCollect() {
        return voterInfoCollect;
    }

    public void setVoterInfoCollect(int voterInfoCollect) {
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

    public ValidateRule getIPValidateRule() {
        return IPValidateRule;
    }

    public void setIPValidateRule(ValidateRule IPValidateRule) {
        this.IPValidateRule = IPValidateRule;
    }

    public ValidateRule getDeviceValidateRule() {
        return deviceValidateRule;
    }

    public void setDeviceValidateRule(ValidateRule deviceValidateRule) {
        this.deviceValidateRule = deviceValidateRule;
    }

    public ValidateRule getEmailValidateRule() {
        return emailValidateRule;
    }

    public void setEmailValidateRule(ValidateRule emailValidateRule) {
        this.emailValidateRule = emailValidateRule;
    }

    public ValidateRule getPhoneValidateRule() {
        return phoneValidateRule;
    }

    public void setPhoneValidateRule(ValidateRule phoneValidateRule) {
        this.phoneValidateRule = phoneValidateRule;
    }

    public ValidateRule getQQValidateRule() {
        return QQValidateRule;
    }

    public void setQQValidateRule(ValidateRule QQValidateRule) {
        this.QQValidateRule = QQValidateRule;
    }

    public ValidateRule getWXValidateRule() {
        return WXValidateRule;
    }

    public void setWXValidateRule(ValidateRule WXValidateRule) {
        this.WXValidateRule = WXValidateRule;
    }

    public String getVotePassword() {
        return votePassword;
    }

    public void setVotePassword(String votePassword) {
        this.votePassword = votePassword;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }


    @Override
    public String toString() {
        return "Vote{" +
                "id=" + id +
                ", creatorId=" + creatorId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", textAfterVote='" + textAfterVote + '\'' +
                ", accessCount=" + accessCount +
                ", choiceMin=" + choiceMin +
                ", choiceMax=" + choiceMax +
                ", countPerRow=" + countPerRow +
                ", paginationCount=" + paginationCount +
                ", voterInfoCollect=" + voterInfoCollect +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", IPValidateRule=" + IPValidateRule +
                ", deviceValidateRule=" + deviceValidateRule +
                ", emailValidateRule=" + emailValidateRule +
                ", phoneValidateRule=" + phoneValidateRule +
                ", QQValidateRule=" + QQValidateRule +
                ", WXValidateRule=" + WXValidateRule +
                ", votePassword='" + votePassword + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
