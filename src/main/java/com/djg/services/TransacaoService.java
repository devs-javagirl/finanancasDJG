package com.djg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.djg.model.Transacao;
import com.djg.repository.TransacaoRepository;

@Service
public class TransacaoService {
	
	@Autowired
	private TransacaoRepository tr;
		
	@PostMapping(path="transacao", produces = MediaType.APPLICATION_JSON_VALUE)
	public void criaTransacao(@RequestBody Transacao transacao) {
		tr.save(transacao);
	}
	
	@RequestMapping("/transacoes")
	public List<Transacao> exibeTransacao() {
		List<Transacao> arrayTransacao =  (List<Transacao>) tr.findAll(); //findAll: retorna um iterable
		return arrayTransacao;
		
	}
	
	@PostMapping(path = "/deletatransacao", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletaTransacao(@RequestBody Transacao transacao) {
		tr.deleteById(transacao.getId());
	}
	
	@GetMapping(value="/transacao/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Transacao listaTransacaoPorId(@PathVariable Long id) {
		Transacao t = tr.findById(id).get();
		return t; 
	}
	
}
