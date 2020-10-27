package com.wigravy.spring.controllers;

import com.wigravy.spring.model.Product;
import com.wigravy.spring.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public String showProductByPage(Model model, @RequestParam(name = "page", defaultValue = "1") Integer pageNumber) {
        if (pageNumber < 1) {
            pageNumber = 1;
        }

        List<Product> products = productService.findByPage(pageNumber - 1, 5).getContent();
        model.addAttribute("products", products);
        return "all_products";
    }


    // Пример:      http://localhost:8189/app/products/info_by_title?title=Milk
    @GetMapping("/info_by_title")
    @ResponseBody
    public Product infoByTitle(@RequestParam String title) {
        return productService.findByTitle(title);
    }


    // Пример:      http://localhost:8189/app/products/find_all_by_min_cost?cost=2.99
    @GetMapping("/find_all_by_min_cost")
    @ResponseBody
    public List<Product> findProductsByMinCost(@RequestParam Double cost) {
        return productService.findByMinCost(cost);
    }


}
