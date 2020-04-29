package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.DisciplinaRequest;
import com.unisinos.admescolas.controller.request.TurmaRequest;
import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.domain.Turma;
import com.unisinos.admescolas.repository.DisciplinaRepository;
import com.unisinos.admescolas.repository.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarDisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public void atualizar(Integer id, DisciplinaRequest request){
        Disciplina disciplina = repository.findById(id).get();
        disciplina.setHorario(request.getHorario());
        disciplina.setNome(request.getNome());

        repository.save(disciplina);
    }
}
