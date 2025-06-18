package com.example.demo.calculadora.controller;

import com.example.demo.calculadora.service.CalculadoraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {
    @Autowired
    private CalculadoraService service;
    /*
        Utilizada porem a forma do subtrair é mais comum e recomendado para se usar
        /calculadora/somar/12/343
     */
    @GetMapping("/somar/{a}/{b}")
    public int somar(@PathVariable int a, @PathVariable int b){
        return service.somar(a,b);
    }

    /*
        dessa forma é a mais comum que vemos na web, o google por exemplo utiliza dessa forma
        ex.: /calculadora/subtrair?a=10&b=49
        se chama query parameters
     */
    @GetMapping("/subtrair")
    public int subtrair(@RequestParam int a, @RequestParam int b){
        return service.subtrair(a,b);
    }
}
