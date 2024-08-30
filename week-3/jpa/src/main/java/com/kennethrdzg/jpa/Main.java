package com.kennethrdzg.jpa;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kennethrdzg.jpa.dao.MovieDAO;
import com.kennethrdzg.jpa.entity.Movie;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieDAO movieDAO){
        return runner -> {
            // createMovie(movieDAO);
            readMovie(movieDAO);
        };
    }

    private void createMovie(MovieDAO movieDAO){

        System.out.println("Creating new movie object...");
        Movie tempMovie = new Movie("Joker", LocalDate.parse("2019-10-04"), 55000000.0, 1079000000.0, 122, 8.2);

        System.out.println("Saving the movie...");
        movieDAO.save(tempMovie);

        System.out.println("Saved movie. Generated ID: " + tempMovie.getId());
    }

    private void readMovie(MovieDAO movieDAO){
        int id = 10;
        System.out.println("Retrieving movie with id: " + id);
        Movie movie = movieDAO.findById(id);

        System.out.println("Found the movie: " + movie);
    }
}