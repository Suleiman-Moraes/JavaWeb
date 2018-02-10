use gerenciar_matriculas;

select * from aluno;
select * from pedido_detalhe;
select * from pedido;
select * from curso;
select * from tipo;

/*Selecione os nomes de todos os alunos que já fizeram alguma matrícula na Softblue, sem repetição*/
select distinct(aluno) from aluno a  
inner join pedido on a.codigo = c_aluno;

/*Exiba o nome do aluno mais antigo da Softblue*/
select distinct(aluno) from aluno a
inner join pedido p on a.codigo = c_aluno order by data_ asc, hora asc limit 1;

select distinct(aluno) from aluno a
inner join pedido p on a.codigo = c_aluno order by data_ desc, hora desc limit 1;

select distinct(aluno) from aluno a
inner join pedido p on a.codigo = c_aluno order by data_ asc, hora asc limit 2 ,1;

select count(*) as 'Quantidade De Cursos Vendidos' from pedido_detalhe;

select sum(valor) as 'Valor total arrecadado' from pedido_detalhe;

select round(avg(valor), 2) as 'Valor médio' from pedido_detalhe group by c_pedido having c_pedido = 2;

select max(valor) from curso;

select min(valor) from curso;

select c_pedido, sum(valor) from pedido_detalhe group by c_pedido;

select i.instrutor, count(c_instrutor) as 'Quantidade de cursos' from instrutor i
inner join curso on c_instrutor = i.codigo group by c_instrutor;

select c_pedido, aluno, round(sum(valor), 2) from pedido_detalhe 
inner join pedido p on c_pedido = p.codigo
inner join aluno a on c_aluno = a.codigo group by c_pedido having sum(valor) > 500;

select c_pedido, aluno, count(*) from pedido_detalhe d
inner join pedido p on c_pedido = p.codigo
inner join aluno a on c_aluno = a.codigo group by c_pedido having count(c_curso) >= 2;

select aluno, endereco from aluno where endereco like '%Av%';

select curso from curso where curso like '%Java%';

select curso, (select min(valor) from pedido_detalhe where c_curso = codigo) as 'Menor valor' from curso;

select curso from curso where c_tipo in (select codigo from tipo where tipo = 'Progamação');

select curso from curso where exists (select codigo from tipo where tipo.codigo = c_tipo and tipo = 'Progamação');

select i.instrutor, (select sum(d.valor) from pedido_detalhe d
inner join curso on curso.codigo = c_curso where i.codigo = c_instrutor) from instrutor i;

select aluno, (select sum(valor) from pedido_detalhe
inner join pedido p on c_pedido = p.codigo where c_aluno = a.codigo) from aluno a;

select * from nome;