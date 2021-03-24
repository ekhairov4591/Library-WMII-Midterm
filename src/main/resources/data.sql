DROP TABLE IF EXISTS users;

CREATE TABLE users
(
    id        NUMERIC AUTO_INCREMENT PRIMARY KEY,
    firstname VARCHAR(20)  NOT NULL,
    lastname  VARCHAR(20)  NOT NULL,
    birthday  VARCHAR(30)  NOT NULL,
    email     VARCHAR(40)  NOT NULL,
    password  VARCHAR(150) NOT NULL
);