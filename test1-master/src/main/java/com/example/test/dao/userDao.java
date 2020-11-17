package com.example.test.dao;

import com.example.test.model.userModel;

import java.util.List;

public interface userDao {
    //登录时信息核对
    userModel getInfo(String name,String password);

    //根据ID查询用户信息
    userModel selectUserById(String id);

    //插入新的用户
    int insertUser(userModel userModel);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(userModel userModel);

    //查询所有用户
    List<userModel> getAllUser();
}
