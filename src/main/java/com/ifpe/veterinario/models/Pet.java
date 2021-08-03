package com.ifpe.veterinario.models;

import com.ifpe.veterinario.Enums.Raca;

import javax.persistence.*;
import java.util.Optional;

@Entity
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    @Column(name="raça")
    @Enumerated(EnumType.STRING)
    private Raca raca;

    @OneToOne
    private Cliente dono;

    public Pet(){}
    //Construtor geral do Pet
    public Pet(Long id, String nome, Raca raca, Cliente dono) {
        this.id = id;
        this.nome = nome;
        this.raca = raca;
        this.dono = dono;
    }

    //construtor Pet para salvar dono
    public Pet(Cliente dono) {
        this.dono = dono;
    }

    public Cliente getDono() {
        return dono;
    }

    public void setDono(Cliente dono) {
        this.dono = dono;
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

    public Enum getRaca() {
        return raca;
    }

    public void setRaca(Raca raca) {
        this.raca = raca;
    }
    
}
