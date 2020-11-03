package com.example.demo.dao;

import com.example.demo.model.userModel;

import java.util.List;

public interface userDao {
    //登录时信息核对
    userModel getInfo(String name,String password);

    //根据ID查询用户信息
    userModel selectUserById(String id);
    //根据用户名查询用户信息
    userModel selectUserByUsername(String username);

    //插入新的用户
    int insertUser(userModel userBean);

    //删除用户
    int deleteUser(String id);

    //修改用户
    int updateUser(userModel userBean);

    //查询所有用户
    List<userModel> getAllUser();

}
