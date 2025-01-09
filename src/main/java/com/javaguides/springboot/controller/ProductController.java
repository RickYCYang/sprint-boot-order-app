package com.javaguides.springboot.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

import com.javaguides.springboot.entity.Product;
import com.javaguides.springboot.service.ProductService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@AllArgsConstructor
@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
    ProductService productService;

    // http://localhost:8080/api/v1/products/search?query=iphone
    @GetMapping("search")
    public ResponseEntity<List<Product>> searchProducts(@RequestParam String query) {
        return ResponseEntity.ok(productService.searchProducts(query));
    }

    // http://localhost:8080/api/v1/products/search/sql?query=iphone
    @GetMapping("search/sql")
    public ResponseEntity<List<Product>> searchProductsSql(@RequestParam String query) {
        return ResponseEntity.ok(productService.searchProductsSql(query));
    }

    // http://localhost:8080/api/v1/products
    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {
        Product createdProduct = productService.createProduct(product);
        return new ResponseEntity<>(createdProduct, HttpStatus.CREATED);
    }


}
