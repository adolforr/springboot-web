package com.andres.curso.springboot.webapp.springbootweb.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamDto;
import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamMixDto;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("api/params")
public class RequestParamController {
    @GetMapping("/foo")
    public ParamDto foo(@RequestParam (required = false, defaultValue = "Hola", name = "mensaje") String message){ //required por default es true
        ParamDto param = new ParamDto();
        param.setMessage(message);
        return param;
    }

    @GetMapping("/bar")
    public ParamMixDto bar(@RequestParam String text, @RequestParam Integer code){
        ParamMixDto params = new ParamMixDto();

        params.setMessage(text);
        params.setCode(code);

        return params;
    }

    @GetMapping("/request")
    public ParamMixDto request(HttpServletRequest request){
        Integer code;

        try {
            code = Integer.parseInt(request.getParameter("code"));
            
        } catch (NumberFormatException e) {
            code = 0;
        }
        ParamMixDto params = new ParamMixDto();

        params.setCode(code);
        params.setMessage(request.getParameter("message"));

        return params;
    }

}
