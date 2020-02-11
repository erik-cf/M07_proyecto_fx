INSERT INTO `cliente`(nombre, username) VALUES
('Erik', 'erikcf'),
('Jonatan', 'jvalle'),
('Marc', 'mprados'),
('Juan', 'juanito'),
('Pepe', 'pepeg'),
('Jose', 'jgarcia'),
('Paco', 'paco123'),
('Pedro', 'pedroabc'),
('testing', 'testing'),
('David', 'despeja');

INSERT INTO `proveedor`(nombre, username, familia) VALUES
('Quesos monterrey', 'qmonte', 'Lácteos'),
('Maquinaria Hosteleria Gomez', 'mahogo', 'Electrodomésticos'),
('Carnicería Puri', 'carpuri', 'Carnes'),
('Pescado Fresco SA', 'pefrisa', 'Pescado y marisco'),
('Carniceria Feliz Cerdo', 'cafece', 'Carnes'),
('El Caserio', 'elcaserio', 'Lácteos'),
('Panga congelada', 'pangcong', 'Pescado y marisco'),
('Electrodomesticos Gutierrez', 'elguti', 'Electrodomésticos');

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Queso Semicurado esp. Host.', 'Queso semicurado pieza entera', 1, 7.19, 34.25, 0, 1),
('Queso Curado Monterrey', 'Queso curado marca propia pieza entera', 1, 8.99, 78.87, 10, 1),
('Queso Fresco Montserrat', 'Queso fresco proviniente de Montserrat', 1, 5.59, 12.34, 0, 1),
('Queso Gouda lonchas 1kg', 'Queso gouda loncheado (envase 1KG)', 0, 4.59, 32, 5, 1);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Freidora Bosch', 'Freidora pequeña', 0, 49.95, 4, 0, 2),
('Plancha Balay', 'Plancha 50x40', 0, 162.99, 2, 0, 2),
('Lavavajillas pequeño', 'Lavavajillas pequeño industrial', 0, 1099.99, 4, 10, 2),
('TPV Swing', 'TPV con ultima tecnologia swing', 0, 4, 32, 50, 2);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Lomo bajo vaca', 'Lomo bajo de vaca', 1, 12.99, 16.25, 10, 3),
('Lomo cinta cerdo', 'Cinta de lomo de cerdo', 1, 3.99, 74.95, 0, 3),
('Lomo alto ternera', 'Lomo alto de ternera', 1, 14.99, 12.38, 5, 3),
('Solomillo ternera', 'Solomillo de ternera pieza entera', 1, 26.99, 34.98, 12, 3),
('Bandeja carpaccio 250g', 'Carpaccio con parmesano', 0, 3.99, 16, 0, 3),
('Bandeja pincho pollo 10u', '10 pinchos de pollo con palo', 0, 6.99, 12, 0, 3),
('Bandeja pechuga pollo', 'Pechuga pollo entera', 1, 4.25, 24.16, 0, 3);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Bacalao entero', 'Bacalao pieza entera', 1, 12.99, 16.25, 5, 4),
('Merluza pincho', 'Merluza pincho entera', 1, 16.99, 25.72, 0, 4),
('Cigalas 0', 'Cigala numero 0', 1, 28.49, 10.72, 0, 4),
('Gamba langostinera caja 2kg', 'Caja de 2kg de gamba langostinera', 0, 17.99, 8, 10, 4),
('Dorada 300/400', 'Dorada 300/400g pieza', 1, 5.99, 12.85, 0, 4),
('Boqueron mediano', 'Boqueron tamaño mediano', 1, 4.99, 74.25, 5, 4);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Lomo cerdo bandeja', 'Lomo de cerdo en bandeja', 1, 5.99, 34.29, 0, 5),
('Libritos cerdo bandeja', 'Libritos de cerdo en bandeja', 1, 6.99, 25.46, 10, 5),
('Galtas de cerdo bandeja', 'Galtas de cerdo con hueso', 1, 6.49, 15.76, 0, 5),
('Pierna de cerdo', 'Pierna de cerdo entera', 1, 4.99, 56.74, 10, 5),
('Cabeza de lomo de cerdo', 'Cuello de cerdo', 1, 4.99, 21.87, 0, 5),
('Panceta vacio', 'Panceta al vacío', 1, 5.75, 33.32, 0, 5),
('Albondiga bdja 15u', 'Albondiga de cerdo', 0, 5.99, 12, 0, 5);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Queso en triangulos', 'Queso en triangulos', 0, 1.79, 24, 0, 6),
('Requeson 250g', 'Requeson 250g', 0, 0.79, 36, 5, 6),
('Requeson 1kg', 'Requeson 1kg', 0, 6.49, 12, 0, 6),
('Queso rallado gouda 250g', 'Queso rallado 250g', 0, 0.69, 64, 0, 6),
('Queso fundido lonchas', 'Queso tranchette', 0, 1.29, 16, 10, 6),
('Queso mozzarella cubitos', 'Queso mozzarela en cubitos', 0, 0.89, 84, 0, 6),
('Provolone 250g', 'Provolone disco 250g', 0, 2.49, 10, 0, 6);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Panga congelada 600g', 'Panga filete', 1, 3.99, 34.54, 10, 7),
('Bacalao filete congelado', 'Bacalao congelado 700g', 1, 5.99, 24.69, 0, 7),
('Calamar limpio cong.800g', 'Calamar limpio', 0, 10.99, 26, 10, 7),
('Sepia grande 14u', 'Sepia cong. 14u', 0, 12.99, 16, 8, 7),
('Rejos de poton', 'Patas de rejo', 1, 3.99, 54.67, 0, 7),
('Tentaculo pulpo', 'Tentaculo pulpo cong.', 1, 32.69, 14.26, 0, 7);

INSERT INTO `producto`(nombre, descripcion, ventaPorPeso, precio, stock, descuento, id_proveedor) VALUES
('Gofrera 2 huecos', 'Gofrera 2 espacios', 0, 29.99, 6, 10, 8),
('Crepera 10x10', 'Crepera 10cm x 10cm', 0, 36.79, 8, 0, 8),
('Cafetera industrial', 'Cafetera 3 cafes', 0, 249.00, 2, 0, 8),
('Heladera 16helados', 'Heladera 16 espacios', 0, 1249.79, 3, 0, 8),
('Exprimidor naranja industrial', 'Exprimidor industrial', 0, 979.00, 2, 5, 8),
('Batidora Balay', 'Batidora 2 velocidades', 0, 29.99, 12, 0, 8),
('Chocolatera 5l', 'Chocolatera de 5L', 0, 149.50, 5, 0, 8);

INSERT INTO `cliente_proveedor` VALUES
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