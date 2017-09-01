package com.keaper.vote.web.controller;

import com.keaper.vote.model.LoginParam;
import com.keaper.vote.model.RegisterParam;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.service.UserService;
import com.keaper.vote.web.vo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(LoginParam loginParam){
        logger.info("参数LoginParam：{}",loginParam);
        User user = userService.login(loginParam);
        if( user != null){
            return JsonResult.getCorrectResult(user);
        }
        return JsonResult.getErrorResult(
                JsonResult.Code.LOGIN_FAIL.name(),JsonResult.Code.LOGIN_FAIL.getCode(),null
        );
    }


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult register(RegisterParam registerParam){
        logger.info("参数RegisterParam：{}",registerParam);
        if(userService.register(registerParam)){
            return JsonResult.getCorrectResult(null);
        }
        return JsonResult.getErrorResult(
                JsonResult.Code.REGISTER_FAIL.name(),JsonResult.Code.REGISTER_FAIL.getCode(),null
        );
    }



}
