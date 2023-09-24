package com.example.springbootredisdatabase.controller;


import com.example.springbootredisdatabase.service.ProductService;
import com.example.springbootredisdatabase.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productService.save(product);
    }

    @GetMapping("/getallproduct")
    public List<Product> findAll() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Object findProductById(@PathVariable Integer id) {
        return productService.findProductById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteProductById(@PathVariable Integer id) {
        return productService.deleteProductById(id);
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello world";
    }
}
