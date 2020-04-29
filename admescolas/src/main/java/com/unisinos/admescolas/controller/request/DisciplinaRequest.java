package com.unisinos.admescolas.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DisciplinaRequest {

    @NotEmpty
    private String nome;

    @NotNull
    private LocalTime horario;
}
