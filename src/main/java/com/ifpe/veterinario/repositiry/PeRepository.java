package com.ifpe.veterinario.repositiry;


import com.ifpe.veterinario.models.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PeRepository extends JpaRepository<Pet, String> {
}
