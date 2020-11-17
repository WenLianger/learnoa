package com.example.test.model;

import lombok.Data;

@Data
public class userModel {
    private int id;
    private String name;
    private String password;
    private String role;
    private String userVerCode;
}
