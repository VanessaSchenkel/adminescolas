package com.unisinos.admescolas.repository;

import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TurmaRepository extends JpaRepository<Turma, Integer> {

}
