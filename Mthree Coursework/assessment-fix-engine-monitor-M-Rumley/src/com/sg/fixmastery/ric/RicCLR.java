package com.sg.fixmastery.ric;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class RicCLR implements CommandLineRunner {
	@Autowired
	RicRepository ricRepository;
	@Override
	public void run(String... args) {}

}
