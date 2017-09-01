package com.keaper.vote.web.controller;

import com.google.code.kaptcha.Constants;
import com.keaper.vote.service.CaptchaService;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/captcha")
public class CaptchaController {

    private static Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    @Resource
    private CaptchaService captchaService;

    @ResponseBody
    @RequestMapping(value = "/alphanumeric")
    public void getAlphanumericCaptcha(HttpServletRequest request, HttpServletResponse response){
        Pair<String,BufferedImage> captchaPair = captchaService.generateAlphanumericCaptcha();
        logger.info("生成验证码：{}",captchaPair.getLeft());
        response.setContentType(MediaType.IMAGE_PNG_VALUE);
        request.getSession().setAttribute(Constants.KAPTCHA_SESSION_KEY,captchaPair.getLeft());
        try {
            OutputStream outputStream =response.getOutputStream();
            ImageIO.write(captchaPair.getRight(),"png",outputStream);
        } catch (IOException e) {
            logger.error("验证码写入失败!",e);
        }
    }
}
