package com.hello.service;

import lombok.Data;

@Data
public class SignupRequest {
    private String userId;
    private String password;
    private String name;
}
