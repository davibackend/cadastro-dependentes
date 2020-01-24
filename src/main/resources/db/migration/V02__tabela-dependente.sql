CREATE TABLE `dependente` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`nome` VARCHAR(15) NOT NULL,
`cpf` BIGINT(11) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`data_cadastro` DATE NOT NULL,
`fk_cliente` INT(11) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (fk_cliente) REFERENCES cliente(id)
);