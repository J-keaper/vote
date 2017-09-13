package com.keaper.vote.common.model;

public class ValidateRule {
    /**
     * 间隔时间（分钟单位），为0表示永久
     */
    int interval;
    /**
     * 每个间隔时间限制次数
     */
    int limit;

    public ValidateRule(int interval, int limit) {
        this.interval = interval;
        this.limit = limit;
    }

    public static ValidateRule fromCode(int code) {
        return new ValidateRule(code/100,code%100);
    }

    public int getCode(){
        return interval*100+limit;
    }


    public int getInterval() {
        return interval;
    }

    public void setInterval(int interval) {
        this.interval = interval;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
