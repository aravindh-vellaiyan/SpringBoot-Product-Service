package com.productservice.inheritancedemo.joinedtables;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "JT_Student")
@Getter
@Setter
public class Student extends User {
    private int psp;
    private String batch;
}
