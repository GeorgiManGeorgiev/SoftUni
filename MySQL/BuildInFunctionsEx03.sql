
#1

SELECT first_name ,last_name
from employees
WHERE left(first_name,2) = 'Sa'
order by employee_id;

#2

SELECT first_name,last_name 
from employees
WHERE  last_name like '%ei%'
order by employee_id;

#3

SELECT first_name 
FROM employees
WHERE department_id in (3,10) AND year(hire_date) BETWEEN 1995 and 2005
order by employee_id;


#4

SELECT first_name,last_name 
FROM employees
WHERE job_title not like '%engineer%'
order by employee_id;

#5

SELECT `name` 
from	towns
WHERE char_length(`name`) in (5,6)
ORDER BY `name`;



#6

SELECT town_id,`name`
FROM	towns
WHERE  upper(left(`name`,1)) in ('M','K','B','E')
ORDER BY `name`;

#7

SELECT town_id,`name`
FROM	towns
WHERE  upper(left(`name`,1)) not in ('R','B','D')
ORDER BY `name`;

#8

CREATE VIEW `v_employees_hired_after_2000` AS
SELECT first_name,last_name
from employees
where year(hire_date) > 2000;

#9

SELECT first_name,last_name
FROM employees
WHERE char_length(last_name) = 5;


#10

SELECT country_name,iso_code
FROM countries
WHERE upper(country_name) LIKE '%A%A%A%'
ORDER BY iso_code;

#11

SELECT p.peak_name ,r.river_name,
lower(concat(peak_name,substring(river_name,2))) as mix
from peaks as p,rivers as r
WHERE right(peak_name,1) = left(river_name,1)
ORDER BY mix ;


#12

SELECT `name` ,date_format( `start`,'%Y-%m-%d') as `start`
from games
WHERE year(`start`) in (2011,2012)
ORDER BY `start`, `name`
LIMIT 50;

#13

SELECT `user_name`,
 SUBSTRING( `email`, locate('@',`email`)+1)   as `Email Provider`
FROM `users`
ORDER BY `Email Provider`,`user_name`;

#14

SELECT user_name,ip_address
from users
WHERE ip_address like '___.1%.%.___'
ORDER BY user_name,ip_address;





#15



 SELECT 
    `name` AS 'game',
    CASE
        WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
        WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
        ELSE 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN `duration` <= 3 THEN 'Extra Short'
        WHEN `duration` BETWEEN 4 AND 6 THEN 'Short'
        WHEN `duration` BETWEEN 7 AND 10 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    `games`
ORDER BY `name`;

-- Another solution
SELECT 
    `name` AS 'game',
    CASE
        WHEN HOUR(`start`) < 12 THEN 'Morning'
        WHEN HOUR(`start`) < 18 THEN 'Afternoon'
        ELSE 'Evening'
    END AS 'Part of the Day',
    CASE
        WHEN `duration` < 4 THEN 'Extra Short'
        WHEN `duration` < 7 THEN 'Short'
        WHEN `duration` < 11 THEN 'Long'
        ELSE 'Extra Long'
    END AS 'Duration'
FROM
    `games`
ORDER BY `name`;

#16 Orders Table


SELECT 
    `product_name`,
    `order_date`,
    DATE_ADD(`order_date`, INTERVAL 3 DAY) AS 'pay_due',
    DATE_ADD(`order_date`, INTERVAL 1 MONTH) AS 'deliver_due'
FROM
    `orders`;

