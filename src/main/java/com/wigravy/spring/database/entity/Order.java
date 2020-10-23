package com.wigravy.spring.database.entity;

import com.wigravy.spring.database.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(name = "order_date")
    private Timestamp date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


    @OneToMany(mappedBy = "order", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;


    public Order() {
    }

    public Order(Timestamp date, Customer customer) {
        this.date = date;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<OrderItem> getOrderItems() {
        Query query = null;
        List<OrderItem> orderItems = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            query = session.createQuery("from OrderItem where order = :order");
            query.setParameter("order", this);
            orderItems = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (orderItems == null) {
            throw new NullPointerException("There are no products in the order yet");
        }
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id = " + id +
                ", date = " + date +
                ", customer = " + customer.getName() +
                '}';
    }
}



