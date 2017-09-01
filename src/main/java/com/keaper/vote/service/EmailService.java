package com.keaper.vote.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class EmailService {

    private static String CAPTCHAMAILSUBJECT = "验证码";

    @Resource
    private JavaMailSenderImpl mailSender;


    public void sendCaptchaMail(String toEmail,String captcha){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();

        simpleMailMessage.setFrom(mailSender.getUsername());
        simpleMailMessage.setFrom("keaper"+"<"+mailSender.getUsername()+">");
        simpleMailMessage.setSubject(CAPTCHAMAILSUBJECT);
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setText(captcha);

        mailSender.send(simpleMailMessage);
    }

}
