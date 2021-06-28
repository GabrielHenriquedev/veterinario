package com.ifpe.veterinario.controllers;


import com.ifpe.veterinario.models.Usuario;
import com.ifpe.veterinario.repositiry.UsuarioRepository;
import com.ifpe.veterinario.exceptions.LoginServiceException;
import com.ifpe.veterinario.service.ServiceUsuario;
import com.ifpe.veterinario.util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.security.NoSuchAlgorithmException;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository ur;
    @Autowired
    private ServiceUsuario serviceUsuario;


    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mh = new ModelAndView("atendimentos/home");
        return mh;
    }




    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mvl = new ModelAndView("atendimentos/login");
        mvl.addObject("usuario", new Usuario());
        return mvl;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mvc = new ModelAndView("atendimentos/cadastro");
        mvc.addObject("usuario", new Usuario());
        return mvc;
    }

    @PostMapping("salvarUsuario")
    public ModelAndView cadastrar(Usuario user) throws Exception{
        ModelAndView mvc = new ModelAndView();
        serviceUsuario.salvarUsuario(user);
        mvc.setViewName("redirect:/login");
        return mvc;
    }
    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult result, HttpSession session) throws NoSuchAlgorithmException, LoginServiceException {

        ModelAndView mvlogin = new ModelAndView("atendimentos/home", "usuario", new Usuario());
//        mvlogin.addObject("usuario", new Usuario());

        if (result.hasErrors()){
            mvlogin.setViewName("atendimentos/login");
        }
        Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
        if (userLogin == null){
            mvlogin.addObject("msg", "Usuário não encontrado.");
        }else{
            session.setAttribute("usuarioLogado", userLogin );
            return home();
        }


        return mvlogin;
    }

}
