package br.com.rnrafa.dto;

import br.com.rnrafa.entity.LivrosUsuario;
import br.com.rnrafa.entity.Usuarios;

import java.time.LocalDateTime;

public class LikesResponseDTO {
    private Long id;
    private LocalDateTime datacriacao;

    private Long idUsuarioInteracao;
    private Long idUsuarioOwner;
    private Long idLivroUsuario;
    private Usuarios usuarioInteracao;
    private Usuarios usuarioOwner;
    private LivrosUsuario livrosUsuario;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

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

    public Usuarios getUsuarioInteracao() {
        return usuarioInteracao;
    }

    public void setUsuarioInteracao(Usuarios usuarioInteracao) {
        this.usuarioInteracao = usuarioInteracao;
    }

    public Usuarios getUsuarioOwner() {
        return usuarioOwner;
    }

    public void setUsuarioOwner(Usuarios usuarioOwner) {
        this.usuarioOwner = usuarioOwner;
    }

    public LivrosUsuario getLivrosUsuario() {
        return livrosUsuario;
    }

    public void setLivrosUsuario(LivrosUsuario livrosUsuario) {
        this.livrosUsuario = livrosUsuario;
    }
}
