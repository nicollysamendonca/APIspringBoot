package com.example.demo.controllers;

import com.example.demo.models.Curriculo;
import com.example.demo.repositories.CurriculoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/curriculos")
@CrossOrigin
public class CurriculoController {

    private final CurriculoRepository repository;

    public CurriculoController(CurriculoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listar")
    public List<Curriculo> listarCurriculos() {
        return repository.findAll();
    }

    @GetMapping("/curriculo/{id}")
    public ResponseEntity<Curriculo> getCurriculoById(@PathVariable Long id) {
        Optional<Curriculo> curriculo = repository.findById(id);
        return curriculo.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/criar")
    public ResponseEntity<Curriculo> criarCurriculo(@RequestBody Curriculo curriculo) {
        Curriculo novoCurriculo = repository.save(curriculo);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoCurriculo);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCurriculo(@PathVariable Long id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Curriculo> atualizarCurriculo(@PathVariable Long id, @RequestBody Curriculo curriculoAtualizado) {
        Optional<Curriculo> curriculoExistente = repository.findById(id);
        if (curriculoExistente.isPresent()) {
            Curriculo curriculo = curriculoExistente.get();
            // Atualiza os campos necessários do currículo existente com os dados do curriculoAtualizado
            curriculo.setNome(curriculoAtualizado.getNome());
            curriculo.setExperiencia(curriculoAtualizado.getExperiencia());

            Curriculo currAtualizado = repository.save(curriculo);
            return ResponseEntity.ok(currAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

