package br.com.rnrafa.dto;

import java.io.Serial;
import java.io.Serializable;

public class AvaliacoesRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = 8033696436997381115L;

    private Integer nota;
    private String descricaoAvaliacao;

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

}
