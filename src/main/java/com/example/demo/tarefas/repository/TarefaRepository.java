package com.example.demo.tarefas.repository;

import com.example.demo.tarefas.model.Tarefas;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Repository
public class TarefaRepository {
    private final List<Tarefas> tarefaList;

    public TarefaRepository(){
        tarefaList = new ArrayList<>();
    }

    public void salvarTarefa(Tarefas tarefas){
        tarefaList.add(tarefas);
    }

    public List<Tarefas> listarTarefas(){
        /*
            para um desenvolvimento seguro, pelo visto, nao é ideal retornar a lista
            dessa forma: return tarefaList. Pois incrivelmente da para modificar ela.
         */
        return Collections.unmodifiableList(tarefaList);
    }

    public void removerTarefas(String nomeTarefa){
        /*
            forma mais recomendada (a principio) para se buscar o nome e remover a tarefa
         */
        tarefaList.removeIf(tarefas -> tarefas.getNomeTarefa().equalsIgnoreCase(nomeTarefa));
    }

    public void editarTarefas(String nomeTarefa, Tarefas novaTarefa){
        removerTarefas(nomeTarefa);
        salvarTarefa(novaTarefa);
    }

    public Tarefas buscarPorIndice(int index){
        if(index < 0 || index>= tarefaList.size()){
            return null;
        }
        return tarefaList.get(index);
    }
}
