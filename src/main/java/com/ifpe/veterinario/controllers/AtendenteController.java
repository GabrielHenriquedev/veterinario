package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.repositiry.Clienterepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtendenteController {
    @Autowired
    private Clienterepository er;

    @GetMapping("/cadastro-cliente")
    public ModelAndView casdastroCliente(){
        ModelAndView cd = new ModelAndView( "atendimentos/CDclients");
        cd.addObject("cliente", new Cliente());
        return cd;
    }
    @PostMapping("/cadastro-cliente")
    public ModelAndView cadastrocliente(Cliente cliente){
        ModelAndView cd = new ModelAndView("atendimentos/CDclients");
        er.save(cliente);
        return cd;

    }
}
