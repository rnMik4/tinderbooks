package br.com.rnrafa.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "likes")
@JsonIgnoreProperties(ignoreUnknown=true)
public class Likes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao", nullable = false, length = 80)
    private LocalDateTime datacriacao;

    @Column(name = "id_usuario_interacao", nullable = false, length = 80)
    private Long idUsuarioInteracao;

    @Column(name = "id_usuario_owner")
    private Long idUsuarioOwner;

    @Column(name = "id_livro_usuario")
    private Long idLivroUsuario;


    @OneToOne
    @JoinColumn(name = "usuario_owner", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuarioOwner;

    @OneToOne
    @JoinColumn(name = "usuario_interacao", referencedColumnName = "id", insertable = false, updatable = false)
    private Usuarios usuarioInteracao;

    @OneToOne
    @JoinColumn(name = "livro_usuario", referencedColumnName = "id", insertable = false, updatable = false)
    private LivrosUsuario livroUsuario;

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

    public Long getIdUsuarioOwner() {
        return idUsuarioOwner;
    }

    public void setIdUsuarioOwner(Long idUsuarioOwner) {
        this.idUsuarioOwner = idUsuarioOwner;
    }

    public LocalDateTime getDatacriacao() {
        return datacriacao;
    }

    public void setDatacriacao(LocalDateTime datacriacao) {
        this.datacriacao = datacriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuarioInteracao() {
        return idUsuarioInteracao;
    }

    public void setIdUsuarioInteracao(Long idUsuarioInteracao) {
        this.idUsuarioInteracao = idUsuarioInteracao;
    }

    public LivrosUsuario getLivroUsuario() {
        return livroUsuario;
    }

    public void setLivroUsuario(LivrosUsuario livroUsuario) {
        this.livroUsuario = livroUsuario;
    }


    public Usuarios getUsuarioOwner() {
        return usuarioOwner;
    }

    public void setUsuarioOwner(Usuarios usuarioOwner) {
        this.usuarioOwner = usuarioOwner;
    }
}