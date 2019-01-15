-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 15-01-2019 a las 04:34:59
-- Versión del servidor: 10.1.35-MariaDB
-- Versión de PHP: 7.2.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `sonno`
--
CREATE DATABASE IF NOT EXISTS `sonno` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `sonno`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administrador`
--

CREATE TABLE `administrador` (
  `id_admin` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `pass` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `administrador`
--

INSERT INTO `administrador` (`id_admin`, `nombre`, `pass`) VALUES
(1, 'SonoMarcos', 'backline'),
(2, 'flor', '123'),
(3, 'lau', 'pass');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `bandas`
--

CREATE TABLE `bandas` (
  `id_banda` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `saldo` int(11) DEFAULT '0',
  `dias_fijos` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `bandas`
--

INSERT INTO `bandas` (`id_banda`, `nombre`, `saldo`, `dias_fijos`) VALUES
(1, 'Las babosas', 300, 'Martes y Jueves'),
(18, 'insacro', -150, 'Viernes'),
(19, 'labanda', 0, 'Sábado'),
(20, 'k-ceria', -450, 'Martes'),
(21, 'nuevaluna', 0, 'Ninguno'),
(22, 'labandina', 0, 'Lunes');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pagos`
--

CREATE TABLE `pagos` (
  `id_pago` int(11) NOT NULL,
  `nombre_admin` varchar(30) NOT NULL,
  `id_turno` int(11) NOT NULL,
  `nombre_banda` varchar(50) NOT NULL,
  `fecha` date NOT NULL,
  `cobro` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `pagos`
--

INSERT INTO `pagos` (`id_pago`, `nombre_admin`, `id_turno`, `nombre_banda`, `fecha`, `cobro`) VALUES
(25, 'lau', 83, 'Las babosas', '2018-12-29', 300),
(26, 'lau', 91, 'Las babosas', '2018-12-29', 150),
(27, 'lau', 85, 'Las babosas', '2018-12-29', 450),
(28, 'lau', 93, 'k-ceria', '2018-12-29', 300),
(29, 'lau', 94, 'k-ceria', '2018-12-29', 600),
(30, 'lau', 92, 'k-ceria', '2018-12-29', 300),
(31, 'lau', 86, 'labanda', '2018-12-29', 150),
(32, 'lau', 95, 'insacro', '2018-12-29', 600),
(33, 'flor', 96, 'Las babosas', '2018-12-29', 300),
(34, 'flor', 97, 'labanda', '2018-12-29', 600),
(35, 'flor', 84, 'insacro', '2019-01-01', 150),
(36, 'flor', 90, 'insacro', '2019-01-01', 600),
(37, 'flor', 99, 'insacro', '2019-01-01', 300),
(38, 'flor', 88, 'labanda', '2019-01-02', 600),
(39, 'flor', 100, 'nuevaluna', '2019-01-02', 150),
(40, 'flor', 101, 'nuevaluna', '2019-01-02', 150),
(41, 'flor', 102, 'nuevaluna', '2019-01-03', 150),
(42, 'flor', 103, 'nuevaluna', '2019-01-02', 150),
(43, 'flor', 104, 'nuevaluna', '2019-01-03', 150),
(44, 'flor', 105, 'nuevaluna', '2019-01-03', 300),
(45, 'flor', 106, 'nuevaluna', '2019-01-10', 150),
(46, 'flor', 107, 'insacro', '2019-01-03', 150),
(47, 'flor', 108, 'nuevaluna', '2019-01-03', 150),
(48, 'flor', 98, 'Las babosas', '2019-01-15', 450),
(49, 'flor', 109, 'nuevaluna', '2019-01-15', 150),
(50, 'flor', 89, 'insacro', '2019-01-15', 450),
(51, 'flor', 110, 'k-ceria', '2019-01-15', 150),
(52, 'flor', 110, 'k-ceria', '2019-01-15', 150),
(53, 'flor', 110, 'k-ceria', '2019-01-15', 150),
(54, 'flor', 110, 'k-ceria', '2019-01-15', 150),
(55, 'flor', 111, 'labandina', '2019-01-15', 150),
(56, 'flor', 87, 'labanda', '2019-01-15', 300);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `turnos`
--

CREATE TABLE `turnos` (
  `id_turno` int(11) NOT NULL,
  `id_admin` int(11) NOT NULL,
  `id_banda` int(11) NOT NULL,
  `fecha` timestamp NULL DEFAULT NULL,
  `monto` int(11) NOT NULL,
  `pagado` varchar(2) NOT NULL DEFAULT 'no',
  `estado` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `turnos`
--

INSERT INTO `turnos` (`id_turno`, `id_admin`, `id_banda`, `fecha`, `monto`, `pagado`, `estado`) VALUES
(82, 2, 18, '2019-01-02 19:21:27', 150, 'no', 0),
(83, 2, 1, '2018-12-30 02:27:58', 300, 'si', 0),
(84, 2, 18, '2019-01-02 20:10:39', 150, 'si', 0),
(85, 2, 1, '2018-12-30 02:27:58', 450, 'si', 0),
(86, 2, 19, '2018-12-30 02:40:40', 150, 'si', 0),
(87, 2, 19, '2019-01-02 19:21:27', 300, 'si', 0),
(88, 2, 19, '2019-04-19 22:59:46', 600, 'si', 1),
(89, 2, 18, '2019-01-15 02:31:52', 450, 'si', 0),
(90, 2, 18, '2019-01-02 21:12:49', 600, 'si', 0),
(91, 2, 1, '2018-12-30 02:27:58', 150, 'si', 0),
(92, 3, 20, '2018-12-30 02:27:58', 300, 'si', 0),
(93, 3, 20, '2018-12-30 02:27:58', 300, 'si', 0),
(94, 3, 20, '2018-12-30 02:27:58', 600, 'si', 0),
(95, 3, 18, '2018-12-30 02:51:59', 600, 'si', 0),
(96, 2, 1, '2018-12-30 02:57:10', 300, 'si', 0),
(97, 2, 19, '2018-12-30 02:59:20', 600, 'si', 0),
(98, 2, 1, '2019-01-15 01:42:11', 450, 'si', 0),
(99, 2, 18, '2019-01-02 22:54:34', 300, 'si', 0),
(100, 2, 21, '2019-01-02 23:02:02', 150, 'si', 0),
(101, 2, 21, '2019-01-02 23:05:09', 150, 'si', 0),
(102, 2, 21, '2019-01-02 23:09:28', 150, 'si', 0),
(103, 2, 21, '2019-01-02 23:09:58', 150, 'si', 0),
(104, 2, 21, '2019-01-03 02:41:48', 150, 'si', 0),
(105, 2, 21, '2019-01-03 02:41:48', 300, 'si', 0),
(106, 2, 21, '2019-01-15 02:08:35', 150, 'si', 0),
(107, 2, 18, '2019-01-03 03:04:52', 150, 'si', 0),
(108, 2, 21, '2019-01-03 03:06:43', 150, 'si', 0),
(109, 2, 21, '2019-01-15 02:23:38', 150, 'si', 0),
(110, 2, 20, '2019-01-25 03:00:27', 150, 'si', 1),
(111, 2, 22, '2019-01-18 04:00:00', 150, 'si', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administrador`
--
ALTER TABLE `administrador`
  ADD PRIMARY KEY (`id_admin`);

--
-- Indices de la tabla `bandas`
--
ALTER TABLE `bandas`
  ADD PRIMARY KEY (`id_banda`);

--
-- Indices de la tabla `pagos`
--
ALTER TABLE `pagos`
  ADD PRIMARY KEY (`id_pago`);

--
-- Indices de la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD PRIMARY KEY (`id_turno`),
  ADD KEY `turnobanda` (`id_banda`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `administrador`
--
ALTER TABLE `administrador`
  MODIFY `id_admin` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `bandas`
--
ALTER TABLE `bandas`
  MODIFY `id_banda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=23;

--
-- AUTO_INCREMENT de la tabla `pagos`
--
ALTER TABLE `pagos`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=57;

--
-- AUTO_INCREMENT de la tabla `turnos`
--
ALTER TABLE `turnos`
  MODIFY `id_turno` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `turnos`
--
ALTER TABLE `turnos`
  ADD CONSTRAINT `turnobanda` FOREIGN KEY (`id_banda`) REFERENCES `bandas` (`id_banda`) ON DELETE NO ACTION ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
