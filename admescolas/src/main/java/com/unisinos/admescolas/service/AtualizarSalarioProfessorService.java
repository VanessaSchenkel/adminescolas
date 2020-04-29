package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.ProfessorRequest;
import com.unisinos.admescolas.domain.Professor;
import com.unisinos.admescolas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarSalarioProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public void atualizar(Integer id, double salario){
        Professor professor = repository.findById(id).get();
        professor.setSalario(salario);

        repository.save(professor);
    }
}
