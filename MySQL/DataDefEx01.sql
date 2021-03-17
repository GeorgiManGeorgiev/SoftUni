
#0

CREATE SCHEMA `minions` ;

#1


CREATE TABLE `minions`
(
             `id`   INT NOT NULL PRIMARY KEY ,
             `name` VARCHAR(50) NOT NULL,
             `age`  INT
);

CREATE TABLE `towns`
(
             `town_id`   INT NOT NULL PRIMARY KEY ,
             `name` VARCHAR(50) NOT NULL
);


#2 


ALTER TABLE `minions`
ADD COLUMN `town_id` INT NOT NULL;
ALTER TABLE `minions`
ADD CONSTRAINT fk_minions_towns
FOREIGN KEY (`town_id`)
REFERENCES `towns`(`id`);

#3

INSERT INTO `towns`(`id`, `name`)VALUES (1,'Sofia');
INSERT INTO `towns`(`id`, `name`)VALUES (2,'Plovdiv');
INSERT INTO `towns`(`id`, `name`)VALUES (3,'Varna');

INSERT INTO `minions`(`id`,`name`,`age`,`town_id`)VALUES(1,'Kevin',22,1);
INSERT INTO `minions`(`id`,`name`,`age`,`town_id`)VALUES(2,'Bob',15,3);
INSERT INTO `minions`(`id`,`name`,`age`,`town_id`) VALUES(3,'Steward',NULL,2);

#4

TRUNCATE TABLE `minions`;

#5

DROP TABLE `minions`;
DROP TABLE `towns`;

#6CREATE TABLE PEOPLE


CREATE TABLE `people`(
`id` INT AUTO_INCREMENT NOT NULL ,
`name` VARCHAR(200) NOT NULL,
`picture` MEDIUMBLOB,
`height` double (5,2),
`weight` double(5,2),
`gender` ENUM('f','m') NOT NULL,
`birthdate` DATE NOT NULL,
`biography` TEXT,
 PRIMARY KEY (id)
); 

INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)VALUES(1,'One',NULL,5.66,5.66,'f','2020-12-01','So on and so on');
INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)VALUES(2,'TWO',NULL,5.66,5.66,'f','2020-12-01','So on and so on');
INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)VALUES(3,'three',NULL,5.66,5.66,'f','2020-12-01','So on and so on');
INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)VALUES(4,'four',NULL,5.66,5.66,'m','2020-12-01','So on and so on');
INSERT INTO `people`(`id`,`name`,`picture`,`height`,`weight`,`gender`,`birthdate`,`biography`)VALUES(5,'five',NULL,5.66,5.66,'m','2020-12-01','So on and so on');


#7CREATE TABLE USERS

CREATE TABLE `users`(
`id` BIGINT AUTO_INCREMENT NOT NULL ,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(26) NOT NULL,
`profile_picture`  VARBINARY(8000) ,
`last_login_time` TIMESTAMP,
`is_deleted`BOOLEAN,
 PRIMARY KEY (id)
); 


INSERT INTO Users (username, password, profile_picture, last_login_time, is_deleted)
VALUES ('Mitko', 'dasaznai123456789', null, '2015-12-08', true),
('Jelqzko', 'dasaznai123789', null, '2015-12-08', true),
('Jivko', 'dasaznai12789', null, '2011-12-11',false),
('Yordan', 'dasaznai12346789', null, '2014-12-26', false),
('Kostadin', 'dasaznai1234567', null, '2015-12-14', true);

#8 CHANGE PRIMARY KEY

ALTER TABLE users 
MODIFY id BIGINT NOT NULL;
ALTER TABLE users
DROP PRIMARY KEY;
ALTER TABLE users
ADD CONSTRAINT pk_users PRIMARY KEY(id,username);

#9 SET DEFAULT VALUE

ALTER TABLE users 
MODIFY last_login_time TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP ;

#10 SET UNIQUE FIELD

