package br.com.rnrafa.dto;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public class MotivosDenunciasResponseDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -7970412041206920501L;

    private Long id;
    private Date dataCriacao;
    private String descricaoMotivoDenuncia;

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

}
