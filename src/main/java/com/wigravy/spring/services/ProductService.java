package com.wigravy.spring.services;


import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.HibernateSessionFactory;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.OrderItem;
import com.wigravy.spring.database.entity.Product;
import org.hibernate.Session;

import javax.persistence.Query;
import java.util.List;

public class ProductService {
    private DaoService<Product> productDaoService = new DaoService<>(Product.class);

    public Product findOneById(Long id) {
        return productDaoService.findOneById(id);
    }

    public List<Product> findAll() {
        return productDaoService.findAll();
    }

    public Product save(Product product) {
        return productDaoService.save(product);
    }

    public void deleteById(Long id) {
        productDaoService.deleteById(id);
    }

    public void delete(Product product) {
        productDaoService.delete(product);
    }

//    public List<Customer> findAllCustomersWhoBuyProduct(Product product) {
//        Query query = null;
//        List<Customer> customers = null;
//        try (Session session = HibernateSessionFactory.getSession()) {
//            session.beginTransaction();
//            query = session.createQuery("from Customer where id = ");
//            query.setParameter("order", this);
//            orderItems = query.getResultList();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        if (orderItems == null) {
//            throw new NullPointerException("There are no products in the order yet");
//        }
//        return customers;
//    }
}
