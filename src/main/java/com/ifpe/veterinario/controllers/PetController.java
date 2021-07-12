package com.ifpe.veterinario.controllers;




import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.repositiry.PeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PetController {
    @Autowired
    private PeRepository er;

    @GetMapping("/cadastro-pet")
    public ModelAndView cadastroPet(){
        ModelAndView cd = new ModelAndView( "atendimentos/PetCD");
        return cd;
    }
    @PostMapping("salvarpet")
    public ModelAndView cadastropet(Pet pet){
        ModelAndView cd = new ModelAndView();
        er.save(pet);
        cd.setViewName("redirect:/home");
        return cd;

    }
}
