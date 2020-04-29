package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.ProfessorRequest;
import com.unisinos.admescolas.domain.Professor;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarProfessorService {

    @Autowired
    private ProfessorRepository repository;

    public void atualizar(Integer id, ProfessorRequest request) {
        Professor professor = repository.findById(id).orElseThrow(() -> new AdminException("Professor não foi encontrado"));
        professor.setNomeCompleto(request.getNomeCompleto());
        professor.setDataDeIngresso(request.getDataDeIngresso());
        professor.setDataDeNascimento(request.getDataDeNascimento());
        professor.setEndereco(request.getEndereco());
        professor.setSalario(request.getSalario());

        repository.save(professor);
    }
}
