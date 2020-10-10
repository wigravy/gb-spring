package com.wigravy.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;



public class App {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProductApplicationConfig.class);
        ProductRepository productRepository = context.getBean("productRepository", ProductRepository.class);
        Cart cart = context.getBean("cart", Cart.class);
        Cart cart2 = context.getBean("cart", Cart.class);
        cart.addProduct(1L);
        cart.addProduct(2L);
        cart.addProduct(3L);
        cart.addProduct(3L);
        cart.addProduct(3L);
        cart.printProductList();
        cart.removeProduct(3L);
        cart.printProductList();

        cart2.addProduct(1L);
        cart2.addProduct(1L);
        cart2.printProductList();

        context.close();
    }

}
