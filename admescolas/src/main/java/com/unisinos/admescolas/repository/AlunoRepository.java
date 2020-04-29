package com.unisinos.admescolas.repository;

import com.unisinos.admescolas.domain.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

}
