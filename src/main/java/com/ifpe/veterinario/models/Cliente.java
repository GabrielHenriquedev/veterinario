package com.ifpe.veterinario.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
public class Cliente {

    @Id
    private String rg;
    private String nome;
    private String email;
    private String telefone;

    @OneToMany(mappedBy = "dono")
    private List<Pet> pet;

    @OneToMany
    @JoinColumn(name="telefone_emergencial")
    private List<Telefone> emergencial;


    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
