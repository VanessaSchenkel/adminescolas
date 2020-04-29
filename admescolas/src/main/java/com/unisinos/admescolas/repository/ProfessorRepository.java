package com.unisinos.admescolas.repository;

import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Professor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfessorRepository extends JpaRepository<Professor, Integer> {

}
