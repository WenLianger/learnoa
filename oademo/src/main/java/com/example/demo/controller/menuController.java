package com.example.demo.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("sys/menu")
public class menuController {
    @RequiresPermissions("sys:menu:index")
    @RequestMapping("index")
    public ModelAndView index(){return new ModelAndView("sys/menu");}
}
