package com.wigravy.spring.controllers;

import com.wigravy.spring.entity.Product;
import com.wigravy.spring.services.ProductsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {
    private ProductsService productsService;

    @Autowired
    public void setProductsService(ProductsService productsService) {
        this.productsService = productsService;
    }

    @RequestMapping("/productinfo")
    public String productInfo(Model model) {
        List<Product> products = productsService.getAllProducts();
        model.addAttribute("products", products);
        return "productsInfo";
    }

    @PostMapping("/addproduct")
    public String addProduct(@ModelAttribute Product product) {
        productsService.addProduct(product);
        return "redirect:/productinfo";
    }
}
