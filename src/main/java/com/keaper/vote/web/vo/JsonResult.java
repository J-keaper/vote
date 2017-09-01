package com.keaper.vote.web.vo;

import com.alibaba.fastjson.JSON;

import java.io.Serializable;

public class JsonResult<T> implements Serializable {

    private static final long serialVersionUID = -2180939684939184163L;

    private Boolean ret = Boolean.TRUE;

    private String msg;

    private Integer code;

    private T data;


    public static <T> JsonResult getCorrectResult(T data) {
        return new JsonResult<T>(true, Code.SUCCESS.name(), 0, data);
    }

    public static <T> JsonResult getErrorResult(String errmsg, int errcode, T data) {
        return new JsonResult<T>(false, errmsg, errcode, data);
    }

    public JsonResult(boolean result, String msg, int code, T data) {
        this.ret = result;
        this.msg = msg;
        this.code = code;
        this.data = data;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Boolean getRet() {
        return ret;
    }

    public void setRet(Boolean ret) {
        this.ret = ret;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "JsonResult{" +
                "ret=" + ret +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }

    public enum Code{

        SUCCESS(0,"成功"),

        LOGIN_FAIL(101,"登陆失败"),

        REGISTER_FAIL(201,"注册失败");

        int  code;
        String text;

        Code(int code, String text) {
            this.code = code;
            this.text = text;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }
    }

}