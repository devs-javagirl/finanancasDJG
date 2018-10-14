package com.djg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djg.model.Transacao;
import com.djg.repository.TransacaoRepository;

@RestController
public class TransacaoController {
	
	@Autowired
	private TransacaoRepository tr;
		
	@PostMapping(path="transacao", produces = MediaType.APPLICATION_JSON_VALUE)
	public void criaTipoDeGasto(@RequestBody Transacao transacao) {
		tr.save(transacao);
	}
	
	
}
