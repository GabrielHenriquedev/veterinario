package com.ifpe.veterinario.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {
//A classe teleffone é responsável pelos números extras do cliente
    @Id
    private String id;
    @ManyToOne
    private Cliente idCliente;
    private String telefone;

    public Telefone(String id, Cliente idCliente, String telefone) {
        this.id = id;
        this.idCliente = idCliente;
        this.telefone = telefone;
    }
    public Telefone(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Cliente getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Cliente idCliente) {
        this.idCliente = idCliente;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
