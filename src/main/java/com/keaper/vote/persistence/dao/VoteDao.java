package com.keaper.vote.persistence.dao;

import com.keaper.vote.persistence.po.Vote;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;


@Repository
public interface VoteDao {

    /**
     * 新增投票
     * @return 主键ID
     */
    int insertOneVote(Vote vote);

    /**
     * 查询投票信息通过ID
     */
    Vote selectVoteById(@Param("id") int id);

    /**
     * 增加访问量
     * @param id
     * @return
     */
    boolean addOneAccessCount(@Param("id") int id);

}
