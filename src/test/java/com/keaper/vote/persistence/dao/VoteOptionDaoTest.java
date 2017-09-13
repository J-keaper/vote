package com.keaper.vote.persistence.dao;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.persistence.po.Vote;
import com.keaper.vote.persistence.po.VoteOption;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VoteOptionDaoTest extends BaseSpringTest{


    @Resource
    private  VoteOptionDao voteOptionDao;

    @Test
    public void insertOptions() throws Exception {
        List<VoteOption> voteOptionList = new ArrayList<VoteOption>();
        VoteOption voteOption = new VoteOption();
        voteOption.setVoteId(1);
        voteOption.setImageUrl("");
        voteOption.setExternalLink("www.baidu.com");
        voteOption.setRankPosition(1);
        voteOptionList.add(voteOption);
        voteOptionDao.insertOptions(voteOptionList);
    }


    @Test
    public void selectVoteOptionListById(){
        System.out.println(voteOptionDao.selectVoteOptionListById(1));
    }
}