package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDTO;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
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
            throw new ProductNotFoundException();
        }
        List<Product> products = new LinkedList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : productsArr.getBody()){
            products.add(fakeStoreProductDTO.getProductObjectFromDTO());
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(url + "/products/" + id, FakeStoreProductDTO.class);
        if(responseEntity.getBody() == null){
            throw new ProductNotFoundException();
        }
        return responseEntity.getBody().getProductObjectFromDTO();
    }

    @Override
    public void deleteProductById(Long id) {

    }

    @Override
    public void addProduct(Product product) {

    }

    @Override
    public void updateProductById(Product product) {

    }


}
