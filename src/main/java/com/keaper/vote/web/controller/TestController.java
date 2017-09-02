package com.keaper.vote.web.controller;


import com.google.code.kaptcha.Constants;
import com.keaper.vote.common.constants.CaptchaReference;
import com.keaper.vote.common.enums.ActivateStatus;
import com.keaper.vote.common.utils.BufferedImageUtils;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.service.CaptchaService;
import com.keaper.vote.web.vo.JsonResult;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferByte;
import java.awt.image.WritableRaster;
import java.io.ByteArrayOutputStream;
import java.io.IOException;


@Controller
@RequestMapping("test")
public class TestController {


    @Resource
    private CaptchaService captchaService;

    @ResponseBody
    @RequestMapping("/captcha")
    public String testCaptcha(HttpSession httpSession){
        return httpSession.getAttribute(CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY).toString();
    }


    @ResponseBody
    @RequestMapping("/captcha2")
    public String testCaptcha(Model model){
        return model.asMap().get(CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY).toString();
    }

    @ResponseBody
    @RequestMapping("/captcha/login")
    public String testCaptchaLogin(HttpServletRequest request){
        return request.getSession().getAttribute(CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY).toString();
    }

    @ResponseBody
    @RequestMapping("/captcha/reg")
    public String testCaptchaRegister(HttpServletRequest request){
        return request.getSession().getAttribute(CaptchaReference.REGISTER_CAPTCHA_SESSION_KEY).toString();
    }


    @RequestMapping("/thymeleaf")
    public String testThymeleaf(Model model){
        model.addAttribute("name","keaper");
        return "index";
    }

    @ResponseBody
    @RequestMapping("/json")
    public User testJson(){
        User user = new User();
        user.setEmail("12735702695@qq.com");
        user.setPassword("123456");
        user.setActivateStatus(ActivateStatus.INACTIVE);
        return user;
    }


    @ResponseBody
    @RequestMapping("/testJsonResult")
    public JsonResult testJsonResult(){
        return JsonResult.getCorrectResult(null);
    }



    @ResponseBody
    @RequestMapping("/testResponse")
    public ResponseEntity<byte[]> getImage() throws IOException {
        Pair<String,BufferedImage> captchaPair = captchaService.generateAlphanumericCaptcha();
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_PNG)
                .body(BufferedImageUtils.getBytes(captchaPair.getRight()));
    }
}
