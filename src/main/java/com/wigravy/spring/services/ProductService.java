package com.wigravy.spring.services;

import com.wigravy.spring.exceptions.ProductNotFoundException;
import com.wigravy.spring.model.Product;
import com.wigravy.spring.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    @Autowired
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product getById(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new ProductNotFoundException("Can't find product with id = " + id));
    }

    public Product findByTitle(String title) {
        return productRepository.findOneByTitle(title);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Page<Product> findAll(Specification<Product> specification, Integer page) {
        if (page < 1) {
            page = 1;
        }
        return productRepository.findAll(specification, PageRequest.of(page - 1, 5));
    }
}
