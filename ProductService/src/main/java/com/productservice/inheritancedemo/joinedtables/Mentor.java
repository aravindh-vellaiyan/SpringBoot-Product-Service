package com.productservice.inheritancedemo.joinedtables;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "JT_Mentor")
public class Mentor extends User {
    private int rating;
}
