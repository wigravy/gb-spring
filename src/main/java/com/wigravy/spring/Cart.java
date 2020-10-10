package com.wigravy.spring;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Scope(value = "prototype")
public class Cart {
    private List<Product> productsInCart;
    private ProductRepository productRepository;

    @PostConstruct
    public void init() {
        productsInCart = new ArrayList<>();
    }

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    public void addProduct(Long id) {
        try {
            productsInCart.add(productRepository.getProductById(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }


    public void removeProduct(Long id) {
        try {
            productsInCart.remove(productRepository.getProductById(id));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    public void printProductList() {
        System.out.println("Products in cart:");
        for (Product product : productsInCart) {
            System.out.println(product);
        }
    }
}
