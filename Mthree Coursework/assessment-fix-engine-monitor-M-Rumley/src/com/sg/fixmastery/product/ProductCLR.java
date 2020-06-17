package com.sg.fixmastery.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ProductCLR implements CommandLineRunner{
	@Autowired
	ProductRepository productRepository;
	@Override
	public void run(String... args) {}

}
