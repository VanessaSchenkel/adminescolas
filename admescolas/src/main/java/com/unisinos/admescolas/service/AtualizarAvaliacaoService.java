package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AvaliacaoRequest;
import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.domain.exception.AdminException;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AtualizarAvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public void atualizar(Integer id, AvaliacaoRequest request) {
        Avaliacao avaliacao = repository.findById(id).orElseThrow(() -> new AdminException("Avaliação não foi encontrado"));
        avaliacao.setTipoAvaliacao(request.getTipoAvaliacao());
        avaliacao.setEntregou(request.isEntregou());
        avaliacao.setNota(request.getNota());
        avaliacao.setDataAvaliacao(request.getDataAvaliacao());

        repository.save(avaliacao);
    }
}
