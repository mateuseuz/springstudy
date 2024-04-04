package com.example.demo.controller;

import com.example.demo.model.JiuJitsu;
import com.example.demo.service.JiuJitsuService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jiujitsu")
public class JiuJitsuController {

    @Autowired
    JiuJitsuService jiuJitsuService;

    @GetMapping
    public List<JiuJitsu> listar() {
        return jiuJitsuService.listar();
    }

    @PostMapping
    public JiuJitsu criar(@Valid @RequestBody JiuJitsu jiuJitsu) {
        return jiuJitsuService.criar(jiuJitsu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody JiuJitsu jiuJitsu, @PathVariable Long id) {
        if(jiuJitsuService.atualizar(jiuJitsu, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(jiuJitsu);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(jiuJitsuService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtd() {
        return jiuJitsuService.qtd();
    }

    @GetMapping("/{id}")
    public Optional<JiuJitsu> buscarPorId(@PathVariable Long id) {
        return jiuJitsuService.buscarPorId(id);
    }

    @GetMapping("/ordenar")
    public List<JiuJitsu> ordenar(@RequestParam(defaultValue = "nome") String sortBy, @RequestParam(defaultValue = "asc") String sortOrder) {
        return jiuJitsuService.ordenar(sortBy, sortOrder);
    }
}
