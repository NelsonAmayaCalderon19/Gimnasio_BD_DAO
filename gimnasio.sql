-- phpMyAdmin SQL Dump
-- version 4.1.14
-- http://www.phpmyadmin.net
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 14-05-2019 a las 14:56:15
-- Versión del servidor: 5.6.17
-- Versión de PHP: 5.5.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Base de datos: `gimnasio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `asignacion`
--

CREATE TABLE IF NOT EXISTS `asignacion` (
  `codigo` int(11) NOT NULL AUTO_INCREMENT,
  `cliente` varchar(25) NOT NULL,
  `clase` varchar(25) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  PRIMARY KEY (`codigo`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=2 ;

--
-- Volcado de datos para la tabla `asignacion`
--

INSERT INTO `asignacion` (`codigo`, `cliente`, `clase`, `fecha_inicio`, `fecha_fin`) VALUES
(1, '1093798043', '001', '2019-05-14', '2019-06-14');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clases`
--

CREATE TABLE IF NOT EXISTS `clases` (
  `Codigo` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Clase` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Horario` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Instructor` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  PRIMARY KEY (`Codigo`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clases`
--

INSERT INTO `clases` (`Codigo`, `Clase`, `Horario`, `Instructor`) VALUES
('001', 'Aquaerobics', '8:00 pm - 9:00 pm', 'Jose'),
('002', 'Yoga', '6:00 am - 7:00 am', 'Pepito'),
('003', 'Yoga', '6:00 am - 7:00 am', 'Pancho'),
('004', 'Spinning', '4:00 pm - 5:00 pm', 'Felipe');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE IF NOT EXISTS `clientes` (
  `Cedula` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Nombre` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Direccion` varchar(40) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Fecha_Ingreso` date NOT NULL,
  PRIMARY KEY (`Cedula`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`Cedula`, `Nombre`, `Apellidos`, `Direccion`, `Telefono`, `Fecha_Ingreso`) VALUES
('10294463', 'Jaider', 'Calderon', 'Calle 20', '3102984754', '2019-04-08'),
('1093798043', 'Nelson', 'Amaya', 'Calle 20', '7836846832', '2019-02-05'),
('1095639357', 'Andres', 'Giraldo', 'Av 11', '3019348573', '2019-02-05');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `instructor`
--

CREATE TABLE IF NOT EXISTS `instructor` (
  `Codigo` varchar(20) COLLATE utf8_spanish_ci NOT NULL,
  `Nombres` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Apellidos` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Telefono` varchar(15) COLLATE utf8_spanish_ci NOT NULL,
  `Especialidad` varchar(25) COLLATE utf8_spanish_ci NOT NULL,
  `Jornada` varchar(30) COLLATE utf8_spanish_ci NOT NULL,
  `Horario` varchar(30) COLLATE utf8_spanish_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Volcado de datos para la tabla `instructor`
--

INSERT INTO `instructor` (`Codigo`, `Nombres`, `Apellidos`, `Telefono`, `Especialidad`, `Jornada`, `Horario`) VALUES
('1093769342', 'Jose', 'Torres', '310496279', 'Aquaerobics', 'Noche', '8:00 pm - 9:00 pm'),
('0939945728', 'Pablo', 'Ruiz', '92486553', 'Bailoterpia', 'Mañana', '8:00 am - 9:00 am'),
('47435647543', 'Estela', 'Calderon', '32049484578', 'Aquaerobics', 'Mañana', '7:00 am - 8:00 am'),
('7684635', 'Pepito', 'Quintero', '3223498235', 'Yoga', 'Mañana', '6:00 am - 7:00 am'),
('36043650734', 'Pancho', 'Villa', '6666458473', 'Yoga', 'Mañana', '6:00 am - 7:00 am'),
('8973827834', 'Felipe', 'Caicedo', '878324623', 'Spinning', 'Tarde', '4:00 pm - 5:00 pm');

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
