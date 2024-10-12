package com.lazycoffee.Sec3_Spring_MVC_Architecture.utils;

import com.lazycoffee.Sec3_Spring_MVC_Architecture.model.Product;
import java.util.Arrays;
import java.util.List;

public class ProductData {

    // Simulate a dataset with 5 rows of product data
    private static final List<Product> products = Arrays.asList(
        new Product(1L, "Laptop", 1200.00),
        new Product(2L, "Smartphone", 800.00),
        new Product(3L, "Tablet", 500.00),
        new Product(4L, "Smartwatch", 200.00),
        new Product(5L, "Monitor", 300.00)
    );

    // Method to return the list of all products
    public static List<Product> getAllProducts() {
        return products;
    }

    // Method to get a product by ID
    public static Product getProductById(Long id) {
        return products.stream()
            .filter(product -> product.getId().equals(id))
            .findFirst()
            .orElse(null);  // Return null if no product is found
    }
}
