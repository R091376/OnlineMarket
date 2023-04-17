package com.khasim.market.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.khasim.market.entity.Product;


@RestController
@RequestMapping("/product")
public class ProductController {

	@GetMapping
	public List<Product> getProducts(){
		return new ArrayList<>();
	}
	
	@GetMapping("/{id}")
	public Product getProduct(@PathVariable("id") String id){
		return new Product();
	}
	
	@PutMapping("/(id)")
	public Product updateProduct(@PathVariable("id") String id){
		return new Product();
	}
	
	@PostMapping
	public Product addProduct(@RequestBody Product product){
		return new Product();
	}
	
	@DeleteMapping("/(id)")
	public Product deleteProduct(@PathVariable("id") String id){
		return new Product();
	}
}
