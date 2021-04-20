package com.fiap.creditcard.controller;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Date;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fiap.creditcard.domain.Fatura;
import com.fiap.creditcard.service.FaturaService;

@RestController
@RequestMapping("/faturas")
public class FaturaController {

	private final FaturaService faturaService;
	
	public FaturaController(final FaturaService faturaService) {
        this.faturaService = faturaService;
    }
	
    @GetMapping
    public ResponseEntity<Fatura> visualizar(@PathVariable("id") Long id) {
    	final Optional<Fatura> fatura = this.faturaService.visualizar(id);
        if (fatura.isPresent()) {
            return ResponseEntity.ok(fatura.get());
        }

        return ResponseEntity.notFound().build();
    }
    
    @PostMapping()
    public ResponseEntity<Fatura> add(@PathVariable("idCliente") Long idCliente, @RequestBody Date dataVencimento) throws URISyntaxException {

        final Fatura novaFatura = this.faturaService.novaFatura(idCliente, dataVencimento);

        return ResponseEntity.created(new URI("/faturas/" + novaFatura.getId())).build();
    }
    
    @PutMapping()
    public ResponseEntity<Fatura> pagar(@PathVariable("id") Long idFatura) throws URISyntaxException {

        final Fatura faturaPaga = this.faturaService.pagar(idFatura);;

        return ResponseEntity.created(new URI("/faturas/" + faturaPaga.getId())).build();
    }

}
