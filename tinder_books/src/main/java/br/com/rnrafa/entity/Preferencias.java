package br.com.rnrafa.entity;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "preferencias")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Preferencias {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "data_criacao", nullable = false, length = 80)
	private LocalDateTime datacriacao;
	
	@Column(name = "distancia", nullable = false, length = 80)
	private Integer distancia;
	
	@Column(name = "max_paginas", nullable = false, length = 80)
	private Integer maxPaginas;
	
	@Column(name = "id_usuario", nullable = false, length = 80)
	private Long idUsuario;
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDatacriacao() {
		return datacriacao;
	}

	public void setDatacriacao(LocalDateTime datacriacao) {
		this.datacriacao = datacriacao;
	}

	public Integer getDistancia() {
		return distancia;
	}

	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}

	public Integer getMaxPaginas() {
		return maxPaginas;
	}

	public void setMaxPaginas(Integer maxPaginas) {
		this.maxPaginas = maxPaginas;
	}

	public Long getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	
	
}
