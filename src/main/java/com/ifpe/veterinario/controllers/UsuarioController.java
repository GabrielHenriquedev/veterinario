package com.ifpe.veterinario.controllers;


import com.ifpe.veterinario.models.Cliente;
import com.ifpe.veterinario.models.Usuario;
import com.ifpe.veterinario.repositiry.ClienteRepository;
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

    @Autowired
    private ClienteRepository cr;


    @GetMapping("/home")
    public ModelAndView home(){
        ModelAndView mh = new ModelAndView("atendimentos/home");
        //select * from Clientes
        Iterable<Cliente> findClientes = cr.findAll();
        mh.addObject("clientes", findClientes);
        return mh;
    }

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mvl = new ModelAndView("atendimentos/login");
        //verifica se há algum objeto Usuario e o instancia
        mvl.addObject("usuario", new Usuario());
        return mvl;
    }

    @GetMapping("/cadastro")
    public ModelAndView cadastrar(){
        ModelAndView mvc = new ModelAndView("atendimentos/cadastro");
        //verifica se há algum objeto Usuario e o instancia
        mvc.addObject("usuario", new Usuario());
        return mvc;
    }


    @PostMapping("salvarUsuario")
    public ModelAndView cadastrando(Usuario user) throws Exception{
        ModelAndView mvc = new ModelAndView();
        serviceUsuario.salvarUsuario(user);
        mvc.setViewName("redirect:/login");
        return mvc;
    }
    @PostMapping("/login")
    public ModelAndView login(@Valid Usuario usuario, BindingResult result, HttpSession session) throws NoSuchAlgorithmException, LoginServiceException {

        ModelAndView mvlogin = new ModelAndView("atendimentos/home", "usuario", new Usuario());
//        mvlogin.addObject("usuario", new Usuario());

        // verificação se há algum erro nos dados enviados
        if (result.hasErrors()){
            //caso haja erro volta para a tela de login
            mvlogin.setViewName("atendimentos/login");
        }
        //verificação se o usuário existe no banco de dados
        //verificando hash md5 da senha para saber se bate
        Usuario userLogin = serviceUsuario.loginUser(usuario.getUser(), Util.md5(usuario.getSenha()));
        if (userLogin == null){
            mvlogin.addObject("msg", "Usuário não encontrado.");
        }else{
            session.setAttribute("usuarioLogado", userLogin );
            return home();
        }


        return mvlogin;
    }

    @PostMapping("cadastro")
    public ModelAndView cadastrar(Usuario usuario){
        ModelAndView mvc = new ModelAndView("redirect:/atendimentos/login");
        ur.save(usuario);
        return mvc;

    }
}
