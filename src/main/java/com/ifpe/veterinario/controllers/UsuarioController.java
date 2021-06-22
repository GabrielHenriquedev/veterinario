package com.ifpe.veterinario.controllers;


import com.ifpe.veterinario.models.Usuario;
import com.ifpe.veterinario.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mvl = new ModelAndView("atendimentos/login");
        return mvl;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mvc = new ModelAndView("atendimentos/cadastro");
        mvc.addObject("usuario", new Usuario());
        return mvc;
    }
    @PostMapping("cadastro")
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView mvc = new ModelAndView("redirect:/atendimentos/login");
        ur.save(usuario);
        return mvc;

    }
}
