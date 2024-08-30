# Java Persistence API

## Database
For this project, we will create a database with some of the most popular movies in TMDB. We can use this publicly available [dataset](https://www.kaggle.com/datasets/ursmaheshj/top-10000-popular-movies-tmdb-05-2023) to get the data we need to construct our database. 

### Creating the database
With the following SQL script, we can create a MySQL Database and Table to store our data.
```
CREATE DATABASE IF NOT EXISTS MovieDB;

USE MovieDB;

DROP TABLE IF EXISTS movies;

CREATE TABLE movies (
    id INT NOT NULL AUTO_INCREMENT PRIMARY KEY, 
    title VARCHAR(64) DEFAULT NULL, 
    releaseDate DATE DEFAULT NULL,
    originalLanguage VARCHAR(64) DEFAULT NULL,
    budget DOUBLE DEFAULT 0,
    revenue DOUBLE DEFAULT 0,
    runtime INT DEFAULT 0,
    rating DOUBLE
) AUTO_INCREMENT=1;
```
Now we can insert values into the table and populate the database. 

Finally, we can perform a simple query to see that our database has been set up correctly. 

`SELECT * FROM movies`

If everything is fine, we should get a result like this:

![Query Result ALT Text](./img/queryResult.png)

The database set up process can be done by executing [this SQL script](./database/create_db.sql). 

## Maven Dependencies
This project requires 2 dependencies to work properly: **Spring Data JPA** and **MySQL Connector/J**.

### Spring Data JPA
This dependency helps implement a JPA application. It will essentially be the backbone of the project, as it will allow integration with our database.

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
    <version>3.2.9</version>
</dependency>
```

### MySQL Connector/J
This dependency provides the driver necessary for connecting our application with a MySQL database. This driver may be exchanged for another to allow connections with other databases. 

```
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```