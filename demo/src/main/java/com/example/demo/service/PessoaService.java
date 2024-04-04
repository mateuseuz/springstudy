package com.example.demo.service;

import com.example.demo.model.Pessoa;
import java.util.List;
import java.util.Optional;

public interface PessoaService <T extends Pessoa> {
    List<T> listar();

    T criar(T t);

    T atualizar(T t, Long id);

    boolean deletar(Long id);

    int qtd();

    Optional<T> buscarPorId(Long id);

    List<T> ordenar(String sortBy, String sortOrder);
}