package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.PresencaRequest;
import com.unisinos.admescolas.domain.Presenca;
import com.unisinos.admescolas.repository.PresencaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarPresencaService {

    @Autowired
    private PresencaRepository repository;

    public void adicionar(PresencaRequest request) {
        Presenca presenca = new Presenca();
        presenca.setPresente(request.isPresente());
        presenca.setAluno(request.getAluno());
        presenca.setDataDePresenca(request.getDataDePresenca());

        repository.save(presenca);

    }
}
