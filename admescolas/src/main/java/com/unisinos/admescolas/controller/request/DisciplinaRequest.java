package com.unisinos.admescolas.controller.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.text.SimpleDateFormat;
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
