package com.khasim.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khasim.market.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
