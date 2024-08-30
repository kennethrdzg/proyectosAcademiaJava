package com.kennethrdzg.jpa.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kennethrdzg.jpa.entity.Movie;

import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class MovieRepository implements MovieDAO {
    private EntityManager entityManager;

    @Autowired
    public MovieRepository(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Movie movie) {
        System.out.print("Saving movie " + movie);
        entityManager.persist(movie);
    }
}