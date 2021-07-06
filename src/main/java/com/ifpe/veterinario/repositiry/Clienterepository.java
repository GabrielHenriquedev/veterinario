package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Clienterepository extends JpaRepository<Cliente, String>  {


}
