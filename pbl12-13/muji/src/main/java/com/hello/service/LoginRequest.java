package com.hello.service;


import lombok.Data;

@Data
public class LoginRequest {
    private String loginId;
    private String password;
}
