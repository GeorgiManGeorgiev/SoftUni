
#1

SELECT 	employee_id, job_title,e.address_id,	a.address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
ORDER BY e.address_id asc LIMIT 5;


#2

SELECT e.first_name,	e.last_name,	t.`name` AS `town`,	a.address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
JOIN towns AS t
ON a.town_id =  t.town_id
ORDER BY e.first_name, e.last_name limit 5;


#3

SELECT 
    e.employee_id,
    e.first_name,
    e.last_name,
    d.`name` AS `department_name`
FROM
    employees AS e
        JOIN
    departments AS d ON e.department_id = d.department_id
WHERE
    d.`name` = 'Sales'
ORDER BY e.employee_id DESC;
      
#4

SELECT 	e.employee_id,	e.first_name ,e.salary, d.`name` AS department_name
FROM employees AS e 
JOIN departments AS d
ON e.department_id = d.department_id
WHERE e.salary > 15000
ORDER BY d.department_id DESC LIMIT 5;


#5


SELECT 
    e.employee_id, e.first_name
FROM
    employees AS e
        LEFT JOIN
    employees_projects AS ep ON e.employee_id = ep.employee_id
WHERE
    ep.project_id IS NULL
ORDER BY e.employee_id DESC
LIMIT 3;

#6

SELECT 	e.first_name, e.last_name, e.hire_date, d.`name` AS dept_name
FROM employees AS e 
JOIN departments AS d
ON e.department_id  = d.department_id
WHERE DATE (e.hire_date) > '1999/1/1' AND d.`name` IN ('Sales', 'Finance') 
ORDER BY e.hire_date ASC;

#7

SELECT e.employee_id, e.first_name, p.`name` AS `project_name`
FROM employees AS e
JOIN employees_projects as ep
ON e.employee_id = ep.employee_id 
RIGHT JOIN projects AS p
ON ep.project_id = p.project_id
WHERE p.start_date > '2002-08-13' AND p.end_date IS NULL
ORDER BY e.first_name ASC, p.`name` ASC limit 5; 

#8

SELECT e.employee_id, e.first_name,  
IF(YEAR(p.start_date) >= 2005,
        NULL,
        p.`name`) AS 'project_name'
FROM employees AS e
JOIN employees_projects as ep
ON e.employee_id = ep.employee_id 
JOIN projects AS p
ON ep.project_id = p.project_id
WHERE e.employee_id = 24 
ORDER BY p.`name` ASC; 

#9

SELECT 
    e.employee_id, e.first_name, e.manager_id, m.first_name
FROM
    `employees` AS e
        JOIN
    `employees` AS m ON e.manager_id = m.employee_id
WHERE
    e.manager_id IN (3 , 7)
ORDER BY e.first_name;
 
 #10
 
 SELECT 
    e.employee_id,
    CONCAT(e.first_name, ' ', e.last_name) AS employee_name,
    CONCAT(m.first_name, ' ', m.last_name) manager_name,
    d.`name` AS department_name
FROM
    employees AS e
        JOIN
    employees AS m ON e.manager_id = m.employee_id
        JOIN
    departments AS d ON e.department_id = d.department_id
ORDER BY e.employee_id;


#11

SELECT  AVG (salary) AS `min_average_salary` from employees 
JOIN departments ON employees.department_id = departments.department_id
GROUP BY departments.department_id
ORDER BY `min_avg_salary` ASC limit 1;

#12

SELECT 	c.country_code,	m.mountain_range, p.peak_name , p.elevation
FROM countries AS c
JOIN mountains_countries AS mc
ON c.country_code = mc.country_code
JOIN mountains AS m
ON m.id = mc.mountain_id
JOIN peaks AS p ON m.id = p.mountain_id
WHERE c.country_code ='BG' AND p.elevation >'2835'
ORDER BY p.elevation DESC;

#13

SELECT countries.country_code,	COUNT( mountains.mountain_range) AS `mountain_range`
FROM countries
JOIN mountains_countries ON countries.country_code = mountains_countries.country_code
JOIN mountains ON mountains_countries.mountain_id = mountains.id
WHERE countries.country_code IN ('BG','US','RU')
GROUP BY countries.country_code 
ORDER BY `mountain_range` DESC;


#14

SELECT 	c.country_name,	r.river_name
FROM countries AS c
LEFT JOIN countries_rivers AS cr ON  c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id = r.id
LEFT JOIN continents AS cont ON c.continent_code = cont.continent_code
WHERE
    cont.continent_name = 'Africa'
ORDER BY c.country_name ASC LIMIT 5;


#15

SELECT 
    c.continent_code,
    c.currency_code,
    COUNT(*) AS 'currency_usage'
FROM
    `countries` AS c
GROUP BY c.continent_code , c.currency_code
HAVING `currency_usage` > 1
    AND `currency_usage` = (SELECT 
        COUNT(*) AS cn
    FROM
        `countries` AS c2
    WHERE
        c2.continent_code = c.continent_code
    GROUP BY c2.currency_code
    ORDER BY cn DESC
    LIMIT 1)
ORDER BY c.continent_code , c.continent_code;


#16

SELECT COUNT( *) AS `country_count`
FROM countries
LEFT JOIN mountains_countries ON countries.country_code = mountains_countries.country_code
WHERE mountains_countries.mountain_id is null;

#17

SELECT 
c.country_name, 
	MAX(p.elevation) AS 'highest_peak_elevation',	
    MAX(r.length) 'longest_river_length'

FROM countries AS c
LEFT JOIN  mountains_countries AS mc ON c.country_code = mc.country_code
LEFT JOIN peaks AS p ON mc.mountain_id = p.mountain_id
LEFT JOIN countries_rivers AS cr  ON c.country_code = cr.country_code
LEFT JOIN rivers AS r ON cr.river_id  = r.id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.country_name
LIMIT 5;


#1111

SELECT 
    c.country_name,
    MAX(p.elevation) AS 'highest_peak_elevation',
    MAX(r.length) AS 'longest_river_length'
FROM
    `countries` AS c
        LEFT JOIN
    `mountains_countries` AS mc ON c.country_code = mc.country_code
        LEFT JOIN
    `peaks` AS p ON mc.mountain_id = p.mountain_id
        LEFT JOIN
    `countries_rivers` AS cr ON c.country_code = cr.country_code
        LEFT JOIN
    `rivers` AS r ON cr.river_id = r.id
GROUP BY c.country_name
ORDER BY `highest_peak_elevation` DESC , `longest_river_length` DESC , c.country_name
LIMIT 5;
