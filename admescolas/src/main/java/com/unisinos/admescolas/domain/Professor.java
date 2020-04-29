package com.unisinos.admescolas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "PROFESSOR")
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "ENDERECO")
    private String endereco;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataDeNascimento;

    @Column(name = "DATA_INGRESSO")
    private LocalDate dataDeIngresso;

    @Column(name = "SALARIO")
    private double salario;

}

