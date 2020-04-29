package com.unisinos.admescolas.service;

import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarAvaliacaoAlunoService {

    @Autowired
    private AvaliacaoRepository repository;

    @Autowired
    private AlunoRepository alunoRepository;

    public void atualizar(Integer idAvalicao, Integer idAluno) {
        Avaliacao avaliacao = repository.findById(idAvalicao).orElseThrow(() -> new AdminException("Avaliação não foi encontrado"));
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new AdminException("Aluno não foi encontrado"));

        avaliacao.setAluno(aluno);

        repository.save(avaliacao);
    }
}
