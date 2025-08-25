package com.productservice.inheritancedemo.singletables;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ST_User")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "User_Type", discriminatorType = DiscriminatorType.INTEGER)
@DiscriminatorValue(value = "0")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String email;
    private String password;
}
