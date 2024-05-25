package br.com.rnrafa.dto;

import jakarta.persistence.Column;

import java.time.LocalDateTime;

public class MatchResponseDTO {

    private Long id;
    private LocalDateTime dataCriacao;
    private Long idUsuarioI;
    private Long idUsuarioII;

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuarioI() {
        return idUsuarioI;
    }

    public void setIdUsuarioI(Long idUsuarioI) {
        this.idUsuarioI = idUsuarioI;
    }

    public Long getIdUsuarioII() {
        return idUsuarioII;
    }

    public void setIdUsuarioII(Long idUsuarioII) {
        this.idUsuarioII = idUsuarioII;
    }
}
