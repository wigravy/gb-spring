package com.wigravy.spring.database.DAO;


import com.wigravy.spring.database.HibernateSessionFactory;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;
import org.hibernate.Session;

import java.util.List;

public class CustomerDao extends DefaultDao<Customer> {
    public List<Order> getOrders(Customer customer) {
        List<Order> orders = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            orders = session.createQuery("from Order where customer = :customer")
                    .setParameter("customer", customer)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (orders == null) {
            throw new NullPointerException(String.format("The customer[%s] has no orders", customer));
        }
        return orders;
    }

    public List<Order> findPriceOFThePurchasedProduct(Customer customer, Product product) {
        List<Order> orders = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            orders = session.createQuery("select o from Customer c, Order o, Product p\n" +
                    "where c = o.customer\n" +
                    "AND p = o.product\n" +
                    "AND c = :customer\n" +
                    "AND p = :product")
                    .setParameter("customer", customer)
                    .setParameter("product", product)
                    .getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (orders == null) {
            throw new NullPointerException(String.format("This customer[%s] did not purchase the selected product[%s]", customer, product));
        }
        return orders;
    }
}
