CREATE DATABASE IF NOT EXISTS studentdb ;
USE studentdb;

CREATE TABLE `studentdb`.`student` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `first_name` VARCHAR(45) NULL,
  `last_name` VARCHAR(45) NULL,
  `email` VARCHAR(45) NULL,
  PRIMARY KEY (`id`));

#SET @@global.time_zone = '+00:00';
#SET @@session.time_zone = '+00:00';

#Select @@global.time_zone,@@session.time_zone;
#Finalement pas besoin des times zones car j'ai ajouté serverTimezone=UTC dans mon URL MySQL
#url="jdbc:mysql://localhost:3306/studentdb?useSSL=false&amp;allowPublicKeyRetrieval=true&amp;serverTimezone=UTC"


INSERT INTO student(first_name,last_name,email) VALUES ('Lucas','Becker','LucasBecker@gmail.com');