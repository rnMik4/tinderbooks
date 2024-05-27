package br.com.rnrafa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class AvaliacoesRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8033696436997381115L;

    @NotNull(message = "O campo Nota é obrigatório")
    private Integer nota;

    @NotEmpty(message = "É obrigatório informar uma breve descrição da avaliação")
    @NotNull(message = "É obrigatório informar uma breve descrição da avaliação")
    @Size(min = 10, max = 300, message = "A descrição da avaliação deve ter no mínimo {min} e no máximo {max} caracteres")
    private String descricaoAvaliacao;

    @NotNull(message = "É obrigatório que a avaliação esteja associada a um match")
    private Long matchId;

    @NotNull(message = "É obrigatório informar o Id do usuário que está registando a avaliação")
    private Long usuarioId;

    public Integer getNota() {
        return nota;
    }

    public void setNota(Integer nota) {
        this.nota = nota;
    }

    public String getDescricaoAvaliacao() {
        return descricaoAvaliacao;
    }

    public void setDescricaoAvaliacao(String descricaoAvaliacao) {
        this.descricaoAvaliacao = descricaoAvaliacao;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }
}
