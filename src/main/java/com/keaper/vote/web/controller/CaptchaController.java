package com.keaper.vote.web.controller;

import com.keaper.vote.common.constants.CaptchaReference;
import com.keaper.vote.common.utils.BufferedImageUtils;
import com.keaper.vote.service.CaptchaService;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.IOException;

@Controller
@RequestMapping(value = "/captcha")
public class CaptchaController {

    private static Logger logger = LoggerFactory.getLogger(CaptchaController.class);

    @Resource
    private CaptchaService captchaService;

    /**
     * @throws IOException 异常抛出，不知道合不合适
     */
    @ResponseBody
    @RequestMapping(value = "/alphanumeric")
    public ResponseEntity<byte[]> getAlphanumericCaptcha(@RequestParam(value = "ref",required = false) String ref,
                                                         HttpSession session) throws IOException {
        Pair<String,BufferedImage> captchaPair = captchaService.generateAlphanumericCaptcha();
        logger.info("生成验证码：{},来源：{}",captchaPair.getLeft(),ref);
        //验证码依据调用来源存Session
        session.setAttribute(CaptchaService.getSessionKeyByRef(ref),captchaPair.getLeft());
        //返回图片
        logger.info("session中{}：{}",CaptchaService.getSessionKeyByRef(ref),
                session.getAttribute(CaptchaService.getSessionKeyByRef(ref)));
        byte [] bytes = BufferedImageUtils.getBytes(captchaPair.getRight());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
