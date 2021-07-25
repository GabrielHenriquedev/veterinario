package com.ifpe.veterinario.repositiry;

import com.ifpe.veterinario.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //retorna usuário com o email desejado
    @Query("select u from Usuario u where u.email = :email")
    public Usuario findByEmail(String email);

    //retorna usuário e senha correspondentes
    @Query("select uLogin from Usuario uLogin where uLogin.user = :user and uLogin.senha = :senha")
    public Usuario buscarLogin(String user, String senha);


}

