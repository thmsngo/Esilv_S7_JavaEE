CREATE DATABASE IF NOT EXISTS WebToDoListDB ;
use WebToDoListDB;

CREATE TABLE `webtodolistdb`.`register` (
  `IDidentifiant` INT NOT NULL AUTO_INCREMENT,
  `identifiant` VARCHAR(45) NULL DEFAULT NULL,
  `password` VARCHAR(45) NULL DEFAULT NULL,
  `status` INT NULL DEFAULT 0,
  PRIMARY KEY (`IDidentifiant`));


CREATE TABLE `webtodolistdb`.`todo` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `descrip` VARCHAR(45) NULL DEFAULT NULL,
  PRIMARY KEY (`id`));

# Teachers
INSERT INTO register(identifiant,password,status) VALUES('Nada','1',1);
INSERT INTO register(identifiant,password,status) VALUES('Peretti','2',1);
INSERT INTO register(identifiant,password,status) VALUES('Sart','3',1);
# Students
INSERT INTO register(identifiant,password,status) VALUES('Lucas','4',0);
INSERT INTO register(identifiant,password,status) VALUES('Thomas','5',0);

INSERT INTO todo (descrip) VALUES ('Faire ses devoirs');
INSERT INTO todo (descrip) VALUES ('Se connecter sur Zoom');
INSERT INTO todo (descrip) VALUES ('Envoyer un mail');
INSERT INTO todo (descrip) VALUES ('Faire une pause');
INSERT INTO todo (descrip) VALUES ('Preparer le prochain cours');
INSERT INTO todo (descrip) VALUES ('Rendez-vous important');
INSERT INTO todo (descrip) VALUES ('Passer à la banque');