package com.djg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.djg.model.Conta;
import com.djg.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired	
	private ContaRepository cr;
	
	public void  criaConta(@RequestBody Conta conta) {
		cr.save(conta);
	}
	
	public List<Conta> exibeConta() {
		List<Conta> arrayConta =  (List<Conta>) cr.findAll(); //findAll: retorna um iterable
		return arrayConta;
	}
	
	@PostMapping(path = "/deletaconta", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletaConta(@RequestBody Conta conta) {
		cr.deleteById(conta.getId());
	}
	
	@GetMapping(value="/contaporid/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Conta listaContaPorId(@PathVariable Long id) {
		Conta c = cr.findById(id).get();
		return c; 
	}

}
