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
@Table(name = "PRESENCA")
public class Presenca {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ESTEVE_PRESENTE")
    private boolean presente;

    @Column(name = "DATA_PRESENCA")
    private LocalDate dataDePresenca;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_PresencaAluno", referencedColumnName = "id")
    private Aluno aluno;



}
