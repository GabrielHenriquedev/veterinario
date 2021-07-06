package com.ifpe.veterinario.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Telefone {

    @Id
    private String id;

    @ManyToOne
    private Cliente idCliente;

    private String telefone;
}
