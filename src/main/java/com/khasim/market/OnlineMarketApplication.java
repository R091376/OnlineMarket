package com.khasim.market;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OnlineMarketApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OnlineMarketApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Executing this method");
	}

}
