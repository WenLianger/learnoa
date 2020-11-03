package com.example.demo.serviceImpl;

import com.example.demo.dao.userDao;
import com.example.demo.model.userModel;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class serviceImpl implements userService {
    @Autowired(required = false)
    private userDao userDao;

    //登录验证
    @Override
    public userModel loginIn(String name, String password){
        return userDao.getInfo(name,password);
    }

    //根据id查询用户信息
    @Override
    public userModel queryUserById(String id){
        return userDao.selectUserById(id);
    }

    //新增用户
    @Override
    public int addUser(userModel userModel){
        return userDao.insertUser(userModel);
    }

    //根据id删除用户
    @Override
    public int dropUser(String id){
        return userDao.deleteUser(id);
    }

    //修改用户信息
    @Override
    public int modifyUser(userModel userModel){
        return userDao.updateUser(userModel);
    }

    //查询所有用户信息
    @Override
    public List<userModel> queryAllUser(){
        return userDao.getAllUser();
    }

    @Override
    public userModel getByUsername(String username) {
        return userDao.selectUserByUsername(username);
    }
}
