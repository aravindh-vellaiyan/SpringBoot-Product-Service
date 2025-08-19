package com.productservice.controllers.advices;

import com.productservice.controllers.ProductController;
import com.productservice.dtos.ExceptionDTO;
import com.productservice.exceptions.ProductNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
//@ControllerAdvice(assignableTypes = ProductController.class)
public class ProductControllerAdvice {

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<ExceptionDTO> handlePNFException(ProductNotFoundException exception){
        return new ResponseEntity<>(new ExceptionDTO(exception.getMessage(), "Failure"), HttpStatus.NOT_FOUND);
    }
}
