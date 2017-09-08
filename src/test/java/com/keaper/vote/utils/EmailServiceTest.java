package com.keaper.vote.utils;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.service.EmailService;
import com.keaper.vote.service.ResetPasswordService;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

public class EmailServiceTest extends BaseSpringTest{

    @Resource
    private EmailService emailService;

    @Resource
    private JavaMailSenderImpl mailSender;

    @Resource
    private ResetPasswordService resetPasswordService;

    @Test
    public void testMailSenderProperty(){
        System.out.println(mailSender.getHost());
        System.out.println(mailSender.getUsername());
        System.out.println(mailSender.getPassword());
    }


    @Test
    public void testSendResetPasswordEmail(){
        emailService.sendResetPasswordEmail("1273570695@qq.com",
                resetPasswordService.generateResetPasswordUrlAndRecord("1273570695@qq.com"));
    }


}