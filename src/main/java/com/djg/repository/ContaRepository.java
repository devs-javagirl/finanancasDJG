package com.djg.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.djg.model.Conta;

@Repository
public interface ContaRepository extends CrudRepository<Conta,Integer>{

	
}
