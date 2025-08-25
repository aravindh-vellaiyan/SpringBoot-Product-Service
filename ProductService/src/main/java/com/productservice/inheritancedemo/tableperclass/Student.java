package com.productservice.inheritancedemo.tableperclass;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "TPC_Student")
@Getter
@Setter
public class Student extends User {
    private int psp;
    private String batch;
}
