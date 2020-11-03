package com.example.demo.common.shiro;

import com.example.demo.common.utils.CryptionKit;
import com.example.demo.model.userModel;
import com.example.demo.service.IMenuService;
import com.example.demo.service.userService;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class MyRealm extends AuthorizingRealm {
    @Lazy
    @Autowired
    private userService userService;

    @Lazy
    @Autowired
    private IMenuService menuService;

    //给用户分配权限
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        userModel user=(userModel) principalCollection.getPrimaryPrincipal();
        int userId=user.getId();
        List<String> permsList=menuService.getPermission(userId);

        //用户权限列表
        Set<String> permsSet=new HashSet<>();
        for(String perms:permsList){
            if(StringUtils.isBlank(perms)){
                continue;
            }
            System.out.println(perms);
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }

        SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);
        return info;
    }
    //验证用户身份
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        userModel user = userService.getByUsername(token.getUsername());
        if(user==null){
            throw new UnknownAccountException("账号或密码不正确");
        }
        String password = CryptionKit.genUserPwd(new String((char [])token.getCredentials()));
        if(!user.getPassword().equals(password)){
            throw new IncorrectCredentialsException("账号或密码不正确");
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
//        System.out.println("user.getPassword:"+user.getPassword());//加密后
//        System.out.println("token.getCredentials:"+(new String((char [])token.getCredentials())));//未加密
//        return new SimpleAuthenticationInfo(user,new String((char [])token.getCredentials()),getName());
    }
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName("MD5");
        shaCredentialsMatcher.setHashIterations(1);
        super.setCredentialsMatcher(shaCredentialsMatcher);
//        super.setCredentialsMatcher(credentialsMatcher);
    }
}
