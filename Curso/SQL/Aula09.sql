
USE curso_sql;

SELECT * FROM pedidod;
CALL limpa_pedidos();

CREATE TABLE pedidod(
	id int unsigned not null auto_increment,
	descricao varchar(100) not null,
	valor double not null default '0',
	pago varchar(3) not null default 'Não',
	PRIMARY KEY(id) );

INSERT INTO pedidod (descricao, valor) VALUES ('TV', 3000);
INSERT INTO pedidod (descricao, valor) values ('Geladeira', 1400);
INSERT INTO pedidod (descricao, valor) values ('DVD Player', 300);

UPDATE pedidod SET pago = 'Sim' WHERE id = 8;

CREATE TABLE estoque(
	id int unsigned not null auto_increment,
	descricao varchar(50) not null,
	quantidade int not null,
	PRIMARY KEY(id) );

CREATE TRIGGER gatilho_limpa_pedidos
BEFORE INSERT 
ON estoque
FOR EACH ROW
CALL limpa_pedidos;

INSERT INTO estoque (descricao, quantidade) VALUES ('Fogão', 5);
INSERT INTO estoque (descricao, quantidade) VALUES ('Forno', 3);