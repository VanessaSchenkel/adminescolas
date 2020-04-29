package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarTurmaService {

    @Autowired
    private TurmaRepository repository;

    public void atualizar(Integer id, TurmaRequest request){
        Turma turma = repository.findById(id).get();
        turma.setSala(request.getSala());
        turma.setSerieAno(request.getSerieAno());

        repository.save(turma);
    }
}