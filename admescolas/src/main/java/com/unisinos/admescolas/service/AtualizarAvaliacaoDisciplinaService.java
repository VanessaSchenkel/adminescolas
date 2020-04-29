package com.unisinos.admescolas.service;

import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import com.unisinos.admescolas.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarAvaliacaoDisciplinaService {

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private DisciplinaRepository disciplinaRepository;

    public void atualizar(Integer idAvalicao, Integer idDisciplina) {
        Avaliacao avaliacao = repository.findById(idAvalicao).orElseThrow(() -> new AdminException("Avaliação não foi encontrado"));
        Disciplina disciplina = disciplinaRepository.findById(idDisciplina).orElseThrow(() -> new AdminException("Disciplina não foi encontrado"));

        avaliacao.setDisciplina(disciplina);

        repository.save(avaliacao);
    }
}
