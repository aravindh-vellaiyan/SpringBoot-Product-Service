package com.productservice.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class Category extends BaseModel {
    private Long id;
    private String name;
}
