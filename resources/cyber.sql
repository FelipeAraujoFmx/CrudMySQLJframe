-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 01-Jun-2021 às 03:05
-- Versão do servidor: 10.4.17-MariaDB
-- versão do PHP: 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `cyber`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `fornecedores`
--

CREATE TABLE `fornecedores` (
  `id_fornecedor` int(11) NOT NULL,
  `nome_forn` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `cnpj` varchar(20) COLLATE utf8_bin DEFAULT NULL,
  `endereco_forn` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `telefone_forn` varchar(15) COLLATE utf8_bin DEFAULT NULL,
  `mail_forn` varchar(50) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `fornecedores`
--

INSERT INTO `fornecedores` (`id_fornecedor`, `nome_forn`, `cnpj`, `endereco_forn`, `telefone_forn`, `mail_forn`) VALUES
(5, 'Materiais Limpeza', '4444444444455/22221', 'Rua Limpinha 123', '115558886663', 'limpeza@limpeza.com'),
(6, 'bla bla bla', '44444444', '444444444', '44444444', '4444444');

-- --------------------------------------------------------

--
-- Estrutura da tabela `funcionarios`
--

CREATE TABLE `funcionarios` (
  `id_funcionario` int(11) NOT NULL,
  `nome_func` varchar(80) COLLATE utf8_bin DEFAULT NULL,
  `RG_func` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `CPF_func` varchar(16) COLLATE utf8_bin DEFAULT NULL,
  `endereco_func` varchar(60) COLLATE utf8_bin DEFAULT NULL,
  `sexo_func` varchar(30) COLLATE utf8_bin DEFAULT NULL,
  `mail_func` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `telefone_func` varchar(15) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `funcionarios`
--

INSERT INTO `funcionarios` (`id_funcionario`, `nome_func`, `RG_func`, `CPF_func`, `endereco_func`, `sexo_func`, `mail_func`, `telefone_func`) VALUES
(1, 'Peterson', '11651156', '15615561', 'Rua 13 2', 'Trans', 'pet@pet.com', '1198896378'),
(9, 'José', '115515', '1561651561', 'Rua Zé 321', 'M', 'jose@jose.com', '9'),
(14, 'Maria', '55555555555', '444444444', 'Rua maria 123', 'F', 'maria@maria.com', '118889995556');

-- --------------------------------------------------------

--
-- Estrutura da tabela `produtos`
--

CREATE TABLE `produtos` (
  `id_produto` int(11) NOT NULL,
  `nome_prod` varchar(40) COLLATE utf8_bin NOT NULL,
  `referencia` varchar(35) COLLATE utf8_bin NOT NULL,
  `lote` varchar(35) COLLATE utf8_bin NOT NULL,
  `valor` double DEFAULT NULL,
  `quantidade` int(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `produtos`
--

INSERT INTO `produtos` (`id_produto`, `nome_prod`, `referencia`, `lote`, `valor`, `quantidade`) VALUES
(1, 'Biscoito', 'da123d1sa', '131as', 3.55, 5),
(2, 'Coxinha', '15615', '22215', 2.95, 3),
(5, 'Miojo', '51ada1s6', '12315', 10.55, 3);

-- --------------------------------------------------------

--
-- Estrutura da tabela `usuario`
--

CREATE TABLE `usuario` (
  `id_usuario` int(11) NOT NULL,
  `nome_usuario` varchar(45) COLLATE utf8_bin DEFAULT NULL,
  `senha_usuario` varchar(45) COLLATE utf8_bin DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Extraindo dados da tabela `usuario`
--

INSERT INTO `usuario` (`id_usuario`, `nome_usuario`, `senha_usuario`) VALUES
(1, 'admin', '1234'),
(2, 'felipe', '1234'),
(5, 'maria', '1234'),
(7, 'joao', '2222');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  ADD PRIMARY KEY (`id_fornecedor`);

--
-- Índices para tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  ADD PRIMARY KEY (`id_funcionario`);

--
-- Índices para tabela `produtos`
--
ALTER TABLE `produtos`
  ADD PRIMARY KEY (`id_produto`);

--
-- Índices para tabela `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`id_usuario`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `fornecedores`
--
ALTER TABLE `fornecedores`
  MODIFY `id_fornecedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT de tabela `funcionarios`
--
ALTER TABLE `funcionarios`
  MODIFY `id_funcionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de tabela `produtos`
--
ALTER TABLE `produtos`
  MODIFY `id_produto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de tabela `usuario`
--
ALTER TABLE `usuario`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
