package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.DisciplinaRequest;
import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarDisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public void adicionar(DisciplinaRequest request) {
        Disciplina disciplina = new Disciplina();
        disciplina.setNome(request.getNome());
        disciplina.setHorario(request.getHorario());

        repository.save(disciplina);
    }
}
