package com.keaper.vote.service;

import com.keaper.vote.BaseSpringTest;
import com.keaper.vote.model.RegisterParam;
import org.junit.Assert;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.UUID;

import static org.junit.Assert.*;

public class UserServiceTest extends BaseSpringTest {

    @Resource
    private UserService userService;

    @Test
    public void testUUID(){
        System.out.println(UUID.randomUUID().toString().replace("-",""));
    }

    @Test
    public void register() throws Exception {
        RegisterParam registerParam = new RegisterParam();
        registerParam.setNickName("Time");
        registerParam.setEmail("1273570694@qq.com");
        registerParam.setPhone("18434361007");
        registerParam.setPassword("123456");
        Assert.assertEquals(userService.register(registerParam),true);
    }



}