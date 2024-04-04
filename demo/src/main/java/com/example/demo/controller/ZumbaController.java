package com.example.demo.controller;

import com.example.demo.model.Zumba;
import com.example.demo.service.ZumbaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/zumba")
public class ZumbaController {

    @Autowired
    ZumbaService zumbaService;

    @GetMapping
    public List<Zumba> listar() {
        return zumbaService.listar();
    }

    @PostMapping
    public Zumba criar(@Valid @RequestBody Zumba zumba) {
        return zumbaService.criar(zumba);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Zumba zumba, @PathVariable Long id) {
        if(zumbaService.atualizar(zumba, id) == null) {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(zumba);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(zumbaService.deletar(id)) {
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }

    @GetMapping("/qtd")
    public int qtd() {
        return zumbaService.qtd();
    }

    @GetMapping("/{id}")
    public Optional<Zumba> buscarPorId(@PathVariable Long id) {
        return zumbaService.buscarPorId(id);
    }

    @GetMapping("/ordenar")
    public List<Zumba> ordenar(@RequestParam(defaultValue = "nome") String sortBy, @RequestParam(defaultValue = "asc") String sortOrder) {
        return zumbaService.ordenar(sortBy, sortOrder);
    }
}
