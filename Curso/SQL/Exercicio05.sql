use gerenciar_matriculas;

select * from curso;
select * from tipo;
select * from pedido;

/*Exiba uma lista com os títulos dos cursos da Softblue e o tipo de curso ao lado*/
select c.curso, t.tipo from curso c inner join tipo t on c.c_tipo = t.codigo;  

/*Exiba uma lista com os títulos dos cursos da Softblue, tipo do curso, nome do instrutor responsável pelo mesmo e telefone*/
select c.curso, t.tipo, i.instrutor, i.telefone from curso c
inner join tipo t on c.c_tipo = t.codigo
inner join instrutor i on c.c_instrutor = i.codigo;

/*Exiba uma lista com o código e data e hora dos pedidos e os códigos dos cursos de cada pedido*/
select p.codigo, p.data_, p.hora, d.c_curso as 'codigo do curso' from pedido p
inner join pedido_detalhe d on p.codigo = d.c_pedido;

/*Exiba uma lista com o código e data e hora dos pedidos e os títulos dos cursos de cada pedido*/
select p.codigo, p.data_, p.hora, c.curso from pedido p
inner join pedido_detalhe d on p.codigo = d.c_pedido 
inner join curso c on d.c_curso = c.codigo;

/*Exiba uma lista com o código e data e hora dos pedidos, nome do aluno e os títulos dos cursos de cada pedido*/
select p.codigo, p.data_, p.hora, a.aluno, c.curso from pedido p
inner join aluno a on p.c_aluno = a.codigo
inner join pedido_detalhe d on p.codigo = d.c_pedido
inner join curso c on d.c_curso = c.codigo;


/*Crie uma visão que traga o título e preço somente dos cursos de programação da Softblue*/
create view t_p_cp_visao as select c.curso, c.valor from curso c
inner join tipo t on c.c_tipo = t.codigo where t.codigo = 2;
select * from t_p_cp_visao; 

/*Crie uma visão que traga os títulos dos cursos, tipo do curso e nome do instrutor*/
create view ctnvisao as select c.curso, t.tipo, i.instrutor from curso c
inner join tipo t on c.c_tipo = t.codigo
inner join instrutor i on c.c_instrutor = i.codigo;
select * from ctnvisao;

/*Crie uma visão que exiba os pedidos realizados, informando o nome do aluno, data e código do pedido*/
create view padcvisao as select a.aluno, p.data_, p.codigo from aluno a
inner join pedido p on p.c_aluno = a.codigo;
select * from padcvisao;