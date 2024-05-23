package br.com.rnrafa.dto;

import br.com.rnrafa.entity.Usuarios;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class AvaliacoesResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 6508990980185238266L;

    private Long id;
    private Long matchId;
    private Date dataCriacao;
    private Integer nota;
    private String descricaoAvaliacao;
    private Usuarios usuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMatchId() {
        return matchId;
    }

    public void setMatchId(Long matchId) {
        this.matchId = matchId;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

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

    public Usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuarios usuario) {
        this.usuario = usuario;
    }
}
