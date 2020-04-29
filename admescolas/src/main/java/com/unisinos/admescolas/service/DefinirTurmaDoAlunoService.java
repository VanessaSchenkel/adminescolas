package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.domain.exception.AdminException;
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
        Aluno aluno = alunoRepository.findById(idAluno).orElseThrow(() -> new AdminException("Aluno não foi encontrado"));
        Turma turma = turmaRepository.findById(idTurma).orElseThrow(() -> new AdminException("Turma não foi encontrado"));

        aluno.setTurma(turma);

        alunoRepository.save(aluno);
    }
}
