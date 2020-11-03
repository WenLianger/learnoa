package com.example.demo.serviceImpl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dao.MenuDao;
import com.example.demo.model.Menu;
import com.example.demo.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired(required = false)
    private MenuDao menuDao;

    @Override
    public List<Menu> listUserPermissionNavMenuByUserId(int userId) {
        return menuDao.selectUserPermissionNavMenuList(userId);
    }

    @Override
    public List<Menu> listUserPermissionMenu(long parentId,int userId) {
        return menuDao.selectUserPermissionMenuList(parentId,userId);
    }

    @Override
    public List<Menu> listUserPermissionMenuWithSubByUserId(int userId) {
        List<Menu> menus = listUserPermissionMenu(0L,userId);
        menus.forEach(menu->{
            List<Menu> submenus = this.listUserPermissionMenu(menu.getId(),userId);
            menu.setSubMenus(submenus);
        });
        return menus;
    }

    @Override
    public List<String> getPermission(int userId){
        return menuDao.selectPermission(userId);
    }
}
