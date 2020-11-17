package com.example.demo.controller;

import com.example.demo.common.dto.R;
import com.example.demo.service.deptService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("sys/dept")
public class deptController {
    @Autowired
    private deptService deptService;

    @RequiresPermissions("sys:dept:index")
    @RequestMapping("index")
    public ModelAndView index(){return new ModelAndView("sys/dept");}

    @GetMapping(value = "get/{id}")
    public R get(@PathVariable Long id) {
        return R.ok(deptService.getById(id));
    }
}
