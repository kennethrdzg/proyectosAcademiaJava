package com.kennethrdzg.springRestJPA.service;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.*;

import java.util.List;
import java.util.Optional;

import com.kennethrdzg.springRestJPA.entity.VideoGame;
import com.kennethrdzg.springRestJPA.dao.VideoGameRepository;

@Service
public class VideoGameServiceImpl implements VideoGameService{
	private VideoGameRepository repository;
	
	@Autowired
	public VideoGameServiceImpl(VideoGameRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public List<VideoGame> findAll(){
		return repository.findAll();
	}
	
	@Override
	public VideoGame findById(int id) {
		Optional<VideoGame> result = repository.findById(id);
		
		VideoGame videogame = null;
		
		if(result.isPresent()) {
			videogame = result.get();
		}
		else {
			throw new RuntimeException("Did not find game with ID: " + id);
		}
		
		return videogame;
	}
	
	@Override
	public VideoGame save(VideoGame videogame) {
		return this.repository.save(videogame);
	}
	
	@Override
	public void deleteById(int id) {
		this.repository.deleteById(id);
	}
	
}
