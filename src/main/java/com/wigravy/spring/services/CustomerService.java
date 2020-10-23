package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.HibernateSessionFactory;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.OrderItem;
import org.hibernate.Session;

import java.io.ObjectInputStream;
import java.util.List;


public class CustomerService {
    DaoService<Customer> customerDaoService = new DaoService<>(Customer.class);

    public Customer findOneById(Long id) {
        return customerDaoService.findOneById(id);
    }

    public List<Customer> findAll() {
        return customerDaoService.findAll();
    }

    public Customer save(Customer customer) {
        return customerDaoService.save(customer);
    }

    public void deleteById(Long id) {
        customerDaoService.delete(findOneById(id));
    }

    public void delete(Customer customer) {
        OrderService orderService = new OrderService();
        List<Order> orders = customer.getOrders();
        for (Order o : orders) {
            orderService.delete(o);
        }
        customerDaoService.delete(customer);
    }
}
