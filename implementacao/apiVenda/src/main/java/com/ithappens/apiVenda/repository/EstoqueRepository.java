package com.ithappens.apiVenda.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ithappens.apiVenda.models.Estoque;

public interface EstoqueRepository extends JpaRepository<Estoque, Long>{
	
	Estoque findById(long id);
}
