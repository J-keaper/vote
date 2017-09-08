package com.keaper.vote.persistence.po;

import java.sql.Timestamp;

public class ResetPasswordInfo {

    /**
     * 主键ID
     */
    private int id;
    /**
     * token
     */
    private String token;
    /**
     * 过期时间
     */
    private Timestamp lapseTime;

    public ResetPasswordInfo(int id, String token, Timestamp lapseTime) {
        this.id = id;
        this.token = token;
        this.lapseTime = lapseTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Timestamp getLapseTime() {
        return lapseTime;
    }

    public void setLapseTime(Timestamp lapseTime) {
        this.lapseTime = lapseTime;
    }

    @Override
    public String toString() {
        return "ResetPasswordInfo{" +
                "id=" + id +
                ", token='" + token + '\'' +
                ", lapseTime=" + lapseTime +
                '}';
    }
}
