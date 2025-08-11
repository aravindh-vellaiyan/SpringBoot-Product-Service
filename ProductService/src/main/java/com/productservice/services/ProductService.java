package com.productservice.services;

import com.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(Long id);
    public void deleteProductById(Long id);
    public void addProduct(Product product);
    public void updateProductById(Product product);
}
