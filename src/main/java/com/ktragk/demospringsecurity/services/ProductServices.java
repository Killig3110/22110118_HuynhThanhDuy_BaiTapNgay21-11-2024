package com.ktragk.demospringsecurity.services;

import java.util.List;
import com.ktragk.demospringsecurity.entities.Product;

public interface ProductServices {
    void delete(Long id);

    Product get(Long id);

    Product save(Product product);

    List<Product> listAll();
}
