package com.pll.bittrex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BittrexClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BittrexClientApplication.class, args);
	}
}
