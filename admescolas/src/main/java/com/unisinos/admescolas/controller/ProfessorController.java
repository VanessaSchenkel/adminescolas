package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.ProfessorRequest;
import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Professor;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.ProfessorRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import com.unisinos.admescolas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/professor")
public class ProfessorController {

    @Autowired
    private AdicionarProfessorService adicionarProfessorService;

    @Autowired
    private ProfessorRepository repository;

    @Autowired
    private AtualizarProfessorService atualizarProfessorService;

    @Autowired
    private AtualizarSalarioProfessorService atualizarSalarioProfessorService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarProfessor(@Valid @RequestBody ProfessorRequest request) {
        adicionarProfessorService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Professor> listarTodosProfessores(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarProfessor(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarProfessor(@PathVariable("id") Integer id, @Valid @RequestBody ProfessorRequest request) {
        atualizarProfessorService.atualizar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}/{valor}")
    public void atualizarSalarioProfessor(@PathVariable("id") Integer id, @PathVariable("valor") double valor) {
        atualizarSalarioProfessorService.atualizar(id, valor);
    }
}
