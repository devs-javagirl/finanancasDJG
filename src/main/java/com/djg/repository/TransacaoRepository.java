package com.djg.repository;

import org.springframework.data.repository.CrudRepository;

import com.djg.model.Transacao;

public interface TransacaoRepository extends CrudRepository<Transacao, Long>{
	
}
