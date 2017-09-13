package com.keaper.vote.service;


import com.keaper.vote.common.model.ValidateRule;
import com.keaper.vote.model.CreateVoteParam;
import com.keaper.vote.model.VoteOptionParam;
import com.keaper.vote.persistence.dao.VoteDao;
import com.keaper.vote.persistence.dao.VoteOptionDao;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.persistence.po.Vote;
import com.keaper.vote.persistence.po.VoteOption;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Resource
    private VoteDao voteDao;

    @Resource
    private VoteOptionDao voteOptionDao;


    public boolean createVote(CreateVoteParam createVoteParam,User user ){
        Vote vote = constructVote(createVoteParam,user);
        voteDao.insertOneVote(vote);
        voteOptionDao.insertOptions(constructVoteOptionList(createVoteParam,vote.getId()));
        return true;
    }

    public Vote selectVoteInfoById(int id){
        return voteDao.selectVoteById(id);
    }

    private Vote constructVote(CreateVoteParam createVoteParam, User user){
        Vote vote = new Vote();
        vote.setCreatorId(user.getId());
        vote.setTitle(createVoteParam.getTitle());
        vote.setDescription(createVoteParam.getDescription());
        vote.setTextAfterVote(createVoteParam.getTextAfterVote());
        vote.setAccessCount(0);
        vote.setChoiceMin(createVoteParam.getChoiceMin());
        vote.setChoiceMax(createVoteParam.getChoiceMax());
        vote.setCountPerRow(createVoteParam.getCountPerRow());
        vote.setPaginationCount(createVoteParam.getPaginationCount());
        vote.setVoterInfoCollect(createVoteParam.isVoterInfoCollect()?1:0);
        vote.setStartTime(createVoteParam.getStartTime());
        vote.setEndTime(createVoteParam.getEndTime());
        vote.setIPValidateRule(ValidateRule.fromCode(createVoteParam.getIPValidateRuleCode()));
        vote.setDeviceValidateRule(ValidateRule.fromCode(createVoteParam.getDeviceValidateRuleCode()));
        vote.setEmailValidateRule(ValidateRule.fromCode(createVoteParam.getEmailValidateRuleCode()));
        vote.setPhoneValidateRule(ValidateRule.fromCode(createVoteParam.getPhoneValidateRuleCode()));
        vote.setQQValidateRule(ValidateRule.fromCode(createVoteParam.getQQValidateRuleCode()));
        vote.setWXValidateRule(ValidateRule.fromCode(createVoteParam.getWXValidateRuleCode()));
        vote.setVotePassword(createVoteParam.getVotePassword());
        return vote;
    }

    private List<VoteOption> constructVoteOptionList(CreateVoteParam createVoteParam, int voteId){
        List<VoteOption> optionList = new ArrayList<VoteOption>();
        List<VoteOptionParam> optionParamList = createVoteParam.getVoteOptionParamList();
        for (VoteOptionParam voteOptionParam : optionParamList){
            VoteOption voteOption = new VoteOption();
            voteOption.setVoteId(voteId);
            voteOption.setImageUrl(voteOptionParam.getImageUrl());
            voteOption.setSummary(voteOptionParam.getSummary());
            voteOption.setExternalLink(voteOptionParam.getExternalLink());
            voteOption.setDetailUrl(voteOptionParam.getDetailUrl());
            voteOption.setRankPosition(voteOptionParam.getRankPosition());
            optionList.add(voteOption);
        }
        return optionList;
    }

}
