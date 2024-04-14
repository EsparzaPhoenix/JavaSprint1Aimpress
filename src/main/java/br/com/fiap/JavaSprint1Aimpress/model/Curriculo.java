package br.com.fiap.JavaSprint1Aimpress.model;

import br.com.fiap.JavaSprint1Aimpress.dto.CadastrarCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.dto.AtualizarCurriculoDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Getter
@NoArgsConstructor

@Entity
@Table(name = "JV_curriculo")
@EntityListeners(AuditingEntityListener.class)
public class Curriculo {

    @Id
    @GeneratedValue
    @Column(name = "id_curriculo")
    private Long id;

    @Column(name = "nm_nome", length = 100, nullable = false)
    private String nome;

    @Column(name = "nr_telefone", length = 11, nullable = false)
    private String numeroTelefone;
    //Ex: 11936620738

    @Column(name = "nvl_escolaridade",length = 20, nullable = false)
    @Enumerated(EnumType.STRING)
    private NivelEscolaridade nivelEscolaridade;

    @Column(name = "ds_habilidades", nullable = false)
    private String habilidades;

    @Column(name = "nm_certificacoes",length = 100)
    private String certificacoes;

    public Curriculo(CadastrarCurriculoDto dto) {
        this.nome = dto.nome();
        this.numeroTelefone = dto.numeroTelefone();
        this.nivelEscolaridade = dto.nivelEscolaridade();
        this.habilidades = dto.habilidades();
        this.certificacoes = dto.certificacoes();
    }

    public void atualizar(AtualizarCurriculoDto dto) {

        if (dto.nome() != null) {
            this.nome = dto.nome();
        }
        if (dto.numeroTelefone() != null){
            this.numeroTelefone = dto.numeroTelefone();
        }
        if (dto.nivelEscolaridade() != null){
            this.nivelEscolaridade = dto.nivelEscolaridade();
        }
        if (dto.habilidades() != null){
            this.habilidades = dto.habilidades();
        }
        if (dto.certificacoes() != null){
            this.certificacoes = dto.certificacoes();
        }
    }

}