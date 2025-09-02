package com.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"name"}))
public class Category extends BaseModel {
    private String name;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "category")
    List<Product> products;
}
