package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("sys/user")
public class userController {
    @RequiresPermissions("sys:user:index")
    @RequestMapping("index")
    public ModelAndView index(){
        return new ModelAndView("sys/user");}

}
