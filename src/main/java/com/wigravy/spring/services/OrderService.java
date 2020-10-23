package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;

import java.sql.Timestamp;
import java.time.LocalDateTime;
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
        orderDaoService.deleteById(id);
    }

    public void delete(Order order) {
        orderDaoService.delete(order);
    }

    public Order update(Order order) {
        return orderDaoService.update(order);
    }
}
