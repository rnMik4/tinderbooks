package br.com.rnrafa.dto;

import java.time.LocalDateTime;

public class PreferenciasRequestDTO {
	private Long idUsuario;
	private Integer maxPaginas;
	private Integer distancia;
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
