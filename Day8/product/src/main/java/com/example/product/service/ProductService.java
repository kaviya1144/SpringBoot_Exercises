package com.example.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.product.model.Product;
import com.example.product.repository.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public Product postProduct(Product product) {
        return productRepo.save(product);
    }

    public List<Product> getproductByStart(String value) {
        return productRepo.findByStartWithName(value);
    }

    public List<Product> getproductByEnd(String value) {
        return productRepo.findByEndWithName(value);
    }

    public List<Product> productSort(String field){
        return productRepo.findAll(Sort.by(Sort.Direction.ASC,field));
    }

}
