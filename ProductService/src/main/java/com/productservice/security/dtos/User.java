package com.productservice.security.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class User {
    private long id;
    private String name;
    private List<Role> roles;
    private String hashedPassword;
    private String email;
    private boolean isEmailVerified;
}

