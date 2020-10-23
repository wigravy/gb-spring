package com.wigravy.spring;


import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.OrderItem;
import com.wigravy.spring.database.entity.Product;
import com.wigravy.spring.services.CustomerService;
import com.wigravy.spring.services.OrderItemService;
import com.wigravy.spring.services.OrderService;
import com.wigravy.spring.services.ProductService;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;


public class App {
    public static void main(String[] args)  {
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        OrderItemService orderItemService = new OrderItemService();
        Order order = orderService.findOneById(1L);
        Product product = productService.findOneById(1L);
        Customer customer = customerService.findOneById(1L);
        List<OrderItem> orderItems = order.getOrderItems();
        List<Order> orders = customer.getOrders();

//        System.out.println("\n\t\t=== Создаём нового покупателя ===");
//        Customer customer1 = new Customer("Denis");
//        customerService.save(customer1);


//        Product product1 = new Product("Orange", 7.99);
//        productService.save(product1);


//        System.out.println("\n\t\t=== Создаём новый заказ ===");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        Order order1 = new Order(timestamp, customer1);


//        System.out.println("\n\t\t=== Добавляем продукты в заказ ===");
//        OrderItem orderItem1 = new OrderItem(order1, product1, product1.getCost());
//        OrderItem orderItem2 = new OrderItem(order1, product, product.getCost());


        System.out.println("\n\t\t=== Выводим информацию о продукте с id 1 ===");
        System.out.println(product);


        System.out.println("\n\t\t=== Выводим информацию о покупателе с id 1 ===");
        System.out.println(customer);


        System.out.println("\n\t\t=== Выводим список заказов для покупателя с id 1 ===");
        for (Order o : orders) {
            System.out.println(o);
        }


        System.out.println("\n\t\t=== Выводим список товаров в заказе с id 1 ===");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }


        System.out.println("\n\t\t=== Выводим список всех товаров и заказов у покупателя с id 1 ===");
        for (Order o : customer.getOrders()) {
            for (OrderItem oi : o.getOrderItems()) {
                System.out.println(oi);
            }
        }
    }
}
