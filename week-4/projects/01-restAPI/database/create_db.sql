CREATE DATABASE IF NOT EXISTS VideoGameDB;

USE VideoGameDB;

DROP TABLE IF EXISTS videogames;

CREATE TABLE videogames (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    title VARCHAR(64) DEFAULT NULL, 
    genre VARCHAR(64) DEFAULT NULL,
    platform VARCHAR(64) DEFAULT NULL,
    release_year INT DEFAULT 0,
    developer VARCHAR(64) DEFAULT NULL, 
    publisher VARCHAR(64) DEFAULT NULL,
    score DOUBLE DEFAULT 0
) AUTO_INCREMENT=1;

INSERT INTO videogames (title, genre, platform, release_year, developer, publisher, score) VALUES ("The Witcher 3: Wild Hunt", "RPG", "PC/PS4/Xbox One", 2015, "CD Projekt Red", "CD Projekt", 10);
INSERT INTO videogames (title, genre, platform, release_year, developer, publisher, score) VALUES ("Red Dead Redemption 2", "Action-adventure", "PS4/Xbox One/PC", 2018, "Rockstar Studios", "Rockstar Games", 10);
INSERT INTO videogames (title, genre, platform, release_year, developer, publisher, score) VALUES ("The Legend of Zelda: Breath of the Wild", "Action-adventure", "Nintendo Switch", 2017, "Nintendo", "Nintendo", 10);
INSERT INTO videogames (title, genre, platform, release_year, developer, publisher, score) VALUES ("Dark Souls III", "Action RPG", "PS4/Xbox One/PC", 2016, "FromSoftware", "Bandai Namco", 9.5);
INSERT INTO videogames (title, genre, platform, release_year, developer, publisher, score) VALUES ("Hades", "Roguelike", "PC/Nintendo Switch", 2020, "Supergiant Games", "Supergiant Games", 9.8);

SELECT * FROM videogames;