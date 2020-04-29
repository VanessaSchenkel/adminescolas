package com.unisinos.admescolas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ALUNO")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOME_COMPLETO")
    private String nomeCompleto;

    @Column(name = "DOCUMENTO")
    private String documento;

    @Column(name = "DATA_NASCIMENTO")
    private LocalDate dataDeNascimento;

    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "FK_AlunoTurma", referencedColumnName = "id")
    private Turma turma;
}
