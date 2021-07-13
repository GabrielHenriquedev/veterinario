package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.repositiry.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository er;

    @GetMapping("/cadastro-cliente")
    public ModelAndView cadastroCliente(){
        ModelAndView cd = new ModelAndView( "atendimentos/CDclients", "cliente", new Cliente());
        return cd;
    }
    @PostMapping("salvarCliente")
    public ModelAndView cadastrocliente(Cliente cliente){
        ModelAndView cd = new ModelAndView();
        er.save(cliente);
        cd.setViewName("redirect:/home");
        return cd;

    }
}
