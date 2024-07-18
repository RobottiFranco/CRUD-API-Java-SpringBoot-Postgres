create table ProductType(
	ProductTypeID serial,
	name varchar(20) UNIQUE NOT NULL,
	primary key(ProductTypeID)
);

create table Product(
	productID serial,
	name varchar(50) NOT NULL,
	ProductTypeID integer NOT NULL,
	price integer NOT NULL,
	stock integer NOT NULL,
	description varchar(70) NOT NULL,
	primary key(productID),
	foreign key(ProductTypeID) references ProductType(ProductTypeID)
);

drop table Product;
drop table ProductType;

INSERT INTO ProductType (name) VALUES 
('amargos'),
('dulce'),
('chocolate'),
('frutal'),
('menta'),
('vainilla'),
('caramelo'),
('café'),
('nuez'),
('limón');

SELECT * FROM Product;

INSERT INTO Product (name, ProductTypeID, description, price, stock) VALUES
('Galletas de Amargos', 1, 'Galletas de amargos con un toque de limón.', 150, 20),
('Turrón Dulce', 2, 'Turrón de dulce de leche cubierto de chocolate.', 200, 50),
('Barra de Chocolate', 3, 'Barra de chocolate negro 70% cacao.', 250, 100),
('Caramelos de Menta', 2, 'Caramelos de menta refrescante.', 50, 300),
('Galletas de Vainilla', 1, 'Galletas de vainilla con chispas de chocolate.', 120, 150),
('Turrón de Café', 2, 'Turrón de café con almendras.', 220, 70),
('Chocolate con Nuez', 3, 'Chocolate con trozos de nuez.', 300, 80),
('Caramelos de Frutal', 2, 'Caramelos de diferentes sabores frutales.', 40, 500),
('Galletas de Limón', 1, 'Galletas con sabor a limón.', 100, 60),
('Barra de Chocolate con Caramelo', 3, 'Barra de chocolate con relleno de caramelo.', 270, 90);
