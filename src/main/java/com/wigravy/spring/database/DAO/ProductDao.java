package com.wigravy.spring.database.DAO;

import com.wigravy.spring.database.HibernateSessionFactory;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class ProductDao extends DefaultDao<Product> {
    public List<Order> getOrders(Product product) {
        List<Order> orders = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            orders = session.createQuery("from Order where product = :product")
                    .setParameter("product", product)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (orders == null) {
            throw new NullPointerException(String.format("The customer[%s] has no orders", product));
        }
        return orders;
    }


    public List<Customer> findAllUniqueCustomersWhoBuyProduct(Product product) {
        List<Customer> customers = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            customers = session.createQuery("select DISTINCT c from Customer c, Order o, Product p\n" +
                    "where c = o.customer\n" +
                    "AND p = :product")
                    .setParameter("product", product)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (customers == null) {
            throw new NullPointerException("Nobody has bought this item yet");
        }
        return customers;
    }
}
