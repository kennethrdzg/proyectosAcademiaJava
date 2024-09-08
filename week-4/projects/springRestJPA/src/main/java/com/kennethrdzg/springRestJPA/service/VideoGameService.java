package com.kennethrdzg.springRestJPA.service;

import com.kennethrdzg.springRestJPA.entity.VideoGame;

import java.util.List;

public interface VideoGameService {
	List<VideoGame> findAll();
	VideoGame findById(int id);
	VideoGame save(VideoGame videogame);
	void deleteById(int id);
}
