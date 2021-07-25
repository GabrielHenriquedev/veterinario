package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.repositiry.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AtendimentoController {
//    @Autowired
//    private ClienteRepository cr;


//    @GetMapping("/home")
//    public ModelAndView home(){
//        ModelAndView mh = new ModelAndView("atendimentos/home");
//        Iterable<Cliente> findClientes = cr.findAll();
//        mh.addObject("clientes", findClientes);
//        return mh;
//    }
}
