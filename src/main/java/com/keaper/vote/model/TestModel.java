package com.keaper.vote.model;

import com.keaper.vote.persistence.po.User;

public class TestModel {

    String name;

    User user;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "TestModel{" +
                "name='" + name + '\'' +
                ", user=" + user +
                '}';
    }
}
