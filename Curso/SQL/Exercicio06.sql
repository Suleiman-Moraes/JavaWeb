
use gerenciar_matriculas;

/*Selecione os nomes de todos os alunos que já fizeram alguma matrícula na Softblue, sem repetição*/
select distinct(aluno) from aluno  
inner join pedido on aluno.codigo = c_aluno;

/*Exiba o nome do aluno mais antigo da Softblue*/
select distinct(aluno) from aluno 
inner join pedido on c_aluno = aluno.codigo order by data_ asc limit 1;

/*Exiba o nome do aluno mais recente da Softblue*/
select distinct(aluno) from aluno
inner join pedido on c_aluno = aluno.codigo order by data_ desc limit 1;

/*Exiba o nome do terceiro aluno mais antigo da Softblue*/
select distinct(aluno) from aluno
inner join pedido on c_aluno = aluno.codigo order by data_ asc limit 1 offset 2;

/*Exiba a quantidade de cursos que já foram vendidos pela Softblue*/
select count(*) from pedido_detalhe;

/*Exiba o valor total já arrecadado pelos cursos vendidos pela Softblue;*/
select sum(valor) from pedido_detalhe;

/*Exiba o valor médio cobrado por curso para o pedido cujo CODIGO é 2*/
select round(avg(valor), 2) from pedido_detalhe where c_pedido = 2;

/*Exiba o valor do curso mais caro da Softblue*/
select max(valor) from curso;

/*Exiba o valor do curso mais barato da Softblue*/
select min(valor) from curso;

/*Exiba o valor total de cada pedido realizado na Softblue*/
select c_pedido, sum(valor)  from pedido_detalhe group by c_pedido;

/*Exiba os nomes dos instrutores da Softblue e a quantidade de cursos que cada um tem sob sua responsabilidade*/
select instrutor, count(curso) from instrutor a 
inner join curso on a.codigo = c_instrutor group by a.codigo; 

/*Exiba o número do pedido, nome do aluno e valor para todos os pedidos realizados na Softblue cujo valor total sejam maiores que 500*/
select c_pedido, aluno, sum(valor) from pedido_detalhe  
inner join pedido p  on c_pedido = p.codigo
inner join aluno a on c_aluno = a.codigo group by c_pedido having sum(valor) > 500;

/*Exiba o número do pedido, nome do aluno e quantos cursos foram comprados no pedido para todos os pedidos realizados na Softblue 
que compraram dois ou mais cursos*/
select p.codigo, aluno, count(*) from pedido_detalhe 
inner join pedido p on p.codigo = c_pedido
inner join aluno a on c_aluno = a.codigo group by c_pedido having count(*) > 1;

/*Exiba o nome e endereço de todos os alunos que morem em Avenidas (Av.)*/
select aluno, endereco from aluno group by endereco having endereco like 'Av%' ;

/*Exiba os nomes dos cursos de Java da Softblue*/
select curso from curso group by curso having curso like '%Java%';

/*Utilizando subquery, exiba uma lista com os nomes dos cursos disponibilizados pela Softblue 
informando para cada curso qual o seu menor valor de venda já praticado*/
select curso, (select min(valor) from pedido_detalhe where c_curso = c.codigo) as 'menor valor' from curso c; 

/*Utilizando subquery e o parâmetro IN, exiba os nomes dos cursos disponibilizados pela Softblue cujo tipo de curso seja 'Programação'*/
select curso from curso where c_tipo in (select codigo from tipo where tipo = 'Progamação');

/*Utilizando subquery e o parâmetro EXISTS, 
exiba novamente os nomes dos cursos disponibilizados pela Softblue cujo tipo de curso seja 'Programação'*/
select curso from curso where exists (select codigo from tipo where tipo.codigo = c_tipo and tipo = 'Progamação');

/*Exiba uma lista com os nomes dos instrutores da Softblue e ao lado o total acumulado das vendas referente aos cursos 
pelo qual o instrutor é responsável*/
select instrutor, (select sum(pedido_detalhe.valor) from pedido_detalhe 
inner join curso on c_curso = curso.codigo where c_instrutor = instrutor.codigo) as 'total de vendas' from instrutor;

/*Crie uma visão que exiba os nomes dos alunos e quanto cada um já comprou em cursos*/
create view nome as select aluno, (select sum(valor) from pedido_detalhe
inner join pedido p on c_pedido = p.codigo where c_aluno = aluno.codigo) from aluno;

select * from nome; /*Visao*/

select * from aluno;
select * from pedido;
select * from pedido_detalhe;
select * from curso;
select * from tipo;