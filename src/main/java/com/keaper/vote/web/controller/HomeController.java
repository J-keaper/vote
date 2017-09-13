package com.keaper.vote.web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {

    private static Logger logger = LoggerFactory.getLogger(HomeController.class);

    @RequestMapping("/")
    public String home(HttpSession session,Model model){
        logger.info("isLogin:{}",session.getAttribute("isLogin"));
//        model.addAttribute("isLogin",session.getAttribute("isLogin"));
        model.addAttribute("nickName","happy");
        return "index";
    }

}
