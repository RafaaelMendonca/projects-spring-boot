package com.example.demo.tarefas.repository;

import com.example.demo.tarefas.model.Tarefas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Repository
public class TarefaRepository {
    private final List<Tarefas> tarefaList;

    public TarefaRepository(){
        tarefaList = new ArrayList<>();
    }

    public boolean salvarTarefa(Tarefas tarefas){
        return tarefaList.add(tarefas);
    }

    public List<Tarefas> listarTarefas(){
        /*
            para um desenvolvimento seguro, pelo visto, nao é ideal retornar a lista
            dessa forma: return tarefaList. Pois incrivelmente da para modificar ela.
         */
        return Collections.unmodifiableList(tarefaList);
    }

    public boolean removerTarefas(int index){
        if(index < 0 || index >= tarefaList.size()){
            return false;
        }
        tarefaList.remove(index);
        return true;
    }

    public boolean editarTarefas(int index, Tarefas tarefas){
        if(index < 0 || index >= tarefaList.size()){
            return false;
        }
        tarefaList.set(index, tarefas);
        return true;
    }

    public Tarefas buscarPorIndice(int index){
        if(index < 0 || index>= tarefaList.size()){
            return null;
        }
        return tarefaList.get(index);
    }
}
