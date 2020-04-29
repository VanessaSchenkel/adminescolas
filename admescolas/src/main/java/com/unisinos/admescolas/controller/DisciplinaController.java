package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.DisciplinaRequest;
import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.DisciplinaRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import com.unisinos.admescolas.service.AdicionarDisciplinaService;
import com.unisinos.admescolas.service.AdicionarTurmaService;
import com.unisinos.admescolas.service.AtualizarDisciplinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/disciplina")
public class DisciplinaController {

    @Autowired
    private AdicionarDisciplinaService adicionarDisciplinaService;

    @Autowired
    private DisciplinaRepository repository;

    @Autowired
    private AtualizarDisciplinaService atualizarDisciplinaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarDisciplina(@Valid @RequestBody DisciplinaRequest request) {
        adicionarDisciplinaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Disciplina> listarTodasDisciplinas(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarDisciplina(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarDisciplina(@PathVariable("id") Integer id, @Valid @RequestBody DisciplinaRequest request) {
        atualizarDisciplinaService.atualizar(id, request);
    }
}
