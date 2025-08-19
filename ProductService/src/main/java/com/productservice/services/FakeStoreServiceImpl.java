package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDTO;
import com.productservice.exceptions.ProductException;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Category;
import com.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedList;
import java.util.List;

@Service("FakeStoreImpl")
public class FakeStoreServiceImpl implements ProductService {

    private final String url = "https://fakestoreapi.com";

    private final RestTemplateBuilder rtBuilder;

    @Autowired
    public FakeStoreServiceImpl(RestTemplateBuilder builder){
        this.rtBuilder = builder;
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        RestTemplate template = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> productsArr = template.getForEntity(url + "/products", FakeStoreProductDTO[].class);
        if(productsArr.getBody() == null){
            throw new ProductNotFoundException("Products not available.!");
        }
        List<Product> products = new LinkedList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : productsArr.getBody()){
            products.add(getProductObjectFromDTO(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(url + "/products/" + id, FakeStoreProductDTO.class);
        if(responseEntity.getBody() == null){
            throw new ProductNotFoundException("Product not found for the Id " + id);
        }
        return getProductObjectFromDTO(responseEntity.getBody());
    }

    @Override
    public Product deleteProductById(Long id) {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.exchange(url + "/products/{id}", HttpMethod.DELETE, null, FakeStoreProductDTO.class, id);
        if(responseEntity.getBody() == null){
            throw new ProductException("Unable to delete the product for the Id " + id);
        }
        return getProductObjectFromDTO(responseEntity.getBody());
    }

    @Override
    public Product addProduct(Product product)  throws ProductException {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity(url + "/products", getDTOFromProduct(product), FakeStoreProductDTO.class);
        if(responseEntity.getBody() == null){
            throw new ProductException("Unable to add the product");
        }
        return getProductObjectFromDTO(responseEntity.getBody());
    }

    @Override
    public void updateProductById(Product product) {

    }

    public Product getProductObjectFromDTO(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setDesc(fakeStoreProductDTO.getDescription());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setCategory(new Category(null, fakeStoreProductDTO.getCategory()));
        return product;
    }

    public FakeStoreProductDTO getDTOFromProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setDescription(product.getDesc());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        return fakeStoreProductDTO;
    }
}
