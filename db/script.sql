CREATE DATABASE ADMINESCOLA;

CREATE table Turma (
 ID integer NOT NULL unique AUTO_INCREMENT,
 sala varchar(10) NOT NULL,
 serie_ano int(15) NOT NULL,
 PRIMARY KEY (ID)
);

CREATE table Disciplina (
 ID integer NOT NULL unique AUTO_INCREMENT,
 nome varchar(50) NOT NULL,
 horario time,
 PRIMARY KEY (ID)
);

CREATE table Professor (
 ID integer NOT NULL unique AUTO_INCREMENT,
 nome_completo varchar(150) NOT NULL,
 endereco varchar(50) NOT NULL,
 data_nascimento date NOT NULL,
 salario double,
 data_ingresso date NOT NULL,
 PRIMARY KEY (ID)
);

CREATE table Aluno (
 ID integer NOT NULL unique AUTO_INCREMENT,
 nome_completo varchar(150) NOT NULL,
 documento varchar(15) NOT NULL,
 data_nascimento date NOT NULL,
 FK_AlunoTurma integer, 
 PRIMARY KEY (ID),
 FOREIGN KEY (FK_AlunoTurma) REFERENCES Turma(ID)
);

CREATE table Avaliacao(
 ID integer NOT NULL unique AUTO_INCREMENT,
 nota double, 
 entregou boolean,
 data_avaliacao datetime,
 tipo_avaliacao varchar(50),
 FK_AvaliacaoAluno integer, 
 FK_AvaliacaoDisciplina integer,
 FK_AvaliacaoTurma integer,
 FK_AvaliacaoProfessor integer,
 PRIMARY KEY (ID),
 FOREIGN KEY (FK_AvaliacaoAluno) REFERENCES Aluno(ID),
 FOREIGN KEY (FK_AvaliacaoDisciplina) REFERENCES Disciplina(ID),
 FOREIGN KEY (FK_AvaliacaoTurma) REFERENCES Turma(ID),
 FOREIGN KEY (FK_AvaliacaoProfessor) REFERENCES Professor(ID)
);

CREATE table Presenca(
 ID integer NOT NULL unique AUTO_INCREMENT,
 esteve_presente boolean,
 FK_PresencaAluno integer,
 FK_PresencaDisciplina integer,
 PRIMARY KEY (ID),
 FOREIGN KEY (FK_PresencaAluno) REFERENCES Aluno(ID),
 FOREIGN KEY (FK_PresencaDisciplina) REFERENCES Disciplina(ID)
);

CREATE table Professor_Disciplina_Turma(
 ID integer NOT NULL unique AUTO_INCREMENT,
 FK_PDTDisciplina integer, 
 FK_PDTTurma integer,
 FK_PDTProfessor integer,
 PRIMARY KEY (ID),
 FOREIGN KEY (FK_PDTDisciplina) REFERENCES Disciplina(ID),
 FOREIGN KEY (FK_PDTTurma) REFERENCES Turma(ID),
 FOREIGN KEY (FK_PDTProfessor) REFERENCES Professor(ID)
);

INSERT INTO turma (sala,serie_ano) VALUES ("233A", 1);
INSERT INTO turma (sala,serie_ano) VALUES ("301A", 12);
INSERT INTO turma (sala,serie_ano) VALUES ("320B", 9);
INSERT INTO turma (sala,serie_ano) VALUES ("320B", 1);
INSERT INTO turma (sala,serie_ano) VALUES ("12B", 12);
INSERT INTO turma (sala,serie_ano) VALUES ("323B", 4);
INSERT INTO turma (sala,serie_ano) VALUES ("123B", 5);
INSERT INTO turma (sala,serie_ano) VALUES ("45B", 6);
INSERT INTO turma (sala,serie_ano) VALUES ("123B", 7);
INSERT INTO turma (sala,serie_ano) VALUES ("124B", 8);

INSERT INTO disciplina (nome,horario) VALUES ("GEOGRAFIA", '08:00:00');
INSERT INTO disciplina (nome,horario) VALUES ("MATEMATICA", '10:00:00');
INSERT INTO disciplina (nome,horario) VALUES ("GEOGRAFIA AVANÇADA", '11:20:00');
INSERT INTO disciplina (nome,horario) VALUES ("LIBRAS", '15:30:00');
INSERT INTO disciplina (nome,horario) VALUES ("FISICA", '11:00:00');
INSERT INTO disciplina (nome,horario) VALUES ("QUIMICA", '09:00:00');
INSERT INTO disciplina (nome,horario) VALUES ("PORTUGUES", '09:30:00');

