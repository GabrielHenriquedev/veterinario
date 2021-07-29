package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.models.Telefone;
import com.ifpe.veterinario.repositiry.ClienteRepository;
import com.ifpe.veterinario.repositiry.PetRepository;
import com.ifpe.veterinario.repositiry.TelefoneRepository;
import com.ifpe.veterinario.service.ServiceTelefone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class ClienteController {

    @Autowired
    private ClienteRepository cr;

    @Autowired
    private PetRepository pr;

    @Autowired
    private ServiceTelefone serviceTelefone;

    @Autowired
    private TelefoneRepository tr;


    @GetMapping("/cadastro-cliente")
    public ModelAndView cadastroCliente(){
        ModelAndView cd = new ModelAndView( "atendimentos/cadastroCliente", "cliente", new Cliente());
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
    public ModelAndView detalhesCliente(@PathVariable("rg") String rg) throws Exception{
        Cliente cliente = cr.findByRg(rg);
//        List<Telefone> telefone= serviceTelefone.findByOwnerRg(rg);
        ModelAndView cd = new ModelAndView("clientes/detalhe-cliente", "petCliente", new Pet(cliente));
        cd.addObject("clienteDetails", cliente);
//        cd.addObject("telefones", telefone);
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
