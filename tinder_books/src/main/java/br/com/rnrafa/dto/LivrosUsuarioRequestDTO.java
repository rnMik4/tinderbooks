package br.com.rnrafa.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class LivrosUsuarioRequestDTO implements Serializable {
    @Serial
    private static final long serialVersionUID = 5022761497136504575L;

    @NotNull(message = "Obrigatório informar se o livro estara ativo ou não no sistema")
    private Boolean ativo;

    @NotEmpty(message = "É obrigatório informar uma breve descrição da avaliação")
    @NotNull(message = "É obrigatório informar uma breve descrição da avaliação")
    @Size(min = 10, max = 300, message = "A descrição da avaliação deve ter no mínimo {min} e no máximo {max} caracteres")
    private String nomeLivro;

    @NotNull(message = "É obrigatório informar o número de páginas do livro")
    private Integer quantidadePaginas;

    @NotEmpty(message = "É obrigatório informar o autor do livro")
    @NotNull(message = "É obrigatório informar o autor do livro")
    @Size(min = 4, max = 80, message = "O nome do autor deve ter no mínimo {min} e no máximo {max} caracteres")
    private String autor;

    @NotEmpty(message = "É obrigatório informar uma breve descrição do livro")
    @NotNull(message = "É obrigatório informar uma breve descrição do livro")
    @Size(min = 10, max = 300, message = "A descrição da avaliação deve ter no mínimo {min} e no máximo {max} caracteres")
    private String descricaoUsuario;

    @NotNull(message = "É obrigatório informar o id do usuário para registrar o livro no sistema")
    private Long usuarioId;

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

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

}
