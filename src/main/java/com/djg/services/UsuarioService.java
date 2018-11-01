package com.djg.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.djg.model.Usuario;
import com.djg.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public void salva(Usuario usuario) {
		usuarioRepository.save(usuario);
	}
	
	public List<Usuario> listaUsuario(){
		return (List<Usuario>) usuarioRepository.findAll();
	}
	
	public Usuario listaPorId(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public void deleta(Long id) {
		System.out.println("*********************************************************"+id);
		usuarioRepository.deleteById(id);
	}
}
