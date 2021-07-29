package com.ifpe.veterinario.controllers;




import com.ifpe.veterinario.models.Pet;
import com.ifpe.veterinario.repositiry.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class PetController {
    @Autowired
    private PetRepository er;

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
        //PROBLEMA: os enums estão dando um erro no retorno.
        List<Pet> pets = er.findAll();
        tp.addObject("pets", pets);

        return tp;
    }
}
