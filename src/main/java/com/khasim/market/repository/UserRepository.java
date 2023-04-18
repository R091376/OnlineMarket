package com.khasim.market.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.khasim.market.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
