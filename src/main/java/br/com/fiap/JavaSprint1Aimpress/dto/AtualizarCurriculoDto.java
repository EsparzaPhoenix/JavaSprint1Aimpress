package br.com.fiap.JavaSprint1Aimpress.dto;

import br.com.fiap.JavaSprint1Aimpress.model.NivelEscolaridade;
import jakarta.validation.constraints.NotNull;

public record AtualizarCurriculoDto(
    @NotNull
    Long id,
    String nome,
    String numeroTelefone,
    NivelEscolaridade nivelEscolaridade,
    String habilidades,
    String certificacoes) {

}
