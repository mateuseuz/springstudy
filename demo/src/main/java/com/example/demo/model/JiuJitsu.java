package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "jiujitsu_id")
public class JiuJitsu extends Aula {
    private String faixa;
    private String tecnica;

    public JiuJitsu() {
    }

    public JiuJitsu(String nome, String instrutorResponsavel, String faixa, String tecnica) {
        super(nome, instrutorResponsavel);
        this.faixa = faixa;
        this.tecnica = tecnica;
    }

    public String getFaixa() {
        return faixa;
    }

    public void setFaixa(String faixa) {
        this.faixa = faixa;
    }

    public String getTecnica() {
        return tecnica;
    }

    public void setTecnica(String tecnica) {
        this.tecnica = tecnica;
    }
}