package br.com.rnrafa.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serial;
import java.io.Serializable;

public class MotivosDenunciasRequestDTO implements Serializable {

    @Serial
    private static final long serialVersionUID = -313816466020832412L;

    @NotNull(message = "O campo motivo denúncia é obrigatório")
    @Size(min = 5, max = 100, message = "O campo motivo denúncia deve ter no mínimo {min} e no máximo {max} caracteres")
    private String descricaoMotivoDenuncia;

    public String getDescricaoMotivoDenuncia() {
        return descricaoMotivoDenuncia;
    }

    public void setDescricaoMotivoDenuncia(String descricaoMotivoDenuncia) {
        this.descricaoMotivoDenuncia = descricaoMotivoDenuncia;
    }
}
