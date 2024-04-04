package com.example.demo.repository;

import com.example.demo.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TreinoRepository extends JpaRepository<Treino, Long> {
}