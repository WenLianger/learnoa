package com.example.demo;

import com.example.demo.model.userModel;
import com.example.demo.service.userService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTest {
    @Autowired
    userService userService;

    @Test
    public void contextLoads() {
        userModel userModel = userService.loginIn("admin","123456");
        System.out.println("该用户ID为：");
        System.out.println(userModel.getId());
    }
}
