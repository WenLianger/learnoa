package com.example.demo.controller;

import com.example.demo.common.dto.R;
import com.example.demo.common.utils.Shiro;
import com.example.demo.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @Autowired
    private IMenuService menuService;

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @ResponseBody
    @GetMapping("/index/navMenus")
    public R navMenus() {
        return R.ok(menuService.listUserPermissionNavMenuByUserId(Shiro.getUserId()));
    }

    @ResponseBody
    @GetMapping("/index/menus")
    public R menus() {
        return R.ok(menuService.listUserPermissionMenuWithSubByUserId(Shiro.getUserId()));
    }
}
