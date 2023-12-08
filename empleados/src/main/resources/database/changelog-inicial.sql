-- liquibase formatted sql

-- changeset script:1
-- comment: Creation table countries
CREATE TABLE countries(
	id_country SERIAL NOT NULL,
	domain VARCHAR(50) NOT NULL,
	name_country VARCHAR(50) NOT NULL,
	PRIMARY KEY (id_country)
);

-- changeset script:2
-- comment: Creation table employees
CREATE TABLE employees (
	id_employee SERIAL NOT NULL,
	creation_date TIMESTAMP(6),
	email VARCHAR(255) NOT NULL,
	extra_name VARCHAR(50),
	name VARCHAR(20) NOT NULL,
	surname VARCHAR(20) NOT NULL,
	id_country_fk INTEGER NOT NULL,
	PRIMARY KEY (id_employee)
);

-- changeset script:3
-- comment: Insert registers
INSERT INTO countries(name_country, domain)	VALUES
    ( 'Colombia', 'cidenet.com.co'),
	( 'Estados unidos', 'cidenet.com.us');
