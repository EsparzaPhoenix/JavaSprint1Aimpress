package br.com.fiap.JavaSprint1Aimpress.controller;

import br.com.fiap.JavaSprint1Aimpress.dto.CadastrarCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.dto.DetalhesCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.dto.AtualizarCurriculoDto;
import br.com.fiap.JavaSprint1Aimpress.model.Curriculo;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import br.com.fiap.JavaSprint1Aimpress.repository .CurriculoRepository;

import java.util.Optional;

@RestController
@RequestMapping("/curriculos") //URL base "/curriculos"
public class CurriculoController {

    @Autowired
    public CurriculoRepository curriculoRepository;

    @PostMapping("/cadastrar") //URL "/curriculos/cadastrar"
    @Transactional
    public ResponseEntity<DetalhesCurriculoDto> cadastrar(@RequestBody @Valid CadastrarCurriculoDto dto, UriComponentsBuilder uriBuilder) {
        if (!dto.Valido()) {
            return ResponseEntity.badRequest().build();
        }

        var curriculo = new Curriculo(dto);
        curriculoRepository.save(curriculo);
        var url = uriBuilder.path("/curriculos/{id}").buildAndExpand(curriculo.getId()).toUri();
        return ResponseEntity.created(url).body(new DetalhesCurriculoDto(curriculo));
    }

    @GetMapping("/{id}") //URL "/curriculos/{id}"
    public ResponseEntity<DetalhesCurriculoDto> getPorId(@PathVariable Long id) {
        var curriculo = curriculoRepository.findById(id);
        return curriculo.map(value -> ResponseEntity.ok(new DetalhesCurriculoDto(value))).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/ids") //URL "/curriculos/ids"
    public ResponseEntity<Page<DetalhesCurriculoDto>> listarTodos(@PageableDefault(sort = {"id"}) Pageable pageable){
        var page = curriculoRepository.findAll(pageable).map(DetalhesCurriculoDto::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}") //URL "/curriculos/{id}"
    @Transactional
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        Optional<Curriculo> optionalCurriculo = curriculoRepository.findById(id);

        if (optionalCurriculo.isPresent()) {
            // Id foi encontrado
            curriculoRepository.deleteById(id);
            return ResponseEntity.noContent().build(); // responde com 204
        } else {
            // Id não foi encontrado
            return ResponseEntity.notFound().build(); // responde com 404
        }
    }

    @PutMapping("/{id}") //URL "/curriculos/{id}"
    @Transactional
    public ResponseEntity<DetalhesCurriculoDto> atualizar(@PathVariable Long id, @RequestBody @Valid AtualizarCurriculoDto dto) {
        // Verifica se o Id existe no BD
        Optional<Curriculo> optionalCurriculo = curriculoRepository.findById(id);

        if (optionalCurriculo.isPresent()) {
            // O Id foi encontrado
            Curriculo curriculo = optionalCurriculo.get();
            curriculo.atualizar(dto);
            curriculoRepository.save(curriculo);
            return ResponseEntity.ok(new DetalhesCurriculoDto(curriculo));
        } else {
            // Id não foi encontrado
            return ResponseEntity.notFound().build(); // Resposta 404 Not Found
        }
    }

}