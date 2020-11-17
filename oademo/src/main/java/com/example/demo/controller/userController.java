package com.example.demo.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.demo.common.dto.R;
import com.example.demo.model.userModel;
import com.example.demo.service.userService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("sys/user")
public class userController {
    @Autowired
    private userService userService;

    @RequiresPermissions("sys:user:index")
    @GetMapping("index")
    public ModelAndView index(){return new ModelAndView("sys/user");}

    @GetMapping("list/data")
    public R listData(){
        Page<userModel> page = userService.listUserPage();
        return R.ok(page);
    }
}
