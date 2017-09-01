package com.keaper.vote.utils;

import org.apache.commons.lang.RandomStringUtils;
import org.junit.Test;

public class RandomStringUtilsTest {


    @Test
    public void testRandomAlphanumeric(){
        String randomString = RandomStringUtils.randomAlphanumeric(4);
        System.out.println(randomString);
    }
}
