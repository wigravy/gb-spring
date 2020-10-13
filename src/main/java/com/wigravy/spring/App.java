package com.wigravy.spring;


import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Product;
import com.wigravy.spring.services.CustomerService;
import com.wigravy.spring.services.ProductsService;

public class App {
    public static void main(String[] args) throws Exception {
//        ProductsService productsService = new ProductsService();
//        productsService.save(new Product("Milk", 3.99));
        CustomerService customerService = new CustomerService();
        customerService.save(new Customer("Elena"));

    }
}
