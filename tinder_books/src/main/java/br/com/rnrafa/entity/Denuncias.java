package br.com.rnrafa.entity;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "denuncias")
public class Denuncias implements Serializable {

    @Serial
    private static final long serialVersionUID = 8968950718908911608L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "descricao_denuncia", nullable = false, length = 500)
    private String descricaoDenuncia;

    @Column(name = "id_usuario_denunciante", nullable = false)
    private Long usuarioDenuncianteId;

    @Column(name = "id_usuario_denunciado", nullable = false)
    private Long usuarioDenunciadoId;

    @OneToOne
    @JoinColumn(name = "id_motivo_denuncia", referencedColumnName = "id", nullable = false)
    private MotivosDenuncias motivoDenuncia;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public String getDescricaoDenuncia() {
        return descricaoDenuncia;
    }

    public void setDescricaoDenuncia(String descricaoDenuncia) {
        this.descricaoDenuncia = descricaoDenuncia;
    }

    public Long getUsuarioDenuncianteId() {
        return usuarioDenuncianteId;
    }

    public void setUsuarioDenuncianteId(Long usuarioDenuncianteId) {
        this.usuarioDenuncianteId = usuarioDenuncianteId;
    }

    public Long getUsuarioDenunciadoId() {
        return usuarioDenunciadoId;
    }

    public void setUsuarioDenunciadoId(Long usuarioDenunciadoId) {
        this.usuarioDenunciadoId = usuarioDenunciadoId;
    }

    public MotivosDenuncias getMotivoDenuncia() {
        return motivoDenuncia;
    }

    public void setMotivoDenuncia(MotivosDenuncias motivoDenuncia) {
        this.motivoDenuncia = motivoDenuncia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Denuncias denuncias)) return false;
        return Objects.equals(id, denuncias.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

}
