package com.kennethrdzg.jpa;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.kennethrdzg.jpa.dao.MovieDAO;
import com.kennethrdzg.jpa.entity.Movie;

@SpringBootApplication
public class MovieApp {
    public static void main(String[] args) {
        SpringApplication.run(MovieApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(MovieDAO movieDAO){
        return runner -> {
            createMovie(movieDAO);
            readMovie(movieDAO);
            queryAllMovies(movieDAO);
            queryMoviesByTitle(movieDAO);
            updateMovie(movieDAO);
            deleteMovie(movieDAO);
            deleteAllMovies(movieDAO);
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

    private void queryAllMovies(MovieDAO movieDAO){
        System.out.println("Retrieving all movies in database");
        List<Movie> movies = movieDAO.findAll();
        
        for(Movie movie: movies){
            System.out.println(movie);
        }
    }

    private void queryMoviesByTitle(MovieDAO movieDAO){
        String title = "Avengers";
        System.out.println("Retrieving movies with \"" + title + "\" in title.");
        List<Movie> movies = movieDAO.findByTitle(title);
        for(Movie movie: movies){
            System.out.println(movie);
        }
    }

    private void updateMovie(MovieDAO movieDAO){
        int id = 24;

        System.out.println("Retrieving movie with id: " + id);
        Movie movie = movieDAO.findById(id);

        if(movie == null){
            System.out.println("Movie was not found");   
            return;
        }

        System.out.println("Updating movie...");
        movie.setTitle("Minions 2");

        movieDAO.update(movie);

        System.out.println("Updated movie: " + movie);
    }

    private void deleteMovie(MovieDAO movieDAO){
        int id = 11;
        System.out.println("Deleting movie with id: " + id);
        movieDAO.delete(id);
    }

    private void deleteAllMovies(MovieDAO movieDAO){
        System.out.println("Deleting all movies from database.");

        int deletedRows = movieDAO.deleteAll();

        System.out.println("Number of Deleted Movies: " + deletedRows);
    }
}
