package com.productservice.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
public class Product extends BaseModel{
    private String title;
    private String desc;
    private Long price;
    @ManyToOne
    private Category category;
//    private List<String> allowedUsers;
}
