package com.khasim.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khasim.market.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
