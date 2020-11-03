package com.example.demo.common.shiro;

import cn.hutool.core.codec.Base64;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public MyRealm myAuthRealm(){
        MyRealm myRealm=new MyRealm();
        return myRealm;
    }

    /**
     * 集成缓存
     * @return sessionManager
     */
    @Bean("sessionManager")
    public SessionManager sessionManager() {
        DefaultWebSessionManager sessionManager = new DefaultWebSessionManager();
        //设置session过期时间(单位：毫秒)，默认为15分钟
        sessionManager.setGlobalSessionTimeout(1000 * 60 * 15);
        sessionManager.setSessionValidationSchedulerEnabled(true);
        sessionManager.setSessionIdUrlRewritingEnabled(false);

        return sessionManager;
    }

    @Bean("securityManager")
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(myAuthRealm());
        securityManager.setSessionManager(sessionManager());
        securityManager.setRememberMeManager(rememberMeManager());
        return securityManager;
    }

    /**
     * Cookie对象
     * @return simpleCookie
     */
    private SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("testMe");
        // 记住时间，单位秒，默认15天
        simpleCookie.setMaxAge(60 * 60 * 24 * 15);
        return simpleCookie;
    }

    /**
     * cookie管理对象;
     * @return cookieRememberMeManager
     */
    private CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        // rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
        return cookieRememberMeManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
        shiroFilter.setSecurityManager(securityManager);
        shiroFilter.setLoginUrl("/login");
        shiroFilter.setSuccessUrl("/users");
        shiroFilter.setUnauthorizedUrl("/error");

        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/static/**", "anon");
        filterMap.put("/login", "anon");
        filterMap.put("/druid/**", "anon");
        filterMap.put("/captcha", "anon");

        filterMap.put("/users", "authc");
        filterMap.put("/sys/**","authc");
        shiroFilter.setFilterChainDefinitionMap(filterMap);
        return shiroFilter;
    }
}
