package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Aula {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String nome;
    @NotNull
    @Size(min = 3, max = 30)
    @Column(nullable = false)
    private String instrutorResponsavel;

    public Aula() {
    }

    public Aula(String nome, String instrutorResponsavel) {
        this.nome = nome;
        this.instrutorResponsavel = instrutorResponsavel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getInstrutorResponsavel() {
        return instrutorResponsavel;
    }

    public void setInstrutorResponsavel(String instrutorResponsavel) {
        this.instrutorResponsavel = instrutorResponsavel;
    }
}
