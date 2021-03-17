
INSERT INTO `addresses` ( address,town, country,user_id)
SELECT u.`username`, u.`password`, u.`ip`, u.`age`  FROM `users` AS `u`
WHERE u.gender = 'M';

UPDATE addresses 
SET addresses.country =(
CASE 
	WHEN LEFT(addresses.country,1) = 'B' THEN 'Blocked'
	WHEN LEFT(addresses.country,1) = 'T' THEN 'Test'
	WHEN LEFT(addresses.country,1) = 'P' THEN 'In Progress'
END

)
WHERE LEFT(`country`,1) IN ('B','T','P');


UPDATE `coaches`
SET `coach_level` = `coach_level`+1
WHERE LEFT( first_name,1 ) = 'A'
AND coaches.id IN (SELECT players_coaches.coach_id FROM players_coaches ); 


SELECT 	username,gender,age FROM  users
ORDER BY age DESC, username;


SELECT 	p.id, p.`date` AS date_and_time , p.description, COUNT(c.id) AS commentsCount
FROM photos AS p
JOIN `comments` AS c ON p.id = c.photo_id
GROUP BY p.id
ORDER BY commentsCount DESC, p.id;
