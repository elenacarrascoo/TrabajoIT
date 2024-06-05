-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 05-06-2024 a las 18:51:04
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `clinica_veterinaria`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cita`
--

CREATE TABLE `cita` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `hora` time NOT NULL,
  `motivo` varchar(100) NOT NULL,
  `idFactura` int(11) NOT NULL,
  `dniVeterinario` varchar(9) NOT NULL,
  `idTratamiento` int(11) DEFAULT NULL,
  `idMedicamento` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `cita`
--

INSERT INTO `cita` (`id`, `fecha`, `hora`, `motivo`, `idFactura`, `dniVeterinario`, `idTratamiento`, `idMedicamento`) VALUES
(6, '2024-06-01', '14:40:12', 'Dolor', 9, '43220987M', 6, 5),
(9, '2024-06-09', '17:30:08', 'Prueba PDF', 12, '43220987M', 9, NULL),
(11, '2024-06-09', '17:35:30', 'Vacuna', 14, '43220987M', NULL, NULL),
(12, '2024-06-09', '17:40:08', 'Dolor', 15, '43220987M', NULL, NULL),
(25, '2024-06-09', '17:00:00', 'Vacuna', 28, '43220987M', NULL, NULL),
(27, '2024-06-09', '17:00:00', 'Vacuna', 30, '12345678A', NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `numFactura` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `importe` double NOT NULL,
  `idPropietario` varchar(9) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`numFactura`, `fecha`, `importe`, `idPropietario`) VALUES
(9, '2024-05-22', 20, '75440799S'),
(10, '2024-05-22', 20, '75440799S'),
(11, '2024-05-23', 20, '98765432B'),
(12, '2024-05-24', -1600766087, '75440799S'),
(13, '2024-06-05', 17, '75440799S'),
(14, '2024-06-05', 67, '75440799S'),
(15, '2024-06-05', 88, '75440799S'),
(16, '2024-06-05', 56, '75440799S'),
(17, '2024-06-05', 80, '75440799S'),
(18, '2024-06-05', 30, '75440799S'),
(19, '2024-06-05', 43, '75440799S'),
(20, '2024-06-05', 38, '75440799S'),
(21, '2024-06-05', 30, '75440799S'),
(22, '2024-06-05', 8, '75440799S'),
(23, '2024-06-05', 6, '75440799S'),
(24, '2024-06-05', 7, '75440799S'),
(25, '2024-06-05', 59, '75440799S'),
(26, '2024-06-05', 84, '75440799S'),
(27, '2024-06-05', 62, '75440799S'),
(28, '2024-06-05', 23, '75440799S'),
(29, '2024-06-05', 17, '75440799S'),
(30, '2024-06-05', 8, '75440799S');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `historial`
--

CREATE TABLE `historial` (
  `num_historial` int(11) NOT NULL,
  `idPaciente` int(11) NOT NULL,
  `idCita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `historial`
--

INSERT INTO `historial` (`num_historial`, `idPaciente`, `idCita`) VALUES
(8, 7, 6),
(11, 7, 9),
(13, 7, 11),
(14, 7, 12),
(26, 7, 25),
(28, 7, 27);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `medicamento`
--

CREATE TABLE `medicamento` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `fechaCaducidad` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `medicamento`
--

INSERT INTO `medicamento` (`id`, `nombre`, `fechaCaducidad`) VALUES
(4, 'Ibuprofeno', '2028-06-22'),
(5, 'Prueba med', '2025-03-07');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `paciente`
--

CREATE TABLE `paciente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `especie` varchar(10) NOT NULL,
  `raza` varchar(30) NOT NULL,
  `sexo` varchar(10) NOT NULL,
  `edad` int(11) NOT NULL,
  `fechaNacimiento` date NOT NULL,
  `dniPropietario` varchar(9) NOT NULL,
  `foto` varchar(500) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `paciente`
--

INSERT INTO `paciente` (`id`, `nombre`, `especie`, `raza`, `sexo`, `edad`, `fechaNacimiento`, `dniPropietario`, `foto`) VALUES
(7, 'Tano', 'perro', 'yorkshire', 'macho', 8, '2016-01-12', '75440799S', ''),
(8, 'Tom', 'perro', 'galgo', 'macho', 5, '2020-01-23', '98765432B', ''),
(11, 'Thor', 'perro', 'perro de agua', 'macho', 6, '2018-01-14', '75440799S', '/FOTOS/a09c9f51e5454d038b129a170f164f41.jpg'),
(12, 'Nilo', 'perro', 'perro de agua', 'macho', 1, '2023-01-05', '75440799S', '/FOTOS/predeterminada.png');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietario`
--

CREATE TABLE `propietario` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `direccion` varchar(50) NOT NULL,
  `telefono` int(9) NOT NULL,
  `correo` varchar(40) NOT NULL,
  `infoContactoAdicional` varchar(60) NOT NULL,
  `password` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `propietario`
