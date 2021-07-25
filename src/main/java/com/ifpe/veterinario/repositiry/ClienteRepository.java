package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, String>  {

    @Query("select c from Cliente c where c.rg = :rg")
    public Cliente findByRg(String rg);
    @Query("select p from Pet p where p.dono = :rg")
    List<Pet> findAllPetByOwner(String rg);

}
