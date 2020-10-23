package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.OrderItem;

import java.util.List;

public class OrderService {
    ProductService productService = new ProductService();
    CustomerService customerService = new CustomerService();

    DaoService<Order> orderDaoService = new DaoService<>(Order.class);

    public Order findOneById(Long id) {
        return orderDaoService.findOneById(id);
    }

    public List<Order> findAll() {
        return orderDaoService.findAll();
    }

    public Order save(Order order) {
        return orderDaoService.save(order);
    }

    public void deleteById(Long id) {
        orderDaoService.delete(findOneById(id));
    }

    public void delete(Order order) {
        OrderItemService orderItemService = new OrderItemService();
        List<OrderItem> orderItems = order.getOrderItems();
        for (OrderItem oi : orderItems) {
            orderItemService.delete(oi);
        }
        orderDaoService.delete(order);
    }
}
