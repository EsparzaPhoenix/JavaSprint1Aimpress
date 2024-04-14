package br.com.fiap.JavaSprint1Aimpress.dto;

import br.com.fiap.JavaSprint1Aimpress.model.Curriculo;
import br.com.fiap.JavaSprint1Aimpress.model.NivelEscolaridade;

public record DetalhesCurriculoDto(Long id, String nome, String numeroTelefone,
                                   NivelEscolaridade nivelEscolaridade, String habilidades,
                                   String certificacoes) {

    public DetalhesCurriculoDto(Curriculo curriculo) {
        this(curriculo.getId(), curriculo.getNome(), curriculo.getNumeroTelefone(),
                curriculo.getNivelEscolaridade(), curriculo.getHabilidades(),
                curriculo.getCertificacoes());
    }
}