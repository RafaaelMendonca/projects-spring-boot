package com.example.demo.tarefas.model;

import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class Tarefas {

    private String nomeTarefa;
    private LocalDate dataTarefa;

    public Tarefas(){}

    public Tarefas(String nomeTarefa, LocalDate dataTarefa){
        this.nomeTarefa = nomeTarefa;
        this.dataTarefa = dataTarefa;
    }


    public String getNomeTarefa() {
        return nomeTarefa;
    }

    public void setNomeTarefa(String nomeTarefa) {
        this.nomeTarefa = nomeTarefa;
    }

    public LocalDate getDataTarefa() {
        return dataTarefa;
    }

    public void setDataTarefa(LocalDate dataTarefa) {
        this.dataTarefa = dataTarefa;
    }
}
