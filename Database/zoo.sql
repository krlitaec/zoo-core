/****** 1. CREAR BD zoo ******/

/****** CREATE SCHEMA zoo; ******/

-- Host: localhost    Database: zoo
-- ------------------------------------------------------

/****** ESQUEMA SEGURIDAD ******/

/****** TABLA USUARIO ******/

CREATE TABLE IF NOT EXISTS usuario (
    id INT AUTO_INCREMENT,
	nombre_usuario VARCHAR(255) NOT NULL,
	password VARCHAR(255) NOT NULL,
	email VARCHAR(255) NOT NULL,
	foto MEDIUMBLOB,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id)
);	

INSERT INTO usuario(nombre_usuario, password, email, activo, creacion_fecha, creacion_usuario, creacion_info)
VALUES ('admin', '$2a$10$0BiGt3X86MBwQ7572foDFOchbRf0AEa.ojJ8xYGj7K8MJvozqOtMa', 'krlitaec23@gmail.com', true,
		(SELECT NOW()), 1, 'VALORES INICIALES');	

/****** TABLA ROL ******/

CREATE TABLE IF NOT EXISTS rol (
    id INT AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
	descripcion	VARCHAR(500),
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id)
);	
	
INSERT INTO rol(nombre, descripcion, activo, creacion_fecha, creacion_usuario, creacion_info)
VALUES ('ROLE_ADMIN', 'Administrator', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO rol(nombre, descripcion, activo, creacion_fecha, creacion_usuario, creacion_info)
VALUES ('ROLE_INVITADO', 'Invitado', true, (SELECT NOW()), 1, 'VALORES INICIALES');		

/****** TABLA USUARIO_ROL ******/

CREATE TABLE IF NOT EXISTS usuario_rol (
    id INT AUTO_INCREMENT,
    id_usuario INT NOT NULL,
    id_rol INT NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (id_usuario)
        REFERENCES usuario (id)
        ON UPDATE RESTRICT ON DELETE CASCADE,
    FOREIGN KEY (id_rol)
        REFERENCES rol (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);
	
INSERT INTO usuario_rol(id_usuario, id_rol, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 1, true, (SELECT NOW()), 1, 'VALORES INICIALES');	
		
	

/****** ESQUEMA CATALOGOS ******/

/****** TABLA grupo ******/

CREATE TABLE IF NOT EXISTS grupo (
    id INT AUTO_INCREMENT,
	nombre VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id)
);	

INSERT INTO grupo(nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES ('Mamíferos', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO grupo(nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES ('Aves', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO grupo(nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES ('Peces', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO grupo(nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES ('Reptiles', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO grupo(nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES ('Anfibios', true, (SELECT NOW()), 1, 'VALORES INICIALES');	

/****** TABLA tipo_animal ******/

CREATE TABLE IF NOT EXISTS tipo_animal (
    id INT AUTO_INCREMENT,
    id_grupo INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (id_grupo)
        REFERENCES grupo (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);	

-- Tipos de animal - Grupo Mamíferos
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Tigre', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'León', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Mono', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Gorila', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Jirafa', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Caballo', true, (SELECT NOW()), 1, 'VALORES INICIALES');
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (1, 'Delfìn', true, (SELECT NOW()), 1, 'VALORES INICIALES');		
	
-- Tipos de animal - Grupo Aves
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (2, 'Loro', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (2, 'Avestruz', true, (SELECT NOW()), 1, 'VALORES INICIALES');
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (2, 'Pingüino', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
	
-- Tipos de animal - Grupo Peces
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (3, 'Tiburón', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (3, 'Pez espada', true, (SELECT NOW()), 1, 'VALORES INICIALES');
	
-- Tipos de animal - Grupo Reptiles
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (4, 'Cocodrilo', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (4, 'Tortuga', true, (SELECT NOW()), 1, 'VALORES INICIALES');
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (4, 'Serpiente', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (4, 'Lagartija', true, (SELECT NOW()), 1, 'VALORES INICIALES');
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (4, 'Iguana', true, (SELECT NOW()), 1, 'VALORES INICIALES');
	
-- Tipos de animal - Grupo Anfibios
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (5, 'Sapo', true, (SELECT NOW()), 1, 'VALORES INICIALES');	
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (5, 'Rana', true, (SELECT NOW()), 1, 'VALORES INICIALES');
INSERT INTO tipo_animal(id_grupo, nombre, activo, creacion_fecha, creacion_usuario, creacion_info)
	VALUES (5, 'Salamandra', true, (SELECT NOW()), 1, 'VALORES INICIALES');
	

/****** TABLA animal ******/

CREATE TABLE IF NOT EXISTS animal (
    id INT AUTO_INCREMENT,
    id_tipo_animal INT NOT NULL,
	nombre VARCHAR(100) NOT NULL,
	especie VARCHAR(500),
    edad INT,
    es_carnivoro BOOLEAN NOT NULL DEFAULT FALSE,
    es_hervivoro BOOLEAN NOT NULL DEFAULT FALSE,
    tiene_crias BOOLEAN NOT NULL DEFAULT FALSE,
	peso DECIMAL(10,2), -- Peso en kilogramos
	foto MEDIUMBLOB,
    activo BOOLEAN NOT NULL DEFAULT TRUE,
	creacion_fecha DATETIME NOT NULL,
	creacion_usuario INT NOT NULL,
	creacion_info VARCHAR(500) NOT NULL,
	modifica_fecha DATETIME,
	modifica_usuario INT,
	modifica_info VARCHAR(500),
    PRIMARY KEY (id),
    FOREIGN KEY (id_tipo_animal)
        REFERENCES tipo_animal (id)
        ON UPDATE RESTRICT ON DELETE CASCADE
);	

