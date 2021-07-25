package com.ifpe.veterinario.repositiry;


import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface PetRepository extends JpaRepository<Pet, Long> {
    @Query("select p from Pet p where p.dono = :rg")
    Iterable<Pet> findAllPetByOwner(String rg);
}
