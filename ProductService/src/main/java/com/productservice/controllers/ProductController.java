package com.productservice.controllers;

import com.productservice.exceptions.ProductException;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Category;
import com.productservice.models.Product;
import com.productservice.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(@Qualifier("FakeStoreImpl") ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getAllProducts() throws ProductNotFoundException {
        return productService.getAllProducts();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(id);
    }

    @GetMapping("/category/")
    public List<Product> getProductsByCategory(Category category){
        return null;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product){
        return productService.addProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable Long id){
        return productService.deleteProductById(id);
    }

}
