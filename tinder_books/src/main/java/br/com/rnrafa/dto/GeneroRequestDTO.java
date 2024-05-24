package br.com.rnrafa.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class GeneroRequestDTO {

    private Long id;

    private LocalDateTime datacriacao;

    private String genero;

    private String ativo;

    public GeneroRequestDTO(Long id, LocalDateTime datacriacao, String genero, String ativo) {
        this.id = id;
        this.datacriacao = datacriacao;
        this.genero = genero;
        this.ativo = ativo;
    }

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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
