package br.com.rnrafa.dto;

public class LikesRequestDTO {
    private Long idUsuarioInteracao;
    private Long idUsuarioOwner;
    private Long idLivroUsuario;

    public Long getIdUsuarioInteracao() {
        return idUsuarioInteracao;
    }

    public void setIdUsuarioInteracao(Long idUsuarioInteracao) {
        this.idUsuarioInteracao = idUsuarioInteracao;
    }

    public Long getIdUsuarioOwner() {
        return idUsuarioOwner;
    }

    public void setIdUsuarioOwner(Long idUsuarioOwner) {
        this.idUsuarioOwner = idUsuarioOwner;
    }

    public Long getIdLivroUsuario() {
        return idLivroUsuario;
    }

    public void setIdLivroUsuario(Long idLivroUsuario) {
        this.idLivroUsuario = idLivroUsuario;
    }
}
