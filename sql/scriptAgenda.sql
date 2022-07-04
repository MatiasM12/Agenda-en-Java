CREATE DATABASE `agenda`;
USE agenda;
CREATE TABLE `personas`
(
  `idPersona` int(11) NOT NULL AUTO_INCREMENT,
  `Nombre` varchar(45) NOT NULL,
  `Apellido` varchar(45) NOT NULL,
  `Telefono` varchar(20) NOT NULL,
  `Calle` varchar(20) ,
  `Altura` int(11) ,
  `Piso` int(11) ,
  `Departamento` varchar(20) ,
  `Email` varchar(20) NOT NULL,
  `Cumpleaños` varchar(20) ,
  `Contacto` varchar(20) ,
  `Localidad` varchar(50),
  `tipoDomicilio` varchar(20),
  `lenguajeDeProgramacion` varchar(20),
  PRIMARY KEY (`idPersona`)
);

create table `tipoContactos`
(
 `tipoDeContacto` varchar(45) NOT NULL,
<<<<<<< HEAD
 PRIMARY KEY (`tipoContactos`)
=======
<<<<<<< HEAD
 PRIMARY KEY (`tipoDeContacto`)
=======
 PRIMARY KEY (`tipoContactos`)
>>>>>>> 1fce85c853a004e895e21f339f61740243cee1a9
>>>>>>> rama1
);

CREATE TABLE `Paises`(`nombre_pk` varchar(25) NOT NULL,
                      PRIMARY KEY (`nombre_pk`));
CREATE TABLE `provincias`(`nombre_pk` varchar(25) NOT NULL,
                          `pais_fk` varchar(25) NOT NULL,
                          PRIMARY KEY (`nombre_pk`),
                          FOREIGN KEY (`pais_fk`) references Paises(`nombre_pk`));
CREATE TABLE `localidades`(`nombre_pk` varchar(25) NOT NULL,
                          `pais_fk` varchar(25) NOT NULL,
                          `provincia_fk` varchar(25) NOT NULL,
                          PRIMARY KEY (`nombre_pk`),
                          FOREIGN KEY (`pais_fk`) references Paises(`nombre_pk`),
                          FOREIGN KEY (`provincia_fk`) references provincias(`nombre_pk`)
                        );
