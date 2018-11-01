package com.djg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	@RequestMapping("/transacoes")
	public List<Transacao> exibeTransacao() {
		List<Transacao> arrayTransacao =  (List<Transacao>) tr.findAll(); //findAll: retorna um iterable
		return arrayTransacao;
		
	}
	
	@PostMapping(path = "/deletatransacao", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletaConta(@RequestBody Transacao transacao) {
		tr.deleteById(transacao.getId());
	}
	
	@GetMapping(value="/transacao/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transacao listaTransacaoPorId(@PathVariable Long id) {
		Transacao t = tr.findById(id).get();
		return t; 
	}
	
}
