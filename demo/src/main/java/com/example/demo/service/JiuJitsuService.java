package com.example.demo.service;

import com.example.demo.model.JiuJitsu;
import com.example.demo.repository.JiuJitsuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class JiuJitsuService implements AulaService <JiuJitsu> {

    @Autowired
    private JiuJitsuRepository jiuJitsuRepository;

    @Override
    public List<JiuJitsu> listar() {
        return jiuJitsuRepository.findAll();
    }

    @Override
    public JiuJitsu criar(JiuJitsu jiuJitsu) {
        return jiuJitsuRepository.save(jiuJitsu);
    }

    @Override
    public JiuJitsu atualizar(JiuJitsu jiuJitsu, Long id) {
        if (jiuJitsuRepository.existsById(id)) {
            jiuJitsu.setId(id);
            return jiuJitsuRepository.save(jiuJitsu);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (jiuJitsuRepository.existsById(id)) {
            jiuJitsuRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int qtd() {
        return jiuJitsuRepository.findAll().size();
    }

    @Override
    public Optional<JiuJitsu> buscarPorId(Long id) {
        return jiuJitsuRepository.findById(id);
    }

    @Override
    public List<JiuJitsu> ordenar(String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        return jiuJitsuRepository.findAll(sort);
    }
}
