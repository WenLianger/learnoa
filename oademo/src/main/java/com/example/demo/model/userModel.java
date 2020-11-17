package com.example.demo.model;

import lombok.Data;

import java.sql.Blob;
import java.util.Date;

@Data
public class userModel {
    private int id;
    private String username;
    private String password;
    private String role;
    private Long deptId;
    private String realname;
    private Integer sex;
    private String phone;
    private String tel;
    private String email;
    private String jobTitle;
    private Integer status;
    private Integer sort;
    private Integer delFlag;
    private Long createBy;
    private Date updateTime;
    private Date createTime;
    private String userVerCode;
    private Blob img;
}
