package br.com.fiap.JavaSprint1Aimpress.dto;

import br.com.fiap.JavaSprint1Aimpress.model.NivelEscolaridade;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record CadastrarCurriculoDto(
        @NotBlank
        String nome,
        @NotBlank
        @Size(max = 11, min =11, message = "Numero de Telefone deve conter 11 caracteres ex: 11943215432")
        String numeroTelefone,
        NivelEscolaridade nivelEscolaridade,
        @NotBlank
        String habilidades,
        @NotBlank
        String certificacoes
) {
        public boolean Valido() {
                return nome() != null &&
                        numeroTelefone() != null &&
                        nivelEscolaridade() != null &&
                        habilidades() != null &&
                        certificacoes() != null;
        }
}