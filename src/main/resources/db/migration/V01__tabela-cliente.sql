CREATE TABLE `client` (
`id` INT(11) NOT NULL AUTO_INCREMENT,
`name` VARCHAR(15) NOT NULL,
`cpf` BIGINT(11) NOT NULL,
`email` VARCHAR(100) NOT NULL,
`registration_date` DATE NOT NULL,
PRIMARY KEY (`id`))