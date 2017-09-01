package com.keaper.vote.common.constants;

import org.omg.CORBA.UNKNOWN;

public enum ActivateStatus {
    INACTIVE(0,"未激活"),
    ACTIVATED(1,"已激活");

    private int code;
    private String text;

    ActivateStatus(int code, String text) {
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

    public static ActivateStatus fromCode(int code){
        for (ActivateStatus value : ActivateStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        return null;
    }

}
