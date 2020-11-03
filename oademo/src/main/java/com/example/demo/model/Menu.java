package com.example.demo.model;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Menu {
    /**
     * 主键
     */
//    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 父菜单ID，一级菜单为0
     */
    private Long parentId;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权标识(多个用逗号分隔，如：user:list,user:create)
     */
    private String permission;

    /**
     * 类型。0：模块；1：一级菜单；2：二级菜单；3：导航菜单
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 状态。0：正常；1：禁用
     */
    private Integer status;

    /**
     * 排序值。越小越靠前
     */
    private Integer sort;

    /**
     * 创建人
     */
    private Long createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 子级菜单列表
     */
//    @TableField(exist = false)
    private List<Menu> subMenus;
}
