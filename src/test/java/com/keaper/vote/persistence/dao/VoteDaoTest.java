package com.keaper.vote.persistence.dao;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.common.model.ValidateRule;
import com.keaper.vote.persistence.po.Vote;
import org.junit.Test;

import javax.annotation.Resource;

import static org.junit.Assert.*;

public class VoteDaoTest extends BaseSpringTest{

    @Resource
    private VoteDao voteDao;

    @Test
    public void insertOneVote() throws Exception {
        Vote vote = new Vote();
        vote.setCreatorId(1);
        vote.setTitle("选举");
        vote.setIPValidateRule(ValidateRule.fromCode(0));
        vote.setDeviceValidateRule(ValidateRule.fromCode(0));
        vote.setEmailValidateRule(ValidateRule.fromCode(0));
        vote.setPhoneValidateRule(ValidateRule.fromCode(0));
        vote.setQQValidateRule(ValidateRule.fromCode(0));
        vote.setWXValidateRule(ValidateRule.fromCode(0));

        System.out.println(voteDao.insertOneVote(vote));
        System.out.println(vote.getId());

    }


    @Test
    public void selectVoteById(){
        Vote vote = voteDao.selectVoteById(1);
        System.out.println(vote);
    }

}