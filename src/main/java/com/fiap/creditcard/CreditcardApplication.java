package com.fiap.creditcard;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fiap.creditcard.service.FaturaService;

@SpringBootApplication
public class CreditcardApplication implements CommandLineRunner{
	
	@Autowired
	private FaturaService faturaService;

	public static void main(String[] args) {
		SpringApplication.run(CreditcardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Creditcard run");
	}

}
