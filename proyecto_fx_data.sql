-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-02-2020 a las 19:58:59
-- Versión del servidor: 10.3.15-MariaDB
-- Versión de PHP: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `proyecto_fx`
--
CREATE DATABASE IF NOT EXISTS `proyecto_fx` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `proyecto_fx`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente`
--

INSERT INTO `cliente` (`id`, `nombre`, `username`) VALUES
(1, 'Erik', 'erikcf'),
(2, 'Jonatan', 'jvalle'),
(3, 'Marc', 'mprados'),
(4, 'Juan', 'juanito'),
(5, 'Pepe', 'pepeg'),
(6, 'Jose', 'jgarcia'),
(7, 'Paco', 'paco123'),
(8, 'Pedro', 'pedroabc'),
(9, 'testing', 'testing'),
(10, 'David', 'despeja');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente_proveedor`
--

CREATE TABLE `cliente_proveedor` (
  `id_cliente` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cliente_proveedor`
--

INSERT INTO `cliente_proveedor` (`id_cliente`, `id_proveedor`) VALUES
(1, 1),
(1, 3),
(1, 4),
(1, 8),
(2, 1),
(2, 2),
(2, 7),
(3, 6),
(3, 7),
(3, 8),
(4, 1),
(4, 2),
(4, 3),
(4, 4),
(5, 1),
(5, 7),
(5, 8),
(6, 3),
(6, 4),
(6, 6),
(7, 1),
(7, 4),
(7, 5),
(8, 2),
(8, 3),
(8, 5),
(9, 1),
(9, 6),
(9, 8),
(10, 1),
(10, 2),
(10, 4),
(10, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura`
--

CREATE TABLE `factura` (
  `id` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `importe_bruto` double NOT NULL,
  `importe_neto` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `fecha`, `id_proveedor`, `id_cliente`, `importe_bruto`, `importe_neto`) VALUES
(1, '2020-02-18', 1, 1, 236.63, 260.29),
(2, '2020-02-18', 1, 4, 72.18, 79.4),
(3, '2020-02-18', 1, 5, 113.58, 124.94),
(4, '2020-02-18', 1, 5, 102.16, 112.38),
(5, '2020-02-18', 1, 7, 249.99, 274.99),
(6, '2020-02-18', 1, 4, 114.48, 125.93),
(7, '2020-02-18', 1, 2, 184.01, 202.41),
(8, '2020-02-18', 2, 2, 1367.92, 1504.71),
(9, '2020-02-18', 2, 4, 103.9, 114.29),
(10, '2020-02-18', 2, 8, 1089.89, 1198.88),
(11, '2020-02-18', 2, 10, 1315.97, 1447.57),
(12, '2020-02-18', 3, 1, 476.36, 524),
(13, '2020-02-18', 3, 4, 955.34, 1050.87),
(14, '2020-02-18', 3, 6, 31.92, 35.11),
(15, '2020-02-18', 3, 8, 538.75, 592.62),
(16, '2020-02-18', 4, 1, 346.65, 381.31),
(17, '2020-02-18', 4, 4, 122.87, 135.16),
(18, '2020-02-18', 4, 7, 247.24, 271.96),
(19, '2020-02-18', 4, 10, 136.08, 149.69),
(20, '2020-02-18', 4, 6, 327.84, 360.62),
(21, '2020-02-18', 5, 7, 100.3, 110.33),
(22, '2020-02-18', 5, 7, 195.21, 214.73),
(23, '2020-02-18', 5, 8, 339.72, 373.69),
(24, '2020-02-18', 5, 8, 316.93, 348.62),
(25, '2020-02-18', 6, 3, 25.48, 28.03),
(26, '2020-02-18', 6, 6, 120.45, 132.5),
(27, '2020-02-18', 7, 3, 261.52, 287.67),
(28, '2020-02-18', 7, 3, 78.35, 86.18),
(29, '2020-02-18', 7, 5, 328, 360.8),
(30, '2020-02-18', 7, 5, 345.86, 380.45),
(31, '2020-02-18', 7, 10, 416.49, 458.14),
(32, '2020-02-18', 8, 3, 2206.83, 2427.51),
(33, '2020-02-18', 8, 1, 1306.77, 1437.45),
(34, '2020-02-18', 8, 5, 349.57, 384.53),
(35, '2020-02-18', 8, 5, 1249.79, 1374.77);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_producto`
--

CREATE TABLE `factura_producto` (
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura_producto`
--

INSERT INTO `factura_producto` (`id_factura`, `id_producto`, `cantidad`) VALUES
(1, 1, 10.25),
(1, 2, 10.85),
(1, 3, 5.64),
(1, 4, 10),
(2, 1, 4.3),
(2, 2, 5.1),
(3, 1, 7),
(3, 2, 5.4),
(3, 3, 3.5),
(4, 2, 5.4),
(4, 3, 5),
(4, 4, 7),
(5, 1, 12.95),
(5, 2, 14),
(5, 4, 10),
(6, 1, 5),
(6, 2, 2.3),
(6, 3, 7.6),
(6, 4, 4),
(7, 1, 5.32),
(7, 2, 10.25),
(7, 3, 5),
(7, 4, 8),
(8, 5, 1),
(8, 6, 2),
(8, 7, 1),
(8, 8, 1),
(9, 5, 2),
(9, 8, 2),
(10, 5, 2),
(10, 7, 1),
(11, 6, 2),
(11, 7, 1),
(12, 9, 10.35),
(12, 10, 5.45),
(12, 11, 5.64),
(12, 12, 7.32),
(12, 13, 3),
(12, 14, 5),
(12, 15, 7.65),
(13, 9, 5),
(13, 11, 42.3),
(13, 12, 12.4),
(14, 13, 8),
(15, 9, 5.32),
(15, 11, 12.85),
(15, 12, 12.36),
(16, 16, 2.32),
(16, 17, 5.38),
(16, 18, 2),
(16, 19, 5),
(16, 20, 6.89),
(16, 21, 10),
(17, 17, 5),
(17, 21, 8),
(18, 17, 12.32),
(18, 21, 8),
(19, 18, 3.64),
(19, 19, 2),
(20, 17, 8.68),
(20, 18, 5),
(20, 21, 8),
(21, 25, 8.6),
(21, 26, 12.36),
(22, 22, 15.32),
(22, 24, 5),
(22, 25, 4.68),
(22, 27, 8.69),
(23, 23, 12.68),
(23, 24, 15.32),
(23, 26, 14.62),
(23, 27, 15.23),
(24, 22, 8.68),
(24, 25, 12.36),
(24, 26, 14.32),
(24, 27, 15.66),
(24, 28, 8),
(25, 31, 2),
(25, 33, 10),
(25, 34, 1),
(26, 29, 16),
(26, 31, 12),
(26, 33, 12),
(27, 41, 8),
(28, 36, 8),
(28, 38, 3),
(28, 40, 5),
(29, 36, 8),
(29, 37, 3),
(29, 38, 2),
(29, 41, 8),
(30, 41, 10.58),
(31, 38, 8),
(31, 41, 10.32),
(32, 42, 1),
(32, 45, 1),
(32, 46, 1),
(33, 42, 1),
(33, 45, 1),
(33, 47, 1),
(34, 42, 1),
(34, 43, 2),
(34, 44, 1),
(35, 45, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `importe_bruto` double NOT NULL,
  `importe_neto` double NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `id_cliente`, `id_proveedor`, `importe_bruto`, `importe_neto`, `fecha`) VALUES
(4, 1, 8, 2738.89, 3012.78, '2020-02-18'),
(6, 1, 1, 62.35, 68.59, '2020-02-18'),
(7, 1, 3, 189.59, 208.55, '2020-02-18'),
(8, 1, 4, 104.48, 114.93, '2020-02-18'),
(10, 2, 1, 92.66, 101.93, '2020-02-18'),
(11, 2, 1, 35.95, 39.55, '2020-02-18'),
(13, 2, 2, 49.95, 54.95, '2020-02-18'),
(14, 2, 7, 153.88, 169.27, '2020-02-18'),
(15, 2, 7, 142.14, 156.35, '2020-02-18'),
(16, 3, 6, 47.65, 52.41, '2020-02-18'),
(18, 3, 7, 182.58, 200.84, '2020-02-18'),
(22, 3, 8, 249, 273.9, '2020-02-18'),
(25, 4, 1, 59.59, 65.55, '2020-02-18'),
(26, 4, 2, 989.99, 1088.99, '2020-02-18'),
(29, 4, 3, 727.74, 800.51, '2020-02-18'),
(30, 4, 4, 375.67, 413.24, '2020-02-18'),
(32, 5, 1, 138.41, 152.25, '2020-02-18'),
(37, 5, 7, 40.7, 44.77, '2020-02-18'),
(40, 5, 8, 930.05, 1023.05, '2020-02-18'),
(41, 6, 3, 192.6, 211.86, '2020-02-18'),
(43, 6, 3, 86.36, 95, '2020-02-18'),
(45, 6, 6, 76.92, 84.61, '2020-02-18'),
(47, 6, 4, 59.26, 65.19, '2020-02-18'),
(49, 7, 1, 238.19, 262.01, '2020-02-18'),
(51, 7, 4, 164.87, 181.36, '2020-02-18'),
(52, 7, 5, 139.83, 153.81, '2020-02-18'),
(56, 8, 2, 329.98, 362.98, '2020-02-18'),
(57, 8, 3, 251.72, 276.89, '2020-02-18'),
(61, 8, 5, 190.73, 209.8, '2020-02-18'),
(62, 10, 1, 173.99, 191.39, '2020-02-18'),
(63, 10, 1, 132.99, 146.29, '2020-02-18'),
(65, 10, 4, 300.29, 330.32, '2020-02-18'),
(67, 10, 2, 209.95, 230.94, '2020-02-18'),
(68, 10, 7, 71.88, 79.07, '2020-02-18');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_producto`
--

CREATE TABLE `pedido_producto` (
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido_producto`
--

INSERT INTO `pedido_producto` (`id_pedido`, `id_producto`, `cantidad`) VALUES
(4, 42, 1),
(4, 43, 2),
(4, 44, 1),
(4, 45, 1),
(4, 46, 1),
(4, 47, 2),
(4, 48, 1),
(6, 1, 5.64),
(6, 4, 5),
(7, 9, 5.1),
(7, 11, 5.2),
(7, 14, 8),
(8, 17, 5),
(8, 20, 3.26),
(10, 1, 5.01),
(10, 2, 7),
(11, 1, 5),
(13, 5, 1),
(14, 36, 2),
(14, 39, 1),
(14, 40, 1),
(14, 41, 4),
(15, 37, 2),
(15, 38, 3),
(15, 40, 8.8),
(15, 41, 2),
(16, 29, 10),
(16, 30, 12),
(16, 33, 5),
(16, 35, 6),
(18, 36, 2),
(18, 39, 1),
(18, 41, 5),
(22, 44, 1),
(25, 1, 5.8),
(25, 3, 3.2),
(26, 7, 1),
(29, 12, 30.64),
(30, 16, 8.64),
(30, 17, 8),
(30, 18, 4),
(30, 20, 3.2),
(32, 1, 10.2),
(32, 3, 5.4),
(32, 4, 8),
(37, 36, 8),
(37, 40, 3),
(40, 46, 1),
(41, 9, 3.8),
(41, 10, 3.8),
(41, 12, 5.6),
(43, 15, 20.32),
(45, 29, 8),
(45, 31, 8),
(45, 34, 12),
(47, 21, 12.5),
(49, 1, 12.45),
(49, 2, 15.68),
(49, 4, 5),
(51, 17, 5.36),
(51, 20, 12.32),
(52, 23, 5.64),
(52, 25, 4.2),
(52, 26, 5.32),
(52, 27, 10.25),
(56, 6, 2),
(56, 8, 2),
(57, 9, 5.6),
(57, 10, 12.32),
(57, 11, 5.7),
(57, 14, 8),
(61, 22, 16.23),
(61, 26, 18.74),
(62, 1, 16.23),
(62, 3, 10.25),
(63, 1, 9.64),
(63, 2, 7.87),
(65, 16, 8.21),
(65, 17, 1),
(65, 18, 3.24),
(65, 19, 3),
(65, 21, 8.67),
(67, 5, 1),
(67, 8, 80),
(68, 37, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `ventaPorPeso` tinyint(1) NOT NULL,
  `precio` double NOT NULL,
  `stock` double NOT NULL,
  `descuento` double NOT NULL,
  `id_proveedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`id`, `nombre`, `descripcion`, `ventaPorPeso`, `precio`, `stock`, `descuento`, `id_proveedor`) VALUES
(1, 'Queso Semicurado esp. Host.', 'Queso semicurado pieza entera', 1, 7.19, 34.25, 0, 1),
(2, 'Queso Curado Monterrey', 'Queso curado marca propia pieza entera', 1, 8.99, 78.87, 10, 1),
(3, 'Queso Fresco Montserrat', 'Queso fresco proviniente de Montserrat', 1, 5.59, 12.34, 0, 1),
(4, 'Queso Gouda lonchas 1kg', 'Queso gouda loncheado (envase 1KG)', 0, 4.59, 32, 5, 1),
(5, 'Freidora Bosch', 'Freidora pequeña', 0, 49.95, 4, 0, 2),
(6, 'Plancha Balay', 'Plancha 50x40', 0, 162.99, 2, 0, 2),
(7, 'Lavavajillas pequeño', 'Lavavajillas pequeño industrial', 0, 1099.99, 4, 10, 2),
(8, 'TPV Swing', 'TPV con ultima tecnologia swing', 0, 4, 32, 50, 2),
(9, 'Lomo bajo vaca', 'Lomo bajo de vaca', 1, 12.99, 16.25, 10, 3),
(10, 'Lomo cinta cerdo', 'Cinta de lomo de cerdo', 1, 3.99, 74.95, 0, 3),
(11, 'Lomo alto ternera', 'Lomo alto de ternera', 1, 14.99, 12.38, 5, 3),
(12, 'Solomillo ternera', 'Solomillo de ternera pieza entera', 1, 26.99, 34.98, 12, 3),
(13, 'Bandeja carpaccio 250g', 'Carpaccio con parmesano', 0, 3.99, 16, 0, 3),
(14, 'Bandeja pincho pollo 10u', '10 pinchos de pollo con palo', 0, 6.99, 12, 0, 3),
(15, 'Bandeja pechuga pollo', 'Pechuga pollo entera', 1, 4.25, 24.16, 0, 3),
(16, 'Bacalao entero', 'Bacalao pieza entera', 1, 12.99, 16.25, 5, 4),
(17, 'Merluza pincho', 'Merluza pincho entera', 1, 16.99, 25.72, 0, 4),
(18, 'Cigalas 0', 'Cigala numero 0', 1, 28.49, 10.72, 0, 4),
(19, 'Gamba langostinera caja 2kg', 'Caja de 2kg de gamba langostinera', 0, 17.99, 8, 10, 4),
(20, 'Dorada 300/400', 'Dorada 300/400g pieza', 1, 5.99, 12.85, 0, 4),
(21, 'Boqueron mediano', 'Boqueron tamaño mediano', 1, 4.99, 74.25, 5, 4),
(22, 'Lomo cerdo bandeja', 'Lomo de cerdo en bandeja', 1, 5.99, 34.29, 0, 5),
(23, 'Libritos cerdo bandeja', 'Libritos de cerdo en bandeja', 1, 6.99, 25.46, 10, 5),
(24, 'Galtas de cerdo bandeja', 'Galtas de cerdo con hueso', 1, 6.49, 15.76, 0, 5),
(25, 'Pierna de cerdo', 'Pierna de cerdo entera', 1, 4.99, 56.74, 10, 5),
(26, 'Cabeza de lomo de cerdo', 'Cuello de cerdo', 1, 4.99, 21.87, 0, 5),
(27, 'Panceta vacio', 'Panceta al vacío', 1, 5.75, 33.32, 0, 5),
(28, 'Albondiga bdja 15u', 'Albondiga de cerdo', 0, 5.99, 12, 0, 5),
(29, 'Queso en triangulos', 'Queso en triangulos', 0, 1.79, 24, 0, 6),
(30, 'Requeson 250g', 'Requeson 250g', 0, 0.79, 36, 5, 6),
(31, 'Requeson 1kg', 'Requeson 1kg', 0, 6.49, 12, 0, 6),
(32, 'Queso rallado gouda 250g', 'Queso rallado 250g', 0, 0.69, 64, 0, 6),
(33, 'Queso fundido lonchas', 'Queso tranchette', 0, 1.29, 16, 10, 6),
(34, 'Queso mozzarella cubitos', 'Queso mozzarela en cubitos', 0, 0.89, 84, 0, 6),
(35, 'Provolone 250g', 'Provolone disco 250g', 0, 2.49, 10, 0, 6),
(36, 'Panga congelada 600g', 'Panga filete', 1, 3.99, 34.54, 10, 7),
(37, 'Bacalao filete congelado', 'Bacalao congelado 700g', 1, 5.99, 24.69, 0, 7),
(38, 'Calamar limpio cong.800g', 'Calamar limpio', 0, 10.99, 26, 10, 7),
(39, 'Sepia grande 14u', 'Sepia cong. 14u', 0, 12.99, 16, 8, 7),
(40, 'Rejos de poton', 'Patas de rejo', 1, 3.99, 54.67, 0, 7),
(41, 'Tentaculo pulpo', 'Tentaculo pulpo cong.', 1, 32.69, 14.26, 0, 7),
(42, 'Gofrera 2 huecos', 'Gofrera 2 espacios', 0, 29.99, 6, 10, 8),
(43, 'Crepera 10x10', 'Crepera 10cm x 10cm', 0, 36.79, 8, 0, 8),
(44, 'Cafetera industrial', 'Cafetera 3 cafes', 0, 249, 2, 0, 8),
(45, 'Heladera 16helados', 'Heladera 16 espacios', 0, 1249.79, 3, 0, 8),
(46, 'Exprimidor naranja industrial', 'Exprimidor industrial', 0, 979, 2, 5, 8),
(47, 'Batidora Balay', 'Batidora 2 velocidades', 0, 29.99, 12, 0, 8),
(48, 'Chocolatera 5l', 'Chocolatera de 5L', 0, 149.5, 5, 0, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `username` varchar(255) NOT NULL,
  `familia` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`id`, `nombre`, `username`, `familia`) VALUES
(1, 'Quesos monterrey', 'qmonte', 'Lácteos'),
(2, 'Maquinaria Hosteleria Gomez', 'mahogo', 'Electrodomésticos'),
(3, 'Carnicería Puri', 'carpuri', 'Carnes'),
(4, 'Pescado Fresco SA', 'pefrisa', 'Pescado y marisco'),
(5, 'Carniceria Feliz Cerdo', 'cafece', 'Carnes'),
(6, 'El Caserio', 'elcaserio', 'Lácteos'),
(7, 'Panga congelada', 'pangcong', 'Pescado y marisco'),
(8, 'Electrodomesticos Gutierrez', 'elguti', 'Electrodomésticos');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `cliente_proveedor`
--
ALTER TABLE `cliente_proveedor`
  ADD PRIMARY KEY (`id_cliente`,`id_proveedor`),
  ADD KEY `FK_proveedor_cliente_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `factura`
--
ALTER TABLE `factura`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_factura_proveedor` (`id_proveedor`),
  ADD KEY `FK_factura_cliente` (`id_cliente`);

--
-- Indices de la tabla `factura_producto`
--
ALTER TABLE `factura_producto`
  ADD PRIMARY KEY (`id_factura`,`id_producto`),
  ADD KEY `FK_producto_factura_producto` (`id_producto`);

--
-- Indices de la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_producto_cliente` (`id_cliente`),
  ADD KEY `FK_producto_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `pedido_producto`
--
ALTER TABLE `pedido_producto`
  ADD PRIMARY KEY (`id_pedido`,`id_producto`),
  ADD KEY `FK_producto_pedido_producto` (`id_producto`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK_Tproducto_proveedor` (`id_proveedor`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `factura`
--
ALTER TABLE `factura`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=70;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente_proveedor`
--
ALTER TABLE `cliente_proveedor`
  ADD CONSTRAINT `FK_cliente_cliente_proveedor` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_proveedor_cliente_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura`
--
ALTER TABLE `factura`
  ADD CONSTRAINT `FK_factura_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_factura_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `factura_producto`
--
ALTER TABLE `factura_producto`
  ADD CONSTRAINT `FK_factura_factura_producto` FOREIGN KEY (`id_factura`) REFERENCES `factura` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_producto_factura_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido`
--
ALTER TABLE `pedido`
  ADD CONSTRAINT `FK_producto_cliente` FOREIGN KEY (`id_cliente`) REFERENCES `cliente` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_producto_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `pedido_producto`
--
ALTER TABLE `pedido_producto`
  ADD CONSTRAINT `FK_pedido_pedido_producto` FOREIGN KEY (`id_pedido`) REFERENCES `pedido` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `FK_producto_pedido_producto` FOREIGN KEY (`id_producto`) REFERENCES `producto` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `producto`
--
ALTER TABLE `producto`
  ADD CONSTRAINT `FK_Tproducto_proveedor` FOREIGN KEY (`id_proveedor`) REFERENCES `proveedor` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
