package com.sg.fixmastery.instrument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

public class InstrumentCLR  implements CommandLineRunner{
	@Autowired
	InstrumentRepository instrumentRepository;
	
	public void run(String...  args) {}
	
}
