package br.com.rnrafa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class ConversasRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 2667010827944871119L;

    @NotNull(message = "Não é possível registrar uma conversa sem que o usuário remetente seja informado.")
    private Long idUsuario1;

    @NotNull(message = "Não é possível registrar uma conversa sem que o usuário destinatário seja informado.")
    private Long idUsuario2;

    @NotNull(message = "Não é possível registrar uma conversa sem que uma iteração de match informada.")
    private Long matchId;

    @NotNull(message = "O mensagem da conversa não pode ser nula")
    @Size(min = 3, max = 900, message = "A mensagem pode ter no mínimo {min} e no máximo {max} caracteres.")
    private String mensagem;

    public Long getIdUsuario1() {
        return idUsuario1;
    }

    public void setIdUsuario1(Long idUsuario1) {
        this.idUsuario1 = idUsuario1;
    }

    public Long getIdUsuario2() {
        return idUsuario2;
    }

    public void setIdUsuario2(Long idUsuario2) {
        this.idUsuario2 = idUsuario2;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
