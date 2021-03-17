
#1

select * from departments;

#2

SELECT d.name FROM departments as d
ORDER BY department_id; 

#3

SELECT `first_name`, `last_name` , `salary` FROM  employees as e
ORDER BY employee_id ASC;


#4
 
 SELECT first_name, middle_name, last_name FROM employees AS e 
 ORDER BY employee_id ASC;


#5

SELECT concat( first_name,'.', last_name,'@softuni.bg') 
AS 'full_email_address'
FROM employees;

#6

SELECT DISTINCT salary 
FROM employees 
order by employee_id ;

#7

SELECT * FROM employees
WHERE job_title = 'Sales Representative'
order by employee_id ;

#8

SELECT first_name,last_name,job_title as 'JobTitle' 
FROM employees
WHERE salary >= 20000 AND salary <= 30000;

SELECT first_name,last_name,job_title as 'JobTitle' 
FROM employees
WHERE salary BETWEEN 20000 AND 30000 ;

#9

SELECT concat_ws(' ', first_name,middle_name,last_name )as 'Full Name' 
FROM employees
WHERE salary in (25000, 14000, 12500 , 23600);

#10

SELECT first_name,last_name 
FROM employees
WHERE manager_id is NULL;

#11

SELECT first_name,last_name,salary
FROM employees
WHERE salary>50000
ORDER BY salary DESC;

#12

SELECT first_name,last_name
FROM employees
ORDER BY salary DESC LIMIT 5;

#13

SELECT first_name,last_name
FROM employees
WHERE department_id != 4;

#14

SELECT employee_id as 'id',
first_name as 'First Name',
last_name as 'Last Name',
middle_name as 'Middle Name',
job_title,
department_id as 'Dept ID',
manager_id as 'Mngr ID',
hire_date as 'Hire Date',
salary,
address_id
FROM employees
ORDER BY salary DESC,
 `First Name` ASC,
 `Last Name` DESC,
 `Middle Name` ASC;
 
 #15
 
  CREATE VIEW v_employees_salaries as
  SELECT  first_name, last_name, salary 
  FROM employees;
 
 #16
 
 CREATE VIEW v_employees_job_titles  as
 SELECT concat_ws(' ',first_name,middle_name,last_name)as full_name 
 ,job_title 
 FROM employees;


#17

SELECT DISTINCT job_title
FROM employees; 

#18

SELECT * from projects
ORDER BY `start_date`,`name` LIMIT 10; 

#19

SELECT first_name,last_name,hire_date
FROM employees
order BY hire_date DESC LIMIT 7;

#20

UPDATE employees SET salary = salary *1.12
WHERE department_id in (1,2,4,11);
SELECT salary from employees;

#21

 SELECT peak_name FROM peaks
 ORDER BY peak_name ASC ;


#22

SELECT country_name,population
from	countries
WHERE continent_code = 'EU'
ORDER BY population DESC limit 30;

#23


SELECT
country_name,country_code,
IF(currency_code = 'EUR', 'Euro ' , 'Not Euro') as currency 
FROM countries
ORDER BY country_name ASC;

#24

SELECT name FROM characters
ORDER BY name asc;