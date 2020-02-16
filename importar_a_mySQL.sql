-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 16-02-2020 a las 02:13:31
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
(9, 'ey', 'ey'),
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
  `importe_bruto` float NOT NULL,
  `importe_neto` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura`
--

INSERT INTO `factura` (`id`, `fecha`, `id_proveedor`, `id_cliente`, `importe_bruto`, `importe_neto`) VALUES
(1, '2020-02-15', 1, 1, 86.779, 95.4569),
(3, '2020-02-15', 8, 1, 1206.04, 1326.65),
(4, '2020-02-16', 1, 1, 40.455, 44.5005),
(5, '2020-02-16', 2, 2, 1039.94, 1143.94),
(6, '2020-02-16', 3, 6, 204.106, 224.517),
(7, '2020-02-16', 4, 7, 69.362, 76.2982),
(8, '2020-02-16', 5, 7, 175.312, 192.843),
(9, '2020-02-16', 6, 6, 28.64, 31.504),
(10, '2020-02-16', 7, 5, 17.97, 19.767),
(11, '2020-02-16', 8, 9, 993.831, 1093.21);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `factura_producto`
--

CREATE TABLE `factura_producto` (
  `id_factura` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `factura_producto`
--

INSERT INTO `factura_producto` (`id_factura`, `id_producto`, `cantidad`) VALUES
(1, 1, 10.25),
(1, 4, 3),
(3, 42, 1),
(3, 44, 1),
(3, 46, 1),
(4, 2, 5),
(5, 5, 1),
(5, 7, 1),
(6, 11, 12),
(6, 13, 3),
(6, 15, 5),
(7, 16, 2),
(7, 18, 1),
(7, 19, 1),
(8, 23, 2),
(8, 24, 2),
(8, 28, 25),
(9, 29, 16),
(10, 37, 3),
(11, 42, 1),
(11, 43, 1),
(11, 46, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido`
--

CREATE TABLE `pedido` (
  `id` int(11) NOT NULL,
  `id_cliente` int(11) NOT NULL,
  `id_proveedor` int(11) NOT NULL,
  `importe_bruto` float NOT NULL,
  `importe_neto` float NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido`
--

INSERT INTO `pedido` (`id`, `id_cliente`, `id_proveedor`, `importe_bruto`, `importe_neto`, `fecha`) VALUES
(5, 9, 1, 404.55, 445.005, '2020-02-16'),
(7, 9, 6, 98.4325, 108.276, '2020-02-16'),
(8, 2, 1, 175.24, 192.764, '2020-02-16'),
(10, 2, 7, 296.43, 326.073, '2020-02-16'),
(11, 3, 6, 70.9225, 78.0147, '2020-02-16'),
(12, 3, 7, 89.3166, 98.2483, '2020-02-16'),
(13, 3, 8, 305.981, 336.579, '2020-02-16'),
(14, 4, 1, 103.699, 114.069, '2020-02-16'),
(15, 4, 2, 316.84, 348.524, '2020-02-16'),
(16, 4, 3, 187.65, 206.415, '2020-02-16'),
(17, 4, 4, 241.257, 265.383, '2020-02-16'),
(21, 6, 4, 148.086, 162.895, '2020-02-16'),
(23, 7, 1, 192.92, 212.212, '2020-02-16'),
(27, 10, 1, 83.8275, 92.2103, '2020-02-16'),
(28, 10, 2, 1204.93, 1325.42, '2020-02-16'),
(29, 10, 4, 259.965, 285.961, '2020-02-16'),
(30, 10, 7, 95.221, 104.743, '2020-02-16'),
(31, 1, 1, 87.1875, 95.9062, '2020-02-16'),
(32, 1, 3, 196.997, 216.697, '2020-02-16'),
(33, 1, 4, 175.386, 192.925, '2020-02-16'),
(34, 1, 8, 462.281, 508.509, '2020-02-16');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pedido_producto`
--

CREATE TABLE `pedido_producto` (
  `id_pedido` int(11) NOT NULL,
  `id_producto` int(11) NOT NULL,
  `cantidad` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `pedido_producto`
--

INSERT INTO `pedido_producto` (`id_pedido`, `id_producto`, `cantidad`) VALUES
(5, 2, 50),
(7, 29, 10),
(7, 30, 5),
(7, 31, 10),
(7, 32, 10),
(7, 35, 2),
(8, 1, 5.5),
(8, 2, 10),
(8, 3, 2),
(8, 4, 10),
(10, 37, 5),
(10, 38, 8),
(10, 39, 2),
(10, 41, 5),
(11, 29, 3),
(11, 30, 5),
(11, 31, 5),
(11, 34, 5),
(11, 35, 10),
(12, 38, 5),
(12, 39, 2),
(12, 40, 4),
(13, 42, 1),
(13, 44, 1),
(13, 47, 1),
(14, 1, 2),
(14, 2, 5.36),
(14, 3, 4.32),
(14, 4, 5),
(15, 5, 3),
(15, 6, 1),
(15, 8, 2),
(16, 9, 5),
(16, 11, 1),
(16, 12, 4),
(16, 13, 5),
(17, 16, 10),
(17, 18, 3),
(17, 19, 2),
(21, 16, 12),
(23, 2, 15),
(23, 3, 5),
(23, 4, 10),
(27, 1, 3),
(27, 2, 5),
(27, 4, 5),
(28, 5, 1),
(28, 6, 1),
(28, 7, 1),
(28, 8, 1),
(29, 17, 12),
(29, 19, 2),
(29, 21, 5),
(30, 38, 1),
(30, 40, 5),
(30, 41, 2),
(31, 1, 2),
(31, 2, 6),
(31, 3, 2),
(31, 4, 3),
(32, 9, 6),
(32, 11, 3),
(32, 13, 7),
(32, 14, 5),
(32, 15, 5),
(33, 17, 5),
(33, 19, 5),
(33, 21, 2),
(34, 42, 1),
(34, 43, 1),
(34, 44, 1),
(34, 48, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `id` int(11) NOT NULL,
  `nombre` varchar(255) NOT NULL,
  `descripcion` varchar(255) NOT NULL,
  `ventaPorPeso` tinyint(1) NOT NULL,
  `precio` float NOT NULL,
  `stock` float NOT NULL,
  `descuento` float NOT NULL,
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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT de la tabla `pedido`
--
ALTER TABLE `pedido`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=35;

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
