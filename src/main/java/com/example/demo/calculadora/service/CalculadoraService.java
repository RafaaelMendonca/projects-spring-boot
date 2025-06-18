package com.example.demo.calculadora.service;

import org.springframework.stereotype.Service;

@Service
public class CalculadoraService {

    public int somar(int a, int b){
        return a + b;
    }

    public int subtrair(int a, int b){
        return a-b;
    }
}
