create table ProductType(
	ProductTypeID serial,
	name varchar(20) UNIQUE,
	primary key(ProductTypeID)
);

create table Product(
	productID serial,
	name varchar(30),
	ProductType varchar(30),
	description varchar(70),
	picture bytea,
	price integer,
	stock integer,
	primary key(productID),
	foreign key(ProductType) references ProductType(name)
);

drop table Product;

drop table ProductType;

