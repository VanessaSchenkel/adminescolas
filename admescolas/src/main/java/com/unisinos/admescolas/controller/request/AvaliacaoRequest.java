package com.unisinos.admescolas.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoRequest {

    private double nota;

    @NotNull
    private boolean entregou;

    @NotNull
    private LocalDateTime dataAvaliacao;

    @NotEmpty
    private String tipoAvaliacao;

}
