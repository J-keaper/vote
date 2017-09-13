package com.keaper.vote.model;

public class VoteOptionParam {

    /**
     * 标题
     */
    String title;
    /**
     * 图片URL
     */
    String imageUrl;
    /**
     * 摘要
     */
    String summary;
    /**
     * 外链
     */
    String externalLink;
    /**
     * 详情页URL
     */
    String detailUrl;
    /**
     * 排列位置
     */
    int rankPosition;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
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
        return "VoteOptionParam{" +
                "title='" + title + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", summary='" + summary + '\'' +
                ", externalLink='" + externalLink + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", rankPosition=" + rankPosition +
                '}';
    }
}
