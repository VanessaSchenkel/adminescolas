package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.PresencaRequest;
import com.unisinos.admescolas.domain.Presenca;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.PresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarPresencaService {

    @Autowired
    private PresencaRepository repository;

    public void atualizar(Integer id, PresencaRequest request) {
        Presenca presenca = repository.findById(id).orElseThrow(() -> new AdminException("Aluno não foi encontrado"));
        presenca.setDataDePresenca(request.getDataDePresenca());
        presenca.setAluno(request.getAluno());
        presenca.setPresente(request.isPresente());

        repository.save(presenca);
    }
}
