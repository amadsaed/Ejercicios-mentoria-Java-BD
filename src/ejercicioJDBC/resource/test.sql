-- phpMyAdmin SQL Dump
-- version 4.9.2
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3306
-- Tiempo de generación: 09-04-2020 a las 18:29:26
-- Versión del servidor: 10.4.10-MariaDB
-- Versión de PHP: 7.3.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `test`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agencia`
--

DROP TABLE IF EXISTS `agencia`;
CREATE TABLE IF NOT EXISTS `agencia` (
  `nombre_agencia` varchar(45) NOT NULL,
  `nro_telefono` int(11) NOT NULL,
  `direccion` varchar(45) NOT NULL,
  `nombre_ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`nombre_agencia`,`nombre_ciudad`),
  KEY `FOREIGNKEY_NOMBRE_CIUDAD` (`nombre_ciudad`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `agencia`
--

INSERT INTO `agencia` (`nombre_agencia`, `nro_telefono`, `direccion`, `nombre_ciudad`) VALUES
('agenciaBA', 9999, 'juan_de_garay', 'BA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `categoria`
--

DROP TABLE IF EXISTS `categoria`;
CREATE TABLE IF NOT EXISTS `categoria` (
  `nombre_categoria` varchar(45) NOT NULL,
  `precio_hora` decimal(45,0) NOT NULL,
  `sueldo_base` decimal(45,0) NOT NULL,
  PRIMARY KEY (`nombre_categoria`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `central_sindical`
--

DROP TABLE IF EXISTS `central_sindical`;
CREATE TABLE IF NOT EXISTS `central_sindical` (
  `id_sindical` int(11) NOT NULL,
  `nombre_sindical` varchar(45) NOT NULL,
  `cuota` float NOT NULL,
  PRIMARY KEY (`id_sindical`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ciudad`
--

DROP TABLE IF EXISTS `ciudad`;
CREATE TABLE IF NOT EXISTS `ciudad` (
  `nombre_ciudad` varchar(45) NOT NULL,
  `nro_habitantes` int(11) NOT NULL,
  PRIMARY KEY (`nombre_ciudad`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado`
--

DROP TABLE IF EXISTS `empleado`;
CREATE TABLE IF NOT EXISTS `empleado` (
  `codigo` int(11) NOT NULL,
  `dni` int(11) NOT NULL,
  `nss` int(11) NOT NULL,
  `nombre` varchar(45) NOT NULL,
  `apellido` varchar(45) NOT NULL,
  `categoria` varchar(45) NOT NULL,
  `centralSindical` varchar(45) NOT NULL,
  `agencia` varchar(45) NOT NULL,
  `ciudad` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`),
  KEY `FOREIGNKEY_CATEGORIA` (`categoria`) USING BTREE,
  KEY `FOREIGNKEY_CIUDAD` (`ciudad`) USING BTREE,
  KEY `FOREIGNKEY_AGENCIA` (`agencia`),
  KEY `FOREIGNKEY_SINDICAL` (`centralSindical`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado`
--

INSERT INTO `empleado` (`codigo`, `dni`, `nss`, `nombre`, `apellido`, `categoria`, `centralSindical`, `agencia`, `ciudad`) VALUES
(5, 555, 66, 'hana', 'saed', 'c', 'q', 'prokarma', 'CORDOBA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_fijo`
--

DROP TABLE IF EXISTS `empleado_fijo`;
CREATE TABLE IF NOT EXISTS `empleado_fijo` (
  `codigo` int(11) NOT NULL,
  `antiguedad` int(11) NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Volcado de datos para la tabla `empleado_fijo`
--

INSERT INTO `empleado_fijo` (`codigo`, `antiguedad`) VALUES
(1, 5),
(2, 10);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_prestamo`
--

DROP TABLE IF EXISTS `empleado_prestamo`;
CREATE TABLE IF NOT EXISTS `empleado_prestamo` (
  `codigo` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `monto` int(11) NOT NULL,
  `activo` tinyint(1) NOT NULL,
  `fecha_solicitud` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `es_concedido` varchar(45) NOT NULL,
  PRIMARY KEY (`codigo`,`tipo`,`fecha_solicitud`),
  KEY `FOREIGNKEY_PRESTAMO` (`tipo`,`codigo`) USING BTREE
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_temporal`
--

DROP TABLE IF EXISTS `empleado_temporal`;
CREATE TABLE IF NOT EXISTS `empleado_temporal` (
  `codigo` int(11) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleado_titulo`
--

DROP TABLE IF EXISTS `empleado_titulo`;
CREATE TABLE IF NOT EXISTS `empleado_titulo` (
  `codigo_empleado` int(11) NOT NULL,
  `id_titulo` int(11) NOT NULL,
  PRIMARY KEY (`codigo_empleado`,`id_titulo`),
  KEY `FOREIGNKEY_obtiene` (`codigo_empleado`) USING BTREE,
  KEY `FOREIGNKEY_ID_TITULO` (`id_titulo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `prestamo`
--

DROP TABLE IF EXISTS `prestamo`;
CREATE TABLE IF NOT EXISTS `prestamo` (
  `id_prestamo` int(11) NOT NULL,
  `tipo` varchar(45) NOT NULL,
  `tipo_interes` varchar(45) NOT NULL,
  `periodo_vigencia` int(11) NOT NULL,
  PRIMARY KEY (`id_prestamo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `titulo`
--

DROP TABLE IF EXISTS `titulo`;
CREATE TABLE IF NOT EXISTS `titulo` (
  `id_titulo` int(11) NOT NULL AUTO_INCREMENT,
  `nombre_titulo` varchar(45) NOT NULL,
  PRIMARY KEY (`id_titulo`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
