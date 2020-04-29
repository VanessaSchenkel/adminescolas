package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AlunoRequest;
import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarAlunoService {

    @Autowired
    private AlunoRepository repository;

    public void atualizar(Integer id, AlunoRequest request){
        Aluno aluno = repository.findById(id).orElseThrow(() -> new AdminException("Aluno não foi encontrado"));
        aluno.setNomeCompleto(request.getNomeCompleto());
        aluno.setDataDeNascimento(request.getDataDeNascimento());
        aluno.setDocumento(request.getDocumento());

        repository.save(aluno);
    }
}
