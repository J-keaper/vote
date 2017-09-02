package com.keaper.vote.web.controller;

import com.google.code.kaptcha.Constants;
import com.keaper.vote.common.constants.CaptchaReference;
import com.keaper.vote.common.utils.BufferedImageUtils;
import com.keaper.vote.service.CaptchaService;
import org.apache.commons.lang3.tuple.Pair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping(value = "/captcha")
@SessionAttributes({CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY,
        CaptchaReference.REGISTER_CAPTCHA_SESSION_KEY})
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
        byte [] bytes = BufferedImageUtils.getBytes(captchaPair.getRight());
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(bytes);
    }
}