ALTER TABLE users
MODIFY id BIGINT NOT NULL;
ALTER TABLE users
DROP PRIMARY KEY;
ALTER TABLE users
ADD CONSTRAINT pk_users PRIMARY KEY(id);
ALTER TABLE users
MODIFY username VARCHAR(30) NOT NULL UNIQUE ;



#11 MOVIES DATABASE

create table directors (
id int not null primary key auto_increment,
director_name varchar(50) not null,
notes text);
create table genres (
id int not null primary key auto_increment,
genre_name varchar(50) not null,
notes text);
create table categories (
id int not null primary key auto_increment,
category_name varchar(50) not null,
notes text);
create table movies (
id int not null primary key auto_increment,
title varchar(100) not null,
director_id int not null,
copyright_year year default '2019',
length time,
genre_id int not null,
category_id int not null,
rating smallint,
notes text);

INSERT INTO   `directors`(director_name,notes) 
VALUES
('Obi_One1','some notes'),
('Obi_One2','some notes'),
('Obi_One3','some notes'),
('Obi_One4','some notes'),
('Obi_One5','some notes');

INSERT INTO `genres`(genre_name,notes)
VALUES
('HORROR','some notes'),
('SCI-FI','some notes'),
('ACTION','some notes'),
('COMEDY','some notes'),
('DRAMA','some notes');
INSERT INTO `categories`(category_name,notes)
VALUES
('ONE','some notes'),
('TWO','some notes'),
('THREE','some notes'),
('FOUR','some notes'),
('FIVE','some notes');
INSERT INTO `movies`(title,director_id,copyright_year,length,genre_id,category_id,rating,notes)
VALUES
('MobiDICK',1, '1999', NULL,1,1, 4,'some notes'),
('MobiDICK1',2, '2000',NULL,2,2, 5, 'some notes'),
('MobiDICK2',3, '2001',NULL,3, 3,6, 'some notes'),
('MobiDICK3',4, '2002',NULL,4,4, 2, 'some notes'),
('MobiDICK4',5, '2003',NULL,5, 5,4, 'some notes');


#12 Car Rental Database 

create table categories (
id int not null primary key auto_increment,
category varchar(30) not null,
daily_rate smallint,
weekly_rate smallint,
monthly_rate smallint,
weekend_rate smallint);
 
create table cars (
id int not null primary key auto_increment,
plate_number varchar(15) not null,
make varchar(20),
model varchar(20),
car_year year,
category_id int not null,
doors smallint,
picture BLOB,
car_condition varchar(15),
available tinyint);
 
create table employees (
id int not null primary key auto_increment,
first_name varchar(40) not null,
last_name varchar(40) not null,
title varchar(30),
notes text);
 
create table customers (
id int not null primary key auto_increment,
driver_licence_number int not null,
full_name varchar(80) not null,
address varchar(100),
city varchar(30),
zip_code int,
notes text);
 
create table rental_orders (
id int not null primary key auto_increment,
employee_id int not null,
customer_id int not null,
car_id int not null,
car_condition varchar(20),
tank_level int,
kilometrage_start int,
kilometrage_end int,
total_kilometrage int,
start_date date,
end_date date,
total_days int,
rate_applied varchar(15),
tax_rate int,
order_status tinyint,
notes text);
 
 
insert into categories (id, category, daily_rate, weekly_rate, monthly_rate, weekend_rate) values
(1, 'топ 3', null, null, null, null),
(2, 'топ 5', null, null, null, null),
(3, 'топ 10', null, null, null, null);
 
insert into cars (id, plate_number, make, model, car_year, category_id, doors, picture, car_condition, available) values
(1, '123456', null, null, null, 3, null, null, null, null),
(2, '654321', null, null, null, 2, null, null, null, null),
(3, '987654', null, null, null, 2, null, null, null, null);
 
insert into employees (id, first_name, last_name, title, notes) values
(1, 'Ivan', 'Ivanov', null, null),
(2, 'Jordan', 'Yordanov', null, null),
(3, 'Petran', 'Petrunov', null, null);
 
