CREATE DATABASE chatapp;

USE chatapp;

CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(100),
    password VARCHAR(100)
);

CREATE TABLE messages(
    id INT PRIMARY KEY AUTO_INCREMENT,
    sender VARCHAR(100),
    message TEXT
);