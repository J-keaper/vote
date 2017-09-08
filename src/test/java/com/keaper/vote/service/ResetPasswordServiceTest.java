package com.keaper.vote.service;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.persistence.dao.ResetPasswordDao;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class ResetPasswordServiceTest extends BaseSpringTest{

    @Resource
    private ResetPasswordService resetPasswordService;


    @Test
    public void generateResetPasswordUrlAndRecord() throws Exception {
        String url = resetPasswordService.generateResetPasswordUrlAndRecord(
                "1273570695@qq.com"
        );
    }


    @Test
    public void setNewPasswordAndDeleteRecord(){
        System.out.println(resetPasswordService.setNewPasswordAndDeleteRecord("c9a8160d50ad64df0dd1e4b99c1fd69194f2a696",
                "123"));
    }


    @Test
    public void judgeValid(){
        System.out.println(resetPasswordService.judgeValid("c9a8160d50ad64df0dd1e4b99c1fd69194f2a696"));
    }
}