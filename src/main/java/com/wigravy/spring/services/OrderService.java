package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DefaultDao;
import com.wigravy.spring.database.entity.Order;

import java.util.List;

public class OrderService {
    DefaultDao<Order> orderDefaultDao = new DefaultDao<>();

    public Order findOneById(Long id) {
        return orderDefaultDao.findOneById(id, Order.class);
    }

    public List<Order> findAll() {
        return orderDefaultDao.findAll(Order.class);
    }

    public void save(Order order) {
        orderDefaultDao.save(order);
    }

    public void deleteById(Long id) {
        orderDefaultDao.delete(findOneById(id));
    }

    public void delete(Order order) {
        orderDefaultDao.delete(order);
    }
}
