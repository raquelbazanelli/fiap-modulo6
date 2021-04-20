package com.fiap.creditcard;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.fiap.creditcard.domain.Cliente;
import com.fiap.creditcard.domain.Fatura;
import com.fiap.creditcard.service.ClienteService;
import com.fiap.creditcard.service.FaturaService;

@SpringBootApplication
public class CreditcardApplication implements CommandLineRunner{
	
	@Autowired
	private FaturaService faturaService;
	@Autowired
	private ClienteService clienteService;

	public static void main(String[] args) {
		SpringApplication.run(CreditcardApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("### RUNNING CREDITCARD ###");

		Cliente cliente = clienteService.novoCliente("Maria");
		System.out.println("Novo cliente: " + cliente.toString());
		
		Fatura fatura = faturaService.novaFatura(cliente.getId(), new Date());
		System.out.println("Nova fatura: " + fatura.toString());
		
		System.out.println("Pagar fatura: ");
		faturaService.pagar(fatura.getId());

		System.out.println("Visualizar fatura: ");
		Optional<Fatura> faturapaga = faturaService.visualizar(fatura.getId());
		System.out.println(faturapaga.get().toString());
	}

}
