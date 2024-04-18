package com.andres.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping({"","/","/home"})
    public String home(){

        //return "redirect:/details"; // redirect reinicia el request haciendo un refresh
        return "forward:/details"; //LOS PARAMETROS NO SE PIERDEN y se mantiene dentro de la misma petición http y se utiliza normalmente para redirigir entre controladores
    }


}
