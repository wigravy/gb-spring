package com.wigravy.spring.entity;


public class Product {
    private Long id;
    private String name;
    private Double cost;

    public Product(Long id, String name, Double cost) {
        this.id = id;
        this.name = name;
        this.cost = cost;
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

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    @Override
    public String toString() {
        return String.format("Product: [id: %d, name: %s, cost: %f]", id, name, cost);
    }
}
