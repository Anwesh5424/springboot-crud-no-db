package com.example.demo.service;

import com.example.demo.model.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    private List<Product> products = new ArrayList<>();

    public List<Product> getAll() {
        return products;
    }

    public Product getById(int id) {
        return products.stream().filter(p -> p.getId() == id).findFirst().orElse(null);
    }

    public Product add(Product product) {
        products.add(product);
        return product;
    }

    public Product update(int id, Product updated) {
        Product existing = getById(id);
        if (existing != null) {
            existing.setName(updated.getName());
            existing.setPrice(updated.getPrice());
        }
        return existing;
    }

    public boolean delete(int id) {
        return products.removeIf(p -> p.getId() == id);
    }
}
