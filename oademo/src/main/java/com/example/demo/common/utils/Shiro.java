package com.example.demo.common.utils;

import com.example.demo.model.userModel;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Shiro {
    public static userModel getUser() {
        return (userModel) SecurityUtils.getSubject().getPrincipal();
    }

    public static Subject getSubject() {
        return SecurityUtils.getSubject();
    }

    public static Session getSession() {
        return SecurityUtils.getSubject().getSession();
    }

    public static void setSessionAttribute(Object key, Object value) {
        getSession().setAttribute(key, value);
    }

    public static int getUserId() {
        return getUser().getId();
    }
}
