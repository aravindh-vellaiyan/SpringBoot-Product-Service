package com.productservice.models;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class Product extends BaseModel{
    private Long id;
    private String title;
    private String desc;
    private Long price;
    private Category category;
    private List<String> allowedUsers;
}
