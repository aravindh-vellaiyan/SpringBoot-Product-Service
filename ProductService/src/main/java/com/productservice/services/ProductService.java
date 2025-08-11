package com.productservice.services;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts() throws ProductNotFoundException;
    public Product getProductById(Long id) throws ProductNotFoundException;
    public void deleteProductById(Long id);
    public void addProduct(Product product);
    public void updateProductById(Product product);
}
