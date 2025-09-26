package com.example.demo.controller;

import com.example.demo.model.Product;
import com.example.demo.service.ProductService; // 👈 important!
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from Spring Boot!";
    }
    @GetMapping
    public List<Product> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable int id) {
        return service.getById(id);
    }

    @PostMapping
    public Product add(@RequestBody Product product) {
        return service.add(product);
    }

    @PutMapping("/{id}")
    public Product update(@PathVariable int id, @RequestBody Product product) {
        return service.update(id, product);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable int id) {
        return service.delete(id) ? "Deleted" : "Not Found";
    }
}
