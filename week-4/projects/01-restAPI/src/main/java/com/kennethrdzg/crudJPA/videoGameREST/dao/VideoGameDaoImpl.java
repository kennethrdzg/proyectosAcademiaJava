package com.kennethrdzg.crudJPA.videoGameREST.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kennethrdzg.crudJPA.videoGameREST.entity.VideoGame;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class VideoGameDaoImpl implements VideoGameDao{
    private EntityManager entityManager;

    @Autowired
    public VideoGameDaoImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
	@Transactional
	public VideoGame save(VideoGame videoGame) {
		entityManager.persist(videoGame);
		return videoGame;
	}

	@Override
	public VideoGame findById(Integer id){
		VideoGame videoGame = entityManager.find(VideoGame.class, id);
		return videoGame;
	}
	
	@Override
	public List<VideoGame> findAll(){
		TypedQuery<VideoGame> query = entityManager.createQuery("FROM VideoGame", VideoGame.class);
        return query.getResultList();
	}

	@Override
	@Transactional
	public VideoGame update(VideoGame videoGame){
		return entityManager.merge(videoGame);
	}

	@Override
	@Transactional
	public void delete(Integer id){
		VideoGame videoGame = entityManager.find(VideoGame.class, id);
		if(videoGame == null)
			throw new RuntimeException("Could not find Video Game with ID: " + id);
		else
			entityManager.remove(videoGame);
	}
}
