package com.example.demo.service;

import com.example.demo.model.Treino;
import com.example.demo.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository treinoRepository;

    public List<Treino> listar() {
        return treinoRepository.findAll();
    }

    public Treino criar(Treino treino) {
        return treinoRepository.save(treino);
    }

    public Treino atualizar(Treino treino, Long id) {
        if (treinoRepository.existsById(id)) {
            treino.setId(id);
            return treinoRepository.save(treino);
        }
        return null;
    }

    public boolean deletar(Long id) {
        if (treinoRepository.existsById(id)) {
            treinoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public int qtd() {
        return treinoRepository.findAll().size();
    }

    public Optional<Treino> buscarPorId(Long id) {
        return treinoRepository.findById(id);
    }

    public List<Treino> ordenar(String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        return treinoRepository.findAll(sort);
    }
}
