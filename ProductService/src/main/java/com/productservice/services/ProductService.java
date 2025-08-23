package com.productservice.services;

import com.productservice.exceptions.ProductException;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    public List<Product> getAllProducts() throws ProductNotFoundException;
    public Product getProductById(Long id) throws ProductNotFoundException;
    public Product deleteProductById(Long id);
    public Product addProduct(Product product) throws ProductException;
    public Product updateProductById(Long id, Product product) throws ProductNotFoundException;
}
