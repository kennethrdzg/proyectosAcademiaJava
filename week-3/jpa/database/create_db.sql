CREATE DATABASE IF NOT EXISTS MovieDB;

USE MovieDB;

DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    title VARCHAR(64) DEFAULT NULL, 
    release_date DATE DEFAULT NULL,
    budget DOUBLE DEFAULT 0,
    revenue DOUBLE DEFAULT 0,
    runtime INT DEFAULT 0,
    rating DOUBLE
) AUTO_INCREMENT=1;

INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Avatar", "2009-12-15", 237000000.0, 2923706026.0, 162.0, 7.6);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Avengers: Endgame", "2019-04-24", 356000000.0, 2794731755.0, 181.0, 8.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Avatar: The Way of Water", "2022-12-14", 460000000.0, 2320250281.0, 192.0, 7.7);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Titanic", "1997-11-18", 200000000.0, 2264162353.0, 194.0, 7.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Star Wars: The Force Awakens", "2015-12-15", 245000000.0, 2068223624.0, 136.0, 7.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Avengers: Infinity War", "2018-04-25", 300000000.0, 2052415039.0, 149.0, 8.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Spider-Man: No Way Home", "2021-12-15", 200000000.0, 1921847111.0, 148.0, 8.0);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Jurassic World", "2015-06-12", 150000000.0, 1671537444.0, 124.0, 6.7);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("The Lion King", "2019-07-12", 260000000.0, 1663075401.0, 118.0, 7.1);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("The Avengers", "2012-04-25", 220000000.0, 1518815515.0, 143.0, 7.7);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Furious 7", "2015-04-01", 190000000.0, 1515341399.0, 137.0, 7.2);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Top Gun: Maverick", "2022-05-24", 170000000.0, 1488732821.0, 131.0, 8.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Frozen II", "2019-11-20", 150000000.0, 1450026933.0, 103.0, 7.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Avengers: Age of Ultron", "2015-04-22", 365000000.0, 1405403694.0, 141.0, 7.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Black Panther", "2018-02-13", 200000000.0, 1349926083.0, 135.0, 7.4);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Harry Potter and the Deathly Hallows: Part 2", "2011-07-07", 125000000.0, 1341511219.0, 130.0, 8.1);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Star Wars: The Last Jedi", "2017-12-13", 200000000.0, 1332698830.0, 152.0, 6.8);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Jurassic World: Fallen Kingdom", "2018-06-22", 170000000.0, 1310466296.0, 129.0, 6.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Frozen", "2013-11-20", 150000000.0, 1274219009.0, 102.0, 7.2);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Beauty and the Beast", "2017-03-16", 160000000.0, 1266115964.0, 129.0, 7.0);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Incredibles 2", "2018-06-14", 200000000.0, 1242805359.0, 118.0, 7.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("The Fate of the Furious", "2017-04-12", 250000000.0, 1236005118.0, 136.0, 6.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Iron Man 3", "2013-04-18", 200000000.0, 1215577205.0, 130.0, 6.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Minions", "2015-06-17", 74000000.0, 1156730962.0, 91.0, 6.4);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Captain America: Civil War", "2016-04-27", 250000000.0, 1153337496.0, 147.0, 7.4);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Aquaman", "2018-12-07", 160000000.0, 1148528393.0, 143.0, 6.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Skyfall", "2012-10-24", 200000000.0, 1142471295.0, 143.0, 7.2);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Spider-Man: Far From Home", "2019-06-28", 160000000.0, 1131927996.0, 129.0, 7.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Captain Marvel", "2019-03-06", 152000000.0, 1131416446.0, 124.0, 6.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Transformers: Dark of the Moon", "2011-06-28", 195000000.0, 1123794079.0, 154.0, 6.2);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("The Lord of the Rings: The Return of the King", "2003-12-01", 94000000.0, 1118888979.0, 201.0, 8.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Transformers: Age of Extinction", "2014-06-25", 210000000.0, 1104054072.0, 165.0, 5.9);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("The Dark Knight Rises", "2012-07-16", 250000000.0, 1081041287.0, 165.0, 7.8);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Joker", "2019-10-01", 55000000.0, 1074458282.0, 122.0, 8.2);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Star Wars: The Rise of Skywalker", "2019-12-18", 250000000.0, 1074144248.0, 142.0, 6.4);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Toy Story 4", "2019-06-19", 175000000.0, 1073394593.0, 100.0, 7.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Toy Story 3", "2010-06-16", 200000000.0, 1066969703.0, 103.0, 7.8);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Pirates of the Caribbean: Dead Man's Chest", "2006-07-06", 200000000.0, 1065659812.0, 151.0, 7.3);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Rogue One: A Star Wars Story", "2016-12-14", 200000000.0, 1056057273.0, 133.0, 7.5);
INSERT INTO movies (title, release_date, budget, revenue, runtime, rating) VALUES ("Aladdin", "2019-05-22", 183000000.0, 1054304000.0, 127.0, 7.1);

SELECT * from movies;