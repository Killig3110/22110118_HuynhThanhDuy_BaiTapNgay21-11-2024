package com.ktragk.demospringsecurity.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.ktragk.demospringsecurity.entities.Product;
import com.ktragk.demospringsecurity.repositories.ProductRepository;
import com.ktragk.demospringsecurity.services.ProductServices;

@Service
public class ProductServiceImpl implements ProductServices {

    @Autowired
    private ProductRepository repo;

    public ProductServiceImpl(ProductRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Product> listAll() {
        return repo.findAll();
    }

    @Override
    public Product save(Product product) {
        return repo.save(product);
    }

    @Override
    public Product get(Long id) {
        return repo.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
}
