package com.productservice.repositories;

import com.productservice.models.Product;
import com.productservice.projections.ProductWithIdAndTitle;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

//    @Override
//    Optional<Product> findById(Long id);
//
//    Product findProductById(Long id);
//
//    Product findByPriceBetween(Long greaterthan, Long lessthan);
//
//    Product findByProductName(String productName);
//
//    String findTitleById(Long id);

    List<Product> findByIdIsNotNullOrderByPrice();

//    List<Product> findAllByIsPublicFalse();

    List<Product> findByTitleEquals(String title, Pageable pageable);

    @Query("select p from Product p where p.title = :title")
    List<Product> foo(@Param("title") String title);

    @Query("select p.id as id, p.title as title from Product p where p.title = :t")
    List<ProductWithIdAndTitle> foo1(@Param("t") String title);

    @Query(value = "select p.id as id from Product p where p.title = :title", nativeQuery = true)
    List<ProductWithIdAndTitle> foo2(@Param("title") String title);
}
