package com.ifpe.veterinario.repository;

import com.ifpe.veterinario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
