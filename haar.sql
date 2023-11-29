CREATE DATABASE HAAR

USE HAAR;
CREATE TABLE clientes (
    id_cliente INT IDENTITY(1,1) PRIMARY KEY,
    nombre_cliente VARCHAR(50),
    apellido_cliente VARCHAR(50),
    telefono_cliente VARCHAR(15),
    numcortes_cliente INT
);

USE HAAR;

CREATE TABLE citas (
    numero_cita INT IDENTITY(1,1) PRIMARY KEY,
	id_cliente INT,
	FOREIGN KEY (id_cliente) REFERENCES clientes(id_cliente),
	hora_cita TIME,
    dia DATE,
    servicio VARCHAR(50)
	);