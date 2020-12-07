CREATE DATABASE IF NOT EXISTS studentdb ;
USE studentdb;

CREATE TABLE `studentdb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

INSERT INTO student(first_name,last_name,email) VALUES ('Lucas','Becker','lucas.becker@edu.devinci.fr');
INSERT INTO student(first_name,last_name,email) VALUES ('Thomas','Ngo','thomas.ngo@edu.devinci.fr');
INSERT INTO student(first_name,last_name,email) VALUES ('Alain','Delon','alain.delon@gmail.com');
INSERT INTO student(first_name,last_name,email) VALUES ('Jean','Dujardin','jean.dujardin@gmail.com');
INSERT INTO student(first_name,last_name,email) VALUES ('Gérard','Depardieu','gerard.depardieu@gmail.com');
INSERT INTO student(first_name,last_name,email) VALUES ('Marion','Cotillard','marion.cotillard@gmail.com');
INSERT INTO student(first_name,last_name,email) VALUES ('Guillaume','Canet','guillaume.canet@gmail.com');