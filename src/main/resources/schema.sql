DROP TABLE IF EXISTS users;
CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       email VARCHAR(255) NOT NULL,
                       password VARCHAR(255) NOT NULL
);

DROP TABLE IF EXISTS contents;
CREATE TABLE contents (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       title VARCHAR(255) NOT NULL,
                       body VARCHAR(255) NOT NULL,
                       author VARCHAR(255) NOT NULL
);