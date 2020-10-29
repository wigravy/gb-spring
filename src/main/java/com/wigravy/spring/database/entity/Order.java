package com.wigravy.spring.database.entity;


import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;


   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column(name = "order_date")
    private Timestamp date;

   @Column
   private Double price;

    @Column
    private Long amount;

    public Order() {
    }

    public Order(Customer customer, Product product, Timestamp date, Double price, Long amount) {
        this.customer = customer;
        this.product = product;
        this.date = date;
        this.price = price;
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Timestamp getDate() {
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", date=" + date +
                ", customer=" + customer +
                ", product=" + product +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}



