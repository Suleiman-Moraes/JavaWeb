use gerenciar_matriculas;

CREATE TABLE conta_bancaria (
	codigo INTEGER UNSIGNED NOT NULL AUTO_INCREMENT, 		-- Código interno (PK)
	titular VARCHAR(32) NOT NULL,						 	-- Nome do titular da conta
	saldo DOUBLE NOT NULL, 									-- Representa o saldo da conta
	PRIMARY KEY(codigo) 									-- Define o campo CODIGO como PK (Primary Key) 
) engine = InnoDB;

INSERT INTO CONTA_BANCARIA VALUES (1, 'André', 213);
INSERT INTO CONTA_BANCARIA VALUES (2, 'Diogo', 489);
INSERT INTO CONTA_BANCARIA VALUES (3, 'Rafael', 568);
INSERT INTO CONTA_BANCARIA VALUES (4, 'Carlos', 712);
INSERT INTO CONTA_BANCARIA VALUES (5, 'Peter', -38);

delete from conta_bancaria; 

/*SET SQL_SAFE_UPDATES = 0;  /*SET SQL_SAFE_UPDATES = 1 
UPDATE funcionarios SET salario = salario * 1.1;*/
set sql_safe_updates = 0;

start transaction;
update conta_bancaria set saldo = saldo *1.03;
commit;
rollback;

select * from conta_bancaria;