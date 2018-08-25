package com.djg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djg.model.Conta;
import com.djg.repository.ContaRepository;


@RestController
public class ContaController {
	@Autowired	
	private ContaRepository cr;
	@PostMapping(path = "/conta", produces = MediaType.APPLICATION_JSON_VALUE)
	public void  criaConta(@RequestBody Conta conta) {
		cr.save(conta);
	}
	
	@RequestMapping("/contas")
	public List<Conta> exibeConta() {
		List<Conta> arrayConta =  (List<Conta>) cr.findAll();
		return arrayConta;
			
		
	}
}
