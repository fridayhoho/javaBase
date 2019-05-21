package com.test.mybatis.dao;

import com.test.mybatis.pojo.User;

public interface UserDAO {

    // 根据 id 查询用户信息
    public User findUserById(int id) throws Exception;
}