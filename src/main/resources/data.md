INSERT INTO ADRESSES (id, province, locality, street, height) VALUES
(1, 'Buenos Aires', 'Ciudadela', 'Hipolito Vieytes', '47'),
(2, 'Buenos Aires', 'Tigre', 'Peru', '1385'),
(3, 'CABA', 'Puerto Madero', 'Azucena Villaflor', '559'),
(4, 'Tierra del Fuego', 'Ushuaia', 'RN3', '3065'),
(5, 'Santiago del Estero', 'La Banda', 'Av. Costanera Diego Armando Maradona', 'G4200');

INSERT INTO CLIENTS (id, name, lastname, docnumber, id_adress) VALUES
(1, 'Lautaro', 'Santillan', '45175053', 1),
(2, 'Franco', 'Colapinto', '45781654', 2),
(3, 'Enrique', 'Perez', '24125687', 3),
(4, 'Marcelo', 'Lopez', '40456124', 4),
(5, 'Hugo', 'Sosa', '38741546', 5);

INSERT INTO INVOICES (id, id_client, created_at, total) VALUES
(1, 1, '2022-03-15 00.56.43', 452.05),
(2, 3, '2022-03-15 01.03.23', 2297.04);

INSERT INTO INVOICE_DETAILS (id, id_invoice, id_product, amount, price) VALUES
(1, 1, 1, 1, 265.94),
(2, 1, 5, 1, 186.11),
(3, 2, 3, 1, 1924.82),
(4, 2, 5, 2, 372.22);

INSERT INTO PRODUCTS (id, name, description, code, stock, price) VALUES (1, 'Samsung Galaxy A52', 'Contemplá las cómodas curvas del elegante Galaxy A52s. La superficie de la cámara se combina con el acabado mate posterior para una apariencia icónica', 'SGA52', 15, 265.94),
(2, 'Samsung Galaxy S23 Lavander', 'Nuestro impactante diseño simétrico regresa con una diferencia importante: el uso de materiales reciclados y ecológicos.', 'SGS23L', 32, 944.44),
(3, 'iPhone 14 Pro', 'El iPhone 14 Pro te permite captar detalles increíbles gracias a su gran cámara de 48 MP. Además, trae la Dynamic Island y una pantalla siempre activa', 'iP14P', 50, 1924.82),
(4, 'iPhone 13', 'El sistema de 2 cámaras más avanzado en un iPhone. El superrápido chip A15 Bionic. Un gran salto en duración de batería y pantalla Super Retina XDR', 'iP13', 28, 1126.48),
(5, 'Moto G22', 'Fotografía profesional en tu bolsillo. Mayor rendimiento con su memoria RAM de 4 GB. Batería de duración superior con la súper batería de 5000 mAh', 'MG22', 43, 186.11);
