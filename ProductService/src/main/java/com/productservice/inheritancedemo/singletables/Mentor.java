package com.productservice.inheritancedemo.singletables;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "ST_Mentor")
@DiscriminatorValue(value = "2")
public class Mentor extends User {
    private int rating;
}
