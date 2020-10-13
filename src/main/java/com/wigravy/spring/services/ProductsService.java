package com.wigravy.spring.services;


import com.wigravy.spring.database.DAO.DaoService;
import com.wigravy.spring.database.entity.Product;

import java.util.List;

public class ProductsService {
    private DaoService<Product> productDaoService = new DaoService<>();

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

    public Product update(Product product) {
        return productDaoService.update(product);
    }
}