INSERT INTO professor (nome_completo,endereco, data_nascimento,salario,data_ingresso) VALUES ("Julia", "Rua da casa", '2000-12-12', 6541.80, '2010-10-10');
INSERT INTO professor (nome_completo,endereco, data_nascimento,salario,data_ingresso) VALUES ("Fernando", "Amazonas", '1980-10-01', 8541.80, '2015-10-10');
INSERT INTO professor (nome_completo,endereco, data_nascimento,salario,data_ingresso) VALUES ("Paula", "Jardinaia", '1993-11-29', 141.80, '2017-10-10');
INSERT INTO professor (nome_completo,endereco, data_nascimento,salario,data_ingresso) VALUES ("José", "Poa", '1990-11-22', 1141.80, '2009-10-10');
INSERT INTO professor (nome_completo,endereco, data_nascimento,salario,data_ingresso) VALUES ("José", "SL", '1999-11-22', 1741.80, '2019-10-10');

INSERT INTO aluno (nome_completo,documento, data_nascimento, FK_AlunoTurma) VALUES ("José",  "00515100", '1990-11-22', 5);
INSERT INTO aluno (nome_completo,documento, data_nascimento, FK_AlunoTurma) VALUES ("Josiane",  "01515100", '1998-10-25', 1);
INSERT INTO aluno (nome_completo,documento, data_nascimento,  FK_AlunoTurma) VALUES ("Leo",  "00515101", '1970-04-24',3);
INSERT INTO aluno (nome_completo,documento, data_nascimento,  FK_AlunoTurma) VALUES ("Vicente",  "00515107", '1995-05-19',4);
INSERT INTO aluno (nome_completo,documento, data_nascimento, FK_AlunoTurma) VALUES ("Jorge",  "00515109", '1997-10-18',1);
INSERT INTO aluno (nome_completo,documento, data_nascimento, FK_AlunoTurma) VALUES ("Lucas",  "00515177", '1997-12-13',3);
INSERT INTO aluno (nome_completo,documento, data_nascimento,  FK_AlunoTurma) VALUES ("Valentina",  "00515164", '1999-06-14',1);
INSERT INTO aluno (nome_completo,documento, data_nascimento, FK_AlunoTurma) VALUES ("Fernada",  "00515154", '1995-07-20',2);

INSERT INTO presenca(esteve_presente, FK_PresencaAluno, FK_PresencaDisciplina) VALUES (TRUE, 1, 2);
INSERT INTO presenca(esteve_presente, FK_PresencaAluno, FK_PresencaDisciplina) VALUES (FALSE, 2, 2);
INSERT INTO presenca(esteve_presente, FK_PresencaAluno, FK_PresencaDisciplina) VALUES (FALSE, 3, 4);
INSERT INTO presenca(esteve_presente, FK_PresencaAluno, FK_PresencaDisciplina) VALUES (TRUE, 1, 1);
INSERT INTO presenca(esteve_presente, FK_PresencaAluno, FK_PresencaDisciplina) VALUES (TRUE, 1, 3);

INSERT INTO avaliacao(nota,entregou, data_avaliacao,tipo_avaliacao, FK_AvaliacaoAluno, FK_AvaliacaoDisciplina, FK_AvaliacaoTurma, FK_AvaliacaoProfessor) 
VALUES (10.00, TRUE, '2020-04-04', "Trabalho", 1, 1, 1, 1);
INSERT INTO avaliacao(nota,entregou, data_avaliacao,tipo_avaliacao, FK_AvaliacaoAluno, FK_AvaliacaoDisciplina, FK_AvaliacaoTurma, FK_AvaliacaoProfessor) 
VALUES (05.00, TRUE, '2020-06-15', "Prova", 2, 2, 2, 2);
INSERT INTO avaliacao(nota,entregou, data_avaliacao,tipo_avaliacao, FK_AvaliacaoAluno, FK_AvaliacaoDisciplina, FK_AvaliacaoTurma, FK_AvaliacaoProfessor) 
VALUES (09.00, TRUE, '2020-07-12', "Trabalho", 3, 3, 3, 3);
INSERT INTO avaliacao(nota,entregou, data_avaliacao,tipo_avaliacao, FK_AvaliacaoAluno, FK_AvaliacaoDisciplina, FK_AvaliacaoTurma, FK_AvaliacaoProfessor)
 VALUES (05.00, TRUE, '2020-08-11', "Redação", 4, 4, 4, 4);
INSERT INTO avaliacao(nota,entregou, data_avaliacao,tipo_avaliacao, FK_AvaliacaoAluno, FK_AvaliacaoDisciplina, FK_AvaliacaoTurma, FK_AvaliacaoProfessor) 
VALUES (07.00, TRUE, '2020-09-01', "Recuperação", 5, 5, 5, 5);