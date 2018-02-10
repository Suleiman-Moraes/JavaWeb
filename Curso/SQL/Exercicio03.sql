create database gerenciar_matriculas;

use gerenciar_matriculas;

create table tipo(
	codigo int unsigned not null auto_increment,
	tipo varchar(30) not null default '',
	primary key (codigo)
);

create table instrutor(
	codigo int unsigned not null auto_increment,
	instrutor varchar(45) not null default '',
	telefone varchar(9) default '',
	primary key (codigo)
);

create table curso(
	codigo int unsigned not null auto_increment,
	curso varchar(30) not null default '',
	c_tipo int unsigned default null,
	c_instrutor int unsigned default null,
	valor float not null,
	primary key (codigo),
	CONSTRAINT fk_codigo_tipo FOREIGN KEY (c_tipo) REFERENCES tipo (codigo),
	CONSTRAINT fk_instrutor_instrutor FOREIGN KEY (c_instrutor) REFERENCES instrutor (codigo)
);

create table aluno(
	codigo int unsigned not null auto_increment,
	aluno varchar(45) not null default '',
	endereco varchar(70) not null default '',
	email varchar(60) not null default '',
	primary key (codigo)
);

create table pedido(
	codigo int unsigned not null auto_increment,
	c_aluno int unsigned default null,
	data_ date not null,
	hora time not null,
	primary key (codigo),
	constraint fk_caluno_aluno foreign key (c_aluno) references aluno (codigo)
);

create table pedido_detalhe(
	c_pedido int unsigned default null,
	c_curso int unsigned default null,
	valor float not null,
	constraint fk_cpedido_pedido foreign key (c_pedido) references pedido (codigo),
	constraint fk_ccurso_pedido foreign key (c_curso) references curso (codigo)
);

alter table aluno add data_nascimento varchar(10) not null default '';

alter table aluno change data_nascimento nascimento date null not null;

create index index_alunos on aluno (aluno);

alter table instrutor add email varchar(100) null;

alter table instrutor drop email;

alter table aluno drop nascimento;

create index index_instrutor on curso (c_instrutor);
drop table curso;