package com.kennethrdzg.spring_batch.spring_batch_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kennethrdzg.spring_batch.spring_batch_app.entity.Movie;

public interface MovieRepository extends JpaRepository<Movie, Integer>{

}