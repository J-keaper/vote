package com.keaper.vote.persistence.dao;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.common.constants.ActivateStatus;
import com.keaper.vote.persistence.po.User;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.UUID;


public class UserDaoTest extends BaseSpringTest{

    @Resource
    private UserDao userDao;

    @Test
    public void selectUserInfoById() throws Exception {
        User user = userDao.selectUserInfoById(1);
        System.out.println(user);
    }

    @Test
    public void insertUser(){
        User user = new User();
        user.setNickName("哈哈");
        user.setEmail("18434361009@163.com");
        user.setPhone("18434361008");
        user.setPassword("123456");
        user.setActivateCode(UUID.randomUUID().toString().replace("-",""));
        user.setActivateStatus(ActivateStatus.INACTIVE);
        Assert.assertEquals(userDao.insertUser(user),1);
    }
}