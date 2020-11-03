package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.model.Menu;
import java.util.List;

public interface IMenuService{
    /**
     *
     */
    List<Menu> listUserPermissionMenu(long parentId,int userId);

    /**
     * 获取用户有权限的导航菜单列表（用于横向导航菜单）
     * @param userId 用户ID
     * @return
     */
    List<Menu> listUserPermissionNavMenuByUserId(int userId);

    /**
     * 获取用户带权限的菜单，带子级菜单。这里只需要获取到第二层菜单即可
     * @param userId 用户ID
     * @return
     */
    List<Menu> listUserPermissionMenuWithSubByUserId(int userId);

    List<String> getPermission(int userId);

}
