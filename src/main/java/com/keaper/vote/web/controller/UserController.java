package com.keaper.vote.web.controller;

import com.keaper.vote.common.constants.CaptchaReference;
import com.keaper.vote.model.LoginParam;
import com.keaper.vote.model.RegisterParam;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.service.UserService;
import com.keaper.vote.web.vo.JsonResult;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {

    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Resource
    private UserService userService;

    @ResponseBody
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public JsonResult login(LoginParam loginParam, HttpSession session){
        logger.info("参数LoginParam：{}",loginParam);
//        captcha error
        logger.info("session中{}：{}",CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY,
                session.getAttribute(CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY));
        if(!StringUtils.equalsIgnoreCase(loginParam.getVcode(),
                session.getAttribute(CaptchaReference.LOGIN_CAPTCHA_SESSION_KEY).toString())){
            return JsonResult.getErrorResult(
                    JsonResult.Code.LOGIN_VCODE_ERROR.name(),
                    JsonResult.Code.LOGIN_VCODE_ERROR.getCode(),
                    null);
        }

        //Email not Exist
        if(!userService.judgeEmailExist(loginParam.getEmail())){
            logger.info("登录邮箱不存在！");
            return JsonResult.getErrorResult(
                    JsonResult.Code.LOGIN_EMAIL_NOT_EXIST.name(),
                    JsonResult.Code.LOGIN_EMAIL_NOT_EXIST.getCode(),
                    null);
        }
        User user = userService.login(loginParam);
        if( user != null){
            //login success
            logger.info("登录成功！");
            session.setAttribute("isLogin",true);
            session.setAttribute("userInfo",user);
            return JsonResult.getCorrectResult(user);
        }
        //Password not match
        logger.info("登录密码错误！");
        return JsonResult.getErrorResult(
                JsonResult.Code.LOGIN_PASSWORD_WRONG.name(),
                JsonResult.Code.LOGIN_PASSWORD_WRONG.getCode(),
                null);
    }


    @ResponseBody
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    public JsonResult register(RegisterParam registerParam,HttpServletRequest request){
        logger.info("参数RegisterParam：{}",registerParam);
//        captcha error
        if(!StringUtils.equals(registerParam.getVcode().toLowerCase(),
                request.getSession().getAttribute(CaptchaReference.REGISTER_CAPTCHA_SESSION_KEY).toString().toLowerCase())) {
            return JsonResult.getErrorResult(
                    JsonResult.Code.REGISTER_VCODE_ERROR.name(),
                    JsonResult.Code.REGISTER_VCODE_ERROR.getCode(),
                    null);
        }
//        Email exist
        if(userService.judgeEmailExist(registerParam.getEmail())){
            logger.info("邮箱 {} 已存在！",registerParam.getEmail());
            return JsonResult.getErrorResult(
                    JsonResult.Code.REGISTER_EMAIL_EXIST.name(),
                    JsonResult.Code.REGISTER_EMAIL_EXIST.getCode(),
                    null);
        }
//        nick exist
        if(userService.judgeNickExist(registerParam.getNickName())){
            logger.info("昵称 {} 已存在！",registerParam.getNickName());
            return JsonResult.getErrorResult(
                    JsonResult.Code.REGISTER_NICK_NAME_EXIST.name(),
                    JsonResult.Code.REGISTER_NICK_NAME_EXIST.getCode(),
                    null);
        }
        if(userService.register(registerParam)){
            return JsonResult.getCorrectResult(null);
        }
        return JsonResult.getErrorResult(
                JsonResult.Code.REGISTER_FAIL.name(),JsonResult.Code.REGISTER_FAIL.getCode(),null
        );
    }
    @RequestMapping("/account/{userId}")
    public String getAccountInfo(@PathVariable("userId") int id, HttpSession session,
                                 Model model){
        User user = userService.getUserInfoById(id);
        model.addAttribute("userInfo",user);
        model.addAttribute("pageIndex","account");
        return "components/user_info/account";
    }
}
