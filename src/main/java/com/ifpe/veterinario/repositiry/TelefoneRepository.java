package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Telefone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TelefoneRepository extends JpaRepository<Telefone, String> {

    @Query("select t from Telefone t where t.idCliente = :rg")
    List<Telefone> findByRg(String rg);
}
