package com.example.demo.dao;

import com.example.demo.model.Menu;

import java.util.List;

public interface MenuDao {
    List<Menu> selectUserPermissionNavMenuList(int userId);
    List<Menu> selectUserPermissionMenuList(long parentId,int userId);
    List<String> selectPermission(int userId);
}
