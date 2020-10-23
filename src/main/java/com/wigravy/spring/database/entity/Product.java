package com.wigravy.spring.database.entity;


import com.wigravy.spring.database.HibernateSessionFactory;
import org.hibernate.Session;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private Double cost;

    @OneToMany(mappedBy = "product")
    @Cascade({org.hibernate.annotations.CascadeType.SAVE_UPDATE})
    private List<OrderItem> orderItems;

    public Product() {
    }

    public Product(String title, Double cost) {
        this.title = title;
        this.cost = cost;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public List<OrderItem> getOrderItems() {
        Query query = null;
        List<OrderItem> orderItems = null;
        try (Session session = HibernateSessionFactory.getSession()) {
            session.beginTransaction();
            query = session.createQuery("from OrderItem where product = :product");
            query.setParameter("product", this);
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
        return "Product{" +
                "id = " + id +
                ", title = '" + title + '\'' +
                ", cost = " + cost +
                '}';
    }
}
