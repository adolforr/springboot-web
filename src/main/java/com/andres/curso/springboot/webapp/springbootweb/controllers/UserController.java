package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.andres.curso.springboot.webapp.springbootweb.models.User;

@Controller
public class UserController {

    @GetMapping("/details")
    //Map<String,Object>
    public String details(Model model) {

        User user = new User("Andres", "Guzman");
        
        model.addAttribute("title", "Hola Mundo Spring Boot");
        model.addAttribute("user", user);
        return "details";
    }

    @GetMapping("/list")
    public String list(ModelMap model){
        
        
        model.addAttribute("title","Listado de usuarios");


        return "list";
    }
    
    @ModelAttribute("users") //Para reutilizar datos comunes para los controlladores o para generar un modelo para la vista sin ningun DAO
    public List<User> userModel(){
        return Arrays.asList(new User("Pepa","Gonzalez"),
                                         new User("Lalo","Perez","lperez@mail.com"),
                                         new User("Juanita","Roe","jroe@mail.com"),
                                         new User("Adres","Doe")
                                         );                                         
    }
}
