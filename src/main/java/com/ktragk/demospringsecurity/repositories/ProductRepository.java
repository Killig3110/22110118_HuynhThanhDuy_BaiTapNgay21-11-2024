package com.ktragk.demospringsecurity.repositories;

import com.ktragk.demospringsecurity.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}