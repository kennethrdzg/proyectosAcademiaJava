package com.kennethrdzg.jpa.dao;

import com.kennethrdzg.jpa.entity.Movie;

import java.util.List;

public interface MovieDAO {
    void save(Movie movie);

    
    Movie findById(Integer id);

    List<Movie> findAll();

    // List<Movie> findByTitle();

    // void update(Movie movie);

    // void delete(Integer id);

    // int deleteAll();
    
}