package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarTurmaDoAlunoService {

    @Autowired
    private AlunoRepository repository;

    @Autowired
    private TurmaRepository turmaRepository;

    public void atualizar(Integer idAluno, Integer idTurma){
        Aluno aluno = repository.findById(idAluno).get();
        Turma turma = turmaRepository.findById(idTurma).get();

        aluno.setTurma(turma);

        repository.save(aluno);
    }
}
