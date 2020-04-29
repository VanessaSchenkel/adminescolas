package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.controller.request.AvaliacaoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import com.unisinos.admescolas.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/avaliacao")
public class AvaliacaoController {

    @Autowired
    private AdicionarAvaliacaoService adicionarAvaliacaoService;

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private AtualizarAvaliacaoService atualizarAvaliacaoService;


    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarAvaliacao(@Valid @RequestBody AvaliacaoRequest request) {
        adicionarAvaliacaoService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Avaliacao> listarTodasAvaliacoes(){
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable("id") Integer id){
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarAvaliacao(@PathVariable("id") Integer id, @Valid @RequestBody AvaliacaoRequest request) {
        atualizarAvaliacaoService.atualizar(id, request);
    }

}
