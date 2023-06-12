-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Tempo de geração: 12-Jun-2023 às 15:56
-- Versão do servidor: 8.0.31
-- versão do PHP: 8.0.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `lava_jato`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `agenda`
--

DROP TABLE IF EXISTS `agenda`;
CREATE TABLE IF NOT EXISTS `agenda` (
  `id` int NOT NULL AUTO_INCREMENT,
  `cliente` varchar(50) NOT NULL,
  `veiculo` varchar(50) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `rua` varchar(20) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `data` date NOT NULL,
  `hora` time NOT NULL,
  `preco` double NOT NULL,
  `pagamento` tinyint(1) NOT NULL,
  `funcionarioresponsavel` int NOT NULL,
  `lavagem` tinyint(1) DEFAULT NULL,
  `cera` tinyint(1) DEFAULT NULL,
  `polimento` tinyint(1) DEFAULT NULL,
  `restauracaoplasticos` tinyint(1) DEFAULT NULL,
  `restauracaofarois` tinyint(1) DEFAULT NULL,
  `lavagembancos` tinyint(1) DEFAULT NULL,
  `aromatizante` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `agenda`
--

INSERT INTO `agenda` (`id`, `cliente`, `veiculo`, `telefone`, `bairro`, `rua`, `numero`, `data`, `hora`, `preco`, `pagamento`, `funcionarioresponsavel`, `lavagem`, `cera`, `polimento`, `restauracaoplasticos`, `restauracaofarois`, `lavagembancos`, `aromatizante`) VALUES
(2, 'PEDRO LUCAS DE SOUZA', 'CIVIC', '(38) 99853-1413', 'Canelas', 'Mangueira', '481', '1111-11-10', '14:11:00', 50, 1, 4, 0, 0, 0, 0, 0, 1, 0),
(3, 'RENATO GONÇALVES', 'POLO', '(38) 99965-2470', 'Canelas', 'Mangueira', '481', '1111-11-10', '14:11:00', 50, 1, 5, 1, 1, 0, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `cliente`
--

DROP TABLE IF EXISTS `cliente`;
CREATE TABLE IF NOT EXISTS `cliente` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `rua` varchar(20) NOT NULL,
  `numero` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `veiculo` varchar(50) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `cliente`
--

INSERT INTO `cliente` (`id`, `nome`, `bairro`, `rua`, `numero`, `telefone`, `veiculo`) VALUES
(1, 'PEDRO LUCAS DE SOUZA', 'Canelas', 'Mangueira', '481', '(38) 99853-1413', 'CIVIC'),
(2, 'RENATO GONÇALVES', 'Canelas', 'Mangueira', '481', '(38) 99965-2470', 'POLO'),
(3, 'ADRIANA SOUZA', 'Melo', 'Curvelo', '213', '(38) 91211-2111', 'GOL');

-- --------------------------------------------------------

--
-- Estrutura da tabela `dispesa`
--

DROP TABLE IF EXISTS `dispesa`;
CREATE TABLE IF NOT EXISTS `dispesa` (
  `id` int NOT NULL AUTO_INCREMENT,
  `titulo` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `dispesa`
--

INSERT INTO `dispesa` (`id`, `titulo`, `preco`) VALUES
(1, 'CONTA DE LUZ', 1000),
(2, 'CONTA DE AGUA', 1500),
(3, 'ALUGUEL', 2000);

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionario`
--

DROP TABLE IF EXISTS `funcionario`;
CREATE TABLE IF NOT EXISTS `funcionario` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(50) NOT NULL,
  `bairro` varchar(20) NOT NULL,
  `rua` varchar(20) NOT NULL,
  `numero` varchar(10) NOT NULL,
  `telefone` varchar(20) NOT NULL,
  `cpf` varchar(20) NOT NULL,
  `cep` varchar(20) NOT NULL,
  `salario` double NOT NULL,
  `comissoes` double NOT NULL,
  `user` varchar(50) NOT NULL,
  `senha` varchar(10) NOT NULL,
  `acesso` tinyint(1) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `funcionario`
--

INSERT INTO `funcionario` (`id`, `nome`, `bairro`, `rua`, `numero`, `telefone`, `cpf`, `cep`, `salario`, `comissoes`, `user`, `senha`, `acesso`) VALUES
(1, 'ADMINISTRADOR', '', '', '', ' (  )      -    ', '   .   .   -  ', '', 0, 100, 'admin', '123', 1),
(4, 'PEDRO LUCAS DE SOUZA', 'Canelas', 'Mangueira', '231', ' (38) 97812-7889', '111.111.111-11', '39172-871', 2000, 150, 'teste', '123', 1),
(5, 'TESTE', 'teste', 'teste', '1', '(11) 11111-1111', '111.111.111-11', '11111-111', 1, 0, 'teste', 'teste', 0),
(6, 'SEMACESSO', 'a', 'a', '1', '(11) 11111-1111', '111.111.111-11', '11111-111', 1, 0, 'semacesso', '123', 0);

-- --------------------------------------------------------

--
-- Estrutura da tabela `produto`
--

DROP TABLE IF EXISTS `produto`;
CREATE TABLE IF NOT EXISTS `produto` (
  `id` int NOT NULL AUTO_INCREMENT,
  `nome` varchar(100) NOT NULL,
  `preco` double NOT NULL,
  `quantidade` double NOT NULL,
  `min` double NOT NULL,
  `max` double NOT NULL,
  `mediagasto` double NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Extraindo dados da tabela `produto`
--

INSERT INTO `produto` (`id`, `nome`, `preco`, `quantidade`, `min`, `max`, `mediagasto`) VALUES
(1, 'SHAMPOO', 15, 2.1999999999999975, 2, 10, 0.2),
(2, 'CERA', 50, 2.5999999999999988, 2, 10, 0.2),
(3, 'LIMPA BAU', 15, 2.799999999999998, 2, 8, 0.2),
(4, 'DESENGRAXANTE', 15, 2.799999999999998, 2, 10, 0.2),
(5, 'REVITALIZADOR DE PLÁSTICOS', 50, 1.9, 1, 3, 0.1),
(6, 'AROMATIZANTE', 4.5, 18, 5, 50, 1),
(7, 'MASSA DE POLIR', 100, 2.8, 1, 3, 0.3),
(8, 'PRETINHO', 10, 4.200000000000003, 2, 5, 0.1);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
