package com.unisinos.admescolas.service;

import com.unisinos.admescolas.controller.request.AvaliacaoRequest;
import com.unisinos.admescolas.domain.Avaliacao;
import com.unisinos.admescolas.repository.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdicionarAvaliacaoService {

    @Autowired
    private AvaliacaoRepository repository;

    public void adicionar(AvaliacaoRequest request) {
        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setDataAvaliacao(request.getDataAvaliacao());
        avaliacao.setNota(request.getNota());
        avaliacao.setEntregou(request.isEntregou());
        avaliacao.setTipoAvaliacao(avaliacao.getTipoAvaliacao());

        repository.save(avaliacao);

    }
}
