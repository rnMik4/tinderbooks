package br.com.rnrafa.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "motivos_denuncias")
public class MotivosDenuncias implements Serializable {

    @Serial
    private static final long serialVersionUID = 665407769757022815L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_criacao", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;

    @Column(name = "motivo_denuncia", nullable = false, length = 100)
    private String descricaoMotivoDenuncia;

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "motivoDenuncia")
    private Denuncias denuncia;

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

    public String getDescricaoMotivoDenuncia() {
        return descricaoMotivoDenuncia;
    }

    public void setDescricaoMotivoDenuncia(String descricaoMotivoDenuncia) {
        this.descricaoMotivoDenuncia = descricaoMotivoDenuncia;
    }

    public Denuncias getDenuncia() {
        return denuncia;
    }

    public void setDenuncia(Denuncias denuncia) {
        this.denuncia = denuncia;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof MotivosDenuncias that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
