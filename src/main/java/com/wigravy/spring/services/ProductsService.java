package com.wigravy.spring.services;


import com.wigravy.spring.entity.Product;
import com.wigravy.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductsService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getAllProducts() {
        return productRepository.getProductsList();
    }


    public void addProduct(Product product) {
        productRepository.addProduct(product);
    }
}