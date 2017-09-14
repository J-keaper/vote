package com.keaper.vote.web.controller;


import com.keaper.vote.model.CreateVoteParam;
import com.keaper.vote.model.VoteRecordParam;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.persistence.po.Vote;
import com.keaper.vote.persistence.po.VoteOption;
import com.keaper.vote.service.VoteService;
import com.keaper.vote.web.vo.JsonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/vote")
public class VoteController {


    @Resource
    private VoteService voteService;

    private static final Logger logger = LoggerFactory.getLogger(VoteController.class);

    /**
     * 创建投票页面
     * @return
     */
    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String  createVote(){
        return "/components/create-vote/create-vote";
    }

    /**
     * 创建投票提交地址
     * @param createVoteParam
     * @param session
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public JsonResult createVote(@RequestBody CreateVoteParam createVoteParam, HttpSession session){
        logger.info("createVoteParam: {}",createVoteParam);
        User user = (User) session.getAttribute("userInfo");
        voteService.createVote(createVoteParam,user);
        return JsonResult.getCorrectResult(null);
    }

    /**
     * 展示投票页面
     * @return
     */
    @RequestMapping(value = "/show/{voteId}",method = RequestMethod.GET)
    public String showVote(@PathVariable("voteId") int voteId, Model model){
        Vote vote = voteService.selectVoteInfoById(voteId);
        model.addAttribute("voteInfo",vote);
        List<VoteOption> voteOptionList= voteService.selectOptiionListById(1);
        model.addAttribute("voteOptionList",voteOptionList);
        logger.info("model:{}",model);
        return "/components/vote-show/vote-show";
    }

    /**
     * 投票提交地址
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/submit",method = RequestMethod.POST)
    public JsonResult submit(@RequestBody List<VoteRecordParam> voteRecordParamList,
                            HttpServletRequest request){
        logger.info("voteRecordParamList:{}",voteRecordParamList);
        voteService.addVoteRecord(voteRecordParamList,request);
        return JsonResult.getCorrectResult(null);
    }
}
