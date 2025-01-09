package com.javaguides.springboot.service;

import java.util.List;
import com.javaguides.springboot.entity.Product;

public interface ProductService {
    List<Product> searchProducts(String query);

    List<Product> searchProductsSql(String query);

    Product createProduct(Product product);
}
