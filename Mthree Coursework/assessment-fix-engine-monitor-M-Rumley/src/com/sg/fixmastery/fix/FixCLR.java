package com.sg.fixmastery.fix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class FixCLR implements CommandLineRunner{
	@Autowired
	FixRepository fixRepository;

	@Override
	public void run(String... args) {}
	
}
