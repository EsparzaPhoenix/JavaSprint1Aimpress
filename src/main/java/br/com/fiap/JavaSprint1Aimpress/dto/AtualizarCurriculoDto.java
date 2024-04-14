package br.com.fiap.JavaSprint1Aimpress.dto;

import jakarta.validation.constraints.NotNull;

public record AtualizarCurriculoDto(
    @NotNull
    Long id,
    String nome,
    String numeroTelefone,
    String habilidades,
    String certificacoes) {

}
