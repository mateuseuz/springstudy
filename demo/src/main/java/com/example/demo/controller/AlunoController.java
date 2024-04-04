package com.example.demo.controller;

import com.example.demo.model.Aluno;
import com.example.demo.service.AlunoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @GetMapping
    public List<Aluno> listar() {
        return alunoService.listar();
    }

    @PostMapping
    public Aluno criar(@Valid @RequestBody Aluno aluno) {
        return alunoService.criar(aluno);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Aluno aluno, @PathVariable Long id) {
        if(alunoService.atualizar(aluno, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(aluno);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(alunoService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtd() {
        return alunoService.qtd();
    }

    @GetMapping("/{id}")
    public Optional<Aluno> buscarPorId(@PathVariable Long id) {
        return alunoService.buscarPorId(id);
    }

    @GetMapping("/ordenar")
    public List<Aluno> ordenar(@RequestParam(defaultValue = "nome") String sortBy, @RequestParam(defaultValue = "asc") String sortOrder) {
        return alunoService.ordenar(sortBy, sortOrder);
    }
}
