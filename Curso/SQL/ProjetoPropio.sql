create database teste;
use teste;
create table nome(
	id int unsigned not null auto_increment,
	nome varchar(45) not null,
	idade int(3) unsigned not null,
	primary key (id) );

insert into nome (id, nome, idade) values (1, 'Suleiman', 20);
insert into nome (id, nome, idade) values (2, 'Veronika', 20);
insert into nome (id, nome, idade) values (3, 'Sarah', 18);
insert into nome (nome, idade) values ('Sem id', 27);

select * from nome;