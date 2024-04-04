package com.example.demo.controller;

import com.example.demo.model.Treino;
import com.example.demo.service.TreinoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    TreinoService treinoService;

    @GetMapping
    public List<Treino> listar() {
        return treinoService.listar();
    }

    @PostMapping
    public Treino criar(@Valid @RequestBody Treino treino) {
        return treinoService.criar(treino);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Treino treino, @PathVariable Long id) {
        if(treinoService.atualizar(treino, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(treino);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(treinoService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtd() {
        return treinoService.qtd();
    }

    @GetMapping("/{id}")
    public Optional<Treino> buscarPorId(@PathVariable Long id) {
        return treinoService.buscarPorId(id);
    }

    @GetMapping("/ordenar")
    public List<Treino> ordenar(@RequestParam(defaultValue = "nome") String sortBy,
                              @RequestParam(defaultValue = "asc") String sortOrder) {
        return treinoService.ordenar(sortBy, sortOrder);
    }
}