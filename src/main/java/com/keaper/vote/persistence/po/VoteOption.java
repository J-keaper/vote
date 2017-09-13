package com.keaper.vote.persistence.po;

public class VoteOption {
    /**
     * 主键ID
     */
    int id;
    /**
     * 关联投票ID
     */
    int voteId;
    /**
     * 选项标题
     */
    String title;
    /**
     * 摘要
     */
    String summary ;
    /**
     * 图片URL
     */
    String imageUrl;
    /**
     * 外链
     */
    String externalLink;
    /**
     * 详情页URL
     */
    String detailUrl;
    /**
     * 默认排列位置
     */
    int rankPosition;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExternalLink() {
        return externalLink;
    }

    public void setExternalLink(String externalLink) {
        this.externalLink = externalLink;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public int getRankPosition() {
        return rankPosition;
    }

    public void setRankPosition(int rankPosition) {
        this.rankPosition = rankPosition;
    }

    @Override
    public String toString() {
        return "VoteOption{" +
                "id=" + id +
                ", voteId=" + voteId +
                ", title='" + title + '\'' +
                ", summary='" + summary + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", externalLink='" + externalLink + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", rankPosition=" + rankPosition +
                '}';
    }
}
