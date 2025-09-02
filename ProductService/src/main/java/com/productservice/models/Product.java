package com.productservice.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Product extends BaseModel{
    private String title;
    private String description;
    private Long price;
    @ManyToOne(cascade = CascadeType.ALL)
    @JsonIgnoreProperties("products")
    private Category category;
}
