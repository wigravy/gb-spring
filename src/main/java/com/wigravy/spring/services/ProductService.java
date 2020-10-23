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

    public List<Customer> findAllCustomersWhoBuyProduct(Product product) {
        Query query = null;
        List<Customer> customers = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            query = session.createQuery("select c from Customer c, Order o, OrderItem oi, Product p\n" +
                    "where c = o.customer\n" +
                    "AND o = oi.order\n" +
                    "AND p = oi.product\n" +
                    "AND p = :product");
            query.setParameter("product", product);
            customers = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (customers == null) {
            throw new NullPointerException("Nobody has bought this item yet");
        }
        return customers;
    }
}
