package com.keaper.vote.service;

import com.keaper.vote.common.constants.ActivateStatus;
import com.keaper.vote.model.LoginParam;
import com.keaper.vote.model.RegisterParam;
import com.keaper.vote.persistence.dao.UserDao;
import com.keaper.vote.persistence.po.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.UUID;

@Service
public class UserService {

    private static Logger logger = LoggerFactory.getLogger(UserService.class);

    @Resource
    private UserDao userDao;

    public boolean register(RegisterParam registerParam) {
        logger.info("注册参数：{}",registerParam);
        User user = generateUser(registerParam);
        logger.info("user :{}",user);
        int affectRows = userDao.insertUser(user);
        return affectRows >= 1;
    }


    public User login(LoginParam loginParam){
        logger.info("登录参数：{}",loginParam);
        return userDao.selectUserByEmailAndPassword(loginParam.getEmail(),loginParam.getPassword());
    }

    private User generateUser(RegisterParam registerParam) {
        User user = new User();
        user.setNickName(registerParam.getNickName());
        user.setPassword(registerParam.getPassword());
        user.setEmail(registerParam.getEmail());
        user.setPhone(registerParam.getPhone());
        user.setActivateStatus(ActivateStatus.INACTIVE);
        user.setActivateCode(UUID.randomUUID().toString().replaceAll("-", ""));
        return user;
    }
}
