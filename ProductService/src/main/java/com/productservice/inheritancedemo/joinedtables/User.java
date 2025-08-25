package com.productservice.inheritancedemo.joinedtables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "JT_User")
@Inheritance(strategy = InheritanceType.JOINED)
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}
