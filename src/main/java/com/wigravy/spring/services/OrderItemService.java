package com.wigravy.spring.services;


import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.entity.OrderItem;

import java.util.List;

public class OrderItemService {
    private DaoService<OrderItem> orderItemDaoService = new DaoService<>(OrderItem.class);

    public OrderItem findOneById(Long id) {
        return orderItemDaoService.findOneById(id);
    }

    public List<OrderItem> findAll() {
        return orderItemDaoService.findAll();
    }

    public OrderItem save(OrderItem orderItem) {
        return orderItemDaoService.save(orderItem);
    }

    public void deleteById(Long id) {
        orderItemDaoService.deleteById(id);
    }

    public void delete(OrderItem orderItem) {
        orderItemDaoService.delete(orderItem);
    }
}
