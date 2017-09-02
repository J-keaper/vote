package com.keaper.vote.model;

public class LoginParam {
    /**
     * 邮箱
     */
    String email;
    /**
     * 手机
     */
    String phone;
    /**
     * 密码
     */
    String password;
    /**
     * 验证码
     */
    String vcode;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "LoginParam{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", vcode='" + vcode + '\'' +
                '}';
    }
}
