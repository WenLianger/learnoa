package com.example.demo.controller;

import com.example.demo.common.utils.HttpServletContextKit;
import com.example.demo.common.utils.Shiro;
import com.example.demo.model.userModel;
import com.example.demo.service.userService;
import com.wf.captcha.utils.CaptchaUtil;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class LoginController {

    @Autowired
    userService userService;

    @RequestMapping("/login")
    public String show(){
        return "login";
    }

    @RequestMapping(value = "/loginIn",method = RequestMethod.POST)
    @ResponseBody
    public Map login(userModel userModel){
        String name=userModel.getUsername();
        String password=userModel.getPassword();
        String uservercode=userModel.getUserVerCode();
        Map<String,Object> map=new HashMap<>();
//        // 验证码校验
//        HttpServletRequest request = HttpServletContextKit.getHttpServletRequest();
//        if (!CaptchaUtil.ver(uservercode, request)) {
//            CaptchaUtil.clear(request);  // 清除session中的验证码
//            map.put("msg","验证码不正确");
//            return map;
//        }

        try {
            Subject subject = Shiro.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(name, password);
            subject.login(token);
            Shiro.setSessionAttribute("user", name);
            map.put("msg","登录成功");
        }catch (Exception e){
            map.put("msg",e.getMessage());
        }
        return map;
    }

    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request,response);
    }
}