--

INSERT INTO `propietario` (`dni`, `nombre`, `direccion`, `telefono`, `correo`, `infoContactoAdicional`, `password`) VALUES
('75440799S', 'Elena Gallego', 'Avenida Pedro Jimenez, 76 Sevilla ', 65476544, 'ecarrascohurtado@gmail.com', 'Prueba1', 'elena1234'),
('98765432B', 'Antonio', 'Calle de prueba', 987654321, 'ecarrascohurtado@gmail.com', 'Prueba', 'antonio123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tratamiento`
--

CREATE TABLE `tratamiento` (
  `id` int(11) NOT NULL,
  `tipo` varchar(20) NOT NULL,
  `fecha` date NOT NULL,
  `precio` double NOT NULL,
  `resultados` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tratamiento`
--

INSERT INTO `tratamiento` (`id`, `tipo`, `fecha`, `precio`, `resultados`) VALUES
(2, 'Fisioterapia', '2024-06-04', 20, 'Perfecto'),
(3, 'Vacunación', '2024-06-05', 60, 'Perfecto'),
(6, 'Fisioterapia', '2024-06-10', 10, 'Prueba'),
(9, 'Fisioterapia', '2024-06-10', 50, 'Prueba');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `veterinario`
--

CREATE TABLE `veterinario` (
  `dni` varchar(9) NOT NULL,
  `nombre` varchar(30) NOT NULL,
  `especialidad` varchar(18) NOT NULL,
  `experiencia` int(11) NOT NULL,
  `telefono` int(9) NOT NULL,
  `correo` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `veterinario`
--

INSERT INTO `veterinario` (`dni`, `nombre`, `especialidad`, `experiencia`, `telefono`, `correo`, `password`) VALUES
('12345678A', 'Pepe Torres', 'Cardiología', 9, 693470152, 'pepetorres@gmail.com', 'pepe123'),
('43220987M', 'Pedro Garcia', 'Fisioterapia', 1, 654309855, 'pedrogarcia@upovet.es', 'Pedro');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cita`
--
ALTER TABLE `cita`
  ADD PRIMARY KEY (`id`),
  ADD KEY `cita_ibfk_1` (`idFactura`) USING BTREE,
  ADD KEY `cita_ibfk_3` (`idTratamiento`) USING BTREE,
  ADD KEY `cita_ibfk_4` (`dniVeterinario`) USING BTREE,
  ADD KEY `cita_ibfk_2` (`idMedicamento`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`numFactura`),
  ADD KEY `factura_ibfk_1` (`idPropietario`) USING BTREE;

--
-- Indices de la tabla `historial`
--
ALTER TABLE `historial`
  ADD PRIMARY KEY (`num_historial`),
  ADD KEY `historial_ibfk_2` (`idCita`),
  ADD KEY `historial_ibfk_1` (`idPaciente`) USING BTREE;

--
-- Indices de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`id`),
  ADD KEY `paciente_ibfk_1` (`dniPropietario`) USING BTREE;

--
-- Indices de la tabla `propietario`
--
ALTER TABLE `propietario`
  ADD PRIMARY KEY (`dni`);

--
-- Indices de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `veterinario`
--
ALTER TABLE `veterinario`
  ADD PRIMARY KEY (`dni`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cita`
--
ALTER TABLE `cita`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `numFactura` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;

--
-- AUTO_INCREMENT de la tabla `historial`
--
ALTER TABLE `historial`
  MODIFY `num_historial` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=29;

--
-- AUTO_INCREMENT de la tabla `medicamento`
--
ALTER TABLE `medicamento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `paciente`
--
ALTER TABLE `paciente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT de la tabla `tratamiento`
--
ALTER TABLE `tratamiento`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cita`
--
ALTER TABLE `cita`
  ADD CONSTRAINT `cita_ibfk_1` FOREIGN KEY (`idFactura`) REFERENCES `factura` (`numFactura`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cita_ibfk_2` FOREIGN KEY (`idMedicamento`) REFERENCES `medicamento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cita_ibfk_3` FOREIGN KEY (`idTratamiento`) REFERENCES `tratamiento` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `cita_ibfk_4` FOREIGN KEY (`dniVeterinario`) REFERENCES `veterinario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `factura_ibfk_1` FOREIGN KEY (`idPropietario`) REFERENCES `propietario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `historial`
--
ALTER TABLE `historial`
  ADD CONSTRAINT `historial_ibfk_1` FOREIGN KEY (`idPaciente`) REFERENCES `paciente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `historial_ibfk_2` FOREIGN KEY (`idCita`) REFERENCES `cita` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `paciente`
--
ALTER TABLE `paciente`
  ADD CONSTRAINT `paciente_ibfk_1` FOREIGN KEY (`dniPropietario`) REFERENCES `propietario` (`dni`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
