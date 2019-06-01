package com.worldnettps.simplebanking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.worldnettps.simplebanking"})
public class SimpleBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimpleBankingApplication.class, args);
	}

}
