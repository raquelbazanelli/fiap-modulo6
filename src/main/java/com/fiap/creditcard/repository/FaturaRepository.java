package com.fiap.creditcard.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.fiap.creditcard.domain.Fatura;

@Repository
public interface FaturaRepository extends PagingAndSortingRepository<Fatura, Long>{

}
