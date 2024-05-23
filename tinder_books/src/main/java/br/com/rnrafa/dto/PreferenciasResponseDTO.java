package br.com.rnrafa.dto;

import java.time.LocalDateTime;

public class PreferenciasResponseDTO {
	private Long id;
	private LocalDateTime datacriacao;
	private Long idUsuario;
	private Integer maxPaginas;
	private Integer distancia;
	
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
	public Long getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Long idUsuario) {
		this.idUsuario = idUsuario;
	}
	public Integer getMaxPaginas() {
		return maxPaginas;
	}
	public void setMaxPaginas(Integer maxPaginas) {
		this.maxPaginas = maxPaginas;
	}
	public Integer getDistancia() {
		return distancia;
	}
	public void setDistancia(Integer distancia) {
		this.distancia = distancia;
	}
	
	
}
