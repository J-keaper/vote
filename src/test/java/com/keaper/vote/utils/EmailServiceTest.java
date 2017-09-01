package com.keaper.vote.utils;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.service.EmailService;
import org.junit.Test;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.annotation.Resource;

public class EmailServiceTest extends BaseSpringTest{

    @Resource
    private EmailService emailService;

    @Resource
    private JavaMailSenderImpl mailSender;

    @Test
    public void testMailSenderProperty(){
        System.out.println(mailSender.getHost());
        System.out.println(mailSender.getUsername());
        System.out.println(mailSender.getPassword());
    }


    @Test
    public void sendCaptchaMail() throws Exception {
        emailService.sendCaptchaMail("1042137827@qq.com","123456");
    }

}