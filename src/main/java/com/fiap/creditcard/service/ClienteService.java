package com.fiap.creditcard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.creditcard.domain.Cliente;
import com.fiap.creditcard.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Transactional
	public Cliente novoCliente(String nome) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		return clienteRepository.save(cliente);
	}

}
