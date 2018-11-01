package com.djg.model;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import com.djg.model.Conta;

@Entity
public class Transacao {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private BigDecimal valor;
	private String descricao;
	private LocalDate data;
	
	@ManyToOne
	@JoinColumn(name="tipodegasto_id", referencedColumnName="id")
	private TipoDeGasto tipoDeGasto;
	
	@ManyToOne
	@JoinColumn(name="conta_id", referencedColumnName="id")
	private Conta conta;

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public TipoDeGasto getTipoDeGasto() {
		return tipoDeGasto;
	}

	public void setTipoDeGasto(TipoDeGasto tipoDeGasto) {
		this.tipoDeGasto = tipoDeGasto;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
}