insert into customers (id, driver_licence_number, full_name, address, city, zip_code, notes) values
(1, '641234567', 'Ivan Ivanov Petrunov', null, null, null, null),
(2, '642345678', 'Georgi Petrunov Ivanov', null, null, null, null),
(3, '643456789', 'Petran Georgiev Petrunov', null, null, null, null);
 
insert into rental_orders (id, employee_id, customer_id, car_id, car_condition, tank_level, kilometrage_start, kilometrage_end, total_kilometrage, start_date, end_date, total_days, rate_applied, tax_rate, order_status, notes) values
(1, 3, 1, 2, null, null, null, null, null, null, null, null, null, null, null, null),
(2, 2, 3, 2, null, null, null, null, null, null, null, null, null, null, null, null),
(3, 2, 3, 1, null, null, null, null, null, null, null, null, null, null, null, null);



#13 Hotel database 88/100

CREATE DATABASE Hotel;

USE Hotel;



CREATE TABLE IF NOT EXISTS `employees`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50) NOT NULL,
    `title` VARCHAR(50),
    `notes` TEXT
);  
 
INSERT INTO `employees`(`last_name`)
    VALUES ('Petrov'),
        ('Ivanov'),
        ('Dimitrov');       
 
CREATE TABLE IF NOT EXISTS `customers`(
    `account_number` VARCHAR(50) PRIMARY KEY NOT NULL,
    `first_name` VARCHAR(50),
    `last_name` VARCHAR(50) NOT NULL,
    `phone_number` VARCHAR(50),
    `emergency_name` VARCHAR(50),
    `emergency_number` VARCHAR(50),
    `notes` TEXT
);
 
INSERT INTO `customers`(`account_number`,`last_name`)
    VALUES ('122','Petrov'),
        ('123412','Ivanov'),
        ('1212341','Dimitrov'); 
 
