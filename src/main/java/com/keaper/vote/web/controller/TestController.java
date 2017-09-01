package com.keaper.vote.web.controller;


import com.alibaba.fastjson.JSON;
import com.google.code.kaptcha.Constants;
import com.keaper.vote.common.constants.ActivateStatus;
import com.keaper.vote.model.TestModel;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.web.vo.JsonResult;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


@Controller
@RequestMapping("test")
public class TestController {


    @ResponseBody
    @RequestMapping("/captcha")
    public String testCaptcha(HttpServletRequest request){
        return request.getSession().getAttribute(Constants.KAPTCHA_SESSION_KEY).toString();
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
    @RequestMapping(value = "/json2")
    public TestModel testObjctJson(){
        TestModel testModel = new TestModel();
        testModel.setName("keaper");
        User user = new User();
        user.setEmail("12735702695@qq.com");
        user.setPassword("123456");
        user.setActivateStatus(ActivateStatus.INACTIVE);
        testModel.setUser(user);
        return testModel;
    }

    @ResponseBody
    @RequestMapping("/testJsonResult")
    public JsonResult testJsonResult(){
        return JsonResult.getCorrectResult(null);
    }
}
