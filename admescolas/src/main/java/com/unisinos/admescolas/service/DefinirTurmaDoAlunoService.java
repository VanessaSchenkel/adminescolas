package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DefinirTurmaDoAlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    @Autowired
    private TurmaRepository turmaRepository;

    public void definir(Integer idAluno, Integer idTurma){
        Aluno aluno = alunoRepository.findById(idAluno).get();
        Turma turma = turmaRepository.findById(idTurma).get();

        aluno.setTurma(turma);

        alunoRepository.save(aluno);
    }
}
