package br.com.rnrafa.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "tb_matchs")
public class Matchs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "dataCriacao", nullable = false, length = 80)
    private LocalDateTime dataCriacao;

    @Column(name = "usuario_1", nullable = false, length = 80)
    private Long id_usuario_i;

    @Column(name = "usuario_ii", nullable = false, length = 80)
    private Long getId_usuario_ii;


    public Matchs() {
    }

    public Matchs(Long id, LocalDateTime dataCriacao, Long id_usuario_i, Long getId_usuario_ii) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.id_usuario_i = id_usuario_i;
        this.getId_usuario_ii = getId_usuario_ii;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId_usuario_i() {
        return id_usuario_i;
    }

    public void setId_usuario_i(Long id_usuario_i) {
        this.id_usuario_i = id_usuario_i;
    }

    public Long getGetId_usuario_ii() {
        return getId_usuario_ii;
    }

    public void setGetId_usuario_ii(Long getId_usuario_ii) {
        this.getId_usuario_ii = getId_usuario_ii;
    }
}
