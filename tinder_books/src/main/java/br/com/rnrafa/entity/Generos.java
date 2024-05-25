package br.com.rnrafa.entity;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "generos")
public class Generos {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao", nullable = false, length = 80)
    private LocalDateTime datacriacao;

    @Column(name = "genero", nullable = false, length = 80)
    private String genero;

    @Column(name = "ativo", nullable = false, length = 80)
    private String ativo;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataCriacao() {
        return datacriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.datacriacao = dataCriacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getAtivo() {
        return ativo;
    }

    public void setAtivo(String ativo) {
        this.ativo = ativo;
    }
}
