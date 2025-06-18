package com.example.demo.tarefas.controller;

import com.example.demo.tarefas.model.Tarefas;
import com.example.demo.tarefas.service.TarefaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    private final TarefaService service;

    public TarefaController(TarefaService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<String> adicionarTarefa(@RequestBody Tarefas tarefas){
        try{
            service.adicionarTarefa(tarefas);
            return ResponseEntity.ok("Tarefa salva com sucesso");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<List<Tarefas>> listarTarefas(){
        return ResponseEntity.ok(service.listarTarefas());
    }

    @DeleteMapping("/{nome}")
    public ResponseEntity<String> removerTarefa(@PathVariable String nome){
        service.removerTarefas(nome);
        return ResponseEntity.ok("Tarefa removida com sucesso!");
    }

    @PutMapping("/{nome}")
    public ResponseEntity<String> editarTarefa(@PathVariable String nome, @RequestBody Tarefas tarefa){
        service.editarTarefas(nome, tarefa);
        return ResponseEntity.ok("Tarefa editada com sucesso!");
    }

    @GetMapping("/{index}")
    public ResponseEntity<Tarefas> buscarPorIndice(@PathVariable int index){
        return ResponseEntity.ok().body(service.buscarPorIndice(index));
    }

}
