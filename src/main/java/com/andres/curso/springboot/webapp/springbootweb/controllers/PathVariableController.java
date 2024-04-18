package com.andres.curso.springboot.webapp.springbootweb.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andres.curso.springboot.webapp.springbootweb.models.User;
import com.andres.curso.springboot.webapp.springbootweb.models.dto.ParamDto;

@RestController
@RequestMapping("/api/var")
public class PathVariableController {

    @Value("${config.username}")
    private String username;
    @Value("${config.listOfValues}")
    private List<String> listOfValues;
    @Value("${config.code}")
    private Integer code;

    @Value("#{${config.valuesMap}}")
    private Map<String,Object> valuesMap;

    @Value("#{${config.valuesMap}.product}")
    private String productName;

    @Value("#{${config.valuesMap}.price}")
    private Long price;
    
    @Value("#{'${config.listOfValues}'.toUpperCase().split(',')}")//Lenguaje de expresión en spring
    private List<String> valueList;

    @Value("#{'${config.listOfValues}'.toUpperCase()}")
    private String valueString;

    @Autowired
    private Environment environment;

    @GetMapping("/baz/{message}")
    public ParamDto baz(@PathVariable String message){ // En este tipo de parametros siempre son requeridos

        ParamDto param = new ParamDto();
        param.setMessage(message);

        return param;

    }

    @GetMapping("/mix/{product}/{id}")
    public Map<String, Object> mixPathVar(@PathVariable String product, @PathVariable Long id){

        Map<String, Object> json = new HashMap<>();
        json.put("product", product);
        json.put("id",id);

        return json;

    }

    @PostMapping("/create")
    public User create(@RequestBody User user){
                user.setName(user.getName().toUpperCase());
                return user;
    }

    @GetMapping("/values")
    public Map<String,Object> values(@Value("${config.message}") String message){
        Map<String,Object> jsonMap = new HashMap<>();
        jsonMap.put("username", username);
        jsonMap.put("code", code);
        jsonMap.put("message", message);
        jsonMap.put("message2", environment.getProperty("config.message"));
        jsonMap.put("code2", Integer.valueOf(environment.getProperty("config.code")));
        jsonMap.put("code3", environment.getProperty("config.code",Long.class));
        jsonMap.put("listOfValues", listOfValues);
        jsonMap.put("valueList", valueList);
        jsonMap.put("valueString", valueString);
        jsonMap.put("valuesMap", valuesMap);
        jsonMap.put("productName", productName);
        jsonMap.put("price", price);

        return jsonMap;

    }

}
