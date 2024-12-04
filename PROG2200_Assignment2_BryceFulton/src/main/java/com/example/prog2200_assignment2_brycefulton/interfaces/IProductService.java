package com.example.prog2200_assignment2_brycefulton.interfaces;

import com.example.prog2200_assignment2_brycefulton.models.Product;

public interface IProductService {
    void addProduct(Product product);
    Product getProductById(int productId);
    boolean returnProduct(int productId);
}
