package com.djg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.djg.model.Conta;
import com.djg.model.Usuario;
import com.djg.repository.UsuarioRepository;
import com.djg.services.UsuarioService;

@RestController
public class UsuarioController {
	
	@Autowired
	private UsuarioService us;
	
	@PostMapping(path="/usuario", produces=MediaType.APPLICATION_JSON_VALUE)
	public void salvarUsuario(@RequestBody Usuario usuario) {
		us.salva(usuario);
	}
	
	@PostMapping(path="/deletausuario", consumes=MediaType.APPLICATION_JSON_VALUE)
	public void deletarUsuario(@RequestBody Usuario usuario) {
		us.deleta(usuario.getId());
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> listarUsuarios(){
		return us.listaUsuario();
	}
	
	@GetMapping("/usuario/{id}")
	public Usuario listaUsuarioPorId(@PathVariable Long id) {
		return us.listaPorId(id);
	}
	
	
}
