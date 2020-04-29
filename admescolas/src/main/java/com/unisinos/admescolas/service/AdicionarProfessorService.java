package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.ProfessorRequest;
import com.unisinos.admescolas.domain.Professor;
import com.unisinos.admescolas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public void adicionar(ProfessorRequest request) {
        Professor professor = new Professor();
        professor.setNomeCompleto(request.getNomeCompleto());
        professor.setDataDeIngresso(request.getDataDeIngresso());
        professor.setDataDeNascimento(request.getDataDeNascimento());
        professor.setEndereco(request.getEndereco());
        professor.setSalario(request.getSalario());

        repository.save(professor);
    }
}
