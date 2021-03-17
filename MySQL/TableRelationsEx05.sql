
#1 

CREATE DATABASE IF NOT EXISTS `customs`;
USE customs;

CREATE TABLE `passports`(
`passport_id`INT UNSIGNED UNIQUE AUTO_INCREMENT PRIMARY KEY ,
`passport_number` VARCHAR(20) UNIQUE NOT NULL
)AUTO_INCREMENT = 101 ;

CREATE TABLE  `people`(
`person_id` INT NOT NULL AUTO_INCREMENT UNIQUE,
`first_name` VARCHAR(20) NOT NULL ,
`salary` DECIMAL(10,2) NOT NULL DEFAULT 0 ,
`passport_id` INT UNSIGNED NOT NULL UNIQUE,

CONSTRAINT fk_people_passports
FOREIGN KEY (`passport_id`)
REFERENCES `passports`(`passport_id`)
);

 INSERT INTO passports
 VALUES
 (101,'N34FG21B'),
 (102,'K65LO4R7'),
 (103,'ZE657QP2');
 
 INSERT INTO people(first_name,salary,passport_id)
 VALUES
 ('Roberto','43300.00',102),
 ('Tom','56100.00',103),
 ('Yana','60200.00',101);
 
 #2
 
 CREATE DATABASE `cars`;
 use cars;
 
 CREATE TABLE `manufacturers`(
`manufacturer_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 `name` VARCHAR(20) ,
 `established_on` DATE
 );
 
 CREATE TABLE `models`(
 `model_id` INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 `name` VARCHAR(20),
 `manufacturer_id` INT,
 
 CONSTRAINT fk_models_manufacturers
 FOREIGN KEY (`manufacturer_id`)
 REFERENCES `manufacturers`(`manufacturer_id`)
 ) AUTO_INCREMENT = 101;
 

 
INSERT 
	INTO `manufacturers` (`name`, `established_on`)
	VALUES 
		('BMW', '1916-03-01'),
		('Tesla', '2003-01-01'),
		('Lada', '1966-05-01');

INSERT
	INTO `models` (`name`, `manufacturer_id`)
    VALUES
		('X1', 1),
		('i6', 1),
		('Model S', 2),
		('Model X', 2),
		('Model 3', 2),
		('Nova', 3);

 
 #3 
 CREATE DATABASE soft_uni;
 use soft_uni;
 
 CREATE TABLE `students`(
 `student_id`  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
 `name` VARCHAR(20)
 );
 
 CREATE TABLE `exams`(
`exam_id`  INT PRIMARY KEY AUTO_INCREMENT NOT NULL,
`name` VARCHAR(20)
 ) AUTO_INCREMENT=101;
 
 
 CREATE TABLE `students_exams`(
 `student_id` int,	
 `exam_id` int

 );
 

ALTER TABLE `students_exams` 
	ADD CONSTRAINT `pk_students_exams` 
		PRIMARY KEY (`student_id`, `exam_id`),
    ADD CONSTRAINT `fk_students_exams_students` 
		FOREIGN KEY (`student_id`)
        REFERENCES `students` (`student_id`),
    ADD CONSTRAINT `fk_students_exams_exams` 
		FOREIGN KEY (`exam_id`)
        REFERENCES `exams` (`exam_id`);

INSERT 
	INTO `students` 
		(`name`)
	VALUES 
		('Mila'), 
        ('Toni'), 
        ('Ron');

INSERT 
	INTO `exams` 
		(`name`)
	VALUES 
		('Spring MVC'), 
        ('Neo4j'), 
        ('Oracle 11g');

INSERT 
	INTO `students_exams`
    VALUES  
		(1, 101),
		(1, 102),
		(2, 101),
		(3, 103),
		(2, 102),
		(2, 103);
 
 
 
 
 #4
  
  
  CREATE TABLE `teachers`(
  `teacher_id`  INT UNSIGNED NOT NULL UNIQUE AUTO_INCREMENT,
  `name` VARCHAR(20) NOT NULL,
  `manager_id` INT UNSIGNED DEFAULT NULL
  )AUTO_INCREMENT=101;
  
 INSERT 
	INTO `teachers`
		(`name`, `manager_id`)
    VALUES
		('John', NULL),
        ('Maya', 106),
        ('Silvia', 106),
        ('Ted', 105),
        ('Mark', 101),
        ('Greta', 101);
 
ALTER TABLE `teachers`
	ADD CONSTRAINT `pk_teachers` 
		PRIMARY KEY (`teacher_id`),
	ADD CONSTRAINT `fk_teacher_manager_id`
		FOREIGN KEY (`manager_id`)
        REFERENCES `teachers`(`teacher_id`);
 
 
 #5
 
 CREATE DATABASE test;
 use test;
 
 
 CREATE TABLE `cities`(
	`city_id` int  PRIMARY KEY NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(50) 
 );
 
 CREATE TABLE `customers`(
 `customer_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `name` VARCHAR(50), 
 `birthday` DATE,
 `city_id` INT NOT NULL,
 
 CONSTRAINT fk_customers_cities
 FOREIGN KEY (`city_id`)
 REFERENCES `cities`(`city_id`)
 );
 
 CREATE TABLE `orders`(
 `order_id` INT  PRIMARY KEY NOT NULL AUTO_INCREMENT,
 `customer_id` INT NOT NULL ,
 
 CONSTRAINT fk_orders_customers
 FOREIGN KEY (`customer_id`)
 REFERENCES customers(`customer_id`)
 );
 