CREATE TABLE IF NOT EXISTS `room_status`(
    `room_status`VARCHAR(50)  PRIMARY KEY NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `room_status`(`room_status`)
    VALUES ('ready'),
        ('empty'),
        ('occupied');   
 
CREATE TABLE IF NOT EXISTS `room_types`(
    `room_type` VARCHAR(50) PRIMARY KEY  NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `room_types`(`room_type`)
    VALUES ('single'),
        ('double'),
        ('appartment'); 
 
 
CREATE TABLE IF NOT EXISTS `bed_types`(
    `bed_type` VARCHAR(50)  PRIMARY KEY  NOT NULL,
    `notes` TEXT
);
 
INSERT INTO `bed_types`(`bed_type`)
    VALUES ('single'),
        ('double'),
        ('king');
 
CREATE TABLE IF NOT EXISTS `rooms`(
    `room_number` INT(4) NOT NULL PRIMARY KEY,
    `room_type` VARCHAR(50) NOT NULL,
    `bed_type` VARCHAR(50) NOT NULL,
    `rate` DECIMAL NOT NULL,
    `room_status` VARCHAR(50) NOT NULL, 
    `notes` TEXT
);
 
INSERT INTO `rooms`(`room_number`,`room_type`,`bed_type`,`rate`,`room_status`)
    VALUES (124,'dsfs','dsfs',124.21,'dsfs'),
        (1214,'dsfs','dsfs',1231.21,'dsfdfsds'),
        (1224,'dsfs','dsfs',112114.21,'dssdfsfssdffs');
 
CREATE TABLE IF NOT EXISTS `occupancies`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `employee_id` INT,
    `date_occupied` DATETIME,
    `account_number` VARCHAR(50),
    `room_number` INT(4) NOT NULL,
    `rate_applied` DECIMAL,
    `phone_charge` DECIMAL,
    `notes` TEXT
);
 
INSERT INTO `occupancies`(`room_number`)
    VALUES (2),
        (3),
        (3);
    
CREATE TABLE IF NOT EXISTS `payments`(
    `id` INT AUTO_INCREMENT PRIMARY KEY,
    `employee_id` INT,
    `payment_date` DATETIME,
    `account_number` VARCHAR(50) NOT NULL,
    `first_date_occupied` DATETIME,
    `last_date_occupied` DATETIME,
    `total_days` INT(4),
    `amount_charged` DECIMAL,
    `tax_rate` DECIMAL,
    `tax_amount` DECIMAL,
    `payment_total` DECIMAL NOT NULL,
    `notes` TEXT
);  
 
INSERT INTO `payments`(`account_number`,`payment_total`)
    VALUES ('1',3),
        ('2',3),
        ('1',2);



/*
CREATE TABLE `employees` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`title` VARCHAR(30) NOT NULL,
	`notes` VARCHAR(128)
);

INSERT INTO `employees`
		(`first_name`, `last_name`, `title`, `notes`)
	VALUES 
		('Gosho', 'Goshev', 'Boss', ''),
		('Pesho', 'Peshev', 'Supervisor', ''),
		('Bai', 'Ivan', 'Worker', 'Can do any work');

CREATE TABLE `customers` (
	`account_number` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`first_name` VARCHAR(30) NOT NULL,
	`last_name` VARCHAR(30) NOT NULL,
	`phone_number` VARCHAR(20) NOT NULL,
	`emergency_name` VARCHAR(50),
	`emergency_number` VARCHAR(20),
	`notes` VARCHAR(128)
);

INSERT INTO `customers`
		(`first_name`, `last_name`, `phone_number`)
	VALUES 
		('Gosho', 'Goshev', '123'),
		('Pesho', 'Peshev', '44-2432'),
		('Bai', 'Ivan', '007');

CREATE TABLE `room_status` (
	`room_status` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`notes` VARCHAR(128)
);

INSERT INTO `room_status` 
		(`notes`)
	VALUES 
		('Free'),
		('For clean'),
		('Occupied');

CREATE TABLE `room_types` (
	`room_type` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`notes` VARCHAR(128)
);

INSERT INTO `room_types` 
		(`notes`)
	VALUES 
		('Small'),
		('Medium'),
		('Appartment');


CREATE TABLE `bed_types` (
	`bed_type` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`notes` VARCHAR(128)
);

INSERT INTO `bed_types` 
		(`notes`)
	VALUES 
		('Single'),
		('Double'),
		('Water-filled');

CREATE TABLE `rooms` (
	`room_number` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`room_type` INT UNSIGNED NOT NULL,
	`bed_type` INT UNSIGNED NOT NULL,
	`rate` DOUBLE DEFAULT 0,
	`room_status` INT UNSIGNED NOT NULL,
	`notes` VARCHAR(128)
);

INSERT INTO `rooms` 
		(`room_type`, `bed_type`, `room_status`)
	VALUES 
		(1, 1, 1),
		(2, 2, 2),
		(3, 3, 3);

CREATE TABLE `payments` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`employee_id` INT UNSIGNED NOT NULL,
	`payment_date` DATE NOT NULL,
	`account_number` INT UNSIGNED NOT NULL,
	`first_date_occupied` DATE,
	`last_date_occupied` DATE,
	`total_days` INT UNSIGNED,
	`amount_charged` DOUBLE,
	`tax_rate` DOUBLE,
	`tax_amount` DOUBLE,
	`payment_total` DOUBLE,
	`notes` VARCHAR(128)
);

INSERT INTO `payments` 
		(`employee_id`, `payment_date`, `account_number`)
	VALUES 
		(1, DATE(NOW()), 1),
		(2, DATE(NOW()), 2),
		(3, DATE(NOW()), 3);


CREATE TABLE `occupancies` (
	`id` INT UNSIGNED PRIMARY KEY NOT NULL UNIQUE AUTO_INCREMENT,
	`employee_id` INT UNSIGNED NOT NULL,
	`date_occupied` DATE NOT NULL,
	`account_number` INT UNSIGNED NOT NULL,
	`room_number` INT UNSIGNED NOT NULL,
	`rate_applied` DOUBLE,
	`phone_charge` DOUBLE,
	`notes` VARCHAR(128)
);

INSERT INTO `occupancies` 
		(`employee_id`, `date_occupied`, `account_number`, `room_number`)
	VALUES 
		(1, DATE(NOW()), 1, 1),
		(2, DATE(NOW()), 2, 2),
		(3, DATE(NOW()), 3, 3);





*/


#14 SOFT UNI DATABASE


CREATE DATABASE soft_uni;
use soft_uni; 

CREATE TABLE towns (
    id INT NOT NULL AUTO_INCREMENT ,
    name VARCHAR(50),
    CONSTRAINT pk_towns
    PRIMARY KEY(id)
);

CREATE TABLE addresses (
    id INT NOT NULL AUTO_INCREMENT ,
    address_text VARCHAR(100) ,
    town_id INT ,
    
    CONSTRAINT pk_addresses 
    PRIMARY KEY (id) ,
    CONSTRAINT fk_addresses_towns
    FOREIGN KEY (town_id)
	REFERENCES `towns` (`id`)
    
);

CREATE TABLE departments (
    `id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) ,
    CONSTRAINT pk_departments_id
    PRIMARY KEY(id)
);

CREATE TABLE employees (
    `id` INT NOT NULL AUTO_INCREMENT ,
    `first_name` VARCHAR(50) NOT NULL ,
    `middle_name` VARCHAR(50)  NOT NULL,
    `last_name` VARCHAR(50) NOT NULL ,
    `job_title` VARCHAR(20) NOT NULL ,
    `department_id` INT NOT NULL ,
    `hire_date` DATE,
    `salary` DECIMAL(19,2),
    `address_id` INT ,
    
    CONSTRAINT pk_emploees_id PRIMARY KEY(id),
    
    CONSTRAINT fk_employees_departments 
    FOREIGN KEY (department_id)
	REFERENCES departments (`id`),
    
    CONSTRAINT fk_employees_addresses
    FOREIGN KEY (address_id)
	REFERENCES addresses (`id`)
);


#15//Basic INSERT

INSERT INTO `towns`
VALUES
(1,'Sofia'),
(2,'Plovdiv'),
(3,'Varna'),
(4,'Burgas');


INSERT INTO `departments`
VALUES
(1,'Engineering'),
(2,'Sales'),
(3,'Marketing'),
(4,'Software Development'),
(5,'Quality Assurance');

INSERT INTO `employees`
(id,
first_name,
middle_name,
last_name,
job_title,
department_id,
hire_date,
salary)
VALUES
(1,'Ivan','Ivanov','Ivanov','.NET Developer',4,'2013-02-01',3500.00),
(2,'Petar','Petrov','Petrov','Senior Engineer',1,'2004-03-02',4000.00),
(3,'Maria','Petrova','Ivanova','Intern',5,'2016-08-28',525.25),
(4,'Georgi','Terziev','Ivanov','CEO',2,'2007-12-09',3000.00),
(5,'Peter','Pan','Pan','Intern',3,'2016-08-28',599.88);


#16 select All fields


SELECT * FROM `towns`;
SELECT * FROM `departments`;
SELECT * FROM `employees`;


#17//Basic Select All Fields and Order Them

SELECT *FROM towns ORDER BY name ASC;

SELECT * FROM departments ORDER BY name ASC;

SELECT * FROM employees ORDER BY salary DESC;

#18// BASIC SELECT SOME FIELDS


SELECT t.name FROM towns AS t ORDER BY t.name ASC;
SELECT d.name FROM departments AS d ORDER BY name ASC;
SELECT 
e.first_name,
e.last_name ,
e.job_title,
e.salary FROM employees AS e ORDER BY e.salary DESC;

#19 INCREASE EMPLOYEE SALARY

UPDATE  employees as e
SET `salary` = e.salary * 1.10;
SELECT e.salary FROM employees as e;

#20Decrease Tax Rate 

UPDATE payments  AS p
set tax_rate = p.tax_rate * 0.97;
SELECT p.tax_rate FROM payments as p;
#21 

DELETE FROM occupancies;

