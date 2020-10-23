package com.wigravy.spring.services;

import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.HibernateSessionFactory;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.OrderItem;
import org.hibernate.Session;

import javax.persistence.Query;
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

    public List<OrderItem> getAllPurchasedProducts(Customer customer) {
        Query query = null;
        List<OrderItem> products = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            query = session.createQuery("select oi from Customer c, Order o, OrderItem oi\n" +
                    "where c = o.customer\n" +
                    "AND o = oi.order\n" +
                    "AND c = :customer");
            query.setParameter("customer", customer);
            products = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (products == null) {
            throw new NullPointerException("Nobody has bought this item yet");
        }
        return products;
    }
}
