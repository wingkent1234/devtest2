CREATE TABLE customer (
	`id` BIGINT(20)	PRIMARY KEY auto_increment,
	`name` varchar(50) NOT NULL,
	`phone` varchar(30) NOT NULL
);

CREATE TABLE auth (
	`id` BIGINT(20)	PRIMARY KEY auto_increment,
	`customer_id` BIGINT(20) NOT NULL,
    `access_token` varchar(50) NOT NULL
);

CREATE TABLE credential (
	`customer_id` BIGINT(20)	PRIMARY KEY,
    `username` varchar(50) NOT NULL,
    `password` varchar(50) NOT NULL
);