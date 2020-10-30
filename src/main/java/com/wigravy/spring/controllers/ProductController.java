package com.wigravy.spring.controllers;

import com.wigravy.spring.model.Product;
import com.wigravy.spring.repositories.specification.ProductSpecification;
import com.wigravy.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public String showProductByPage(Model model,
                                    @RequestParam(name = "page", defaultValue = "1") Integer pageNumber,
                                    @RequestParam(name = "min_cost", required = false) Double minCost,
                                    @RequestParam(name = "max_cost", required = false) Double maxCost) {

        Specification<Product> specification = Specification.where(null);
        if (minCost != null) {
            specification = specification.and(ProductSpecification.costGreaterOrEqualThan(minCost));
        }
        if (maxCost != null) {
            specification = specification.and(ProductSpecification.costLessOrEqualThan(maxCost));
        }

        List<Product> products = productService.findAll(specification, pageNumber).getContent();
        model.addAttribute("products", products);
        return "all_products";
    }


    // Пример:      http://localhost:8189/app/products/info_by_title?title=Milk
    @GetMapping("/info_by_title")
    @ResponseBody
    public Product infoByTitle(@RequestParam String title) {
        return productService.findByTitle(title);
    }
}
