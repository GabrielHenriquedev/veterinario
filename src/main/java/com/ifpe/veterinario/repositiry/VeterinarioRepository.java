package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
