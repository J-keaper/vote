package com.keaper.vote.persistence.dao;

import com.keaper.vote.persistence.po.ResetPasswordInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;

@Repository
public interface ResetPasswordDao{

    /**
     * 插入一条记录
     * @return
     */
    boolean insertOneRecord(ResetPasswordInfo resetPasswordInfo);

    /**
     * 查ID是否存在
     * @param id
     * @return
     */
    boolean selectExistId(@Param("id") int id);

    /**
     * 查Token是否存在
     * @param token
     * @return
     */
    boolean selectExistToken(@Param("token") String token);


    /**
     * 根据ID更新，用于重新生成
     * @return
     */
    boolean updateOneRecord(ResetPasswordInfo resetPasswordInfo);

    /**
     * token查id
     * @param token
     * @return
     */
    int selectIdByToken(@Param("token") String token);

    /**
     * 删除记录
     * @param id
     * @return
     */
    int deleteOneRecord(@Param("id") int id);

    /**
     * 根据ID查信息
     * @param id
     * @return
     */
    ResetPasswordInfo selectInfoById(@Param("id") int id);
}
