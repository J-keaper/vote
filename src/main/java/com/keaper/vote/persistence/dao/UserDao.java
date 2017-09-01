package com.keaper.vote.persistence.dao;


import com.keaper.vote.persistence.po.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {

    /**
     * 根据ID查用户信息
     * @param id
     * @return
     */
    User selectUserInfoById(Integer id);

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
    User selectUserByEmailAndPassword(String email, String password);
}
