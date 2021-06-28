package com.ifpe.veterinario.service;

import com.ifpe.veterinario.exceptions.CriptoExistsException;
import com.ifpe.veterinario.exceptions.EmailExistsException;
import com.ifpe.veterinario.exceptions.LoginServiceException;
import com.ifpe.veterinario.models.Usuario;
import com.ifpe.veterinario.repositiry.UsuarioRepository;
import com.ifpe.veterinario.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
public class ServiceUsuario {

    @Autowired
    private UsuarioRepository userRep;

    public void salvarUsuario(Usuario user) throws Exception{

        try{
            if (userRep.findByEmail(user.getEmail()) != null){
                throw new EmailExistsException("O email: " + user.getEmail() + " já se encontra na nossa base de dados");
            }
            user.setSenha(Util.md5(user.getSenha()));

        }catch (NoSuchAlgorithmException e){
            throw new CriptoExistsException("Erro na criptografia da senha");
        }
        userRep.save(user);
    }

    public Usuario loginUser(String user, String senha) throws LoginServiceException {

        Usuario userLogin = userRep.buscarLogin(user, senha);
        return userLogin;

    }
}
