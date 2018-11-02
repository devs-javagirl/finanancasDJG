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

import com.djg.model.TipoDeGasto;
import com.djg.repository.TipoDeGastoRepository;

@Service
public class TipoDeGastoService{
	
	@Autowired
	private TipoDeGastoRepository cr;
		
	@PostMapping(path="tipodegasto", produces = MediaType.APPLICATION_JSON_VALUE)
	public void criaTipoDeGasto(@RequestBody TipoDeGasto tipoDeGasto) {
		cr.save(tipoDeGasto);
	}
	
	@RequestMapping("/tiposdegasto")
	public List<TipoDeGasto> listarTiposDeGastos(){
		List<TipoDeGasto> arrayTiposDeGastos = (List<TipoDeGasto>) cr.findAll();
		return arrayTiposDeGastos;
	}
	
	@PostMapping(path = "/deletatipodegasto", produces = MediaType.APPLICATION_JSON_VALUE)
	public void deletaTipoDeGasto(@RequestBody TipoDeGasto tipoDeGasto) {
		cr.deleteById(tipoDeGasto.getId());
	}
	
	@GetMapping(value="/listaTipoDeGastoPorId/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public TipoDeGasto listaTipoDeGastoPorId(@PathVariable Integer id) {
		TipoDeGasto tipoDeGasto = cr.findById(id).get();
		return tipoDeGasto;
	}
	
}
