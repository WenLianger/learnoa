package com.example.demo.model;

import lombok.Data;

import java.util.Date;

@Data
public class deptModel {
    private Long id;
    private Long parentId;
    private String name;
    private Integer type;
    private Long areaId;
    private Integer sort;
    private Integer status;
    private Date updateTime;
    private Long createBy;
    private Date createTime;
}
