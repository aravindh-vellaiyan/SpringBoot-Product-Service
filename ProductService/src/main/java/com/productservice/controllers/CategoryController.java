package com.productservice.controllers;

import com.productservice.models.Category;
import com.productservice.repositories.CategoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {

    CategoryRepository categoryRepository;

    public CategoryController(CategoryRepository categoryRepository){
        this.categoryRepository = categoryRepository;
    }

    @GetMapping("/categories/{id}")
    public Category getCategoryById(@PathVariable("id") Long id){
        return this.categoryRepository.findById(id).get();
    }
}
