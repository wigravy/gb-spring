package com.wigravy.spring.services;


import com.wigravy.spring.database.DAO.ProductDao;
import com.wigravy.spring.database.entity.Customer;
import com.wigravy.spring.database.entity.Order;
import com.wigravy.spring.database.entity.Product;

import java.util.List;

public class ProductService {
    private ProductDao productDaoService = new ProductDao();

    public Product findOneById(Long id) {
        return productDaoService.findOneById(id, Product.class);
    }

    public List<Product> findAll() {
        return productDaoService.findAll(Product.class);
    }

    public void save(Product product) {
        productDaoService.save(product);
    }

    public void deleteById(Long id) {
        productDaoService.deleteById(id, Product.class);
    }

    public void delete(Product product) {
        productDaoService.delete(product);
    }

    public List<Order> getOrders(Product product) {
        return productDaoService.getOrders(product);
    }


    public List<Customer> findAllUniqueCustomersWhoBuyProduct(Product product) {
        return productDaoService.findAllUniqueCustomersWhoBuyProduct(product);
    }
}
