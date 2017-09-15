package com.keaper.vote.web.controller;


import com.keaper.vote.common.constants.SiteConstants;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/manage")
public class ManageController {

    @RequestMapping("/center")
    public String index(){
        return "/components/manage-center/index";
    }

    /**
     * 分享页面
     * @param voteId
     * @return
     */
    @RequestMapping(value = "/share/{id}")
    public String getEntrance(@PathVariable("id") int voteId, Model model){
        String link = SiteConstants.PROTOCOL + SiteConstants.DOMAIN +"/vote/show/"+voteId;
        model.addAttribute("voteLink",link);
        return "/components/manage-center/share";
    }
}