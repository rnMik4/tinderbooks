package br.com.rnrafa.dto;

import java.time.LocalDateTime;

public class GeneroResponseDTO {

    private LocalDateTime datacriacao;
    private String genero;
    private String ativo;


    public GeneroResponseDTO(LocalDateTime datacriacao, String genero, String ativo) {
        this.datacriacao = datacriacao;
        this.genero = genero;
        this.ativo = ativo;
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
