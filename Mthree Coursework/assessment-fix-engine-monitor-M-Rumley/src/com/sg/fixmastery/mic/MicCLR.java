package com.sg.fixmastery.mic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class MicCLR implements CommandLineRunner {
	
	@Autowired
	MicRepository micRepository;
	
	@Override
	public void run(String... args) {}
	
}
