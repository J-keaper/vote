package com.keaper.vote.persistence.dao;


import com.keaper.vote.persistence.po.VoteOption;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteOptionDao {

    /**
     * 插入选项
     * @param voteOptionList
     * @return
     */
    int insertOptions(List<VoteOption> voteOptionList);

}
