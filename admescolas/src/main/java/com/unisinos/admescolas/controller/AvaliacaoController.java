package com.unisinos.admescolas.controller;

import com.unisinos.admescolas.controller.request.AvaliacaoRequest;
import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import com.unisinos.admescolas.service.AdicionarAvaliacaoService;
import com.unisinos.admescolas.service.AtualizarAvaliacaoAlunoService;
import com.unisinos.admescolas.service.AtualizarAvaliacaoDisciplinaService;
import com.unisinos.admescolas.service.AtualizarAvaliacaoService;
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

    @Autowired
    private AtualizarAvaliacaoDisciplinaService atualizarAvaliacaoDisciplinaService;

    @Autowired
    private AtualizarAvaliacaoAlunoService atualizarAvaliacaoAlunoService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void adicionarAvaliacao(@Valid @RequestBody AvaliacaoRequest request) {
        adicionarAvaliacaoService.adicionar(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/todos")
    public List<Avaliacao> listarTodasAvaliacoes() {
        return repository.findAll();
    }

    @ResponseStatus(HttpStatus.OK)
    @DeleteMapping("/{id}")
    public void deletarAvaliacao(@PathVariable("id") Integer id) {
        repository.deleteById(id);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{id}")
    public void atualizarAvaliacao(@PathVariable("id") Integer id, @Valid @RequestBody AvaliacaoRequest request) {
        atualizarAvaliacaoService.atualizar(id, request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/disciplina/{id-avaliacao}/{id-disc}")
    public void adicionarDisciplinaAvaliacao(@PathVariable("id-avaliacao") Integer idAval, @PathVariable("id-disc") Integer idDisc) {
        atualizarAvaliacaoDisciplinaService.atualizar(idAval, idDisc);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/aluno/{id-avaliacao}/{id-aluno}")
    public void adicionarAlunoAvaliacao(@PathVariable("id-avaliacao") Integer idAval, @PathVariable("id-aluno") Integer idAlu) {
        atualizarAvaliacaoAlunoService.atualizar(idAval, idAlu);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/ver/{id}")
    public Avaliacao verPorId(@PathVariable("id") Integer id) {
        return repository.findById(id).orElseThrow(() -> new AdminException("Não foi encontrado"));
    }

}
