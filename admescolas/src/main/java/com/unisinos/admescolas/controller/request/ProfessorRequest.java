package com.unisinos.admescolas.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfessorRequest {

    @NotEmpty
    private String nomeCompleto;

    @NotEmpty
    private String endereco;

    @NotNull
    private LocalDate dataDeNascimento;

    @NotNull
    private LocalDate dataDeIngresso;

    private double salario;

}
