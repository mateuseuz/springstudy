package com.example.demo.service;

import com.example.demo.model.Aluno;
import com.example.demo.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class AlunoService implements PessoaService <Aluno> {

    @Autowired
    private AlunoRepository alunoRepository;

    @Override
    public List<Aluno> listar() {
        return alunoRepository.findAll();
    }

    @Override
    public Aluno criar(Aluno aluno) {
        return alunoRepository.save(aluno);
    }

    @Override
    public Aluno atualizar(Aluno aluno, Long id) {
        if (alunoRepository.existsById(id)) {
            aluno.setId(id);
            return alunoRepository.save(aluno);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (alunoRepository.existsById(id)) {
            alunoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int qtd() {
        return alunoRepository.findAll().size();
    }

    @Override
    public Optional<Aluno> buscarPorId(Long id) {
        return alunoRepository.findById(id);
    }

    @Override
    public List<Aluno> ordenar(String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        return alunoRepository.findAll(sort);
    }
}
