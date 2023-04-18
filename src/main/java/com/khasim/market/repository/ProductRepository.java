package com.khasim.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khasim.market.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
