package com.keaper.vote.persistence.dao;

import com.keaper.vote.persistence.po.VoteRecord;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface VoteRecordDao {

    /**
     * 添加投票记录
     * @param voteRecordList
     * @return
     */
    int addVoteRecord(List<VoteRecord> voteRecordList);

}
