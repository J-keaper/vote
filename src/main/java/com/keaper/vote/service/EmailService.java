package com.keaper.vote.service;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.MailMessage;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailService {


    private static Logger logger = LoggerFactory.getLogger(EmailService.class);

    private static String CAPTCHA_MAIL_SUBJECT = "验证码";

    private static String RESET_PASSWORD_SUBJECT = "密码重置";


    @Resource
    private JavaMailSenderImpl mailSender;

    @Resource
    private SpringTemplateEngine thymeleafEngine;

    private void sendThymeleafMail(String[] toEmails, String subject, Map<String, Object> model, String templateLocation){
        try {
            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"UTF-8");

            messageHelper.setFrom(mailSender.getUsername());
            messageHelper.setTo(toEmails);
            messageHelper.setSubject(subject);

            if(model != null){
                Context context = new Context();
                for(Map.Entry<String, Object> param : model.entrySet()){
                    context.setVariable(param.getKey(), param.getValue());
                }

                String emailContent = thymeleafEngine.process(templateLocation, context);
                logger.info("发送邮件内容{}",emailContent);
                messageHelper.setText(emailContent,true);
            }
            mailSender.send(mimeMessage);
        } catch (MessagingException e) {
            logger.error("发送邮件异常！",e);
        }
    }


    private void sendThymeleafMail(String toEmail, String subject, Map<String, Object> model, String templateLocation){
        sendThymeleafMail(new String[]{toEmail},subject,model,templateLocation);
    }

    public void sendResetPasswordEmail(String toMails, final String resetPasswordUrl){
        sendThymeleafMail(toMails, RESET_PASSWORD_SUBJECT,
                new HashMap<String, Object>(){{
                   put("url",resetPasswordUrl);
                }},"/components/email/reset-pwd-email"
        );
    }

}
