package com.example.demo.common.utils;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.digest.DigestUtil;

public class CryptionKit {
    //生成初始密码
    public static String genUserPwd(){
        return DigestUtil.md5Hex("123456");
    }

    public static String genUserPwd(String pwd){
        if(StrUtil.isEmpty(pwd)){
            return genUserPwd();
        }
        return DigestUtil.md5Hex(pwd);
    }
}
