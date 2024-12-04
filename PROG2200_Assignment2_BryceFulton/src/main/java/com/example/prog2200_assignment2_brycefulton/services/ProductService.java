package com.example.prog2200_assignment2_brycefulton.services;

import com.example.prog2200_assignment2_brycefulton.interfaces.IProductService;
import com.example.prog2200_assignment2_brycefulton.models.Product;

import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.ArrayList;

public class ProductService implements IProductService {
    private final Map<Integer, Product> products = new HashMap<>();

    @Override
    public void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product getProductById(int productId) {
        return products.get(productId);
    }

    @Override
    public boolean returnProduct(int productId) {
        return products.remove(productId) != null;
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products.values());
    }
}
