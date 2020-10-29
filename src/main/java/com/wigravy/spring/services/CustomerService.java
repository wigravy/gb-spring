package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.CustomerDao;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;

import java.util.List;


public class CustomerService {
    CustomerDao customerDaoService = new CustomerDao();

    public Customer findOneById(Long id) {
        return customerDaoService.findOneById(id, Customer.class);
    }

    public List<Customer> findAll() {
        return customerDaoService.findAll(Customer.class);
    }

    public void save(Customer customer) {
        customerDaoService.save(customer);
    }

    public void deleteById(Long id) {
        customerDaoService.deleteById(id, Customer.class);
    }

    public void delete(Customer customer) {
        customerDaoService.delete(customer);
    }

    public List<Order> getOrders(Customer customer) {
        return customerDaoService.getOrders(customer);
    }

    public List<Order> findPriceOFThePurchasedProduct(Customer customer, Product product) {
        return customerDaoService.findPriceOFThePurchasedProduct(customer, product);
    }
}
