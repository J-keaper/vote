package com.keaper.vote.service;

import com.google.code.kaptcha.Constants;
import com.google.code.kaptcha.Producer;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import org.apache.commons.lang.RandomStringUtils;
import org.apache.commons.lang.StringUtils;
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
        String captchaCode = RandomStringUtils.randomAlphanumeric(CAPTCHADEFAULTLENGTH);
        BufferedImage captchaImage = captchaProducer.createImage(captchaCode);
        return new MutablePair<String,BufferedImage>(captchaCode,captchaImage);
    }

    public static String getSessionKeyByRef(String ref){
        if(StringUtils.isEmpty(ref)){
            return Constants.KAPTCHA_SESSION_KEY;
        }
        return Constants.KAPTCHA_SESSION_KEY+"_"+ref.toUpperCase();
    }
}
