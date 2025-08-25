package com.productservice.inheritancedemo.singletables;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "ST_Student")
@DiscriminatorValue(value = "1")
@Getter
@Setter
public class Student extends User {
    private int psp;
    private String batch;
}
