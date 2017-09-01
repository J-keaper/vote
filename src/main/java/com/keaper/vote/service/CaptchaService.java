package com.keaper.vote.service;

import com.google.code.kaptcha.Producer;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang3.tuple.MutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.awt.image.BufferedImage;

@Component
public class CaptchaService {

    private static int CAPTCHADEFAULTLENGTH = 4;

    @Resource
    private Producer captchaProducer;

    public Pair<String,BufferedImage> generateAlphanumericCaptcha(){
        return generateAlphanumericCaptcha(CAPTCHADEFAULTLENGTH);
    }

    public Pair<String,BufferedImage> generateAlphanumericCaptcha(int length){
        String captchaCode = RandomStringUtils.randomAlphanumeric(length);
        BufferedImage captchaImage = captchaProducer.createImage(captchaCode);
        return new MutablePair<String,BufferedImage>(captchaCode,captchaImage);
    }

}
