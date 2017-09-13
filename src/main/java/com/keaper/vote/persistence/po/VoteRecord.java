package com.keaper.vote.persistence.po;

import java.util.Date;

public class VoteRecord {
    /**
     * 主键ID
     */
    int id;
    /**
     * IP
     */
    String  IP;
    /**
     * 设备标识，暂时为MAC地址
     */
    String deviceMAC;
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

}
