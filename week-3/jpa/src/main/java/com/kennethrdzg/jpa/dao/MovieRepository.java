package com.kennethrdzg.jpa.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kennethrdzg.jpa.entity.Movie;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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

    @Override
    public Movie findById(Integer id){
        return entityManager.find(Movie.class, id);
    }

    @Override
    public List<Movie> findAll(){
        TypedQuery<Movie> query = entityManager.createQuery("FROM Movie", Movie.class);
        return query.getResultList();
    }

    @Override
    public List<Movie> findByTitle(String title){
        TypedQuery<Movie> query = entityManager.createQuery("FROM Movie WHERE title LIKE :data", Movie.class);
        query.setParameter("data", "%" + title + "%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Movie movie){
        entityManager.merge(movie);
    }
}