package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarTurmaService {

    @Autowired
    private TurmaRepository repository;

    public void atualizar(Integer id, TurmaRequest request) {
        Turma turma = repository.findById(id).orElseThrow(() -> new AdminException("Turma não foi encontrado"));
        turma.setSala(request.getSala());
        turma.setSerieAno(request.getSerieAno());

        repository.save(turma);
    }
}
