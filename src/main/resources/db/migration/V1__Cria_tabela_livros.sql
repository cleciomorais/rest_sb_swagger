CREATE TABLE `livros` (
  `id` INT(10) AUTO_INCREMENT PRIMARY KEY,
  `autor` longtext,
  `dtLancamento` datetime(6) NOT NULL,
  `preco` decimal(65,2) NOT NULL,
  `titulo` longtext
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
