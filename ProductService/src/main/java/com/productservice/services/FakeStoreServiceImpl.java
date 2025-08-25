package com.productservice.services;

import com.productservice.thirdpartyclients.FakeStoreClient;
import com.productservice.dtos.FakeStoreProductDTO;
import com.productservice.exceptions.ProductException;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.models.Category;
import com.productservice.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("FakeStoreImpl")
public class FakeStoreServiceImpl implements ProductService {

    private  final FakeStoreClient client;

    @Autowired
    public FakeStoreServiceImpl(FakeStoreClient client){
        this.client = client;
    }

    @Override
    public List<Product> getAllProducts() throws ProductNotFoundException {
        List<FakeStoreProductDTO> fakeStoreProductDTOS = client.getAllProducts();
        List<Product> products = new LinkedList<>();
        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS){
            products.add(getProductObjectFromDTO(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product getProductById(Long id) throws ProductNotFoundException {
        return getProductObjectFromDTO(client.getProductById(id));
    }

    @Override
    public Product deleteProductById(Long id) {
        return getProductObjectFromDTO(client.deleteProductById(id));
    }

    @Override
    public Product addProduct(Product product)  throws ProductException {
        return getProductObjectFromDTO(client.addProduct(getDTOFromProduct(product)));
    }

    @Override
    public Product updateProductById(Long id, Product product) throws ProductNotFoundException {
        return getProductObjectFromDTO(client.updateProduct(id, getDTOFromProduct(product)));
    }

    private Product getProductObjectFromDTO(FakeStoreProductDTO fakeStoreProductDTO){
        Product product = new Product();
//        product.setId(fakeStoreProductDTO.getId());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        Category category = new Category();
        category.setName(fakeStoreProductDTO.getCategory());
        product.setCategory(category);
        return product;
    }

    private FakeStoreProductDTO getDTOFromProduct(Product product){
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        return fakeStoreProductDTO;
    }
}
