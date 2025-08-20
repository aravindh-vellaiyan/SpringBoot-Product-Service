package com.productservice.thirdpartyclients;

import com.productservice.dtos.FakeStoreProductDTO;
import com.productservice.exceptions.ProductException;
import com.productservice.exceptions.ProductNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Component
public class FakeStoreClient {

    private final String url = "https://fakestoreapi.com";

    private final RestTemplateBuilder rtBuilder;

    @Autowired
    public FakeStoreClient(RestTemplateBuilder builder){
        this.rtBuilder = builder;
    }

    public List<FakeStoreProductDTO> getAllProducts() throws ProductNotFoundException {
        RestTemplate template = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO[]> productsArr = template.getForEntity(url + "/products", FakeStoreProductDTO[].class);
        if(productsArr.getBody() == null){
            throw new ProductNotFoundException("Products not available.!");
        }
        return new LinkedList<>(Arrays.asList(productsArr.getBody()));
    }

    public FakeStoreProductDTO getProductById(Long id) throws ProductNotFoundException {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.getForEntity(url + "/products/" + id, FakeStoreProductDTO.class);
        if(responseEntity.getBody() == null){
            throw new ProductNotFoundException("Product not found for the Id " + id);
        }
        return responseEntity.getBody();
    }

    public FakeStoreProductDTO deleteProductById(Long id) {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.exchange(url + "/products/{id}", HttpMethod.DELETE, null, FakeStoreProductDTO.class, id);
        if(responseEntity.getBody() == null){
            throw new ProductException("Unable to delete the product for the Id " + id);
        }
        return responseEntity.getBody();
    }

    public FakeStoreProductDTO addProduct(FakeStoreProductDTO product)  throws ProductException {
        RestTemplate restTemplate = rtBuilder.build();
        ResponseEntity<FakeStoreProductDTO> responseEntity = restTemplate.postForEntity(url + "/products", product, FakeStoreProductDTO.class);
        if(responseEntity.getBody() == null){
            throw new ProductException("Unable to add the product");
        }
        return responseEntity.getBody();
    }
}
