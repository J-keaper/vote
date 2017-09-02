package com.keaper.vote.utils;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.service.CaptchaService;
import org.apache.commons.lang3.tuple.Pair;
import org.junit.Test;

import javax.annotation.Resource;

import java.awt.image.BufferedImage;


public class CaptchaServiceTest extends BaseSpringTest{

    @Resource
    private CaptchaService captchaService;

    @Test
    public void generateAlphanumericCaptcha() throws Exception {
        Pair<String,BufferedImage> captchaPair = captchaService.generateAlphanumericCaptcha();
        System.out.println(captchaPair);
    }

    @Test
    public void getSessionKeyByRef(){
        System.out.println(CaptchaService.getSessionKeyByRef("login"));
    }
}