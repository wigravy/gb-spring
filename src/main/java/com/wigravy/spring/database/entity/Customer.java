package com.wigravy.spring.database.entity;


import com.wigravy.spring.database.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY)
    @Cascade({org.hibernate.annotations.CascadeType.ALL})
    private List<Order> orders;

    public Customer() {
    }

    public Customer(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        Query query = null;
        List<Order> orders = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            query = session.createQuery("from Order where customer = :customer");
            query.setParameter("customer", this);
            orders = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (orders == null) {
            throw new NullPointerException(String.format("The customer[%s] has no orders", this));
        }
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }


    @Override
    public String toString() {
        return "Customer{" +
                "id = " + id +
                ", name = '" + name + '\'' +
                '}';
    }
}
