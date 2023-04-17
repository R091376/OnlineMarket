package com.khasim.market.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

	@GetMapping("/")
	public String sayHello() {
		System.out.println("Hello world");
		return "Hello World";
	}
}
