package br.com.rnrafa.dto;

import java.time.LocalDateTime;

public class MatchRequestDTO {

    private Long idUsuarioI;
    private Long idUsuarioII;

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