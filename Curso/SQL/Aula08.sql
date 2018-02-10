USE curso_sql;

SHOW ENGINES;
SELECT * FROM contas_bancarias;

CREATE TABLE contas_bancarias(
	id int unsigned not null auto_increment,
	titular varchar(45) not null,
	PRIMARY KEY(id) )engine = InnoDB;

ALTER TABLE contas_bancarias ADD valor double not null;
ALTER TABLE contas_bancarias CHANGE valor saldo double not null;
ALTER TABLE contas_bancarias DROP valor;

INSERT INTO contas_bancarias (titular, saldo) VALUES ('André', 1000);
INSERT INTO contas_bancarias (titular, saldo) VALUES ('Carlos', 2000);

start transaction;
UPDATE contas_bancarias SET saldo = saldo - 100 WHERE id = 1;
UPDATE contas_bancarias SET saldo = saldo + 100 WHERE id = 2;
rollback;

start transaction;
UPDATE contas_bancarias SET saldo = saldo - 100 WHERE id = 1;
UPDATE contas_bancarias SET saldo = saldo + 100 WHERE id = 2;
commit;

use financeiro;
select * from lancamento;
select * from pessoa;

insert into lancamento (data_pagamento, data_vencimento, descricao, tipo, valor, pessoa_id) 
values('2010-04-15', '2010-04-15', 'teste', 'sei la oq é tipo', 50, 1);
update pessoa set id = 2 where id = 1;
delete from pessoa where id = 2;
insert into pessoa (nome) values ('Ciclano');
