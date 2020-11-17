package com.example.test.service;

import com.example.test.model.userModel;

import java.util.List;

public interface userService {
    userModel loginIn(String name,String password);

    //根据id查询用户信息
    userModel queryUserById(String id);

    //插入新的用户
    int addUser(userModel userModel);

    //删除用户
    int dropUser(String id);

    //修改用户
    int modifyUser(userModel userModel);

    //查询所有用户
    List<userModel> queryAllUser();
}
