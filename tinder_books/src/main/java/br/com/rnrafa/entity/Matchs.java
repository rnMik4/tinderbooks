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

    @Column(name = "id_usuario_i", nullable = false, length = 80)
    private Long idUsuarioI;

    @Column(name = "id_usuario_ii", nullable = false, length = 80)
    private Long idUsuarioII;


    public LocalDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(LocalDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getIdUsuarioI() {
        return idUsuarioI;
    }

    public void setIdUsuarioI(Long idUsuarioI) {
        this.idUsuarioI = idUsuarioI;
    }

    public Long getIdUsuarioII() {
        return idUsuarioII;
    }

    public void setIdUsuarioII(Long idUsuarioII) {
        this.idUsuarioII = idUsuarioII;
    }
}
