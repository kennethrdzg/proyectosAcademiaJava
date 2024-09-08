package com.kennethrdzg.crudJPA.videoGameREST.dao;

import java.util.List;

import com.kennethrdzg.crudJPA.videoGameREST.entity.VideoGame;

public interface VideoGameDao {
    VideoGame save(VideoGame videoGame);
	List<VideoGame> findAll();
	/*
	 * VideoGame findById(Integer id);
	List<VideoGame> findAll();
	VideoGame post(VideoGame videoGame);
	VideoGame update(VideoGame videoGame);
	void delete(Integer id);
	 */
}