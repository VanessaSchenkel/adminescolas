package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.controller.request.DisciplinaRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.repository.AlunoRepository;
import com.unisinos.admescolas.repository.DisciplinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class AdicionarDisciplinaService {

    @Autowired
    private DisciplinaRepository repository;

    public void adicionar(DisciplinaRequest request){
       //TODO ARRUMAR QUESTÃO DO HORÁRIO

        Disciplina disciplina = new Disciplina();
       disciplina.setNome(request.getNome());
       disciplina.setHorario(request.getHorario());

        repository.save(disciplina);
    }
}
