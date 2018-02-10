use gerenciar_matriculas;


/*Tabela "tipo"*/
insert into tipo (tipo) values ('Banco de dados');
insert into tipo (tipo) values ('Progamação');
insert into tipo (tipo) values ('Modelagem de dados');

select * from tipo;

/*Tabela "instrutor"*/
insert into instrutor (instrutor, telefone) values ('André Milani', '1111-1111');
insert into instrutor (instrutor, telefone) values ('Carlos Tosin', '1212-1212');
update instrutor set telefone = '1111-1111' where codigo = 1;
select * from instrutor;

/*Tabela "curso"*/
insert into curso (curso, c_tipo, c_instrutor, valor) values ('Java Fundamentos', 2, 2, 270);
insert into curso (curso, c_tipo, c_instrutor, valor) values ('Java Avançado', 2, 2, 330);
insert into curso (curso, c_tipo, c_instrutor, valor) values ('SQL Completo', 1, 1, 170);
insert into curso (curso, c_tipo, c_instrutor, valor) values ('Php Básico', 2, 1, 270);
select * from curso;

/*Tabela "aluno"*/
insert into aluno (aluno, endereco, email) values ('José', 'Rua XV de Novembro 72', 'jose@softblue.com.br');
insert into aluno (aluno, endereco, email) values ('Wagner', 'Av. Paulista', 'wagner@softblue.com.br');
insert into aluno (aluno, endereco, email) values ('Emílio', 'Rua Lajes 103, ap: 701', 'emilio@softblue.com.br');
insert into aluno (aluno, endereco, email) values ('Cris', 'Rua Tauney 22', 'cris@softblue.com.br');
insert into aluno (aluno, endereco, email) values ('Regina', 'Rua Salles 305', 'regina@softblue.com.br');
insert into aluno (aluno, endereco, email) values ('Fernando', 'Av. Central 30', 'fernando@softblue.com.br');
select * from aluno;

/*Tabela"pedido"*/
insert into pedido (codigo, c_aluno, data_, hora) values (1, 2, '2010-04-15', '11:23:32');
insert into pedido (codigo, c_aluno, data_, hora) values (2, 2, '2010-04-15', '14:36:21');
insert into pedido (codigo, c_aluno, data_, hora) values (3, 3, '2010-04-16', '11:17:45');
insert into pedido (codigo, c_aluno, data_, hora) values (4, 4, '2010-04-17', '14:27:22');
insert into pedido (codigo, c_aluno, data_, hora) values (5, 5, '2010-04-18', '11:18:19');
insert into pedido (codigo, c_aluno, data_, hora) values (6, 6, '2010-04-19', '13:47:35');
insert into pedido (codigo, c_aluno, data_, hora) values (7, 6, '2010-04-20', '18:13:44');
select * from pedido;

/*Tabela "pedido_detalhe"*/
insert into pedido_detalhe values (1, 1, 270);
insert into pedido_detalhe values (1, 2, 330);
insert into pedido_detalhe values (2, 1, 270);
insert into pedido_detalhe values (2, 2, 330);
insert into pedido_detalhe values (2, 3, 170);
insert into pedido_detalhe values (3, 4, 270);
insert into pedido_detalhe values (4, 2, 330);
insert into pedido_detalhe values (4, 4, 270);
insert into pedido_detalhe values (5, 3, 170);
insert into pedido_detalhe values (6, 3, 170);
insert into pedido_detalhe values (7, 4, 270);
select * from pedido_detalhe;

select * from aluno;
select * from curso;
select * from instrutor;
select * from pedido;
select * from pedido_detalhe;
select * from tipo;

select curso from curso;
select curso, valor from curso where valor > 200;
select curso, valor from curso where valor > 200 and valor < 300;
select curso, valor from curso where valor between 200 and 300;

select * from pedido where data_ >= '2010-04-15' and data_ <= '2010-04-18';
select * from pedido where data_ between '2010-04-15' and '2010-04-18';
select * from pedido where data_ = '2010-04-15';

/*UPDATE funcionarios SET salario = salario * 1.1 WHERE id = 1;*/
update aluno set endereco = 'Av. Brasil 778' where aluno = 'José';
update aluno set email = 'cristiano@softblue.com.br' where aluno = 'Cris';
SET SQL_SAFE_UPDATES = 0;  /*SET SQL_SAFE_UPDATES = 1 */
update curso set valor = round(valor * 1.1, 2) where valor < 300;
update curso set curso = 'Php Fundamentos' where curso = 'Php Básico';
