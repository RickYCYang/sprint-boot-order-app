package com.javaguides.springboot.service.Impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.javaguides.springboot.repository.ProductRepository;
import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.service.ProductService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {
    ProductRepository productRepository;

    @Override
    public List<Product> searchProducts(String query) {
        return productRepository.searchProducts(query);
    }

    @Override
    public List<Product> searchProductsSql(String query) {
        return productRepository.searchProductsSql(query);
    }

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

}
