package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@PrimaryKeyJoinColumn(name = "treino_id")
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 5, max = 11)
    @Column(nullable = false)
    private String nome;
    @NotNull
    @Column(nullable = false)
    private int series;
    @NotNull
    @Column(nullable = false)
    private int repeticoes;
    @NotNull
    @Column(nullable = false)
    private int carga;

    public Treino() {
    }

    public Treino(String nome, int repeticoes, int series, int carga) {
        this.nome = nome;
        this.series = series;
        this.repeticoes = repeticoes;
        this.carga = carga;
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

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public int getRepeticoes() {
        return repeticoes;
    }

    public void setRepeticoes(int repeticoes) {
        this.repeticoes = repeticoes;
    }

    public int getCarga() {
        return carga;
    }

    public void setCarga(int carga) {
        this.carga = carga;
    }
}

