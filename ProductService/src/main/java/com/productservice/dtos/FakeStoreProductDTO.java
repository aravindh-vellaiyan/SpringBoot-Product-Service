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

    public Product getProductObjectFromDTO(){
        Product product = new Product();
        product.setId(this.getId());
        product.setDesc(this.getDescription());
        product.setTitle(this.getTitle());
        product.setPrice(this.getPrice());
        product.setCategory(new Category(null, this.getCategory()));
        return product;
    }
}
