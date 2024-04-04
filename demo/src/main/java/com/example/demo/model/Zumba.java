package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name = "zumba_id")
public class Zumba extends Aula {
    private String ritmo;

    public Zumba() {
    }

    public Zumba(String nome, String instrutorResponsavel, String ritmo) {
        super(nome, instrutorResponsavel);
        this.ritmo = ritmo;
    }

    public String getRitmo() {
        return ritmo;
    }

    public void setRitmo(String ritmo) {
        this.ritmo = ritmo;
    }
}