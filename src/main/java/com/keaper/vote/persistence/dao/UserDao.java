package com.keaper.vote.persistence.dao;


import com.keaper.vote.persistence.po.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 根据ID查用户信息
     * @param id
     * @return
     */
    User selectUserInfoById(@Param("id") int id);

    /**
     * 根据email查用户
     * @param email
     * @return
     */
    boolean selectIdExistByEmail(@Param("email") String email);

    /**
     * 根据phone查用户
     * @param phone
     * @return
     */
    boolean selectIdExistByPhone(@Param("phone") String phone);

    /**
     * 根据昵称查用户
     * @param nickName
     * @return
     */
    boolean selectIDExistByNick(@Param("nickName") String nickName);


    /**
     * 插入新用戶
     * @param user
     * @return
     */
    int insertUser(User user);

    /**
     * 根据Email和Password查询User
     * @param email
     * @param password
     * @return
     */
    User selectUserByEmailAndPassword(@Param("email") String email,
                                      @Param("password") String password);
}
