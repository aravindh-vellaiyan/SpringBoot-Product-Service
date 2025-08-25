package com.productservice.repositories;

import com.productservice.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Override
//    Optional<Product> findById(Long id);
}
