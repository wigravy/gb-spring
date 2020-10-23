package com.wigravy.spring;



import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.OrderItem;
import com.wigravy.spring.database.entity.Product;
import com.wigravy.spring.services.CustomerService;
import com.wigravy.spring.services.OrderItemService;
import com.wigravy.spring.services.OrderService;
import com.wigravy.spring.services.ProductService;

import java.util.List;


public class App {
    public static void main(String[] args)  {
        ProductService productService = new ProductService();
        CustomerService customerService = new CustomerService();
        OrderService orderService = new OrderService();
        OrderItemService orderItemService = new OrderItemService();
        Order order = orderService.findOneById(4L);
        Product product = productService.findOneById(1L);
        Customer customer = customerService.findOneById(2L);
        List<OrderItem> orderItems = order.getOrderItems();
        List<Order> orders = customer.getOrders();

        System.out.println("\n\t\t=== Добавляем нового покупателя ===");
//        Customer customer1 = new Customer("Denis");
//        customerService.save(customer1);
//        System.out.println(customer1);
//        Customer customer1 = customerService.findOneById(1L);
//        customerService.delete(customer1);

//        System.out.println("\n\t\t=== Добавляем новый товар ===");
//        Product product1 = new Product("Orange", 4.99);
//        productService.save(product1);

//        System.out.println("\n\t\t=== Удаляем товар ===");
//        Product product1 = productService.findOneById(5L);
//        productService.delete(product1);


//        System.out.println("\n\t\t=== Создаём новый заказ ===");
//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        Order order1 = new Order(timestamp, customer1);


//        System.out.println("\n\t\t=== Добавляем продукты в заказ ===");
//        Order order2 = orderService.findOneById(4L);
//        Product product2 = productService.findOneById(4L);
//        Product product3 = productService.findOneById(3L);
//        OrderItem orderItem1 = new OrderItem(order2, product2, product2.getCost());
//        OrderItem orderItem2 = new OrderItem(order2, product3, product3.getCost());
//        orderItemService.save(orderItem1);
//        orderItemService.save(orderItem2);


//        System.out.println("\n\t\t=== Выводим информацию о продукте с id 1 ===");
//        System.out.println(product);//
//
//        System.out.println("\n\t\t=== Выводим информацию о покупателе с id 2 ===");
//        System.out.println(customer);
//
//        System.out.println("\n\t\t=== Выводим информацию о заказе с id 5 ===");
//        System.out.println(order);
//
//
//        System.out.println("\n\t\t=== Выводим список заказов для покупателя с id 2 ===");
//        for (Order o : orders) {
//            System.out.println(o);
//        }
//
//
//        System.out.println("\n\t\t=== Выводим список товаров и их стоимость на момент покупки, в заказе с id 5 ===");
//        for (OrderItem orderItem : orderItems) {
//            System.out.println(orderItem);
//        }
//
//
//        System.out.println("\n\t\t=== Выводим список всех товаров, их стоимости на момент покупки, а так же заказов у покупателя с id 2 ===");
//        for (Order o : orders) {
//            for (OrderItem oi : o.getOrderItems()) {
//                System.out.println(oi);
//            }
//        }
    }
}
