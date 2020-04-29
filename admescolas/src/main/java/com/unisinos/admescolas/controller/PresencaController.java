package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.PresencaRequest;
import com.unisinos.admescolas.domain.Presenca;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.PresencaRepository;
import com.unisinos.admescolas.service.AdicionarPresencaService;
import com.unisinos.admescolas.service.AtualizarPresencaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/presenca")
public class PresencaController {


    @Autowired
    private PresencaRepository repository;

    @Autowired
    private AdicionarPresencaService adicionarPresencaService;

    @Autowired
    private AtualizarPresencaService atualizarPresencaService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void cadastrarPresenca(@Valid @RequestBody PresencaRequest request) {
        adicionarPresencaService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public Presenca verPorId(@PathVariable("id") Integer id) {
        return repository.findById(id).orElseThrow(() -> new AdminException("Não foi encontrado"));
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Presenca> listarTodasPresencas() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarPresenca(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/ver/{id}")
    public void atualizarPresenca(@PathVariable("id") Integer id, @Valid @RequestBody PresencaRequest request) {
        atualizarPresencaService.atualizar(id, request);
    }

}
