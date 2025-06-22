
package com.example.productcatalogue.repository;

import com.example.productcatalogue.model.Product;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class InMemoryProductRepository {
    private final Map<Long, Product> productMap = new HashMap<>();

    public InMemoryProductRepository() {
        productMap.put(1L, new Product(1L, "iPhone 15", "Latest iPhone", 1200.00));
        productMap.put(2L, new Product(2L, "Samsung Galaxy S24", "Latest Samsung", 999.00));
    }

    public List<Product> findAll() { return new ArrayList<>(productMap.values()); }

    public List<Product> searchByKeyword(String keyword) {
        return productMap.values().stream()
            .filter(p -> p.getName().toLowerCase().contains(keyword.toLowerCase()))
            .collect(Collectors.toList());
    }
}
