package com.tka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class RetailStoreMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetailStoreMsApplication.class, args);
	}

}
