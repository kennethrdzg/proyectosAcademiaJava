package com.kennethrdzg.spring_batch.spring_batch_app.config;

import org.springframework.batch.item.ItemProcessor;
import com.kennethrdzg.spring_batch.spring_batch_app.entity.Movie;

public class MovieProcessor implements ItemProcessor<Movie, Movie>{
    @Override
    public Movie process(Movie movie) throws Exception{
        // if()
        if(movie.getVote_average() >= 7.5){
            return movie;
        }
        return null;
    }
}