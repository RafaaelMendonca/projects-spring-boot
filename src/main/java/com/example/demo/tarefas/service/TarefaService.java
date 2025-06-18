package com.example.demo.tarefas.service;

import com.example.demo.tarefas.model.Tarefas;
import com.example.demo.tarefas.repository.TarefaRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TarefaService {
    private final TarefaRepository tarefaRepository;

    public TarefaService(TarefaRepository tarefaRepository){
        this.tarefaRepository = tarefaRepository;
    }

    public void adicionarTarefa(Tarefas tarefas){
        if(tarefas.getDataTarefa().isBefore(LocalDate.now())){
            throw new IllegalArgumentException("A data da tarefa não pode ser no passado");
        }
        tarefaRepository.salvarTarefa(tarefas);
    }

    public List<Tarefas> listarTarefas(){
        return tarefaRepository.listarTarefas();
    }

    public void removerTarefas(String nomeTarefa){
        if(nomeTarefa.trim().isEmpty()){
            throw new IllegalArgumentException("Atente-se a preencher de forma correta o argumento");
        }
        tarefaRepository.removerTarefas(nomeTarefa);
    }

    public void editarTarefas(String nomeTarefa, Tarefas novaTarefa){
        List<Tarefas> tarefa = tarefaRepository.listarTarefas();
        boolean verificacao = false;
        for(Tarefas t: tarefa){
            if(t.getNomeTarefa().equalsIgnoreCase(nomeTarefa)){
                verificacao = true;
                break;
            }
        }
        if(!verificacao){
            throw new IllegalArgumentException("Nome da tarefa não encontrada");
        }
        tarefaRepository.editarTarefas(nomeTarefa, novaTarefa);
    }

    public Tarefas buscarPorIndice(int index){
        if(tarefaRepository.buscarPorIndice(index) == null) {
            throw new IllegalArgumentException("Índice não encontrado");
        }
        return tarefaRepository.buscarPorIndice(index);
    }

}
