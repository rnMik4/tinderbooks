package br.com.rnrafa.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class GeneroRequestDTO {


    private String genero;

    private String ativo;



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
