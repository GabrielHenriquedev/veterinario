package com.ifpe.veterinario.controllers;


import com.ifpe.veterinario.models.Usuario;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UsuarioController {

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
}
