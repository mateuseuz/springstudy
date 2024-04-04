package com.example.demo.service;

import com.example.demo.model.Zumba;
import com.example.demo.repository.ZumbaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ZumbaService implements AulaService <Zumba> {

    @Autowired
    private ZumbaRepository zumbaRepository;

    @Override
    public List<Zumba> listar() {
        return zumbaRepository.findAll();
    }

    @Override
    public Zumba criar(Zumba zumba) {
        return zumbaRepository.save(zumba);
    }

    @Override
    public Zumba atualizar(Zumba zumba, Long id) {
        if (zumbaRepository.existsById(id)) {
            zumba.setId(id);
            return zumbaRepository.save(zumba);
        }
        return null;
    }

    @Override
    public boolean deletar(Long id) {
        if (zumbaRepository.existsById(id)) {
            zumbaRepository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int qtd() {
        return zumbaRepository.findAll().size();
    }

    @Override
    public Optional<Zumba> buscarPorId(Long id) {
        return zumbaRepository.findById(id);
    }

    @Override
    public List<Zumba> ordenar(String sortBy, String sortOrder) {
        Sort.Direction direction = sortOrder.equalsIgnoreCase("asc") ? Sort.Direction.ASC : Sort.Direction.DESC;
        Sort sort = Sort.by(direction, sortBy);
        return zumbaRepository.findAll(sort);
    }
}
