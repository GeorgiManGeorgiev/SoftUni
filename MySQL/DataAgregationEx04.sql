

#1

SELECT COUNT(*) AS count
 FROM wizzard_deposits ;

#2

SELECT MAX(magic_wand_size)
as `longest_magic_wand`
 FROM wizzard_deposits ;
 
#3

SELECT deposit_group,
MAX(magic_wand_size)
as `longest_magic_wand`
 FROM wizzard_deposits
 GROUP BY  deposit_group
 ORDER BY`longest_magic_wand`asc,deposit_group;
 
 #4
 
 SELECT  deposit_group
  FROM wizzard_deposits
  GROUP BY deposit_group
 ORDER BY AVG(`magic_wand_size`)
 limit 1;
  
#5
  
  SELECT deposit_group, SUM( deposit_amount ) AS `total_sum`
  FROM wizzard_deposits
  GROUP BY deposit_group 
  ORDER BY `total_sum` ;
  
  
#6
  
SELECT `deposit_group`, SUM(deposit_amount) AS `total_sum`
FROM `wizzard_deposits`
WHERE  `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
ORDER BY `deposit_group`;
 
 #7
 
SELECT 
    `deposit_group`, 
    SUM(`deposit_amount`) AS 'total_sum'
FROM
    `wizzard_deposits`
WHERE
    `magic_wand_creator` = 'Ollivander family'
GROUP BY `deposit_group`
HAVING `total_sum` < 150000
ORDER BY `total_sum` DESC;
 
 #8
 
 SELECT deposit_group,
 magic_wand_creator, 
 MIN(deposit_charge) as `min_deposit_charge`
 FROM wizzard_deposits
 GROUP BY deposit_group,magic_wand_creator
 ORDER BY magic_wand_creator,deposit_group;
  
  SELECT 
    `deposit_group`,
    `magic_wand_creator`,
    MIN(`deposit_charge`) AS 'min_deposit_charge'
FROM
    `wizzard_deposits`
GROUP BY `deposit_group` , `magic_wand_creator`
ORDER BY `magic_wand_creator` , `deposit_group`;

#9

SELECT (
CASE
WHEN `age` BETWEEN 0 AND 10 THEN '[0-10]'
WHEN `age` BETWEEN 11 AND 20 THEN '[11-20]'
WHEN `age` BETWEEN 21 AND 30 THEN '[21-30]'
WHEN `age` BETWEEN 31 AND 40 THEN '[31-40]'
WHEN `age` BETWEEN 41 AND 50 THEN '[41-50]'
WHEN `age` BETWEEN 51 AND 60 THEN '[51-60]'
ELSE '[61+]'
END
) AS   `age_group`, COUNT(*)  as `wizard_count`
FROM wizzard_deposits
GROUP BY `age_group`
ORDER BY wizard_count;
  
  
#10

SELECT substr(first_name,1,1) 
 AS `first_letter`  
FROM wizzard_deposits
WHERE deposit_group = 'Troll Chest' 
GROUP BY  `first_letter`
ORDER BY `first_letter`;

#11

SELECT `deposit_group`,
`is_deposit_expired`
, AVG(deposit_interest) as `average_interest`
from wizzard_deposits
WHERE `deposit_start_date` > '1985-01-01'
GROUP BY `deposit_group`, `is_deposit_expired`
ORDER BY `deposit_group` DESC, `is_deposit_expired` ASC;

#12

SELECT 
    SUM(`hw`.`deposit_amount` - `gw`.`deposit_amount`) AS 'sum_difference'
FROM
    `wizzard_deposits` AS `hw`,
    `wizzard_deposits` AS `gw`
WHERE
    `gw`.`id` - `hw`.`id` = 1;


SELECT 
    `hw`.`first_name` AS 'host_wizard',
    `hw`.`deposit_amount` AS 'host_wizard_deposit',
    `gw`.`first_name` AS 'guest_wizard',
    `gw`.`deposit_amount` AS 'guest_wizard_deposit',
    (`hw`.`deposit_amount` - `gw`.`deposit_amount`) AS 'difference'
FROM
    `wizzard_deposits` AS `hw`, `wizzard_deposits` AS `gw`
WHERE
     `gw`.`id` - `hw`.`id` = 1;


#13

SELECT `department_id`, MIN(salary) as `minimum_salary`
FROM employees
WHERE department_id in (2,5,7) and hire_date>'2000-01-01'
GROUP BY department_id
ORDER BY department_id;




#14

CREATE TABLE   `new_table` as
(SELECT
department_id,
manager_id,
salary
FROM employees
WHERE
salary > 30000 
);
DELETE from new_table 
WHERE manager_id = 42;
UPDATE new_table 
SET salary = salary+5000
WHERE department_id = 1;

SELECT department_id, AVG(salary) as `avg_salary` from new_table
GROUP BY department_id
ORDER BY department_id;



#15

SELECT department_id, MAX(salary) as `max_salary`
FROM employees
GROUP BY  department_id
HAVING NOT `max_salary` BETWEEN 30000 AND 70000
ORDER BY department_id;


#16

SELECT

COUNT(`salary`) as ''

FROM `employees`

WHERE ISNULL(`manager_id`);

#17

SELECT  e.department_id,
(
SELECT DISTINCT  e2.`salary` 
FROM `employees` AS `e2`
WHERE e2.`department_id` = e.`department_id`
ORDER BY e2.`salary` DESC 
LIMIT 2,1) AS 'ths'
FROM `employees` as e
GROUP BY e.department_id
Having `ths` is not NULL
ORDER BY department_id asc;


#18

SELECT e.first_name, e.last_name,e.department_id
FROM employees as e
WHERE salary >
(
SELECT AVG (e2. salary) as `avg`
FROM employees as e2
WHERE e2.department_id = e.department_id
GROUP BY e2.department_id
)
ORDER BY department_id, employee_id
LIMIT 10;
#19


SELECT 
    `department_id`, SUM(`salary`) AS 'total_salary'
FROM
    `employees`
GROUP BY `department_id`
ORDER BY `department_id`; 
