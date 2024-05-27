package br.com.rnrafa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class DenunciasRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -4032372469529408419L;

    @NotNull(message = "O preenchimento do campo descrição da denuncia é obrigatório")
    @Size(min = 20, max = 500, message = "A descrição da denúncia deve ter no mínimo {min} e no máximo {max} caracteres")
    private String descricaoDenuncia;

    @NotNull(message = "É obrigatório que a denúncia seja vinculada a algum motivo para que a mesma possa ser registrada.")
    private Long motivoDenunciaId;

    @NotNull(message = "A denúncia precisa do id do usuário denunciante para que a mesma seja registrada.")
    private Long usuarioDenuncianteId;

    @NotNull(message = "A denúncia precisa do id do usuário denunciado para que a mesma seja registrada.")
    private Long usuarioDenunciadoId;

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

}
