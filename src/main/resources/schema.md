CREATE TABLE clients(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
name varchar(50) NOT NULL,
lastname varchar(50) NOT NULL,
docnumber varchar(11) NOT NULL UNIQUE,
id_adress int NOT NULL,
CONSTRAINT fk_id_adress FOREIGN KEY(id_adress) REFERENCES adresses(id)
);

CREATE TABLE adresses(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
province varchar(50) NOT NULL,
locality varchar(50) NOT NULL,
street varchar(50) NOT NULL,
height varchar(15) NOT NULL
);

CREATE TABLE invoices(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_client int NOT NULL,
createdAt date NOT NULL UNIQUE,
total double NOT NULL DEFAULT 0,
CONSTRAINT fk_id_client FOREIGN KEY(id_client) REFERENCES clients(id)
);

CREATE TABLE invoice_details(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
id_invoice int NOT NULL,
id_product int NOT NULL,
amount int NOT NULL,
price double NOT NULL,
CONSTRAINT fk_id_invoice FOREIGN KEY(id_invoice) REFERENCES invoices(id),
CONSTRAINT fk_id_product FOREIGN KEY(id_product) REFERENCES products(id)
);

CREATE TABLE products(
id int PRIMARY KEY AUTO_INCREMENT NOT NULL,
name varchar(30) NOT NULL,
description varchar(150) NOT NULL,
code varchar(50) NOT NULL UNIQUE,
stock int NOT NULL,
price double NOT NULL
);
