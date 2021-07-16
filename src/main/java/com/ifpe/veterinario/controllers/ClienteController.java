package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.repositiry.ClienteRepository;
import com.ifpe.veterinario.repositiry.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository cr;

    @Autowired
    private PetRepository pr;


    @GetMapping("/cadastro-cliente")
    public ModelAndView cadastroCliente(){
        ModelAndView cd = new ModelAndView( "atendimentos/CDclients", "cliente", new Cliente());
        return cd;
    }
    @PostMapping("salvarCliente")
    public ModelAndView cadastrocliente(Cliente cliente){
        ModelAndView cd = new ModelAndView();
        cr.save(cliente);
        cd.setViewName("redirect:/home");
        return cd;

    }
    @GetMapping("/{rg}")
    public ModelAndView detalhesCliente(@PathVariable("rg") String rg){
        Cliente cliente = cr.findByRg(rg);
        System.out.println("*************************************************************************");
        System.out.println("*************************************************************************");
        System.out.println("*************************************************************************");
        System.out.println(rg);
        System.out.println(cliente);
        System.out.println("*************************************************************************");
        System.out.println("*************************************************************************");
        System.out.println("*************************************************************************");
        ModelAndView cd = new ModelAndView("clientes/detalhe-cliente", "petCliente", new Pet(cliente));
        cd.addObject("clienteDetails", cliente);
        return cd;
    }
    @PostMapping("/{rg}")
    public ModelAndView salvarPetCliente(@PathVariable("rg") String rg, Pet petCliente){
        ModelAndView cp = new ModelAndView();
        Cliente cliente = cr.findByRg(rg);
        petCliente.setDono(cliente);
        pr.save(petCliente);
        cp.setViewName("redirect:/home");
       return cp;

    }
}
