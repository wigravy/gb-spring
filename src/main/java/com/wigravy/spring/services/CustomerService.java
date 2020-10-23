package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.entity.Customer;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
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
        customerDaoService.deleteById(id);
    }

    public void delete(Customer customer) {
        customerDaoService.delete(customer);
    }

    public Customer update(Customer customer) {
        return customerDaoService.update(customer);
    }
}
