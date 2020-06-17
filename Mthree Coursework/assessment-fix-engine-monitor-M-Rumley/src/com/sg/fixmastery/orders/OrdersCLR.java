package com.sg.fixmastery.orders;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class OrdersCLR implements CommandLineRunner{
	@Autowired
	OrdersRepository ordersRepository;

	@Override
	public void run(String... args) {}
	
	
}
