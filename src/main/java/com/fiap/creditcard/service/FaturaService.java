package com.fiap.creditcard.service;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fiap.creditcard.domain.Cliente;
import com.fiap.creditcard.domain.Fatura;
import com.fiap.creditcard.repository.FaturaRepository;

@Service
public class FaturaService {
	
	@Autowired
	private FaturaRepository faturaRepository;

	@Transactional
	public Fatura novaFatura(Long idCliente, Date dataVencimento) {
		
		Fatura novaFatura = new Fatura();
		novaFatura.setCliente(new Cliente(idCliente));
		novaFatura.setDataVencimento(dataVencimento);
		novaFatura.setIsPago(false);
		
		return faturaRepository.save(novaFatura);
	}
	
	public Optional<Fatura> visualizar(Long idFatura) {
		return faturaRepository.findById(idFatura);
	}
	
	@Transactional
	public Fatura pagar(Long idFatura) {
		Optional<Fatura> fatura = visualizar(idFatura);
		
		if (fatura.isPresent()) {
			fatura.get().setIsPago(true);
	        faturaRepository.save(fatura.get());
	        return fatura.get();
	    } else {
	    	System.out.print("Fatura não encontrada no banco de dados");
	    	return null;
	    }
	}
}
