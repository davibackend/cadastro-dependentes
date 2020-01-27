CREATE TABLE `dependent` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL,
`cpf` BIGINT(11) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`registration_date` DATE NOT NULL,
`fk_client` INT(11) NOT NULL,
PRIMARY KEY (`id`),
FOREIGN KEY (fk_client) REFERENCES client(id)
);