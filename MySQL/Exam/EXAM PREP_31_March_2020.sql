CREATE DATABASE `instd`;
USE `instd`;

CREATE TABLE `users`(
`id`INT PRIMARY KEY AUTO_INCREMENT ,
`username` VARCHAR(30) NOT NULL UNIQUE,
`password` VARCHAR(30) NOT NULL,
`email` VARCHAR(50) NOT NULL,
`gender` CHAR(1) NOT NULL,
`age` INT NOT NULL,
`job_title` VARCHAR(40) NOT NULL,
`ip` VARCHAR(30) NOT NULL
);

CREATE TABLE `addresses`(
`id`INT PRIMARY KEY AUTO_INCREMENT ,
`address` VARCHAR(30) NOT NULL,
`town` VARCHAR(30) NOT NULL,
`country` VARCHAR(30) NOT NULL,
`user_id` INT NOT NULL,

CONSTRAINT fk_addresses_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`)

);


CREATE TABLE `photos`(
`id` INT PRIMARY KEY AUTO_INCREMENT ,
`description` TEXT NOT NULL,
`date` DATETIME NOT NULL ,
`views` INT NOT NULL DEFAULT 0
);


CREATE TABLE `comments`(
`id` INT PRIMARY KEY AUTO_INCREMENT,
`comment` VARCHAR(255) NOT NULL,
`date` DATETIME NOT NULL,
`photo_id` INT NOT NULL,

CONSTRAINT fk_comments_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)

); 


CREATE TABLE `users_photos`(
`user_id` INT NOT NULL,
`photo_id` INT NOT NULL,



CONSTRAINT fk_users_photos_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),

CONSTRAINT fk_users_photos_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)

);

CREATE TABLE `likes`(

`id` INT PRIMARY KEY NOT NULL,
`photo_id` INT ,
`user_id` INT,

CONSTRAINT fk_likes_users
FOREIGN KEY (`user_id`)
REFERENCES `users`(`id`),


CONSTRAINT fk_likes_photos
FOREIGN KEY (`photo_id`)
REFERENCES `photos`(`id`)

);
 
 
 # CONSTRAINT pk_users_photos
# PRIMARY KEY (`user_id` , `photo_id`),

#2

INSERT INTO `addresses` (`address`, `town` ,`country`,`user_id`)
SELECT `username` , `password`, `ip`, `age` FROM `users`
WHERE 	`gender` = 'M';


#3
UPDATE `addresses`
SET `country`= (
CASE

WHEN LEFT(`country`,1) = 'B' THEN 'Blocked'
WHEN LEFT(`country`,1) = 'T' THEN 'Test'
WHEN LEFT(`country`,1) = 'P' THEN 'In Progress'
END

)
WHERE LEFT(`country`,1) IN ('B','T','P');



#4

DELETE FROM addresses
WHERE id % 3 = 0;



#5

SELECT `username`, `gender`, `age`
FROM `users` AS `u`
ORDER BY u.age DESC, u.username ;

#6

SELECT p.`id`,
	p.`date`,
	p.`description`,
	COUNT(c.id) AS `commentsCount`
    FROM `photos` AS `p`
    JOIN `comments` AS `c`
    ON p.id = c.photo_id
    GROUP BY  p.id
    ORDER BY commentsCount DESC, p.id LIMIT 5;

#7

SELECT  concat_ws(' ',u.id, u.username) AS id_username, u.email
FROM `users` AS `u`
JOIN users_photos AS `up`
ON u.id = up.user_id
WHERE u.id = up.photo_id
ORDER BY u.id ASC;

#8

SELECT (p.id) AS `photo_id`,
	COUNT(DISTINCT `l`.id) AS `likes_count`,
COUNT(DISTINCT `c`.id) AS `comments_count`
FROM photos AS  `p`
LEFT JOIN comments AS `c` ON p.id = c.photo_id
LEFT JOIN likes AS `l` ON p.id = l.photo_id
GROUP BY p.id
ORDER BY likes_count DESC, comments_count DESC, p.id;




