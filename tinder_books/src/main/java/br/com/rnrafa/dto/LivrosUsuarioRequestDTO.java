package br.com.rnrafa.dto;

import java.io.Serial;
import java.io.Serializable;

public class LivrosUsuarioRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5022761497136504575L;

    private Boolean ativo;
    private String nomeLivro;
    private Integer quantidadePaginas;
    private String autor;
    private String descricaoUsuario;

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public String getNomeLivro() {
        return nomeLivro;
    }

    public void setNomeLivro(String nomeLivro) {
        this.nomeLivro = nomeLivro;
    }

    public Integer getQuantidadePaginas() {
        return quantidadePaginas;
    }

    public void setQuantidadePaginas(Integer quantidadePaginas) {
        this.quantidadePaginas = quantidadePaginas;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getDescricaoUsuario() {
        return descricaoUsuario;
    }

    public void setDescricaoUsuario(String descricaoUsuario) {
        this.descricaoUsuario = descricaoUsuario;
    }

}
