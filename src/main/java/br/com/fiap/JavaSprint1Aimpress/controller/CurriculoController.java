package br.com.fiap.JavaSprint1Aimpress.controller;

import br.com.fiap.JavaSprint1Aimpress.dto.CadastrarCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.dto.DetalhesCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.model.Curriculo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fiap.JavaSprint1Aimpress.repository .CurriculoRepository;

@RestController
@RequestMapping("/curriculo")
public class CurriculoController {

    @Autowired
    private CurriculoRepository curriculoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DetalhesCurriculoDto> cadastrar(@RequestBody @Valid CadastrarCurriculoDto dto, UriComponentsBuilder uriBuilder){

        var curriculo = new Curriculo(dto);
        curriculoRepository.save(curriculo);
        var url = uriBuilder.path("curriculos/{id}").buildAndExpand(curriculo.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCurriculoDto(curriculo));

    }

}
