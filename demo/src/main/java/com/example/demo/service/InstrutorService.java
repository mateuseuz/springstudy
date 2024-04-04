package com.example.demo.service;

import com.example.demo.model.Instrutor;
import com.example.demo.repository.InstrutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class InstrutorService implements PessoaService <Instrutor> {
    @Autowired
    private InstrutorRepository instrutorRepository;

    @Override
    public List<Instrutor> listar() {
        return instrutorRepository.findAll();
    }

    @Override
    public Instrutor criar(Instrutor instrutor) {
        return instrutorRepository.save(instrutor);
    }

    @Override
    public Instrutor atualizar(Instrutor instrutor, Long id) {
        if (instrutorRepository.existsById(id)) {
            instrutor.setId(id);
            return instrutorRepository.save(instrutor);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (instrutorRepository.existsById(id)) {
            instrutorRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int qtd() {
        return instrutorRepository.findAll().size();
    }

    @Override
    public Optional<Instrutor> buscarPorId(Long id) {
        return instrutorRepository.findById(id);
    }

    @Override
    public List<Instrutor> ordenar(String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        return instrutorRepository.findAll(sort);
    }
}
