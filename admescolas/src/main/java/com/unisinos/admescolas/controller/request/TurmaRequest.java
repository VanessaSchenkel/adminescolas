package com.unisinos.admescolas.controller.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TurmaRequest {
    @NotEmpty
    private String sala;

    @NotNull
    private int serieAno;

}
