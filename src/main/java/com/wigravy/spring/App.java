package com.wigravy.spring;


import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;
import com.wigravy.spring.services.CustomerService;
import com.wigravy.spring.services.OrderService;
import com.wigravy.spring.services.ProductService;

import java.sql.Timestamp;
import java.util.List;


public class App {
    public static void main(String[] args)  {
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();


//        System.out.println("\n\t\t=== Добавляем нового покупателя ===");
//        Customer customer1 = new Customer("Alex");
//        customerService.save(customer1);
//        System.out.println(customer1);
//
//
//        System.out.println("\n\t\t=== Добавляем новый товар ===");
//        Product product = new Product("Orange");
//        productService.save(product);
//        System.out.println(product);
//
//
//        System.out.println("\n\t\t=== Удаляем товар ===");
//        Product product1 = productService.findOneById(20L);
//        productService.delete(product1);
//
//
//        System.out.println("\n\t\t=== Создаём новый заказ ===");
//        Customer customer = customerService.findOneById(1L);
//        System.out.println("Покупатель: " + customer);
//        Product product1 = productService.findOneById(1L);
//        System.out.println("Продукт: " + product1);
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        Order order1 = new Order(customer, product1, timestamp, 3.99,1L);
//        orderService.save(order1);
//
//
//        System.out.println("\n\t\t=== Выводим информацию о продукте с id 1 ===");
//        Product product = productService.findOneById(1L);
//        System.out.println(product);
//
//
//        System.out.println("\n\t\t=== Выводим информацию о покупателе с id 1 ===");
//        Customer customer = customerService.findOneById(1L);
//        System.out.println(customer);
//
//
//        System.out.println("\n\t\t=== Выводим список заказов для покупателя с id 1 ===");
//        List<Order> orders = customerService.getOrders(customer);
//        orders.forEach(System.out::println);
//
//
//        System.out.println("\n\t\t=== Выводим информацию о заказе с id 1 ===");
//        Order order = orderService.findOneById(1L);
//        System.out.println(order);
//
//
//        System.out.println("\n\t\t=== Выводим информацию о всех заказах в которых есть продукт с id 1 ===");
//        Product product = productService.findOneById(1L);
//        List<Order> orders = productService.getOrders(product);
//        orders.forEach(System.out::println);
//
//
//        System.out.println("\n\t\t=== Выбрать всех уникальных покупателей купивших продукт с id 1 ===");
//        Product product1 = productService.findOneById(1L);
//        List<Customer> customers = productService.findAllUniqueCustomersWhoBuyProduct(product1);
//        customers.forEach(System.out::println);
//
//
//        System.out.println("\n\t\t=== Узнать все цены на товар с id 1, для покупателя с id 1 ===");
//        Customer customer = customerService.findOneById(1L);
//        List<Order> orders = customerService.findPriceOFThePurchasedProduct(customer, product);
//        orders.forEach(System.out::println);
    }
}
