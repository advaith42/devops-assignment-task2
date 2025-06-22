
package com.example.productcatalogue.controller;

import com.example.productcatalogue.model.Product;
import com.example.productcatalogue.repository.InMemoryProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private InMemoryProductRepository repository;

    @GetMapping("/health")
    public String health() { return "Service is up"; }

    @GetMapping
    public List<Product> getAll() { return repository.findAll(); }

    @GetMapping("/search")
    public List<Product> search(@RequestParam(required = false) String keyword) {
        if (keyword == null || keyword.isEmpty()) {
            return repository.findAll();
        }
        return repository.searchByKeyword(keyword);
    }
}
