package com.unisinos.admescolas.repository;

import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Integer> {

}
