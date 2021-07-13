package com.ifpe.veterinario.controllers;

import com.ifpe.veterinario.models.Veterinario;
import com.ifpe.veterinario.repositiry.VeterinarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class VeterinarioController {

    @Autowired
    VeterinarioRepository vr;

    @GetMapping("/veterinarios")
    public ModelAndView veterinarios(){
        ModelAndView vet = new ModelAndView("veterinario/index");
        Iterable<Veterinario> veterinarios = vr.findAll();
        vet.addObject("veterinarios", veterinarios);

        return vet;
    }
    @GetMapping("/cadastro-veterinario")
    public ModelAndView cadastrarVeterinario(){
        ModelAndView vet = new ModelAndView("veterinario/cadastro-veterinario", "veterinario", new Veterinario());
        return vet;
    }
    @PostMapping("salvarVeterinario")
    public ModelAndView cadastrarVeterinario(Veterinario veterinario){
        ModelAndView cv = new ModelAndView();
        vr.save(veterinario);
        cv.setViewName("redirect:/home");
        return cv;

    }
//    @RequestMapping("/{codigo}")
//    public ModelAndView detalhesEvento(@PathVariable("codigo") Long codigo){
//        ModelAndView mvd = new ModelAndView("detalhesEvento");
//        Evento event = er.findByCodigo(codigo);
//        mvd.addObject("evento", event);
//
//        Iterable<Cliente> convidados = cr.findByEvento(event);
//        mvd.addObject("convidados", convidados);
//
//        return mvd;
//    }


    @RequestMapping("/{id}")
    public ModelAndView detalhesVeterinario(@PathVariable("id") Long id){
        ModelAndView cv = new ModelAndView("veterinario/detalhe-veterinario");
        Optional<Veterinario> veterinario = vr.findById(id);
        cv.addObject("veterinarios", veterinario);
        return cv;

    }
}
