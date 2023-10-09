-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 10-10-2023 a las 00:14:32
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_spring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera`
--

CREATE TABLE `carrera` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrera`
--

INSERT INTO `carrera` (`id`, `nombre`) VALUES
(1, 'TUDAI'),
(2, 'Licenciatura en Química'),
(5, 'Medicina'),
(7, 'Derecho');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `carrera_estudiante`
--

CREATE TABLE `carrera_estudiante` (
  `id` bigint(20) NOT NULL,
  `egreso` date DEFAULT NULL,
  `ingreso` date DEFAULT NULL,
  `carrera_id` bigint(20) DEFAULT NULL,
  `estudiante_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `carrera_estudiante`
--

INSERT INTO `carrera_estudiante` (`id`, `egreso`, `ingreso`, `carrera_id`, `estudiante_id`) VALUES
(1, '2022-12-18', '2018-03-01', 2, 1),
(2, '2021-12-18', '2017-03-01', 2, 2),
(3, '2020-12-18', '2016-03-01', 5, 3),
(4, '2021-12-18', '2018-03-01', 1, 4),
(5, NULL, '2016-03-01', 1, 5),
(6, '2018-12-18', '2014-03-01', 1, 6),
(7, '2022-03-01', '2019-12-18', 5, 7),
(8, '2021-03-01', '2018-12-18', 5, 8),
(9, '2021-03-01', '2018-12-18', 7, 9),
(10, '2021-03-01', '2018-12-18', 5, 9),
(11, '2021-03-01', '2018-12-18', 2, 8),
(12, '2021-03-01', '2018-12-18', 1, 7),
(14, NULL, '2018-12-18', 2, 5),
(15, '2021-03-01', '2018-12-18', 2, 4);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `estudiante`
--

CREATE TABLE `estudiante` (
  `id` bigint(20) NOT NULL,
  `apellido` varchar(255) DEFAULT NULL,
  `ciudad` varchar(255) DEFAULT NULL,
  `dni` int(11) NOT NULL,
  `edad` int(11) NOT NULL,
  `genero` varchar(255) DEFAULT NULL,
  `nombre` varchar(255) DEFAULT NULL,
  `numero_libreta` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `estudiante`
--

INSERT INTO `estudiante` (`id`, `apellido`, `ciudad`, `dni`, `edad`, `genero`, `nombre`, `numero_libreta`) VALUES
(1, 'Morales', 'Tandil', 51702139, 22, 'Masculino', 'Felipe', 125423),
(2, 'Dominguez', 'Tres Arroyos', 43123122, 28, 'Masculino', 'Augusto', 125127),
(3, 'Smith', 'Tandil', 12345678, 25, 'Masculino', 'John', 987654),
(4, 'Johnson', 'Los Angeles', 87654321, 30, 'Femenino', 'Emily', 654321),
(5, 'Brown', 'Tres Arroyos', 45678912, 35, 'Masculino', 'Michael', 321654),
(6, 'Davis', 'Olavarria', 98765432, 28, 'Femenino', 'Emma', 654986),
(7, 'Miller', 'Tres Arroyos', 21436587, 32, 'Masculino', 'Andrew', 789455),
(8, 'Wilson', 'Tres Arroyos', 56789123, 27, 'Femenino', 'Olivia', 456123),
(9, 'Moore', 'Tandil', 32789456, 29, 'Masculino', 'James', 321653),
(10, 'Taylor', 'Olavarria', 56879124, 31, 'Femenino', 'Sophia', 654987),
(11, 'Anderson', 'Cascallares', 98712345, 26, 'Masculino', 'Ava', 789456),
(12, 'Thomas', 'Cascallares', 45632879, 33, 'Femenino', 'Isabella', 456125);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `carrera`
--
ALTER TABLE `carrera`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `carrera_estudiante`
--
ALTER TABLE `carrera_estudiante`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK38f286krxmfjmi4n284xq3uew` (`carrera_id`),
  ADD KEY `FK6mtp6nvjod6uulpkve3vb0uy4` (`estudiante_id`);

--
-- Indices de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `carrera`
--
ALTER TABLE `carrera`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT de la tabla `carrera_estudiante`
--
ALTER TABLE `carrera_estudiante`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT de la tabla `estudiante`
--
ALTER TABLE `estudiante`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `carrera_estudiante`
--
ALTER TABLE `carrera_estudiante`
  ADD CONSTRAINT `FK38f286krxmfjmi4n284xq3uew` FOREIGN KEY (`carrera_id`) REFERENCES `carrera` (`id`),
  ADD CONSTRAINT `FK6mtp6nvjod6uulpkve3vb0uy4` FOREIGN KEY (`estudiante_id`) REFERENCES `estudiante` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
