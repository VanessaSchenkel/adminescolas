package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.TurmaRepository;
import com.unisinos.admescolas.service.AdicionarTurmaService;
import com.unisinos.admescolas.service.AtualizarTurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    private AdicionarTurmaService adicionarTurmaService;

    @Autowired
    private TurmaRepository repository;

    @Autowired
    private AtualizarTurmaService atualizarTurmaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void criarTurma(@Valid @RequestBody TurmaRequest request) {
        adicionarTurmaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Turma> listarTodasTurmas() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarTurma(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarTurma(@PathVariable("id") Integer id, @Valid @RequestBody TurmaRequest request) {
        atualizarTurmaService.atualizar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/ver/{id}")
    public Turma verPorId(@PathVariable("id") Integer id) {
        return repository.findById(id).orElseThrow(() -> new AdminException("Não foi encontrado"));
    }
}
