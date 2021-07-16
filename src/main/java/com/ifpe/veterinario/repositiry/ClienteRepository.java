package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ClienteRepository extends JpaRepository<Cliente, String>  {

    @Query("select c from Cliente c where c.rg = :rg")
    public Cliente findByRg(String rg);
}