CREATE TABLE `item_types`(
`item_type_id` INT  PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) 

);


CREATE TABLE `items`(
`item_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50) NOT NULL,
`item_type_id` INT NOT NULL ,

CONSTRAINT fk_items_item_types
FOREIGN KEY (`item_type_id`)
REFERENCES `item_types`(`item_type_id`)

);

CREATE TABLE `order_items`(
`order_id` INT  NOT NULL,
`item_id` INT NOT NULL ,

CONSTRAINT pk_order_items
PRIMARY KEY (`order_id`,`item_id`),
    CONSTRAINT `fk_order_items_orders` 
		FOREIGN KEY (`order_id`)
        REFERENCES `orders` (`order_id`),
    CONSTRAINT `fk_order_items_items` 
		FOREIGN KEY (`item_id`)
        REFERENCES `items` (`item_id`)
);

#6

CREATE TABLE `majors`(
`major_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`name` VARCHAR(50)
);

CREATE TABLE `students`(
`student_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`student_number`VARCHAR(12),
`student_name`VARCHAR(50),
`major_id` INT,

CONSTRAINT fk_sudents_majors
FOREIGN KEY (`major_id`)
REFERENCES `majors`(`major_id`)


);

CREATE TABLE `payments`(
`payment_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`payment_date` DATE,
`payment_amount` DECIMAL(8,2),
`student_id` INT,

CONSTRAINT fk_payments_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`)
);

CREATE TABLE `subjects`(
`subject_id` INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
`subject_name` VARCHAR(50)
);

CREATE TABLE `agenda`(
`student_id` INT,
`subject_id` INT,

CONSTRAINT pk_agenda
PRIMARY KEY (`student_id`, `subject_id`),
CONSTRAINT fk_agenda_students
FOREIGN KEY (`student_id`)
REFERENCES `students`(`student_id`),
CONSTRAINT fk_agenda_subjects
FOREIGN KEY (`subject_id`)
REFERENCES `subjects`(`subject_id`)

);


#9

USE `geography`;
 
SELECT 
    m.mountain_range,
    p.peak_name,
    p.elevation AS 'peak_elevation'
FROM
    `mountains` AS m
        JOIN
    `peaks` AS p ON m.id = p.mountain_id
WHERE
    m.mountain_range = 'Rila'
ORDER BY p.elevation DESC;