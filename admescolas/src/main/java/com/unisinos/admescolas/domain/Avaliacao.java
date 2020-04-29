package com.unisinos.admescolas.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "AVALIACAO")
public class Avaliacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "NOTA")
    private double nota;

    @Column(name = "ENTREGOU")
    private boolean entregou;

    @Column(name = "DATA_AVALIACAO")
    private LocalDateTime dataAvaliacao;

    @Column(name = "TIPO_AVALIACAO")
    private String tipoAvaliacao;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AvaliacaoAluno", referencedColumnName = "id")
    private Aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AvaliacaoDisciplina", referencedColumnName = "id")
    private Disciplina disciplina;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AvaliacaoTurma", referencedColumnName = "id")
    private List<Turma> listaDeTurma;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "FK_AvaliacaoProfessor", referencedColumnName = "id")
    private List<Professor> listaDeProfessores;
}