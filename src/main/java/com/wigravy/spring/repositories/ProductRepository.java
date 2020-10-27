package com.wigravy.spring.repositories;

import com.wigravy.spring.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    Product findOneByTitle(String title);

    List<Product> findAllByCostGreaterThanEqual(Double minCost);
}
