package com.keaper.vote.service;


import com.keaper.vote.common.model.ValidateRule;
import com.keaper.vote.common.utils.RequestUtils;
import com.keaper.vote.model.CreateVoteParam;
import com.keaper.vote.model.VoteOptionParam;
import com.keaper.vote.model.VoteRecordParam;
import com.keaper.vote.persistence.dao.VoteDao;
import com.keaper.vote.persistence.dao.VoteOptionDao;
import com.keaper.vote.persistence.dao.VoteRecordDao;
import com.keaper.vote.persistence.po.User;
import com.keaper.vote.persistence.po.Vote;
import com.keaper.vote.persistence.po.VoteOption;
import com.keaper.vote.persistence.po.VoteRecord;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Service
public class VoteService {

    @Resource
    private VoteDao voteDao;

    @Resource
    private VoteOptionDao voteOptionDao;

    @Resource
    private VoteRecordDao voteRecordDao;

    @Transactional
    public boolean createVote(CreateVoteParam createVoteParam,User user ){
        Vote vote = constructVote(createVoteParam,user);
        voteDao.insertOneVote(vote);
        voteOptionDao.insertOptions(constructVoteOptionList(createVoteParam,vote.getId()));
        return true;
    }

    public Vote selectVoteInfoById(int id){
        return voteDao.selectVoteById(id);
    }

    public List<VoteOption> selectOptiionListById(int id){
        return voteOptionDao.selectVoteOptionListById(id);
    }

    public boolean addVoteRecord(List<VoteRecordParam> voteRecordParamList, HttpServletRequest request){
        List<VoteRecord> voteRecordList = constructVoteRecordList(voteRecordParamList,request);
        int affectRows = voteRecordDao.addVoteRecord(voteRecordList);
        return affectRows > 0;
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

    private List<VoteRecord> constructVoteRecordList(List<VoteRecordParam> voteRecordParamList,HttpServletRequest request){
        List<VoteRecord> voteRecordList = new ArrayList<VoteRecord>();
        for(VoteRecordParam voteRecordParam:voteRecordParamList){
            VoteRecord voteRecord = new VoteRecord();
            voteRecord.setIP(RequestUtils.getIP(request));
            voteRecord.setdevice(RequestUtils.getUserAgent(request));
            voteRecord.setVoteId(voteRecordParam.getVoteID());
            voteRecord.setVoteOptionId(voteRecordParam.getOptionId());
            voteRecord.setEmail(voteRecordParam.getEmail());
            voteRecord.setPhone(voteRecordParam.getPhone());
            voteRecord.setQQ(voteRecordParam.getQQ());
            voteRecord.setWX(voteRecordParam.getWX());
            voteRecordList.add(voteRecord);
        }
        return voteRecordList;
    }
}
