package br.com.rnrafa.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class MatchResponseDTO {

    private LocalDateTime dataCriacao;

    private Long id_usuario_i;

    private Long getId_usuario_ii;


    public MatchResponseDTO(LocalDateTime dataCriacao, Long id_usuario_i, Long getId_usuario_ii) {
        this.dataCriacao = dataCriacao;
        this.id_usuario_i = id_usuario_i;
        this.getId_usuario_ii = getId_usuario_ii;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId_usuario_i() {
        return id_usuario_i;
    }

    public void setId_usuario_i(Long id_usuario_i) {
        this.id_usuario_i = id_usuario_i;
    }

    public Long getGetId_usuario_ii() {
        return getId_usuario_ii;
    }

    public void setGetId_usuario_ii(Long getId_usuario_ii) {
        this.getId_usuario_ii = getId_usuario_ii;
    }
}
