package com.wigravy.spring.repositories;



import org.springframework.stereotype.Component;


import com.wigravy.spring.entity.Product;
import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Component
public class ProductRepository {
    private List<Product> products;

    @PostConstruct
    public void init() {
        this.products = new ArrayList<>();
        this.products.add(new Product(1L, "Milk", 4.99));
        this.products.add(new Product(2L, "Meat", 9.99));
        this.products.add(new Product(3L, "Pizza", 7.49));
        this.products.add(new Product(4L, "Coca-Cola", 2.49));
        this.products.add(new Product(5L, "Ice cream", 0.69));
    }

    public List<Product> getAll() {
        return Collections.unmodifiableList(products);
    }

    public Product getById(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        throw new NullPointerException(String.format("Error: no such value exists [id = %d]", id));
    }

    public void add(Product product) {
        for (Product prod : products) {
            if (prod.getId().equals(product.getId())) {
                throw new IllegalArgumentException(String.format("An element with this id(%d) already exists", product.getId()));
            }
        }
        products.add(product);
    }
}
