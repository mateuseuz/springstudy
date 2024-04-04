package com.example.demo.repository;

import com.example.demo.model.JiuJitsu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JiuJitsuRepository extends JpaRepository<JiuJitsu, Long> {
}