package com.example.demo.common.dto;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.Data;

import java.io.Serializable;
@Data
public class R implements Serializable {
    private Integer code;
    private String msg;
    private Object data;
    private int total;

    public R() {}

    private R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        if (data instanceof Page<?>) {
            Page<?> page = (Page<?>) data;
            this.total = page.getRecords().size();
            this.data = page.getRecords();
        } else {
            this.data = data;
        }
    }

    public static R ok(){ return new R(200,"请求成功",null); }

    public static R ok(Object data){ return new R(200,"请求成功",data); }

    public static R ok(String msg,Object data){ return new R(200,msg,data); }

    public static R fail(String msg){ return new R(400,msg,null);}

    public static R fail(int code,String msg){ return new R(code,msg,null);}
}
