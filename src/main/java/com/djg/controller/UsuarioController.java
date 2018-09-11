package com.djg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djg.model.Usuario;
import com.djg.repository.UsuarioRepository;

@RestController
public class UsuarioController {
	@Autowired
	private UsuarioRepository ur;
	@PostMapping(path="/usuario", produces=MediaType.APPLICATION_JSON_VALUE)
	public void salvarUsuario(@RequestBody Usuario usuario) {
		ur.save(usuario);
	}
}
