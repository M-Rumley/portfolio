package com.sg.fixmastery.contract;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class ContractCLR implements CommandLineRunner {
	@Autowired
	ContractRepository contractRepository;
	
	public void run(String... args) {}

}
