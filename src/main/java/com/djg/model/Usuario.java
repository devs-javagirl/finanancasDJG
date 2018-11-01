package com.djg.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario{
	
	private String nome;
	private String email;
	private String senha;
	
	@Id
	/*@GeneratedValue(strategy=GenerationType.IDENTITY)*/
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
	

}
