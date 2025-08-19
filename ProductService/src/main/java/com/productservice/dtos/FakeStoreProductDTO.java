package com.productservice.dtos;

import com.productservice.models.Category;
import com.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private Long id;
    private String title;
    private String description;
    private Long price;
    private String category;
}
