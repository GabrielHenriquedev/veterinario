package com.ifpe.veterinario.controllers;




import com.ifpe.veterinario.Enums.Raca;
import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.repositiry.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.expression.Strings;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Controller
public class PetController {
    @Autowired
    private PetRepository petRepository;

    @GetMapping("/cadastro-pet")
    public ModelAndView cadastroPet(){
        ModelAndView cp = new ModelAndView( "atendimentos/PetCD");
        return cp;
    }
//    @PostMapping("salvarpet")
//    public ModelAndView cadastropet(Pet pet){
//        ModelAndView cd = new ModelAndView();
//        er.save(pet);
//        cd.setViewName("redirect:/home");
//        return cd;
//
//    }

    @GetMapping("/pets")
    //listar todos os pets
    public ModelAndView todosPets(){
        ModelAndView tp = new ModelAndView("pets/pets");
        tp.addObject("pets", petRepository.findAll());

        return tp;
    }
}
