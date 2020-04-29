package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class AdicionarAlunoService {

    @Autowired
    private AlunoRepository repository;

    public void adicionar(AlunoRequest request){
        Aluno aluno = new Aluno();
        aluno.setNomeCompleto(request.getNomeCompleto());
        aluno.setDataDeNascimento(request.getDataDeNascimento());
        aluno.setDocumento(request.getDocumento());

        repository.save(aluno);
    }
}
