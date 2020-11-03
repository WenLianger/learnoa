package com.example.demo.model;

import lombok.Data;

import java.sql.Blob;

@Data
public class userModel {
    private int id;
    private String name;
    private String password;
    private String role;
    private String userVerCode;
    private Blob img;
}
