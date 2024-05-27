package br.com.rnrafa.dto;

import br.com.rnrafa.entity.MotivosDenuncias;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class DenunciasResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4794762449274636625L;

    private Long id;
    private Date dataCriacao;
    private String descricaoDenuncia;
    private Long motivoDenunciaId;
    private Long usuarioDenuncianteId;
    private Long usuarioDenunciadoId;
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

    public Long getMotivoDenunciaId() {
        return motivoDenunciaId;
    }

    public void setMotivoDenunciaId(Long motivoDenunciaId) {
        this.motivoDenunciaId = motivoDenunciaId;
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

}
