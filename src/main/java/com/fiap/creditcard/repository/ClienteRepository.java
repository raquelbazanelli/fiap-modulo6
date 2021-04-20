package com.fiap.creditcard.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiap.creditcard.domain.Cliente;


@Repository
public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Long>{

}