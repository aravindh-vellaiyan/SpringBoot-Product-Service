package com.productservice.controllers;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import com.productservice.services.ProductService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    private ProductController productController;

    @MockBean
    private ProductService productService;

    @Test
    void getProductById() throws ProductNotFoundException {
        //Arrange
        Product dummy = new Product();
        dummy.setTitle("Dummy product");
        dummy.setId(1L);
        when(productService.getProductById(1L)).thenReturn(dummy);

        //Act
        Product product = productController.getProductById(1L);

        //Assert
        assertEquals(1L, product.getId());
    }
}