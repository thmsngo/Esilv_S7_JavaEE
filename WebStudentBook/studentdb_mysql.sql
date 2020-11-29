#drop database studentdb;
create database if not exists studentdb;
use studentdb;

CREATE TABLE `studentdb`.`student` (
id int(10) NOT NULL AUTO_INCREMENT ,
first_name varchar(25),
last_name varchar(25),
email varchar(50),
  PRIMARY KEY(id));

insert into student (first_name,last_name,email) value('Thomas','Ngo','thomas.ngo@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Lucas','Becker','lucas.becker@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Alain','Delon','alain.delon@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Jean','Dujardin','jean.dujardin@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Gérard','Depardieu','gérard.depardieu@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Marion','Cotillard','marion.cotillard@edu.devinci.fr');
insert into student (first_name,last_name,email) value('Guillaume','Canet','cuillaume.canet@edu.devinci.fr');
