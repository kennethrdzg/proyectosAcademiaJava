package com.kennethrdzg.crudJPA.videoGameREST.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kennethrdzg.crudJPA.videoGameREST.dao.VideoGameDao;
import com.kennethrdzg.crudJPA.videoGameREST.entity.VideoGame;

@Service
public class VideoGameServiceImpl implements VideoGameService{
	private VideoGameDao videoGameDAO;
	
	@Autowired
	public VideoGameServiceImpl(VideoGameDao videoGameDAO) {
		this.videoGameDAO = videoGameDAO;
	}
	
	@Override
	public VideoGame save(VideoGame videoGame) {
		videoGameDAO.save(videoGame);
		return videoGame;
	}
	
	@Override
	public List<VideoGame> findAll(){
		return videoGameDAO.findAll();
	}
}
