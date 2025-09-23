package com.productservice.controllers;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import com.productservice.services.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
//    @InjectMocks
    private ProductController productController;

    @MockBean
//    @Mock
    private ProductService productService;

//    @BeforeEach
//    public void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }

    @Test
    void getProductById() throws ProductNotFoundException {
        //Arrange
//        Product dummy = new Product();
//        dummy.setTitle("Dummy product");
//        dummy.setId(1L);
        when(productService.getProductById(1L)).thenThrow(new ProductNotFoundException("Product not found."));

        //Act
//        Product product = productController.getProductById(1L);
        assertThrows(ProductNotFoundException.class, () -> productController.getProductById(null,1L));

        //Assert
//        assertEquals(1L, product.getId());
    }
}