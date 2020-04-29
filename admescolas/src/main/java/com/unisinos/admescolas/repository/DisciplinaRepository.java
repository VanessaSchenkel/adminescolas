package com.unisinos.admescolas.repository;

import com.unisinos.admescolas.domain.Disciplina;
import com.unisinos.admescolas.domain.Turma;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DisciplinaRepository extends JpaRepository<Disciplina, Integer> {

}
