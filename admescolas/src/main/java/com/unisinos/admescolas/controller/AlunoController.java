package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.service.AdicionarAlunoService;
import com.unisinos.admescolas.service.AtualizarAlunoService;
import com.unisinos.admescolas.service.AtualizarTurmaDoAlunoService;
import com.unisinos.admescolas.service.DefinirTurmaDoAlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    private AdicionarAlunoService adicionarAlunoService;

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private DefinirTurmaDoAlunoService definirTurmaDoAlunoService;

    @Autowired
    private AtualizarAlunoService atualizarAlunoService;

    @Autowired
    private AtualizarTurmaDoAlunoService atualizarTurmaDoAlunoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void matricularAluno(@Valid @RequestBody AlunoRequest request) {
        adicionarAlunoService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Aluno> listarTodosAlunos(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarAluno(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id-aluno}/{id-turma}")
    public void colocarAlunoNaTurma(@PathVariable("id-aluno") Integer idAluno, @PathVariable("id-turma") Integer idTurma){
        definirTurmaDoAlunoService.definir(idAluno, idTurma);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarAluno(@PathVariable("id") Integer id, @Valid @RequestBody AlunoRequest request) {
        atualizarAlunoService.atualizar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("atualizar/{id-aluno}/{id-turma}")
    public void atualizarTurmaDoAluno(@PathVariable("id-aluno") Integer idAluno, @PathVariable("id-turma") Integer idTurma ) {
        atualizarTurmaDoAlunoService.atualizar(idAluno, idTurma);
    }
}
