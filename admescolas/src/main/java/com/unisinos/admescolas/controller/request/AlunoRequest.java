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
public class AlunoRequest {

    @NotEmpty
    private String nomeCompleto;

    @NotEmpty
    private String documento;

    @NotNull
    private LocalDate dataDeNascimento;

}
