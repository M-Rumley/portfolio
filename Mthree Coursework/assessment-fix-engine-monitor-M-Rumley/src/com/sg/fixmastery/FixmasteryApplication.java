package com.sg.fixmastery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class FixmasteryApplication {
	@RequestMapping("/")
	String home() {
		return "hello";
	}
	public static void main(String[] args) {
		SpringApplication.run(FixmasteryApplication.class, args);
	}

}
