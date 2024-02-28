package com.example.productputdelt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.productputdelt.model.Product;
import com.example.productputdelt.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product postProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Product getProductById(int productId) {
        return productRepo.findById(productId).orElse(null);
    }

    public Product putProduct(int productId, Product product) {
        Optional<Product> optionalProduct = productRepo.findById(productId);
        if (optionalProduct.isPresent()) {
            Product existingProduct = optionalProduct.get();
            existingProduct.setProductName(product.getProductName());
            existingProduct.setDescription(product.getDescription());
            return productRepo.save(existingProduct);
        } else {
            return null;
        }
    }

    public Product deleteProduct(int id) {
        Optional<Product> optionalProduct = productRepo.findById(id);
        if (optionalProduct.isPresent()) {
            Product product = optionalProduct.get();
            productRepo.delete(product);
            return product;
        } else {
            return null;
        }
    }
    
}
