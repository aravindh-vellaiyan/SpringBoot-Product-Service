package com.productservice.services;

import com.productservice.models.Category;
import com.productservice.models.Product;
import com.productservice.repositories.CategoryRepository;
import com.productservice.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository){
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return this.productRepository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        Optional<Product> optionalProduct = this.productRepository.findById(id);
        return optionalProduct.orElse(null);
    }

    @Override
    public Product deleteProductById(Long id) {
        Optional<Product> productOptional = this.productRepository.findById(id);
        if(productOptional.isPresent()){
            this.productRepository.deleteById(id);
            return productOptional.get();
        }
        return null;
    }

    @Override
    public Product addProduct(Product product) {
        Optional<Category> categoryOptional = this.categoryRepository.findByName(product.getCategory().getName());
        if(categoryOptional.isPresent()){
            product.setCategory(categoryOptional.get());
        } else {
            Category category = categoryRepository.save(product.getCategory());
            product.setCategory(category);
        }
        return this.productRepository.save(product);
    }

    @Override
    public Product updateProductById(Long id, Product product) {
        return this.productRepository.findById(id)
                .map(existingProduct -> {
                    existingProduct.setPrice(product.getPrice());
                    existingProduct.setDescription(product.getDescription());
                    existingProduct.setTitle(product.getTitle());
                    existingProduct.setCategory(this.categoryRepository.findByName(product.getCategory().getName()).get());
                    return productRepository.save(existingProduct);
                }).orElseThrow();
    }
}
