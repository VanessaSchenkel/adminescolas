package com.unisinos.admescolas.controller.request;

import com.unisinos.admescolas.domain.Aluno;
import com.unisinos.admescolas.domain.Disciplina;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PresencaRequest {

    private boolean presente;

    private LocalDate dataDePresenca;

    private Aluno aluno;

    private Disciplina disciplina;

}
