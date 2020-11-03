package com.example.demo.controller;

import com.example.demo.model.userModel;
import com.example.demo.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class modifyUserController {
    @Autowired
    userService userService;

    /**
     * 查询所有用户信息
     * @param modelMap
     * @return
     */
    @RequestMapping("/users")
    public String showUsers(ModelMap modelMap){
        List<userModel> userList=userService.queryAllUser();
        modelMap.addAttribute("userList",userList);
        return "users";
    }

    /**
     * 新增用户
     * remark：这里未做用户名是否重复校验
     * @param userModel
     * @return
     */
    @RequestMapping("/addUser")
    @ResponseBody
    public Map addUser(userModel userModel){
        int flag=userService.addUser(userModel);
        Map<String,Object> map = new HashMap<>();
        if(flag==1){
            map.put("msg","新增用户成功");
        }else{
            map.put("msg","新增用户失败");
        }
        return map;
    }

    /**
     * 根据用户ID删除用户信息
     * @param id
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/deleteUser+{id}")
    public String dropUser(@PathVariable("id") String id,ModelMap modelMap){
        int flag=userService.dropUser(id);
        List<userModel> userList = userService.queryAllUser();
        modelMap.addAttribute("userList",userList);
        if(flag==1){
            return "users";
        }else{
            return "error";
        }
    }

    /**
     * 根据用户ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping("/user+{id}")
    public String queryUser(@PathVariable("id") String id,ModelMap modelMap){
        userModel userModel = userService.queryUserById(id);
        modelMap.addAttribute("user",userModel);

        return "userInfo";
    }

    /**
     * 根据用户ID修改用户信息
     * remark：这里未做用户名是否重复校验
     * @param userModel
     * @return
     */
    @RequestMapping("/modifyUser")
    @ResponseBody
    public Map modifyUser(userModel userModel){
        int flag = userService.modifyUser(userModel);
        Map<String,Object> map = new HashMap<>();
        if(flag==1){
            map.put("msg","修改用户信息成功");
        }else{
            map.put("msg","修改用户信息失败");
        }
        return map;
    }
}
