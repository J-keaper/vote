package com.keaper.vote.persistence.dao;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.persistence.po.VoteRecord;
import org.junit.Test;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class VoteRecordDaoTest extends BaseSpringTest{

    @Resource
    private  VoteRecordDao voteRecordDao;

    @Test
    public void addOneRecord() throws Exception {
        List<VoteRecord> voteRecordList = new ArrayList<VoteRecord>();
        VoteRecord voteRecord = new VoteRecord();
        voteRecord.setVoteId(1);
        voteRecord.setVoteOptionId(1);
        voteRecordList.add(voteRecord);
        voteRecordDao.addVoteRecord(voteRecordList);


    }

}